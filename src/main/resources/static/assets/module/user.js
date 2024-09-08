 
layui.define(['laypage', 'element', 'flow','admin', 'table','tableX'], function(exports){

  var $ = layui.jquery;
  var layer = layui.layer;
  var util = layui.util;
  var laytpl = layui.laytpl;
  var form = layui.form;
  var laypage = layui.laypage;
  var flow = layui.flow;
  var element = layui.element;
  var upload = layui.upload;
  var table = layui.table;
  var tableX = layui.tableX;



  //已购产品
  var insTb = tableX.render({
    elem: '#LAY_orderList'
    ,url: '/course/order/page'
    ,method: 'get'
    ,where:{userId:layui.cache.user.uid}
    ,cols: [[
      {field:'orderNo',title: '订单号', minWidth: 200}
      ,{field:'name',title: '产品名称', minWidth: 200}
      ,{field:'type',align: 'center', title: '支付方式', width: 100}
      ,{field: 'jine', align: 'center',title: '付费金额', width: 100}
      ,{field: 'create_time',align: 'center', title: '创建时间', width: 200, templet: function(d){
        return layui.util.toDateString(d.createTime, "yyyy-MM-dd HH:mm:ss");
      }}
    ]]
    ,page: true
  });
  
  //通知信息
  var insTb = tableX.render({
    elem: '#LAY_noticeList'
    ,url: '/course/notice/page'
    ,method: 'get'
    ,cols: [[
      {field:'name',title: '名称', minWidth: 100}
      ,{field:'content',align: 'center', title: '内容', width: 500}
      ,{align: 'center',title: '教师', width: 100,templet:teacher}
      ,{field: 'createTime',align: 'center', title: '创建时间', width: 200, templet: function(d){
        return layui.util.toDateString(d.createTime, "yyyy-MM-dd HH:mm:ss");
      }}
    ]]
    ,page: true
  });
  
  function teacher(d){
     var teachername = $.ajax({url:"/course/teacher/getById",data:{id:d.teacherId},async:false});
     return teachername.responseText;
  }
  
	  var insTb = tableX.render({
	    elem: '#LAY_releaseList'
	    ,url: '/course/release/page'
	    ,method: 'get'
	    ,cols: [[
                {field: 'name', title: '名称', sort: true,width:200},
                {field: 'content', title: '内容', sort: true,width:300},
                {field: 'url', title: '资料', sort: true},
                {field: 'state', title: '状态', sort: true,templet:state},
                {field: 'createTime', title: '创建时间', sort: true},
            ]]
	    ,page: true
	  });
	  
	  function state(d){
	      if(d.state == 0){
	         return "未审核";
	      }else if(d.state == 1){
	         return "审核通过";
	      }else if(d.state == 2){
	         return "审核不通过";
	      }
	  }

    /* 表格搜索 */
    form.on('submit(releaseTbSearch)', function (data) {
        insTb.reload({where: data.field, page: {curr: 1}});
        return false;
    });
    
  exports('user', null);
  
});