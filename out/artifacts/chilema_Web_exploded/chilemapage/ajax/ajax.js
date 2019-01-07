var CurrentPage = 1;
		$("#top").click(function(){
			if(CurrentPage==1){
				CurrentPage = 1;
			}else{
				CurrentPage--;
			}
			$.post("startPage",{"page":CurrentPage}, function(test) {
				var ht = eval("(" + test + ")");
				var html = "";
				var sss=ht.dataMap;
				html +="<ul class='sgoods-list clearfix' style='margin-left: 0; margin-left 0.5s ease'>";
				$.each(ht.dataMap.list, function(index, m) {
					//html+=m.shopName;
					html +="<li class='sgoods-item'>";
					html +="<div class='sgoods-thumb'>";
					html +="<a href='xiangqing?shopId="+m.shopId+"'><img src='Echo?imgName="+m.trademark+"'></a></div>";
					html +="<div class='goods-title'>";
					html +="<a href='' class='title'>"+m.shopName+"</a></div>";
					html +="<p class='goods-info'>看你麻痹看.. 没有介绍!</p>";
					html +="</li>";

				});
				html +="</ul>";
				$("#div").html(html);
				html = "";
				s=sss.yeshu;
				
			});
		})
		$("#down").click(function(){
			CurrentPage++;
			$.post("startPage",{"page":CurrentPage}, function(test) {
				var ht = eval("(" + test + ")");
				var html = "";
				var sss=ht.dataMap;
				html +="<ul class='sgoods-list clearfix' style='margin-left: 0; margin-left 0.5s ease'>";
				$.each(ht.dataMap.list, function(index, m) {
					//html+=m.shopName;
					html +="<li class='sgoods-item'>";
					html +="<div class='sgoods-thumb'>";
					html +="<a href='xiangqing?shopId="+m.shopId+"'><img src='Echo?imgName="+m.trademark+"'></a></div>";
					html +="<div class='goods-title'>";
					html +="<a href='' class='title'>"+m.shopName+"</a></div>";
					html +="<p class='goods-info'>看你麻痹看.. 没有介绍!</p>";
					html +="</li>";

				});
				html +="</ul>";
				$("#div").html(html);
				html = "";
				s=sss.yeshu;
				
			});
		})