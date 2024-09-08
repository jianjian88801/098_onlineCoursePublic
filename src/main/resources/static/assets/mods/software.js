layui.define('dataGrid',function(exports){
	var $ = layui.jquery;
	var dataGrid = layui.dataGrid;
    
    
    
    var ins = dataGrid.render({
        elem: '#demoCardList2',
        templet: '#demoCardItem2',
        url: '/all',
        loadMore: {limit: 12}
    });
    
    
    
    
    exports("software",null);
})