Ext.define('Ung.apps.bandwidthcontrol.ConfWizardController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.app-bandwidthcontrol-wizard',

    control: {
        '#': {
            afterrender: 'onAfterRender'
        },
        'window > panel': {
            activate: 'onActivateCard'
        }
    },

    onAfterRender: function () {
        var me = this,
            vm = this.getViewModel();

        // vm.set('nextBtnText', this.getView().getLayout().getNext().getTitle());

        Rpc.asyncData('rpc.networkManager.getNetworkSettings')
            .then(function (result) {
                me.networkSettings = result;
                console.log(result);
                vm.set('interfaces', result.interfaces.list);
            });
    },

    onActivateCard: function (panel) {
        var vm = this.getViewModel(),
            layout = this.getView().getLayout();

        // console.log(panel);
        vm.set('prevBtn', layout.getPrev());
        if (layout.getPrev()) {
            vm.set('prevBtnText', layout.getPrev().getTitle());
        }
        vm.set('nextBtn', layout.getNext());
        if (layout.getNext()) {
            vm.set('nextBtnText', layout.getNext().getTitle());
        }
    },

    onNext: function () {
        var v = this.getView(),
            vm = this.getViewModel(),
            activeItem = v.getLayout().getActiveItem();

        if (activeItem.getItemId() === 'welcome') {
            v.getLayout().next();
        }

        if (activeItem.getItemId() === 'wan') {
            var grid = activeItem.down('grid'),
                invalidValues = false;

            grid.getStore().each(function (intf) {
                if (
                    (!intf.get('downloadBandwidthKbps') || intf.get('downloadBandwidthKbps') === 0) ||
                    (!intf.get('uploadBandwidthKbps') || intf.get('uploadBandwidthKbps') === 0)) {
                    invalidValues = true;
                }
            });
            if (invalidValues) {
                Ext.Msg.alert('Warning'.t(), 'Invalid values'.t());
            } else {
                if (grid.getStore().getModifiedRecords().length > 0 || !this.networkSettings.qosSettings.qosEnabled) {
                    this.networkSettings.qosSettings.qosEnabled = true;

                    // the download/upload values were modified via binding
                    Ext.MessageBox.wait('Configuring WAN...'.t(), 'Please wait'.t());
                    Metrics.stop();
                    Rpc.asyncData('rpc.networkManager.setNetworkSettings', this.networkSettings)
                        .then(function () {
                            Metrics.start();
                            v.getLayout().next();
                        }).always(function () {
                            Ext.MessageBox.hide();
                        });
                } else {
                    v.getLayout().next();
                }
            }
        }
        if (activeItem.getItemId() === 'configuration') {
            var startConf = activeItem.down('combo').getValue();
            if (!startConf) {
                Ext.MessageBox.alert('Error'.t(), 'You must select a starting configuration.'.t());
                return;
            }
            Ext.MessageBox.wait('Configuring Settings...'.t(), 'Please wait'.t());
            this.getView().appManager.wizardLoadDefaults(function (result) {
                Ext.MessageBox.hide();
                v.getLayout().next();
            }, startConf.replace(/_.*/,''));
        }
        if (activeItem.getItemId() === 'quotas') {
            if (!vm.get('quota.enabled')) {
                v.getLayout().next();
                return;
            }

            if (Ext.isEmpty(vm.get('quota.clients'))) {
                Ext.MessageBox.alert('Error', 'You must provide an IP/netmask or range.'.t());
                return;
            }

            Ext.MessageBox.wait('Configuring Quotas...'.t(), 'Please wait'.t());
            this.getView().appManager.wizardAddQuotaRules(function (result) {
                Ext.MessageBox.hide();
                v.getLayout().next();
            },
            vm.get('quota.clients'),
            vm.get('quota.expiration'),
            Math.round(vm.get('quota.size') * vm.get('quota.unit')),
            vm.get('quota.priority')
            );
        }
    },

    onPrev: function () {
        var v = this.getView();
        if (v.getLayout().getPrev()) {
            v.getLayout().prev();
        }
    }
});