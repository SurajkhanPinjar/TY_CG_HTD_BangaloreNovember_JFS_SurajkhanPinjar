<%@page import="com.capgemini.empwebmvc.beans.EmployeeBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<jsp:useBean 
		id="bean" 
		class="com.capgemini.empwebmvc.beans.EmployeeBean" 
		scope="session">
</jsp:useBean>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="./changepassword">Change Password</a>
	<a href="./logout" style="float: right;">Logout</a>
	
	<h1>Welcome <%=bean.getName()%></h1>
	<h2>${mess}</h2>
	<form action="./search" >
		<table>
			<tr>
				<td>Enter Key :</td>
				<td><input type="text" name="key"> </td>
				<td><input type="submit" value="Search"></td>
			</tr>
		</table>
	</form>
	<% 
		List<EmployeeBean> list = (List<EmployeeBean>) request.getAttribute("list");
	
	%>
	<%
		if(list != null) {
	%>
	<%
		if( list.isEmpty()){
	%>
	<h3>Data Found</h3>
	<%
		}else {
 	%>
	<table>
		<tr>
			<th>Name</th>
			<th></th>
			<th></th>
		</tr>
		
		<%for(EmployeeBean bean1 : list ) { %>
		
		<tr>
			<td><%=bean1.getEid() %></td>
			<td><%=bean1.getName()%></td>
			<td><%=bean1.getEmail() %></td>
		
		</tr>
		
	<%} %>
	</table>
	<%
		}
	%>
	<%
		}
	%>
	
	
</body>
</html>