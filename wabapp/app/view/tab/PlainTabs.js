Ext.define('Huskar.view.tab.PlainTabs', {
    extend: 'Ext.tab.Panel',
    xtype: 'plain-tabs',
    
    //<example>
    exampleTitle: 'Plain Tabs',
    exampleDescription: [
        '<p>Demonstrates a tab panel with no background on the tab strip.</p>'
    ].join(''),
    //</example>
    
    width: 400,
    height: 300,
    plain: true,
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