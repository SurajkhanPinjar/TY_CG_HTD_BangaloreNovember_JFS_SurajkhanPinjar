<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page session="false" %>
<%String msg = (String )request.getAttribute("msg"); %>
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
	<h4> <a href="./home">Home </a> </h4>
	</fieldset>
	<legend>Update Emp</legend>
	<form action="./updateEmployee2" method="post">
	<table>
		
		<tr>
			<td>Employee Id</td>
			<td>:</td>
			<td><input type="number" name="empId" required></td>
		</tr>
		
		<tr>
			<td>Employee Name</td>
			<td>:</td>
			<td><input type="text" name="name" ></td>
		</tr>
		
		<tr>
			<td>Age</td>
			<td>:</td>
			<td><input type="number" name="age" ></td>
		</tr>
		
		<tr>
			<td>salary</td>
			<td>:</td>
			<td><input type="number" name="salary" ></td>
		</tr>
		
		<tr>
			<td>Designation</td>
			<td>:</td>
			<td><input type="text" name="designation" ></td>
		</tr>
		
		<tr>
			<td>password</td>
			<td>:</td>
			<td><input type="password" name="password" ></td>
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