<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
<!--[if lt IE 9]>
<script type="text/javascript" src="/H-ui/lib/html5shiv.js"></script>
<script type="text/javascript" src="/H-ui/lib/respond.min.js"></script>
<![endif]-->
<!--[if IE 6]>
<script type="text/javascript" src="/H-ui/lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('.pngfix,.icon');</script>
<![endif]--> 
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<link  rel="stylesheet" type="text/css" href="/H-ui/static/h-ui/css/H-ui.min.css">
<script type="text/javascript" src="/H-ui/static/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="/H-ui/lib/layer/2.4/layer.js"></script>
<link  rel="stylesheet" type="text/css" href="/commons/css/login.css">
<style type="text/css">
	body{
		background: url("/commons/bg1800.jpg") no-repeat center 0;
		background-size: 100% auto;
	}
</style>
</head>
<body>
	<div class="box">
		<div class="group">
			<input type="text" class="input-text radius size-L" placeholder="请输入用户名" name="username" value="admin">
			<input type="password" class="input-text radius size-L" placeholder="请输入密码" name="password" value="useradmin9527">
			<div class="code-box">
				<input type="text" class="input-text radius size-L" placeholder="请输入验证码" name="code">
				<img alt="点击刷新验证码" src="/login/code" onclick="changeImg(this)">
			</div>
			<input type="button" class="btn btn-primary radius size-L" value="登录" onclick="submitForm()">
		</div>
	</div>
	<script type="text/javascript">
		function submitForm(){
			var username = $("input[name=username]").val().trim();
			var password = $("input[name=password]").val().trim();
			var code = $("input[name=code]").val().trim();
			
			$.post("/login/login",{"username":username,"password":password,"code":code},function(data){
				if(data.result){
					var index = layer.load(1, {
						  shade: [0.1,'#fff'] //0.1透明度的白色背景
					});
					location.href="/index/";
				}else{
					$.Huimodalalert(data.msg,2000);
				}
			});
		}
		function changeImg(ele){
			ele.src = "/login/code?"+new Date().getTime();
		}
	</script>
</body>
</html>