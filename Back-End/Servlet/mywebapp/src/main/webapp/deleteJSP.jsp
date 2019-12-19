<%@page import="com.capgemini.myweb.beans.EmployeeInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page session="false" %>
 <%String msg = (String)request.getAttribute("msg"); %>
 <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
		<legend> Delete  Employee</legend>
		<form action="./delEmpl" method="get">		
		Employee Id : <input type = "number" name = "empid" required> <br>
		<input type = "Submit" value = "Delete">
		</form>
		
	</fieldset>
	<br><br>
	
	<% if( msg != null ){ %>
	<h3>Deleted Successfully</h3>
	<% } else { %>
	<h3>Not Present </h3>
	<%} %>
</body>
</html>