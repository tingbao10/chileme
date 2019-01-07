$(function(){
	//注册的
	$("#tj").click(function(){
		var phone=$("#phone").val();
		var password1=$("#password1").val();
		var password2=$("#password2").val();
		if(password1!=password2){
			alert("2次密码不一致");
			return;
		}
		var verificationCode=$("#yamnum").val();
		$.post("register",{'phone':phone,'password':password1,'verificationCode':verificationCode},function(data){
			objtu = eval ("(" + data + ")");
			if(objtu.code==200||objtu.code=="200"){//注册登陆
				alert("注册成功");
				window.location.replace("homo");
			}else{//注册失败
				alert("此账号已存在");
			}

		});
	});

	//登陆的
	$("#sub").click(function(){
		var username=$("#username").val();
		var password=$("#password").val();
		var obj;
		if(username!=null&&password!=null){
			$.post("userLogin",{'loginUser':username,'password':password},function(data){
				obj = eval ("(" + data + ")");
				if(obj.code!=null){
					window.location.href = "homo";

				}else{
					$(".sf1").css("display","block");
				}
			});
		}
	});
	//验证码的
	var s=true;
	var yam11;
	$("#yzm").click(function(){
		var phone=$("#phone").val();
		if(phone==null||phone==""){
			alert("請輸入手機號");
		}else{
			$.post("getVerificationCode",{'phone':phone},function(data){
				obj = eval ("(" + data + ")");
				yam11=obj.dataMap.verificationCode;
				if(obj.code==200){
//					$("#yzm").html("验证码已发送");
					$('#yzm').unbind("click");
					s=false;
					settime(60);
				}else{
					$("#yzm").html("验证码发送异常");
				}

			});
		}
		return false;
	});

	//验证码定时器
	function settime(time){
	var btn=$("#yzm");
	btn.attr("disabled",true);
	btn.val(time);
	var header=setInterval(function(){
		if(time<=0){
			clearInterval(hander);
			btn.html("发送验证码");
			btn.attr("disabled",false);
			return false;
		}else{
			btn.html(""+(time--)+"秒后发送");
		}
	},1000);
	}
	//验证码验证对错 焦点移除事件
	
	$("#yamnum").blur(function(){
		if(s){
			return;
		}
		var yzm22=$("#yamnum").val();
		if(yzm22==yam11){
			$("#yzm2").html("验证码正确");
			$("#yzm2").css("color","#2dcc1a");
		}else{
			$("#yzm2").html("验证码错误");
			$("#yzm2").css("color","red");
		}
	});
	//修改userinfo
	$("#subm").click(function(){
		var phone=$("#phone").val();
		var nickName=$("#nickName").val();
		var userName=$("#userName").val();
		var email=$("#email").val();
		var roomAddress=$("#roomAddress").val();
		$.post("userinfo",{'nickName':nickName,'userName':userName,'email':email,'roomAddress':roomAddress,'phone':phone},function(data){
			objtt = eval ("(" + data + ")");
			if(objtt.code==200){
				$("#nickName").val(objtt.dataMap.nickName);
				$("#userName").val(objtt.dataMap.userName);
				$("#email").val(objtt.dataMap.email);
				$("#roomAddress").val(objtt.dataMap.roomAddress);
			}

		});
	});
});