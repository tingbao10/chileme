//上传(将文件流数组传到后台)
function submitPicture() {
	var data = new FormData($("#upload_form")[0]);
	$.ajax({
		url: 'userToShop' ,
		type: 'POST',  
		data: data,  
		async: true,  //设置为同步
		cache: false,  
		contentType: false,  
		processData: false,  
		success: function(dat) {
			var json= eval('(' + dat + ')');
			if(json.code==-1){
				alert("您还没有登陆，请登陆");
				window.location.replace("userLogin");
			}else{
				alert("注册成功")
				window.location.replace("homo");
			}
		}
	});
	return false;
}