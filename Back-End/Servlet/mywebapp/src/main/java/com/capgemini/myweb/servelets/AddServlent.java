package com.capgemini.myweb.servelets;

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

@WebServlet ("/addEmp")
public class AddServlent extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Get The Form
		
		HttpSession session = req.getSession(false);
		
		EmployeeInfoBean eBean = new EmployeeInfoBean();
		EmployeeService serv = new EmployeeServImpl();
		
		if(session != null) {
			//Valid Session
			
			String empIdVal =  req.getParameter("empId");
			int empId = Integer.parseInt(empIdVal);
			eBean.setEmpId(empId);
			String name = req.getParameter("empName");
			eBean.setName(name);
			String salary = req.getParameter("salary");
			eBean.setSalary(Double.parseDouble(salary));
			String age = req.getParameter("age");
			eBean.setAge(Integer.parseInt(age));
			String designation = req.getParameter("designation");
			eBean.setDesignation(designation);
			String password =  req.getParameter("password");
			eBean.setPassword(password);
			
			PrintWriter out = resp.getWriter();
			out.println("<html> ");
			out.println("<body> ");
			
			if (serv.addEmployee(eBean)) {
			
				out.println("<h3 style='color : red'>Successfully Added  </h3>");
				
				
			} else {
				
				out.println("<h3 style='color : red'>Cannot Be addded </h3>");
			}
			
			out.println("</body> ");
			out.println("</html> ");
			
			req.getRequestDispatcher("./add.html").include(req, resp);
			
			
		} else {
			// Invalid Session
			
			PrintWriter out1 =  resp.getWriter();
			out1.println("<html> ");
			out1.println("<body> ");
			out1.println("<h3 style='color : red'>Cannot Be addded </h3>");
			out1.println("</body> ");
			out1.println("</html> ");
		}
		
		
		
		
	} //End of doPost

} // End Of Class
