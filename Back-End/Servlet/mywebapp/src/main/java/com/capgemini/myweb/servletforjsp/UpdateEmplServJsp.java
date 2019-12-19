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

@WebServlet("/updateEmployee2")
public class UpdateEmplServJsp extends HttpServlet {
	
	EmployeeService serv = new EmployeeServImpl();
	
			
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session =  req.getSession(false);
		
		if(session != null ) {
			//Valid Session
			// Get The Form Data
			int empId=Integer.parseInt(req.getParameter("empId"));
			String name=req.getParameter("name");
			String age1=(req.getParameter("age"));
			String salary1=(req.getParameter("salary"));
			String password=req.getParameter("password");
			String designation=req.getParameter("designation");
			
			EmployeeInfoBean employeeInfoBean=new EmployeeInfoBean();
			employeeInfoBean.setEmpId(empId);
			
			if(age1 != null && !age1.isEmpty()) {
				int age = Integer.parseInt(age1);
				employeeInfoBean.setAge(age);
				
			}
			employeeInfoBean.setDesignation(designation);
			employeeInfoBean.setName(name);
			if(salary1 != null && !salary1.isEmpty()) {
				int salary = Integer.parseInt(salary1);
				employeeInfoBean.setAge(salary);
				
			}

			employeeInfoBean.setPassword(password);
			
			boolean b = serv.updateEmployee(employeeInfoBean);
			
			if(b) {
				req.setAttribute("msg", "Update Details Successfully");
			} else {
				req.setAttribute("msg", "Please Try Again ");
			}
			req.getRequestDispatcher("./updateJSP.jsp").forward(req, resp);
			
		} else {
			//Invalid Session
			
			req.setAttribute("msg", " Please Login First ");
			req.getRequestDispatcher("./loginFormJSP").forward(req, resp);
		}
	
	}

}
