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

@WebServlet("/searchemp")
public class SearchEmployeeServlet2 extends HttpServlet {

	private EmployeeService employeeService = new EmployeeServImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		HttpSession session = req.getSession(false);

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		out.println("<html>");
		out.println("<body>");

		if(session != null) {
			//valid Session 
			// Get The form data

			String empIdVal = req.getParameter("empid");
			int empId = Integer.parseInt(empIdVal);

			EmployeeInfoBean employeeInfoBean =	employeeService.searchEmployee(empId);

			//	resp.setContentType("text/html");
			PrintWriter out1 = resp.getWriter();
			out1.println("<html>");
			out1.println("<body>");

			if (employeeInfoBean != null) {
				out1.println("<h3 style = 'color: green'>Employee Id "+empId+ " Found-</h3>");
				out1.println("name = "+employeeInfoBean.getName());
				out1.println("<br>Age ="+employeeInfoBean.getAge());
				out1.println("<br>Salary ="+ employeeInfoBean.getSalary());
				out1.println("<br>Designation = "+ employeeInfoBean.getDesignation() );

			} else {
				out1.println("<h3 style = 'color: red '>Employee ID "+ empId + "Not Found !</h3>");

			}
			out.println("</body>");
			out.println("</html>");



		} else {
			//Invalid Session
			out.println("please login first !! ");
			req.getRequestDispatcher("./login.html").include(req, resp);

		}

		out.println("</body>");
		out.println("</html>");
	}


}
