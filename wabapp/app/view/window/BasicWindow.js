Ext.define('Huskar.view.window.BasicWindow', {
    extend: 'Ext.window.Window',
    xtype: 'basic-window',
    
    //<example>
    exampleTitle: 'Basic Window',
    exampleDescription: [
        '<p>Demonstrates a basic window control.</p>'
    ].join(''),
    //</example>
    
    height: 300,
    width: 400,
    title: 'Window',
    autoScroll: true,
    bodyPadding: 10,
    html: Huskar.DummyText.extraLongText
});