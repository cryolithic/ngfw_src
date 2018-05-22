Ext.define('Ung.config.network.view.BypassRules', {
    extend: 'Ung.cmp.MasterGrid',
    alias: 'widget.config-network-bypass-rules',
    itemId: 'bypass-rules',

    bind: {
        store: {
            data: '{settings.bypassRules.list}',
            model: 'Ung.model.BypassRules'
        }
    },


    // title: 'Bypass Rules'.t(),
    description: 'Bypass Rules control what traffic is scanned by the applications. Bypassed traffic skips application processing. The rules are evaluated in order. Sessions that meet no rule are not bypassed.'.t(),

    toolbarActions: ['ADD'],
    enableMove: true,
    enableDelete: true,

    settingsProperty: 'bypassRules',
    conditionClass: 'com.untangle.uvm.network.BypassRuleCondition',
    conditions: [
        Condition.DST_ADDR,
        Condition.DST_PORT,
        Condition.DST_INTF,
        Condition.SRC_ADDR,
        Condition.SRC_PORT,
        Condition.SRC_INTF,
        Condition.PROTOCOL,
        Condition.CLIENT_TAGGED,
        Condition.SERVER_TAGGED
    ],

    emptyText: 'No Bypass Rules defined'.t(),

    newRecord: {
        ruleId: -1,
        enabled: true,
        bypass: true,
        javaClass: 'com.untangle.uvm.network.BypassRule',
        conditions: {
            javaClass: 'java.util.LinkedList',
            list: []
        },
        description: ''
    },

    columnsDef: [
        Column.RULEID,
        Column.ENABLED,
        Column.DESCRIPTION,
        Column.CONDITIONS,
        Column.BYPASS
    ]
});
