<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var json = {
			"name":"james",
			"address":{
				"city":"chongqing",
				"school":"nankai"
			},
			"teaching":function(){
				alert("语文");
			}
	}
	//alert(json.name);
	//json.teaching();
	
	var testStr = "alert('hello json')";
	//alert(testStr);
	//可以把字符串转为本地js代码执行
	//eval(testStr);
	
	//将json字符串转换为json对象
	var jsonStr = "{name:'harden'}";
	var obj = eval("("+jsonStr+")");
	alert(obj.name);
	
</script>
</head>
<body>


</body>
</html>