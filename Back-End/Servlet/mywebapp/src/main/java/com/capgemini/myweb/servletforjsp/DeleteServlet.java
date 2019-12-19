package com.capgemini.myweb.servletforjsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.myweb.beans.EmployeeInfoBean;
import com.capgemini.myweb.service.EmployeeServImpl;
import com.capgemini.myweb.service.EmployeeService;

@WebServlet ("/delEmployee")
public class DeleteServlet extends HttpServlet {
	
	private EmployeeService serv = new EmployeeServImpl();
	EmployeeInfoBean employeeInfoBean = new EmployeeInfoBean();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);
		
		if (session != null) {
			// Valid session
			int empId =Integer.parseInt(req.getParameter("empId")) ;
			
			if (serv.deleteEmployee(empId)) {
				req.setAttribute("msg", "Record Employee Id " +empId + "Deleted!");
				
			} else {
				req.setAttribute("msg", "Invalid Id " +empId  +" is not Found");

			}
			req.getRequestDispatcher("./deleteJSP.jsp").forward(req, resp);
			
		} else {
			// Invalid 
			
			req.setAttribute("msg", "Please Login First ");
			req.getRequestDispatcher("./lofinFormJSP").forward(req, resp);
		}
		
	}
}
