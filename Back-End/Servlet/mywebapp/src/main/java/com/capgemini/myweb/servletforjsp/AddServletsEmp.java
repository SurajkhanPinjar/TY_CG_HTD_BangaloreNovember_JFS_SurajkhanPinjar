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

@WebServlet ("/servAdd")
public class AddServletsEmp extends HttpServlet {
	
	private EmployeeService service=new EmployeeServImpl();
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session=req.getSession(false);
		
		if(session!=null) {
			int empId=Integer.parseInt(req.getParameter("empId"));
			String name=req.getParameter("name");
			int age=Integer.parseInt(req.getParameter("age"));
			double salary=Double.parseDouble(req.getParameter("salary"));
			String password=req.getParameter("password");
			String designation=req.getParameter("designation");
			
			EmployeeInfoBean employeeInfoBean=new EmployeeInfoBean();
			employeeInfoBean.setEmpId(empId);
			employeeInfoBean.setAge(age);
			employeeInfoBean.setDesignation(designation);
			employeeInfoBean.setName(name);
			employeeInfoBean.setSalary(salary);
			employeeInfoBean.setPassword(password);
			
			boolean isAdd= service.addEmployee(employeeInfoBean);
			if(isAdd) {
				req.setAttribute("msg", "Added successfully");
			}else {
				req.setAttribute("msg", "Unable to add employee");
			}
			req.getRequestDispatcher("./addJsp.jsp").forward(req, resp);

		}else {
			req.setAttribute("msg", "Please login first");
			req.getRequestDispatcher("./loginFormJSP.jsp").forward(req, resp);
		}
	}

}
