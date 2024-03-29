Ext.define('Huskar.view.toolbar.BasicToolbar', {
    extend: 'Ext.toolbar.Toolbar',
    xtype: 'basic-toolbar',
    id: 'basic-toolbar',
    //<example>
    exampleTitle: 'Basic Toolbar',
    exampleDescription: [
        '<p>Demonstrates a simple toolbar. Some of the buttons have menus attached.</p>'
    ].join(''),
    themes: {
        classic: {
            width: 380,
            pasteIconCls: 'paste',
            cutIconCls: 'cut',
            copyIconCls: 'copy',
            formatIconCls: 'format',
            listIconCls: 'list'
        },
        neptune: {
            width: 500,
            pasteGlyph: 70,
            cutGlyph: 67,
            copyGlyph: 102,
            formatGlyph: 76,
            listGlyph: 61
        }
    },
    //</example>

    initComponent: function() {
        Ext.apply(this, {
            width: this.themeInfo.width,
            items: [{
                xtype:'splitbutton',
                text:'Menu Button',
                iconCls: this.themeInfo.listIconCls,
                glyph: this.themeInfo.listGlyph,
                menu:[{
                    text:'Menu Button 1'
                }]
            }, '-', {
                xtype:'splitbutton',
                text:'Cut',
                iconCls: this.themeInfo.cutIconCls,
                glyph: this.themeInfo.cutGlyph,
                menu: [{
                    text:'Cut Menu Item'
                }]
            }, {
                iconCls: this.themeInfo.copyIconCls,
                glyph: this.themeInfo.copyGlyph,
                text:'Copy'
            }, {
                text:'Paste',
                iconCls: this.themeInfo.pasteIconCls,
                glyph: this.themeInfo.pasteGlyph,
                menu:[{
                    text:'Paste Menu Item'
                }]
            }, '-', {
                iconCls: this.themeInfo.formatIconCls,
                glyph: this.themeInfo.formatGlyph,
                text:'Format'
            }]
        });
        this.callParent();
    }
});