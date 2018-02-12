<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript">

	$(function() {
		$("a").click(function() {
			//使用load 方法处理ajax
			var url = this.href;
			//添加args参数是为了防止缓存，针对于eclipse自带浏览器，但是chrome和firefox不需要
			var args = {"time":new Date()};
			$("#content").load(url,args);
			return false;
		})		
	});
	
</script>
</head>
<body>
	<a href="hello.txt">hello,world!</a>
	<div id="content"></div>
</body>
</html>