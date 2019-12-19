<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page session="false" %>
<%String msg=(String)request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%if(msg!=null && !msg.isEmpty()){ %>
<h3 style="color: navy;"></h3> <%=msg %>
<%} %>
<fieldset>
	<h4><a href="./home.jsp"></a></h4>
	<legend>AddEmployee</legend>
	<form action="./servAdd" method="post">
	<table>
		
		<tr>
			<td>Employee Id</td>
			<td>:</td>
			<td><input type="number" name="empId" required></td>
		</tr>
		
		<tr>
			<td>Employee Name</td>
			<td>:</td>
			<td><input type="text" name="name" required></td>
		</tr>
		
		<tr>
			<td>Age</td>
			<td>:</td>
			<td><input type="number" name="age" required></td>
		</tr>
		
		<tr>
			<td>salary</td>
			<td>:</td>
			<td><input type="number" name="salary" required></td>
		</tr>
		
		<tr>
			<td>Designation</td>
			<td>:</td>
			<td><input type="text" name="designation" required></td>
		</tr>
		
		<tr>
			<td>password</td>
			<td>:</td>
			<td><input type="password" name="password" required></td>
		</tr>
		
		<tr>
			<td colspan="3" align="center"><br>
			<input type="submit" value="Submit"></td>
		</tr>
	
	</table>
	</form>
	</fieldset>
</body>
</html>