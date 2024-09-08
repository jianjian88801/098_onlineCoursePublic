layui.define(['layer', 'dataGrid', 'element'],function(exports){
	
	var $ = layui.jquery;
    var layer = layui.layer;
    var dataGrid = layui.dataGrid;
   
    var ins = dataGrid.render({
        elem: '#demoCardList1',
        templet: '#demoCardItem1',
        url: '/default/course/page',
        page: {limit: 12,limits: [12, 24, 36, 48, 60]}  // 开启分页
    });
   
    
    window.Classify = function(classify){
    	var ins = dataGrid.render({
            elem: '#demoCardList1',
            templet: '#demoCardItem1',
            url: '/default/course/page',
            where: {classifyId:classify},
            page: {limit: 12,limits: [12, 24, 36, 48, 60]}  // 开启分页
        });
    }
    
    
    window.Type = function(type){
    	var ins = dataGrid.render({
            elem: '#demoCardList1',
            templet: '#demoCardItem1',
            url: '/default/course/page',
            where: {type:type},
            page: {limit: 12,limits: [12, 24, 36, 48, 60]}  // 开启分页
        });
    }
    
    window.Search = function(){
        var title = document.getElementById("sea_text").value;
    	var ins = dataGrid.render({
            elem: '#demoCardList1',
            templet: '#demoCardItem1',
            url: '/default/course/page',
            where: {name:title},
            page: {limit: 12,limits: [12, 24, 36, 48, 60]}  // 开启分页
        });
    }
    
    window.Detail = function(id){
        location.href= "/default/detail/"+id+"/";
    }
    
    exports('codes', null);
})