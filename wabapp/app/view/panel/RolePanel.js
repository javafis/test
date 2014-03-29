Ext.define('Huskar.view.panel.RolePanel', {
    extend: 'Ext.Container',
    width: 660,
    layout: {
        type: 'table',
        columns: 3,
        tdAttrs: { style: 'padding: 10px;' }
    },

    defaults: {
        xtype: 'panel',
        width: 200,
        height: 200,
        bodyPadding: 10,
        frame: true
    },
    
    initComponent: function () {
        this.callParent();
    }
});
