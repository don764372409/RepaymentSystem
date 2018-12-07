<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="/H-ui/lib/html5shiv.js"></script>
<script type="text/javascript" src="/H-ui/lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="/H-ui/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="/H-ui/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="/H-ui/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="/H-ui/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="/H-ui/static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="/H-ui/lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>用户管理</title>
<style type="text/css">
	@media (max-width: 767px){
		.yueInfo span{
			display: block;
		}
	}
</style>
</head>
<body>
<div class="pd-20">
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <a class="btn btn-success radius r btn-refresh" style="line-height:1.6em;margin-top:3px" onclick="location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<!--   <div class="text-c"> 短信发送时间： -->
<!--     <input type="text" onfocus="WdatePicker()" id="datemin" class="input-text Wdate" style="width:120px;"> -->
<!--     - -->
<!--     <input type="text" onfocus="WdatePicker()" id="datemax" class="input-text Wdate" style="width:120px;"> -->
<!--     <input type="text" class="input-text" style="width:250px" placeholder="输入用户模板姓名、电话等进行查询" id="" name=""><button type="submit" class="btn btn-success" id="" name=""><i class="icon-search"></i> 搜用户</button> -->

<!--   </div> -->
  <div class="cl pd-5 bg-1 bk-gray mt-20">
  	<span class="l yueInfo">
  		<span>支付方式：${obj.payinfo}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
  		<span>余额:${obj.overage}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
  		<span>总点数：${obj.sendTotal}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
  		<a href="javascript:;" onclick="window.location.href=location.href;" class="btn btn-primary radius"><i class="icon-plus"></i> 刷新余额</a>
  	</span>
<!--     <span class="l"><a href="javascript:;" onclick="deleteObj()" class="btn btn-danger radius"><i class="icon-trash"></i> 删除用户</a> -->
<!--     <a href="javascript:;" onclick="location.relaod();" class="btn btn-primary radius"><i class="icon-plus"></i> 短信余额: 条</a></span> -->
    <span class="r">共有数据：<strong>${list?size}</strong> 条</span>
  </div>
  <div class="mt-20"></div>
  <table class="table table-border table-bordered table-hover table-bg table-sort">
    <thead>
      <tr class="text-c">
        <th width="60">联系人姓名</th>
        <th width="100">电话</th>
        <th width="200">发送内容</th>
        <th width="60">发送时间</th>
        <th width="40">发送状态</th>
      </tr>
    </thead>
    <tbody>
    <#list list as obj>
      <tr class="text-c">
        <td>
       		${obj.name?if_exists}
        </td>
        <td>${obj.phone?if_exists}</td>
        <td>
       		 <#if obj.status==1>
       		 	${obj.content?if_exists}
        		<#else>
        		通知管理员,${obj.name?if_exists} 电话：${obj.phone?if_exists} 短信未发送成功.
        	</#if>	
        </td>
        <td>
        	<#if obj.sendTime??>
	        	${obj.sendTime?datetime}
        	</#if>
        </td>
        <td>
        	<#if obj.status==1>
        		<span class="label label-success radius">发送成功</span>
        		<#else>
	        		<span class="label radius">发送失败</span>
        	</#if>	
        </td>
      </tr>
     </#list>
    </tbody>
  </table>
  <div id="pageNav" class="pageNav"></div>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="/H-ui/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="/H-ui/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="/H-ui/static/h-ui/js/H-ui.js"></script> 
<script type="text/javascript" src="/H-ui/static/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="/H-ui/lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" src="/H-ui/lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="/H-ui/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
window.onload = (function(){
    // optional set
    pageNav.pre="&lt;上一页";
    pageNav.next="下一页&gt;";
    // p,当前页码,pn,总页面
    pageNav.fn = function(p,pn){$("#pageinfo").text("当前页:"+p+" 总页: "+pn);};
    //重写分页状态,跳到第三页,总页33页
//     pageNav.go(1,13);
});
$('.table-sort').dataTable({
// 	"lengthMenu":false,//显示数量选择  默认显示
	"bFilter": true,//过滤功能
	"bPaginate": true,//翻页信息
	"bInfo": false,//数量信息
// 	"aaSorting": [[ 0, "desc" ]],//默认第几个排序
	"bStateSave": true,//状态保存
	"aoColumnDefs": [
	  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
// 	  {"orderable":false,"aTargets":[0,4,5]}// 制定列不参与排序
	]
});
function addObj(w,h,title,url){
	layer_show(title,url,w,h);
	//打开全屏
// 	layer.full(index);
}
function edit(w,h,title,url,id){
	layer_show(title,url+"?id="+id,w,h);
}

function deleteObj(obj,o,u,id){
	layer.confirm("确认要删除编号为1"+o+"的模板吗？",function(index){
		$.ajax({
			type: 'POST',
			url: u,
			data:{"id":id},
			dataType: 'json',
			success: function(data){
				layer.msg(data.msg,{icon:1,time:1000});
				if(data.result){
					$(obj).parents("tr").remove();
				}
			},
			error:function(data) {
				layer.msg("网络异常,请稍后再试.",{icon:1,time:1000});
			},
		});		
	});
}
</script>
</body>
</html>
