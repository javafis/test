
//@require @packageOverrides
Ext.application({
	name: 'Huskar',
    controllers: [
        'Main'
    ],
    init: function() {
    	Ext.tip.QuickTipManager.init();
        //Ext.state.Manager.setProvider(Ext.create('Ext.state.CookieProvider'));
    	var MainApp = Ext.create('Huskar.view.Viewport');
    }
});
