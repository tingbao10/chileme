<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/style.css">
<link rel="stylesheet" href="ajxj/register.css">
</head>
<body>

	<div class="register-container container">
		<div class="row">
			<div class="iphone span5">
				<img src="assets/img/ditu.jpg" alt="">
			</div>
			<div class="register span6" id="calss11">
				<form action="register" method="post">
					<h2>
						注册 <span class="red"><strong>吃了吗</strong></span>
					</h2>
					 <label
						for="phone">手机号码</label> <input type="text" id="phone"
						name="phone" placeholder="请输入11位手机号码">
					<label for="password">密码</label> <input type="password"
						id="password1" name="password" placeholder="请输入用户密码"> <label
						for="password">确认密码</label> <input type="password" id="password2"
						name="password2" placeholder="请再次输入用户密码">
					<span id="yanzhengmatishi" style=" line-height: 40px;">
					<p style="height: 40px; color: red; font-size: 16px; text-align: left; margin-left: 5px;">最开始不要设值，输入验证码后用.text(提示)</p>	
					<input type="text" placeholder="输入验证码" id="yamnum" name="verificationCode" style="margin-top: 10px;">
					<input type="button" id="yzm" class="yzm" value="发送验证码" style="margin-bottom: 10px;" />
					</span>
					<button  type="button" id="tj">注册</button>
				</form>
			</div>
		</div>
	</div>
	<!-- Javascript -->
	<script src="assets/js/jquery-1.8.2.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/js/jquery.backstretch.min.js"></script>
	<script src="assets/js/scripts.js"></script>
	<script type="text/javascript" src="ajxj/ajax.js"></script>
	<script type="text/javascript">
		$(function(){
		$("#yzm").click(function(){
			$(this).css("background","darkgrey");
		});
		});
	</script>
</body>

</html>
