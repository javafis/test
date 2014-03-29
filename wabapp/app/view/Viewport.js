Ext.define('Huskar.view.Viewport', {
    extend: 'Ext.container.Viewport',
    layout: 'border',
    requires:[
    	'Huskar.view.MTabPanel'
    ],
    items: [{
		        region: 'north',
		        xtype: 'appHeader'
	    	}, {
		        region: 'west',
		        xtype: 'navigation',
		        width: 180,
		        split: true,
		        collapsible: true
	    	}, {
		        region: 'center',
		        xtype: 'mTpanel'
	    	}
	]
});