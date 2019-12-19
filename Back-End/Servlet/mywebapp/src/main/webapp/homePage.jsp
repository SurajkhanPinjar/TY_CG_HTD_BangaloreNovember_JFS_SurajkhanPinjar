<%@page import="com.capgemini.myweb.beans.EmployeeInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@ page session="false" %> 
<%HttpSession session = request.getSession(false); %>   
<% EmployeeInfoBean employeeInfoBean = (EmployeeInfoBean) session.getAttribute("employeeInfoBean"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3 style="color : green;"> Home <%=employeeInfoBean.getName() %> </h3>
	<a href="./addJsp.jsp">Add Employee</a><br>
	<a href="./delEmployee">Delete Employee</a><br>
	<a href="./updateJSP.jsp">Update Employee</a><br>
	<a href="./seeAllEmployees">See All Emoloyee</a><br>
	<a href="./searchEmpJsp">Search Employee</a><br>
	
	<a href="./logout2">Logout</a>
</body>
</html>