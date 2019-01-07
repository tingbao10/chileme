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
</head>
<body>

 

        <div class="register-container container">
            <div class="row">
                <div class="iphone span5">
                    <img src="assets/img/ditu.jpg" alt="">
                </div>
                <div class="register span6">
                    <form action="userLogin" method="post">
                        <h2>登录 <span class="red"><strong>吃了吗</strong></span></h2>
                        <label for="username">用户名</label>
                        <input type="text" id="username" name="loginUser" placeholder="请输入用户名">
                        <label for="password">用户密码</label>
                        <input type="password" id="password" name="password" placeholder="请输入用户密码">
                       
                        <span style="float: right;"><a href="register">注册</a></span>
                        <span class="sf1">账号或密码错误</span>
                         <button type="button"  id="sub">登录</button>
                    </form>
             	 
               </div>
            </div>
        </div>
        <!-- Javascript -->
        <script src="assets/js/jquery-1.8.2.min.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/js/jquery.backstretch.min.js"></script>
        <script src="assets/js/scripts.js"></script>
        <script src="ajxj/ajax.js"></script>

    </body>
</html>