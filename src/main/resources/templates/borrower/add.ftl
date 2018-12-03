<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="/favicon.ico" >
<link rel="Shortcut Icon" href="/favicon.ico" />
<!--[if lt IE 9]>
<script type="text/javascript" src="/H-ui/lib/html5shiv.js"></script>
<script type="text/javascript" src="/H-ui/lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="/H-ui/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="/H-ui/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="/H-ui/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="/H-ui/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="/H-ui/static/h-ui.admin/css/style.css" />

<script type="text/javascript" src="/H-ui/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="/H-ui/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="/H-ui/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="/H-ui/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<script type="text/javascript" src="/H-ui/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="/H-ui/lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="/H-ui/lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="/H-ui/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<!--[if IE 6]>
<script type="text/javascript" src="/H-ui/lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<!--/meta 作为公共模版分离出去-->
<title>添加短信用户</title>
</head>
<body>
<article class="page-container">
	<form action="" method="post" class="form form-horizontal" id="form-member-add">
		<div class="row cl">
			<label class="form-label col-xs-3 col-sm-3"><span class="c-red">*</span>合同编号：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="请输入合同编号" name="number">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-3 col-sm-3"><span class="c-red">*</span>姓名：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="请输入姓名" name="name" style="width:40%">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;手&nbsp;&nbsp;机：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="text" class="input-text" value="" placeholder="请输入手机" name="phone" style="width:40%">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-3 col-sm-3"><span class="c-red">*</span>借款起止时间：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" placeholder="请输入借款起始时间" onfocus="WdatePicker()" name="loanTime" class="input-text Wdate" style="width:40%">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="text" placeholder="请输入还款截止时间" onfocus="WdatePicker()" name="repaymentTime" class="input-text Wdate" style="width:40%">	
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-3 col-sm-3">紧联人姓名1：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="请输入紧联人姓名" name="name11" style="width:40%">
				紧联人手机1：
				<input type="text" class="input-text" value="" placeholder="请输入紧联人手机" name="phone11" style="width:40%">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-3 col-sm-3">紧联人姓名2：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="请输入紧联人姓名" name="name12" style="width:40%">
				紧联人手机2：
				<input type="text" class="input-text" value="" placeholder="请输入紧联人手机" name="phone12" style="width:40%">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-3 col-sm-3">担保人姓名1：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="请输入担保人姓名" name="name21" style="width:40%">
				担保人手机1：
				<input type="text" class="input-text" value="" placeholder="请输入担保人手机" name="phone21" style="width:40%">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-3 col-sm-3">担保人姓名2：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="请输入担保人姓名" name="name22" style="width:40%">
				担保人手机2：
				<input type="text" class="input-text" value="" placeholder="请输入担保人手机" name="phone22" style="width:40%">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-3 col-sm-3">担保人姓名3：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="请输入担保人姓名" name="name23" style="width:40%">
				担保人手机3：
				<input type="text" class="input-text" value="" placeholder="请输入担保人手机" name="phone23" style="width:40%">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-3 col-sm-3">备注：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<textarea name="remark" cols="" rows="" class="textarea" placeholder="请输入备注信息"></textarea>
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-3 col-sm-offset-3">
				<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
			</div>
		</div>
	</form>
</article>
<script type="text/javascript">
$(function(){
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});

	$("#form-member-add").validate({
		rules:{
			number:{
				required:true
			},
			name:{
				required:true
			},
			phone:{
				required:true,
				isMobile:true
			},
			phone11:{
				isMobile:true
			},
			phone12:{
				isMobile:true
			},
			phone21:{
				isMobile:true
			},
			phone22:{
				isMobile:true
			},
			phone23:{
				isMobile:true
			},
			loanTime:{
				required:true
			},
			repaymentTime:{
				required:true
			},
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
			var name11 = $("input[name=name11]").val().trim();
			var phone11 = $("input[name=phone11]").val().trim();
			if(name11&&!phone11){
				layer.msg("紧联人1填写时，必须填写对应的电话",{icon:1,time:1000});
				return;
			}
			var name12 = $("input[name=name12]").val().trim();
			var phone12 = $("input[name=phone12]").val().trim();
			if(name12&&!phone12){
				layer.msg("紧联人2填写时，必须填写对应的电话",{icon:1,time:1000});
				return;
			}
			var name21 = $("input[name=name21]").val().trim();
			var phone21 = $("input[name=phone21]").val().trim();
			if(name21&&!phone21){
				layer.msg("担保人1填写时，必须填写对应的电话",{icon:1,time:1000});
				return;
			}
			var name22 = $("input[name=name22]").val().trim();
			var phone22 = $("input[name=phone22]").val().trim();
			if(name22&&!phone22){
				layer.msg("担保人2填写时，必须填写对应的电话",{icon:1,time:1000});
				return;
			}
			var name23 = $("input[name=name23]").val().trim();
			var phone23 = $("input[name=phone23]").val().trim();
			if(name23&&!phone23){
				layer.msg("担保人3填写时，必须填写对应的电话",{icon:1,time:1000});
				return;
			}
			
			$(form).ajaxSubmit({
				type: 'post',
				url: "/borrower/add" ,
				success: function(data){
					layer.msg(data.msg,{icon:1,time:1000});
					if(data.result){
						parent.$('.btn-refresh').click();
// 						var index = parent.layer.getFrameIndex(window.name);
// 						parent.layer.close(index);
					}
				},
                error: function(XmlHttpRequest, textStatus, errorThrown){
					layer.msg('网络异常,请刷新重试!',{icon:2,time:1000});
				}
			});
		}
	});
});
</script> 
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>