layui.define(['element','carousel'], function(exports){
	var element = layui.element;
	var carousel = layui.carousel;
	var $ = layui.$;
	
	 //图片轮播
    carousel.render({
      elem: '#test10'
      ,width: '1210px'
      ,height: '440px'
      ,interval: 5000
    });
	   
    window.Detail = function(id){
        location.href= "/default/detail/"+id+"/";
    }
    
    
    
    exports('default', null);
});