Ext.define('Huskar.view.tab.FramedTabs', {
    extend: 'Ext.tab.Panel',
    xtype: 'framed-tabs',
    
    //<example>
    exampleTitle: 'Framed Tabs',
    exampleDescription: [
        '<p>Demonstrates a tab panel with framing.</p>'
    ].join(''),
    //</example>
    
    frame: true,
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