<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE HTML>


<!--[if IE 9]><html class="ie9"><![endif]-->
<!--[if IE 8]><html class="ie8"><![endif]-->
<!--[if IE 7]><html class="ie7"><![endif]-->
<!--[if IE 6]><html class="ie6"><![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html>
<!--<![endif]-->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<link rel="dns-prefetch" href="//xs01.meituan.net">
<link rel="dns-prefetch" href="//p0.meituan.net">
<link rel="dns-prefetch" href="//p1.meituan.net">
<link rel="stylesheet" type="text/css" href="css/personal.css" />
<meta name="baidu-site-verification" content="Qu9OzfSVVJ" />
<meta name="keywords" content="XXX外卖">
<meta name="description" content="吃了么,没吃就上吃了么网上订餐服务。">
<title>XXX商家</title>
<script type="text/javascript">
    var MT = {};
    MT.BOOTSTAMP = new Date().getTime();
    MT.STATIC_ROOT = "http://xs01.meituan.net/waimai_web";
    MT.ENV = "production";
    </script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="css/main.css">
<link rel="shortcut icon" type="image/vnd.microsoft.icon"
	href="/static/img/favicon_1.ico">
<link rel="icon" href="/static/img/favicon_1.ico" size="16x16 32x32">
<link rel="stylesheet" href="css/restaurant_f2ca72fb.css" />



</head>
<body>
<jsp:include page="head.jsp"></jsp:include>
	<div id="">
		<div id="zuofudong">
			<ul>
				<li><a id="sanyuedan">商家订单</a>
					</li>

			</ul>
		</div>
		<div id="mydingdan">
				<ul id="list">
				 <c:forEach items="${Order}" var="Order">
						<ul id="test">
							订单ID :  ${Order.orderId}<br />
	      				           下单时间 : ${Order.orderTime}<br />
	      					<!-- <p id="">价格:后台拼接好再说</p><br /> -->
	      					<c:forEach items="${listaksdhjasd}" var="listaksdhjasd">
	      							<br>
	      							商品名字:${listaksdhjasd.name}
	      							商品数量:${listaksdhjasd.num}
	      							商品价格:${listaksdhjasd.price}
	      							<br>
	      					</c:forEach>
	      					
	      					
	      					<br />
								点击我! 查看配送信息:<li id="test">${Order.userId}</li>
	      					<br />
	      						<div id = "lijianzhangSB">
	      							
	      						</div>
	      					
	      					
	      					<br />
	      							<span style="color: red"><a style="color: red" href="updateUserOrder?orderId=${Order.orderId}">确认接单</a></span>
	      							<span style="color: red"><a style="color: red" href="delectUserOrder?orderId=${Order.orderId}">删除接单</a></span>
	      					
	      					
						</ul>
				</c:forEach>
				</ul> 


		</div>
	
	</div>
	<!--
   	作者：1010036652@qq.com
   	时间：2017-10-26
   	描述：我的账户我的收藏切换
   -->
	<script type="text/javascript">
	$(function(){
		$("#sanyuedan").click(function(){
				$("#mydingdan").show();
				$("#myshoucang,#myzhanghu").hide();
																		});
		$("#wodezhanghu").click(function(){
		    $("#myzhanghu").show();
		    $("#myshoucang,#mydingdan").hide();
		$("#wodeshoucang").click(function() {
			$("#myshoucang").show();
			$("#myzhanghu,#mydingdan").hide();
		});
		$("#myzhanghu_touxiang").click(function () {
	   			$("#touxiangshangchuan").show();
	   		});   
		});
	});
</script>
	<!--
	作者：1010036652@qq.com
	时间：2017-10-26
	描述：判断上传的是否是图片
-->
	<script>
	   function imgPreview(fileDom){
        //判断是否支持FileReader
        if (window.FileReader) {
            var reader = new FileReader();
        } else {
            alert("您的设备不支持图片预览功能，如需该功能请升级您的设备！");
        }

        //获取文件
        var file = fileDom.files[0];
        var imageType = /^image\//;
        //是否是图片
        if (!imageType.test(file.type)) {
            alert("请选择图片！");
            return;
        }
        //读取完成
        reader.onload = function(e) {
            //获取图片dom
            var img = document.getElementById("preview");
            //图片路径设置为读取的图片
            img.src = e.target.result;
        };
        reader.readAsDataURL(file);
    }
</script>
	<script type="text/javascript">
      //全局违禁词规定
      var forbiddenWords = ['习大大', '习达达', '习哒哒', '习近平', '彭麻麻','彭妈妈', '彭丽媛'];
  </script>


	<script type="text/javascript">
			window.onload = function() {
				var obj_lis = document.getElementById("test").getElementsByTagName("li");
				for(i = 0; i < obj_lis.length; i++) {
					obj_lis[i].onclick = function() {
						var value = this.innerHTML;
						var html = "";
						$.post("userId",{"value":value},function(test){
								var ht=JSON.parse(test);
								$.each(ht.dataMap,function(index,m){
									html+="<br>";
									html+="<br>";
									html+="下单用户:"+m.userName;
									html+="<br>";
									html+="用户电话:"+m.phone;
									html+="<br>";
									html+="用户地址:"+m.roomAddress;
									html+="<br>";
									html+="用户邮箱:"+m.email;
									html+="<br>";
				      						
								});
								$("#lijianzhangSB").html(html);
								//window.location.href="index.jsp"
								//window.location.href="jb51.jsp?backurl="+window.location.href; 
								html="";
							});
					}
				}
			}
		</script>

</body>
</html>
