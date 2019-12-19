package com.capgemini.myweb.servletforjsp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.myweb.beans.EmployeeInfoBean;
import com.capgemini.myweb.service.EmployeeServImpl;
import com.capgemini.myweb.service.EmployeeService;

@WebServlet ("/seeAllEmployees")
public class SeeAllEmployeeJSP  extends HttpServlet{
	private EmployeeService serv = new EmployeeServImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		
		if(session!=null) {
			// Valid Session
			List<EmployeeInfoBean> employeeInfoBeans = serv.getAllEmployees();
			
			if(employeeInfoBeans != null && !employeeInfoBeans.isEmpty()) {
				req.setAttribute("employeeInfoBeans", employeeInfoBeans);
			} else {
				req.setAttribute("msg", "There Is No Employees To Display");
			}
			req.getRequestDispatcher("./seeAllEmpJSP.jsp").forward(req, resp);
			
		} else {
			//Invalid Session
			req.setAttribute("msg", "please Login First");
			req.getRequestDispatcher("loginFormJSP").forward(req, resp);
		
		}//End Of Session
	
	}

} //End Of Class
