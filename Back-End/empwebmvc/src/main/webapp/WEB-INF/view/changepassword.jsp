<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>${msg}</h2>

	<a href="./home">Home</a>
	<a href="./logout">logout</a>
<form action="./changepassword" method="post">
	
		<legend>Change The Password</legend>
		
		<table>
			<tr>
				<td><input type="password" name="password"></td> <br>
				<td><input type="submit" value="Change Password"> </td>
			</tr>
		</table>
	


</form>
</body>
</html>