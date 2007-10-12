#!/usr/bin/ruby

require 'logger'
require 'debian'

LOG_FILE = '@UVM_LOG@/apt.log'
LOG = Logger.new(LOG_FILE, 10, 1048576)

STDERR.reopen(LOG_FILE, 'a')

printusage()
{
puts <<STR
usage:
  mkg installed
  mkg available
  mkg install <mackage>
  mkg update
  mkg upgrade
  mkg remove
STR
  exit(1)
}

def installed()
  IO.popen("dpkg --get-selections '*'", 'r') do |input|
    IO.popen("xargs dpkg-query -W", 'w') do |output|
      input.each_line do |l|
        s = l.split
        output.puts(s[0]) if 'install' == s[1]
      end
    end
  end
end

def download(pkg)
end



# this is needed now !
export DEBIAN_FRONTEND=noninteractive



INST_OPTS = " -o DPkg::Options::=--force-confnew --yes --force-yes --fix-broken --purge "
UPGD_OPTS = " -o DPkg::Options::=--force-confnew --yes --force-yes --fix-broken --purge "
UPDT_OPTS = " --yes --force-yes --purge "
REMO_OPTS = " --yes --force-yes --fix-broken --purge "
DEBUG_OPTS = " -o Debug::pkgDPkgPM=true "


RET=0

download()
{
    aptlist=$1

    cat $aptlist >>$APT_LOG
    echo "END PACKAGE LIST" >>$APT_LOG

    for u in $(cat $aptlist | awk '{ print $1 }' | sed "s/'//g"); do
        echo "downloading: $u" >>$APT_LOG
        dltmp=$(mktemp -d mkg.XXXXXXXXXX)
        wget --progress=dot -P "$dltmp" "$u" >>$APT_LOG 2>&1
        if [ $? -eq 0 ]; then
            mv $dltmp/* /var/cache/apt/archives
            echo "DOWNLOAD SUCCEEDED: $u" >>$APT_LOG
        else
            echo "DOWNLOAD FAILED: $u" >>$APT_LOG
        fi
        rm -r $dltmp
    done
}

while getopts k: f; do
  case $f in
      k) stamp=$OPTARG
  esac
done
shift $(expr $OPTIND - 1)

if [ $# -lt 1 ] ; then
    printusage
fi

if [ -z $prefix ] ; then
    # invoked in real environment
    if [ "$1" = "installed" ] ; then
        my_dpkg_query '*' 2>/dev/null | awk '{ if ($2) printf("%s %s\n",$1,$2) }'
        #RET=$? return code ignored
    elif [ "$1" = "available" ] ; then
        pkgs=$(apt-cache search '.' 2>/dev/null | cut -d ' ' -f 1)
        for pkg in $pkgs; do
            apt-cache show --no-all-versions $pkg 2>/dev/null
            #RET=$? return code ignored
        done
    elif [ "$1" = "install" ] ; then
        aptlog "start $stamp"

        aptlog "downloading: \"$2\""

        # XXX the way i create mackage name is wrong:
        aptlist=$(mktemp -t mkg.XXXXXXXXXX)
        apt-get install $INST_OPTS --print-uris "$2" 2>/dev/null \
            | awk " /^'http:\\/\\// { print \$0 } " >$aptlist
        download $aptlist
        rm $aptlist

        aptlog "installing: \"$2\""
        # XXX the way i create mackage name is wrong:
        apt-get install $INST_OPTS "$2" >>$APT_LOG 2>&1
        RET=$?

        aptlog "done $stamp"

    elif [ "$1" = "update" ] ; then
        aptlog "start $tstamp" "apt-get update $UPDT_OPTS"
        apt-get update $UPDT_OPTS >>$APT_LOG 2>&1
        RET=$?
        aptlog "done $stamp"
    elif [ "$1" = "upgrade" ] ; then
        aptlog "start $stamp"  "apt-get upgrade $UPGD_OPTS"

        aptlist=$(mktemp -t mkg.XXXXXXXXXX)
        apt-get dist-upgrade $UPGD_OPTS --print-uris 2>/dev/null \
            | awk " /^'http:\\/\\// { print \$0 } " >$aptlist
        download $aptlist
        rm $aptlist

        apt-get dist-upgrade $UPGD_OPTS >>$APT_LOG 2>&1
        RET=$?

        aptlog "done $stamp"
    elif [ "$1" = "remove" ] ; then
        aptlog "start $stamp" "apt-get remove $REMO_OPTS \"$2\""
        apt-get remove $REMO_OPTS "$2" >>$APT_LOG 2>&1
        apt-get clean >>/dev/null 2>&1
        RET=$?
        aptlog "done $stamp"
    fi
else
    # invoked in development environment
    if [ "$1" = "installed" ] ; then
        cat $pkglist* | awk ' /^Package: / { print $2 " 10.0" } '
    elif [ "$1" = "install" ] ; then
        aptlog "start $stamp"
        echo "END PACKAGE LIST" >>$APT_LOG
        aptlog "done $stamp"
    elif [ "$1" = "update" ] ; then
        : # XXX
    elif [ "$1" = "upgrade" ] ; then
        aptlog "start $stamp"
        echo "END PACKAGE LIST" >>$APT_LOG
        aptlog "done $stamp"
    elif [ "$1" = "remove" ] ; then
        echo "remove not supported in build environment"
    elif [ "$1" = "available" ] ; then
        cat $pkglist* | sed -e 's/^XB-//' \
            | awk '{ print $0 }; /^Package: / { print "Version: 10.0" }'
    fi
fi

exit $RET
