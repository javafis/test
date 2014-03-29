Ext.define('Huskar.view.Header', {
    extend: 'Ext.Container',
    xtype: 'appHeader',
    id: 'app-header',
    height: 52,
    layout: {
        type: 'hbox',
        align: 'middle'
    },
    initComponent: function() {
        this.items = [{
            xtype:'component',
            id:'app-header-title',
            html:'Huskar',
            flex: 1
        }];
        this.callParent();
    }
});
