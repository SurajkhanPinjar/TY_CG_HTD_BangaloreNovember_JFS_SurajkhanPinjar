package com.capgemini.myweb.servletforjsp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.myweb.beans.EmployeeInfoBean;
import com.capgemini.myweb.service.EmployeeServImpl;
import com.capgemini.myweb.service.EmployeeService;

@WebServlet("/searchEmplo")
public class SearchEmpServletJsp  extends HttpServlet{
	
	private EmployeeService serv = new EmployeeServImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession session = req.getSession(false);
	
	if (session != null ) {
		// Valid Session
		// Get the form Data
		
		int empId = Integer.parseInt(req.getParameter("empId"));
		
		EmployeeInfoBean employeeInfoBean = serv.searchEmployee(empId);
		
		req.setAttribute("employeeInfoBean", employeeInfoBean);
		req.getRequestDispatcher("./searchEmpJsp.jsp").forward(req, resp);
	
	} else {
		// Invalid Session
		req.setAttribute("msg", "Please Login First ");
		req.getRequestDispatcher("./lofinFormJSP").forward(req, resp);
	}

	} //End Of doGet()

} //End Of Class
