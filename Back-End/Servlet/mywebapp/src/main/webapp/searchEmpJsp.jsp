<%@page import="com.capgemini.myweb.beans.EmployeeInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page session="false" %>
<% EmployeeInfoBean employeeInfoBean =(EmployeeInfoBean) request.getAttribute("employeeInfoBean"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
		<legend> Search Employee</legend>
		<form action="./searchEmplo" method="get">		
		Employee Id : <input type = "number" name = "empid" required> <br>
		<input type = "Submit" value = "Search">
		</form>
		
	</fieldset>
	<br><br>
	
	<% if (employeeInfoBean == null) {%>
	<h3 style="color: red;">Employee ID not found!</h3>
	<%} else { %>
		
		<h3 style="color: green;">Details For Employee ID <%=employeeInfoBean.getEmpId() %></h3>
		Employee Name = <%= employeeInfoBean.getName() %><br>
		Age = <%= employeeInfoBean.getAge() %><br>
		Salary = <%= employeeInfoBean.getSalary() %><br>
		Designation = <%= employeeInfoBean.getDesignation() %><br>
		
	<%} %>	

</body>
</html>