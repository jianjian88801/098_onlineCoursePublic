layui.define(['element','carousel','dataGrid'], function(exports){
	var element = layui.element;
	var carousel = layui.carousel;
	var $ = layui.$;
	var dataGrid = layui.dataGrid;
	
	
	//图片轮播
    carousel.render({
      elem: '#test10'
      ,width: '100%'
      ,height: '440px'
      ,interval: 5000
    });
	   
    window.Detail = function(id){
        location.href= "/default/detail/"+id+"/";
    }
    
    window.Detail2 = function(id){
        location.href= "/default/detail2/"+id+"/";
    }
    
    var ins = dataGrid.render({
        elem: '#demoCardList1',
        templet: '#demoCardItem1',
        url: '/default/present/page',
        loadMore: {limit: 12}
    });
    
    var ins = dataGrid.render({
        elem: '#demoCardList2',
        templet: '#demoCardItem2',
        where:{state:1},
        url: '/default/release/page',
        loadMore: {limit: 12}
    });
    
    exports('default', null);
});