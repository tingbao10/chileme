<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商家上传菜品</title>
<meta charset="UTF-8">
<title></title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

#upBox {
	text-align: center;
	width: 500px;
	padding: 20px;
	border: 1px solid #666;
	margin: auto;
	margin-top: 150px;
	margin-bottom: 200px;
	position: relative;
	border-radius: 10px;
}

#inputBox {
	width: 100%;
	height: 40px;
	border: 1px solid cornflowerblue;
	color: cornflowerblue;
	border-radius: 20px;
	position: relative;
	text-align: center;
	line-height: 40px;
	overflow: hidden;
	font-size: 16px;
}

#inputBox input {
	width: 114%;
	height: 40px;
	opacity: 0;
	cursor: pointer;
	position: absolute;
	top: 0;
	left: -14%;
}

#imgBox {
	text-align: left;
}

.imgContainer {
	display: inline-block;
	width: 32%;
	height: 150px;
	margin-left: 1%;
	border: 1px solid #666666;
	position: relative;
	margin-top: 30px;
	box-sizing: border-box;
}

.imgContainer img {
	width: 100%;
	height: 150px;
	cursor: pointer;
}

.imgContainer p {
	position: absolute;
	bottom: -1px;
	left: 0;
	width: 100%;
	height: 30px;
	background: black;
	text-align: center;
	line-height: 30px;
	color: white;
	font-size: 16px;
	font-weight: bold;
	cursor: pointer;
	display: none;
}

.imgContainer:hover p {
	display: block;
}

#btn {
	outline: none;
	width: 100px;
	height: 30px;
	background: cornflowerblue;
	border: 1px solid cornflowerblue;
	color: white;
	cursor: pointer;
	margin-top: 30px;
	border-radius: 5px;
}
</style>
<script src="upload/js/jquery-2.0.0.js"></script>
</head>
<body>
	<form id="upload_form"  enctype="data/form-data">
		<div style="width: 100%; height: 100vh; position: relative;">
			<div id="upBox">
				<div id="inputBox">
					<input type="file" title="请选择上传菜品主图" id="file" name="files" multiple
						accept="upload/image/png,upload/image/jpg,upload/image/gif,upload/image/JPEG" />请选择上传菜品主图
				</div>
				<div id="imgBox"></div>
					<br>
				<br>
				<br>
				商品标题 : <input type="text"  id="shopName" name="shopName">   
				商品价格 : <input type="text"  id="shopPice" name="shopPice">
				
				<button id="btn">发布菜品</button>
			</div>
		</div>
	</form>
	<script src="upload/js/uploadImg2.js" type="text/javascript"
		charset="utf-8"></script>
	<script type="text/javascript">
		imgUpload({
			inputId : 'file', //inputæ¡id
			imgBox : 'imgBox', //å¾çå®¹å¨id
			buttonId : 'btn', //æäº¤æé®id
			upUrl : 'shoptop', //æäº¤å°å
			data : 'files' //åæ°å
		})
	</script>

</body>
</html>