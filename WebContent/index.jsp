<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	window.onload = function() {
		
		//1.获取a标签节点，并为其添加点击事件
		document.getElementsByTagName("a")[0].onclick = function() {
			
			//3.创建一个 XMLHttpRequest对象
			var request = new XMLHttpRequest();
			
			//4.准备发送请求的数据：url(一般加上时间戳防止浏览器缓存，但是chrome和火狐测试不需要)
			var url = this.href+"?time="+new Date();
			var method = "GET";
			
			//5.调用XMLHttpRequest对象的open方法
			request.open(method,url);
			
			//6.调用XMLHttpRequest对象的send方法,get请求就设置为null即可
			request.send(null);
			
			//7.为XMLHttpRequest对象添加onreadystatechange 响应函数
			request.onreadystatechange = function() {
				//8.判断响应是否完成：XMLHttpRequest对象的readysState 属性值为4的时候
				if(request.readyState == 4){
					//9.再判断响应是否可用：XMLHttpRequest对象的status 属性值为200的时候
					if(request.status == 200 || request.status == 304){
						//10.打印响应的结果：responseText
						alert(request.responseText);
					}
				}
			}
			//2.取消a标签的默认跳转行为
			return false;
		}
	}
</script>
</head>
<body>
	<a href="hello.txt">hello,world!</a>
</body>
</html>