layui.define(['element','form','layer','layedit','upload'],function(exports){
	   var $ = layui.$;
	   var element = layui.element;
	   var layer = layui.layer;
  	   var form = layui.form;
  	   var layedit = layui.layedit;
  	   var url = $('#url').val();
	   
	   window.Detail = function(id){
          location.href= "/default/detail/"+id+"/";
       }
       
       
       
       window.Pay = function(id){
          location.href= "/default/pay/"+id+"/";
       }
       
       
       
       form.on('submit(demo1)', function(data){
           $.post('/default/pay', {name:data.field.name,type:data.field.type,jine:data.field.jine}, function (res) {
                 if(0 === res.code){
                     layer.msg(res.msg, {icon: 1});
                 }else if(1 === res.code){
                     layer.msg(res.msg, {icon: 1});
                 }else if(2 === res.code){
                     layer.msg(res.msg, {icon: 1});
                 }
	       });
	       return false;
       });
       
       
       layedit.set({
  		  uploadImage: {
  		    url: '/default/edit_upload' //接口url
  		  }
      	});
      	
       var editIndex = layedit.build('eContentEdt'); // 建立编辑器
       
       layui.upload.render({
            elem: '#LAY_video_upload'
            , url: '/default/upload'
            , accept: 'file' //指定允许上传时校验的文件类型
  		     , size: 102400 //最大允许上传的文件大小
            , before: function (obj) {
          	  layer.msg('正在上传中，请稍等...', {icon: 16,offset: 't',shade:0.3,offset: '170px'});
            }
            , done: function (res) {
                if (res.code == 0) {
              	  layer.msg(res.msg, {anim: 6,icon: 6,offset: 't',shade:0.3,offset: '30px',time: 1500}, function(index){
  						//给模板url赋值
  						$("input[name='url']").val("http://localhost:8098/getFileURL/file/"+res.url);
  					});
                } else {
              	  layer.msg(res.msg, {anim: 6,icon: 5,offset: 't',shade: 0.3,offset: '30px',time: 1500});
                }
            }
        });
        
        layui.upload.render({
            elem: '#LAY_image_upload'
            , url: '/default/upload'
            , accept: 'file' //指定允许上传时校验的文件类型
            , exts: 'jpg|png'
  		     , size: 102400 //最大允许上传的文件大小
            , before: function (obj) {
          	  layer.msg('正在上传中，请稍等...', {icon: 16,offset: 't',shade:0.3,offset: '170px'});
            }
            , done: function (res) {
                if (res.code == 0) {
              	  layer.msg(res.msg, {anim: 6,icon: 6,offset: 't',shade:0.3,offset: '30px',time: 1500}, function(index){
  						//给模板url赋值
  						$("input[name='image']").val("http://localhost:8098/getFileURL/file/"+res.url);
  					});
                } else {
              	  layer.msg(res.msg, {anim: 6,icon: 5,offset: 't',shade: 0.3,offset: '30px',time: 1500});
                }
            }
        });
       
       form.on('submit(demo2)', function(data){
           $.post('/default/releaseSave', {name:data.field.name,content:data.field.content,url:data.field.url,image:data.field.image}, function (res) {
                 if(0 === res.code){
                     layer.msg(res.msg, {icon: 1});
                 }else if(1 === res.code){
                     layer.msg(res.msg, {icon: 1});
                 }else if(2 === res.code){
                     layer.msg(res.msg, {icon: 1});
                 }
	       });
	       return false;
       });
	   
	   exports('detail',null);
})