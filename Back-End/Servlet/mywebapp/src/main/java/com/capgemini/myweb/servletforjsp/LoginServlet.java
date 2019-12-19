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

@WebServlet ("/findlogin")
public class LoginServlet extends HttpServlet  {
	
	private EmployeeService service = new EmployeeServImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Get The Form Data 
		int empId = Integer.parseInt(req.getParameter("empId"));
		String password = req.getParameter("password");
		
		EmployeeInfoBean employeeInfoBean = service.authenticate(empId, password);
		if (employeeInfoBean != null ) {
			// Valid Credentials 
			HttpSession session = req.getSession(true);
			
			session.setAttribute("employeeInfoBean", employeeInfoBean);
			
			//Session Time out
			session.setMaxInactiveInterval(60);
			
			req.getRequestDispatcher("./homePage.jsp").forward(req, resp);
			
		} else {
			// Invalid Credentials
			// set The attributes 
			req.setAttribute("msg", "Invalid Credentials");
			req.getRequestDispatcher("./loginFormJSP").forward(null, resp);   // path from web.xml and we should forward the request 
			
		}
	
	} //End Of doPost

} //End Of Class
