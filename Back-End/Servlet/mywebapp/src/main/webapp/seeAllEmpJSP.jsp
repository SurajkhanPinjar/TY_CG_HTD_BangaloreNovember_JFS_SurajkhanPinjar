<%@page import="com.capgemini.myweb.beans.EmployeeInfoBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@  page session="false"%>
<%List<EmployeeInfoBean> employeeList = (List<EmployeeInfoBean>) request.getAttribute("employeeInfoBeans"); %>
<% String msg = (String) request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h4>
		<a href="./home">Home</a>
	</h4>
	<%if (employeeList != null && !employeeList.isEmpty()) {%>
	
	<table>
		<tr>
			<th>EmpID</th>
			<th>Name</th>
			<th>Age</th>
			<th>Salary</th>
			<th>Designation</th>
		</tr>
		<%for (EmployeeInfoBean bean : employeeList) { %>
		
		<tr>
			<td> <%=bean.getEmpId() %></td>
			<td> <%=bean.getName() %> </td>
			<td> <%=bean.getAge() %></td>
			<td><%=bean.getSalary() %></td>
			<td><%=bean.getDesignation() %></td>
		</tr>
		
		<%} %>
	</table>

	<%} %>
	<% if( msg != null && !msg.isEmpty()) { %>
	<%= msg %>
	<%} %>

</body>
</html>