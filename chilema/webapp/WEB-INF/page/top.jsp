<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品上传</title>
<script
	src="<%=request.getContextPath()%>/chilemapage/TOP/js/jquery-2.0.0.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/chilemapage/TOP/mycssAndimg/css.css">
</head>
<style>
</style>
<body
	style="background-image: url(<%=request.getContextPath()%>/chilemapage/TOP/mycssAndimg/timg.jpg);">
	<div id="none">
		<!-- style="width: 100%;height: 60px;background-color: white;" -->
	</div>

	<div>

		<div>
				<div id="divt" align="center">
					
				</div>
	
			<form id="upload_form">

				<!--                   <div>
                        <div><label for="image_file" style="color: wheat;">请选择投稿视频文件</label></div>
                        <div><input type="file" name="files" id="video" /></div>
                    </div> -->
				<div>
					<div>
						<label for="image_file" style="color: wheat;">请选择上传菜单图片</label>
					</div>
					<div>
						<input type="file" name="files" id="img" />
					</div>
				</div>
				<div>
					<div>
						<label for="image_file" style="color: wheat;">请输入这坨屎的标题</label>
					</div>
					<div>
						<input type="text" name="biaoti" id="biaoti" />
					</div>
				</div>

				<div>
					<div>
						<label for="image_file" style="color: wheat;">请输入本菜品的描述</label>
					</div>
					<div>
						<textarea rows="13" id="miaoshu" cols="70"></textarea>
					</div>
				</div>
				<div>
					<input type="button" value="立即投稿" id="tougao" /> <input
						type="button" id="homo" value="取消返回" />
				</div>
			</form>
			<div style="display: none;" id="daxiaobuneng">
				<b style="color: red;">总大小不能超过1g</b>
			</div>





		</div>
		<script type="text/javascript">
        	$("#homo").click(function(){
        		location.href = "homo";
        	})
        	
        </script>

		<script>
        	$("#tougao").click(function(){
					//判断图片
					var img = $("#img").val();
					if(img == "") {
						alert("请选择图片");
						return false;
					} else {
						if(!/\.(gif|jpg|jpeg|png|GIF|JPG|PNG)$/.test(img)) {
							alert("图片类型必须是.gif,jpeg,jpg,png中的一种")
							return false;
						}
					}
					//开始判断输入的内容
					var biaoti = $("#ibiaoti").val();
					var miaoshu = $("#miaoshu").val();
					if(biaoti == "" || miaoshu == "" || miaoshu == "null" || biaoti == "null") {
						alert("请正确输入标题和描述");
						return false;
					}
					//判断文件总大小 不能超1g
					//用户上传的视频
			        		/* var addImags =$("#video").prop('files');
			        		var fileSize=0;
			        		for(var i=0;i<addImags.length;i++){
			        			fileSize=$(addImags)[i].size; 
			        		}
			        		//用户上传的图片
			        		var addImags2 =$("#img").prop('files');
			        		var fileSize2=0;
			        		for(var i=0;i<addImags2.length;i++){
			        			fileSize2=$(addImags2)[i].size; 
			        		}
			        		
			        		var zonggongdaxiao = fileSize+fileSize2;
			        		var Maxzong = 1073741824;
			        		if(zonggongdaxiao>Maxzong){
			        				$("#daxiaobuneng").show();
			        			alert("对不起 文件过大.无法上传");
			        			return false;
			        		} */
			        		
        	
				//判断结束
				$("#tougao").attr('disabled',true); //将button变成不可点击
				 var formData = new FormData($( "#upload_form" )[0]);
				 $.ajax({  
			          url: 'shoptop' ,
			          type: 'POST',  
			          data: formData,  
			          async: true,  //设置为同步
			          cache: false,  
			          contentType: false,  
			          processData: false,  
			          success: function (returndata) {  
			        	  //$("#tougao").attr('disabled',false); //将button变成可点击
			        	  alert(returndata);
			        	  var html = "";
			        	  html +="<img src='${pageContext.request.contextPath}"+returndata+"'>";
			        	  alert(html);
			        	  $("#divt").html(html);
			          },  
			          error: function (returndata) {  
			              alert(returndata);  
			          }  
			     }); 

        	})
        	
        	
        </script>
		<!--         要想获取某个radio的值有以下的几种方法,直接给出代码：
					1、
					1.$('input[name="testradio"]:checked').val();2、
					1.$('input:radio:checked').val();3、
					1.$('input[@name="testradio"][checked]');4、
					1.$('input[name="testradio"]').filter(':checked');差不多挺全的了，如果我们要遍历name为testradio的所有radio呢，代码如下
					1.$('input[name="testradio"]').each(function(){2.alert(this.value);3.});如果要取具体某个radio的值，比如第二个radio的值，这样写
					1.$('input[name="testradio"]:eq(1)').val() -->
</body>



</html>