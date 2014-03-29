Ext.define('Huskar.controller.Main', {
    extend: 'Ext.app.Controller',
    requires: [
        'Huskar.view.*',
        'Ext.window.Window'
    ],

    refs: [
        {ref: 'navigation',selector: 'navigation'}
    ],

    init: function() {
        this.control({
            'navigation': {
                selectionchange: 'onNavSelectionChange',
                itemclick:'onItemClick'
            }
        });
    },
    
    onNavSelectionChange: function(selModel, records) {
        var record = records[0],
        text = record.get('text'),
        nodeId = record.get('id');
        
        if(nodeId){
        	var tmArray = nodeId.split('-');
        	var panelType = tmArray[0];
        	var panelId = tmArray[0]+'_id';
        	var panelTitle = text;
        	var panelInstance = Ext.getCmp(panelId);
        	if(!panelInstance){
        		panelInstance = Ext.create(panelType,{id:panelId,title:panelTitle});
        		Ext.getCmp('m-t-panel').add(panelInstance);
        	}
        	Ext.getCmp('m-t-panel').setActiveTab(panelInstance);
       }
        
    }
    
});
