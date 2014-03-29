Ext.define('Huskar.view.panel.UserPanel', {
    extend: 'Ext.panel.Panel',
    layout:'border',
    items:[
           {
        	   xtype:'panel',
        	   region:'center',
        	   border:1,
        	   html:'sss'
           },{
        	   xtype:'panel',
        	   region:'east',
        	   width:200,
        	   html:'west'
           }       
    ],
    initComponent: function () {
    	var userListStore = new Ext.data.JsonStore({
            autoLoad :true,
            storeId: 'myStore',
            proxy: {
                type: 'ajax',
                url : 'account/listUser.action',
                reader: {
                    type: 'json',
                    root: 'images',
                    idProperty: 'name'
                }
            },
            fields: ["password","userName","email","msn","qq","id"]
        });
        
    	this.callParent();
    }
});
