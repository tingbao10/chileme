<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		 <script src="assets/js/jquery-1.8.2.min.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/js/jquery.backstretch.min.js"></script>
        <script src="assets/js/scripts.js"></script>
		<link rel="stylesheet" type="text/css" href="css/new_file.css"/>
		<script src="assets/js/upload.js" type="text/javascript" charset="utf-8"></script>
	</head>
	<body style="margin: 0px 0px;">
		<div id="chengweishagnjia">
			<h3 style="color: deepskyblue; margin: 0px 0px; margin-left: 10px;">成为商家</h3>
			<hr style=" border: 1px solid deepskyblue;">
			<form id="upload_form" >
				   <div id="">
				   	<div id="">
				   		<img id="preview" style="width: 80px; height: 80px;" alt="商家LOGO"/><br />
    					<p id="tijiao">
    					<input type="file" name="files" onchange="imgPreview(this)" />
    					选择图片
    					</p>
    					<input type="text" name="shopName" id="dianming" placeholder="输入店名" />
				   	</div>
      			  <span id="anniu">
    					<input type="button" onClick="submitPicture()" value="确定" />
    					<input type="button"  id="quxiao" value="取消" style="margin-left: 10px;"/>
    				</span>
    		</form>
		</div>
		<!--测试测试-->
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
	</body>
</html>