//var caidan = {
//sid : 'id',
//sl : 0
//};
var priceAll = 0;
var idArray = new Array();
function c(id,name,price) {
	if(!isHave(id)){
		$("#menus").append(
				"<div class=\"cai \" id='menu"+id+"'><div hidden='hidden'>"+id+ "</div><div class=\"caiming\">" + name
				+ "</div><div class=\"caiming\">" + price
				+ "</div><div class=\"caiming2\" id=\"sl\">  <input id=\""
				+ id + "\" type=\"button\" value=\"+\"   onClick=\"ja('"
				+ id + "','" + price + "');\" > <span class=\"" + id
				+ "\" id=\"sabi\">0</span><input id=\"" + id
				+ "\" type=\"button\" value=\"-\"   onClick=\"jian('" + id
				+ "','" + price + "');\" ></div></div>");
	}
	ja(id, price);
}
function isHave(id){
	var length=idArray.length;
	for(var i=0;i<length;i++){
		if(idArray[i]==id){
			return true;
		}
	}
	idArray[length]=id;
}
function removeByValue(id) {
	for(var i=0; i<idArray.length; i++) {
		if(idArray[i] == id) {
			idArray.splice(i, 1);
			break;
		}
	}
}
//计算总价
function ja(id, price) {
	priceAll = priceAll * 1 + price * 1;
	var s = $("." + id).html();
	var num = parseInt(s) + 1;
	$("." + id).html(num);
	$("#xiugaizongjia").html("总价:￥" + priceAll);
}
function jian(id, price) {
	priceAll = priceAll * 1 - price * 1;
	var s = $("." + id).html();
	var num = parseInt(s) - 1;
	$("." + id).html(num);
	$("#xiugaizongjia").html("总价:￥" + priceAll);
	if(num==0){
		$("#menu"+id).remove();
		removeByValue(id);
	}
}
function spost(){
	//格式  menuId:name:数量:price, 
	//{'phone':phone,'password':password1,'verificationCode':verificationCode}
	var usernameEle = document.getElementById("menus");
	var childs = usernameEle.childNodes;
	var str="";
	for(var i = 1; i< childs.length; i++) {
		var cw=childs[i].childNodes;
		var id=cw[0].innerText;
		var name=cw[1].innerText;
		var price=cw[2].innerText;
		var num=cw[3].innerText;
		str+=id+":"+name+":"+num+":"+price
		if(i<childs.length-1){
			str+=",";
		}

	}
	$.post("AddOrder",{'menuOrder':str},function(data){
		objtu = eval ("(" + data + ")");
		if(objtu.key==1||objtu.key=="1"){
			alert("下单成功 ")
			window.location.href = "homo";
		}
	});
} 


