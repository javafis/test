Ext.define('Huskar.view.tab.BasicTabs', {
    extend: 'Ext.tab.Panel',
    xtype: 'basic-tabs',
    
    //<example>
    exampleTitle: 'Basic Tabs',
    exampleDescription: [
        '<p>Demonstrates a default configuration of a tab panel.</p>'
    ].join(''),
    //</example>
    width: 400,
    height: 300,
    defaults: {
        bodyPadding: 10,
        autoScroll: true
    },
    items: [{
        title: 'Active Tab',
        html: Huskar.DummyText.longText
    }, {
        title: 'Inactive Tab',
        html: Huskar.DummyText.extraLongText
    }, {
        title: 'Disabled Tab',
        disabled: true
    }]
});