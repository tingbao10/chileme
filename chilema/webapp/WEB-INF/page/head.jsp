<%@ page language="java" contentType="text/html; charset=utf-81"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="js/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" href="css/main.css">
<title>Insert title here</title>
</head>
<body>
	<!-- 顶部导航条 -->
	<div class="topbar">
		<div class="container">
			<div class="topbar-info">
				<c:choose>
					<c:when test="${user==null}">
						<a href="userLogin" class="link">登录</a>
						<span class="ver">|</span>
						<a href="register" class="link">注册</a>
					</c:when>
					<c:otherwise>
						<a href="userinfo" class="link">用户:${user.nickName}</a>
						<c:choose>
							<c:when test="${user.groupId==2}">
								<a href="shopUp" class="link">上传菜品</a>
								<a href="ShopPersonal" class="link">已卖出的</a>
							</c:when>
							<c:otherwise>
								<a href="userToShop">成为商家</a>
							</c:otherwise>
						</c:choose>
						<a href="zhuxiao" class="link">注销</a>
						<span class="ver">|</span>
					</c:otherwise>
				</c:choose>
				<span class="ver">|</span> <a href="homo" class="link">首頁</a>
			</div>
		</div>
	</div>
</body>
</html>