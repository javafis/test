Ext.define('Huskar.view.Navigation', {
    extend: 'Ext.tree.Panel',
    xtype: 'navigation',
    title: '导航',
    rootVisible: false,
    lines: false,
    useArrows: true,
    root: {
        expanded: true,
        children: [
            {
                text:'系统管理',
                expanded: true,
                children: [
                    {
                    	id:'Huskar.view.panel.UserPanel-node',
                    	text: '用户管理',
                    	leaf: true
                    },{
                    	id:'Huskar.view.panel.RolePanel-node',
                    	text: '权限管理', 
                    	leaf: true 
                    }
                ]
            }
        ]
    }
});