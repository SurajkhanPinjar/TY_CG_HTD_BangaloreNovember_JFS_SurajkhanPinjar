<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page session="false" %>  
 
<% 
	String msg = (String)request.getAttribute("msg"); 
%>
<!DOCTYPE html>
<html>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<h1><%=msg %></h1>

		<form action="./login" method="post">
		<table>
			<tr>
				<td>User Name :</td>
				<td> <input type="text" name="username"></td>
			</tr>
			
			<tr>
				<td>Password :</td>
				<td> <input type="password" name="password"></td>
			</tr>

			<tr>
				<td> <input type="submit" name="login"></td>
			</tr>

		</table>
	</form>


</body>
</html>