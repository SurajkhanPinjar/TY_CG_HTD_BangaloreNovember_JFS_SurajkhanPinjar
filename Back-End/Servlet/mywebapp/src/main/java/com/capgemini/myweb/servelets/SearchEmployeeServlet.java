package com.capgemini.myweb.servelets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.myweb.beans.EmployeeInfoBean;
import com.capgemini.myweb.service.EmployeeServImpl;
import com.capgemini.myweb.service.EmployeeService;

@WebServlet("/searchEmployee")		// this is configure the web Server
public class SearchEmployeeServlet extends HttpServlet {
	
	private EmployeeService employeeService = new EmployeeServImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// Get The form data
	String empIdVal = req.getParameter("empid");
	int empId = Integer.parseInt(empIdVal);
	
	EmployeeInfoBean employeeInfoBean =	employeeService.searchEmployee(empId);
	
//	resp.setContentType("text/html");
	PrintWriter out = resp.getWriter();
	out.println("<html>");
	out.println("<body>");
	
	if (employeeInfoBean != null) {
		out.println("<h3>Employee Id "+empId+ " Found-</h3>");
		out.println("name = "+employeeInfoBean.getName());
		out.println("<br>Age ="+employeeInfoBean.getAge());
		out.println("<br>Salary ="+ employeeInfoBean.getSalary());
		out.println("<br>Designation = "+ employeeInfoBean.getDesignation() );
		
	} else {
		out.println("<h3 style = 'color: red '>Employee ID "+ empId + "Not Found !</h3>");
		
	}
	out.println("</body>");
	out.println("</html>");

	}

}
