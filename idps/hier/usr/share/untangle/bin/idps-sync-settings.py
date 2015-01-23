#!/usr/bin/python
#
# Synchronize downloaded snort-formatted rules into idps settings.
#
import errno
import os
import getopt
import sys
import subprocess
import re
import json
import time
import uvm
from uvm import Manager
from uvm import Uvm

UNTANGLE_DIR = '%s/usr/lib/python%d.%d' % ( "@PREFIX@", sys.version_info[0], sys.version_info[1] )
if ( "@PREFIX@" != ''):
    sys.path.insert(0, UNTANGLE_DIR)
	
import untangle_node_idps

def usage():
    print "usage..."
    print "help\t\tusage"
    print "settings\tSettings configuration file name"
    print "conf\t\tSnort configuration file name"
    print "rules\t\tSnort rule file name"
    print "node\t\tNode identifier"
    print "debug\t\tEnable debugging"
        
def main(argv):
    global _debug
    _debug = False
    rules_file_name = ""
    previous_rules_file_name = ""
    settings_file_name = ""
    status_file_name = ""
    nodeId = "0"
	
    try:
		opts, args = getopt.getopt(argv, "hscrna:d", ["help", "settings=", "rules=", "previous_rules=", "nodeId=", "status=", "debug"] )
    except getopt.GetoptError:
    	usage()
    	sys.exit(2)
    for opt, arg in opts:
        if opt in ( "-h", "--help"):
            usage()
            sys.exit()
        elif opt in ( "-d", "--debug"):
             _debug = True
        elif opt in ( "-n", "--nodeId"):
            nodeId = arg
        elif opt in ( "-r", "--rules"):
            rules_file_name = arg
        elif opt in ( "-p", "--previous_rules"):
            previous_rules_file_name = arg
        elif opt in ( "-s", "--settings"):
            settings_file_name = arg
        elif opt in ( "-a", "--status"):
            status_file_name = arg

    if _debug == True:
        print "rules_file_name = " + rules_file_name
        print "settings_file_name = " + settings_file_name
        print "node = " + nodeId
        print "_debug = ",  _debug

    snort_conf = untangle_node_idps.SnortConf()
    snort_rules = untangle_node_idps.SnortRules( nodeId, rules_file_name )
    snort_rules.load( True )

    settings = untangle_node_idps.IdpsSettings( nodeId, settings_file_name )
    if settings.exists() == False:
        settings.initialize( snort_conf, snort_rules )
    else:
        settings.load()
        added_rule_sids = []
        deleted_rule_sids = []
        modified_rule_sids = []
        
        previous_snort_rules = untangle_node_idps.SnortRules( nodeId, previous_rules_file_name )
        previous_snort_rules.load( True )
        
        previous_rules = previous_snort_rules.get_rules()
        current_rules = snort_rules.get_rules()
        settings_rules = settings.get_rules().get_rules()
        
        active_rules_classtypes = settings.get_active_rules_classtypes()
        active_rules_categories = settings.get_active_rules_categories()
        
        for sid in previous_rules:
            if current_rules.has_key(sid) == False:
                deleted_rule_sids.append( sid )

        for sid in current_rules:
            if previous_rules.has_key(sid) == False:
                added_rule_sids.append( sid )
            elif current_rules[sid].build() != previous_rules[sid].build():
                modified_rule_sids.append( sid )

        for sid in deleted_rule_sids:
            if settings_rules.has_key(sid):
                settings_rules.remove(sid)
                
        for sid in added_rule_sids:
            if settings_rules.has_key(sid):
                new_rule = current_rules[sid]
                new_rule.enabled = settings_rules[sid].enabled
                new_rule.action = settings_rules[sid].action
                settings_rules[sid] = new_rule
            else:
                settings_rules[sid] = current_rules[sid]
                if len( active_rules_classtypes ) > 0 and ( settings_rules[sid].options["classtype"] in active_rules_classtypes ) == False:
                    settings_rules[sid].enabled = False
                if len( active_rules_categories ) > 0 and ( settings_rules[sid].options["classtype"] in active_rules_categories ) == False:
                    settings_rules[sid].enabled = False
        settings.set_rules( settings_rules )

        if status_file_name != "":
            status = {
                "rules" : {
                    "deleted" : deleted_rule_sids,
                    "modified" : modified_rule_sids,
                    "added" : added_rule_sids
                }
            }

            status_file = open( status_file_name, "w" )
            json.dump( status, status_file, False, True, True, True, None, 0 )
            status_file.close()
        
    settings.save()
    sys.exit()

if __name__ == "__main__":
	main( sys.argv[1:] )
