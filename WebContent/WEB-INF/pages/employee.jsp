<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/jquery/jquery.blockUI.js"></script>
<script type="text/javascript">
	$(function(){
		//使用默认的BlockUI设置（专门用来对发送ajax请求和接收ajax响应进行页面处理）
		//$(document).ajaxStart($.blockUI).ajaxStop($.unblockUI);
		//具体的自定义的blockUI使用
		 $(document).ajaxStart(function(){
			$.blockUI({
				message: $("#loading"),
				css:{
					top:($(window).height() - 400)/2 + 'px',
					left:($(window).width() - 400)/2 + 'px',
					width:'400px',
					border:'none'
				},
				overlayCSS:{backgroundColor:'red'}
			})
		}).ajaxStop($.unblockUI); 
		
		//城市和部门的二级联动
		$("#city").change(function(){
			$("#department option:gt(0)").remove();
			$("#employee option:not(:first)").remove();
			$("#empdetails").hide();
			
			var val = $("#city option:selected").val();
			if(val != ""){
				var url = "${pageContext.request.contextPath}/employeeServlet?method=departmentList";
				var args = {"locationId":val,"time":new Date()};
				$.getJSON(url,args,function(data){
					if(data.length == 0){
						alert("当前城市没有部门");
					}else{
						for(var i=0;i<data.length;i++){
							var deptId = data[i].id;
							var deptName = data[i].name;
							$("#department").append("<option value='"+deptId+"'>"+deptName+"</option>");
						}
					}
				})
			}
		})
		//部门和员工的二级联动
		$("#department").change(function(){
			$("#employee option:not(:first)").remove();
			$("#empdetails").hide();
			
			var val = $(this).val();
			if(val != ""){
				var url = "${pageContext.request.contextPath}/employeeServlet?method=empList";
				var args = {"deptId":val,"time":new Date()};
				$.getJSON(url,args,function(data){
					if(data.length == 0){
						alert("当前部门没有员工");
					}else{
						for(var i=0;i<data.length;i++){
							$("#employee").append("<option value='"+data[i].id+"'>"+data[i].name+"</option>");
						}
					}
					
				})
			}
		})
		$("#employee").change(function(){
			var val = $(this).val();
			if(val != ""){
				var url = "${pageContext.request.contextPath}/employeeServlet?method=getEmp";
				var args = {"empId":val,"time":new Date()};
				$.getJSON(url,args,function(data){
					$("#id").text(data.id);
					$("#name").text(data.name);
					$("#salary").text(data.salary);
					$("#hireDate").text(data.hireDate);
					$("#email").text(data.email);
				})
				$("#empdetails").show();
			}else{
				$("#empdetails").hide();
			}
			
		})
		
	})

</script>
</head>
<body>
	<img id="loading" alt="" src="${pageContext.request.contextPath}/img/load.gif" style="display: none">
	<center>
		<br><br>
		City:
			<select id="city">
				<option value="">请选择...</option>
				<c:forEach items="${locations }" var="location" >
					<option value="${location.id }">${location.city }</option>
				</c:forEach>
			</select>
			
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		Department:
			<select id="department">
				<option value="">请选择...</option>
			</select>	
			
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		Employee:
			<select id="employee">
				<option value="">请选择...</option>
			</select>
			<br><br>
			
		<table id="empdetails" border="1" cellpadding="5" cellspacing="0" style="display: none">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Salary</th>
				<th>HireDate</th>
				<th>Email</th>
			</tr>
			
			<tr>
				<td id="id"></td>
				<td id="name"></td>
				<td id="salary"></td>
				<td id="hireDate"></td>
				<td id="email"></td>
			</tr>
		</table>	
			
	</center>
	
</body>
</html>