<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath }/jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript">

	$(function() {
		//在js中写el表达式代码
		
		//直接在el中进行判断session的域属性是否存在
		var isHasCart = "${sessionScope.sc == null}";
		//alert(isHasCart);
		//js中的字符串是否相等用 ==,el表达式中用   eq 'xxx'
		if(isHasCart == "true"){
			$("#cartDiv").hide();
		}else{
			$("#cartDiv").show();
			
			$("#bookName").text("${sessionScope.sc.bookName}");
			$("#totalCount").text("${sessionScope.sc.allCount}");
			$("#totalPrice").text("${sessionScope.sc.allPrice}");
		}
		
		$("a").click(function() {
			$("#cartDiv").show();
			var url = null;
			url = this.href;
			//alert(url);
			//url = $(this).attr("href");
			//alert(url);
			
			var args = {"time":new Date()};
			//getJSON方法注意JSON必须大写啊！！！
			//服务器响应回来的数据是json格式的字符串
			$.getJSON(url,args,function(data){
				//往jquery标签对象中填写标签文本内容用text(...)
				$("#bookName").text(data.bookName);
				$("#totalCount").text(data.allCount);
				$("#totalPrice").text(data.allPrice);
			});
			//一定要先阻止a标签的默认行为
			return false;
		})		
	});
</script>

<body>
	<div id="cartDiv">
	您已将 &nbsp;<font color='red' id="bookName"></font>&nbsp; 添加至购物车中，<br>
	目前购物车中共有 &nbsp;<font color='red' id="totalCount"></font>&nbsp; 本书，<br>
	共计 &nbsp;<font color='red' id="totalPrice"></font>&nbsp; 元<br>
	</div>
	<br><br><br>
	
	<a href="${pageContext.request.contextPath }/add?name=java&price=100">java大师</a><br>
	<a href="${pageContext.request.contextPath }/add?name=oracle&price=10">oracle之神</a><br>
	<a href="${pageContext.request.contextPath }/add?name=spring&price=200">spring之父</a><br>

</body>
</html>