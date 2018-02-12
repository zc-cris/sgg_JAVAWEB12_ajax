<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<!-- 
	1. 导入jquery的库
	2. 获取name=“username”的节点：username
	3. 为username添加change函数
	3.1 获取username的value值，取出前后空格且不为空，即准备发送ajax请求
	3.2 发送ajax请求检查用户名是否可用
	3.3 在服务端直接返回一个html片段：<font color="red">该用户名已经被占用</font>
	4. 在客户端浏览器直接将返回的数据直接添加到#message的html中
 -->
 <script type="text/javascript" src="${pageContext.request.contextPath }/jquery/jquery-3.3.1.min.js"></script>
 <script type="text/javascript">
 	$(function() {
 		//当文本框的数据被改变时，使用change函数，会自动判断用户焦点失去才执行change函数
 		$(":input[name='userName']").change(function() {
			var val = $(this).val();
			val = $.trim(val);
			
			if(val != ''){
				var url = "${pageContext.request.contextPath }/validateUserName";
				var args = {"userName":val,"date":new Date()};
				//这种方式可以直接为元素直接添加返回的html片段
				/* $.post(url,args,function(data){
					$("#message").html(data);
				}) */
				//这种方法更加简单
				$("#message").load(url,args);
			}
		})
	})

 </script>
<body>
	<form action="" method="post">
		用户名：<input type="text" name="userName" />
		<br>
		<div id="message"></div>
		<br>
		<input type="submit" value="submit">
	</form>

</body>
</html>