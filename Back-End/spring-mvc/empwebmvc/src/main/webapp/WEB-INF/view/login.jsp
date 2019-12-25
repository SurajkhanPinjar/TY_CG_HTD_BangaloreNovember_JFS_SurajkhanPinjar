<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page session="false" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>${msg}</h2>
		
	<form action="./login" method="post">
		<table>
		<tr>
			<td>Email:</td>
			<td><input type="email" name="email"> </td>
		</tr>
		
		<tr>
			<td>Password:</td>
			<td><input type="password" name="password"> </td>
		</tr>
		
		<tr>
			<td></td>
			<td><input type="submit" value="Login"> </td>
		</tr>
		
		</table>
	<a href="./register">Register</a>
	</form>
</body>
</html>