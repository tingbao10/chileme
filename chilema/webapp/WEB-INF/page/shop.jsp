<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>登陆</title>
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/style.css">
<!-- 我导入自写CSS -->
<link rel="stylesheet" href="ajxj/my.css">
<!-- Javascript -->
	<script src="assets/js/jquery-1.8.2.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/js/jquery.backstretch.min.js"></script>
	<script src="assets/js/scripts.js"></script>
</head>
<body>

<jsp:include page="head.jsp"></jsp:include>

	<div class="register-container container">
		<div class="row">
			<div class="iphone span5">
				<img src="assets/img/ditu.jpg" alt="">
			</div>
			<div class="inpoy span6">
				<form class="bs-example bs-example-form" role="form" action="userToShop" method="post">
					<div class="input-group">
						<span class="input-group-addon">账号</span> <input type="text"
							class="form-control"  disabled="disabled" value="${str.phone}" id="phone">
					</div>
					<br>
					
					<div class="input-group">
						<span class="input-group-addon" >商店名</span> <input type="text"
							class="form-control" name="shopName"   id="nickName">
					</div>
					<br>
					
				
					<input type="button" class="btn-success btn-lg" value="注册" id="subm"> 
					
					
				</form>

			</div>
		</div>
	</div>
	

</body>
</html>