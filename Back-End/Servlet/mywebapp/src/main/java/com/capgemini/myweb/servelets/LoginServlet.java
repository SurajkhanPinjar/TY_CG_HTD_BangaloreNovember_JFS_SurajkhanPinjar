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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	private EmployeeService serv = new EmployeeServImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Get The Form Data
		String empIdVal =  req.getParameter("empId");
		String password =  req.getParameter("password");
		
		int empId = Integer.parseInt(empIdVal);
		EmployeeInfoBean employeeInfoBean = serv.authenticate(empId, password);
		
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		if (employeeInfoBean != null) {
			
			//Valid Credentials
			HttpSession session = req.getSession(true);   // We Should Pass True
			
			//Add attributes
			session.setAttribute("employeeInfoBean", employeeInfoBean);
			out.println("<h2>Welcome "+ employeeInfoBean.getName()+ "!</h2>");
			out.println("<br> <a href = './add.html' > Add Employee </a>");
			out.println("<br> <a href = '#' > Update Employee </a>");
			out.println("<br> <a href = './searchEmpForm.html' > Search Employee </a>");
			out.println("<br> <a href = './delete.html' > Delete Employee </a>");
			out.println("<br> <a href = '#' > See All Employee </a>");
			
			out.println("<br> <a href = './logout' > Logout </a>");
			
		} else {
			// Invalid Credentials
			out.print("<h3 style= 'color: red'>Invalid Credentials </h3>" );
			req.getRequestDispatcher("./login.html").include(req, resp);
		}
		
		out.println("</body>");
		out.println("</html>");
		
		
		
		
		
		
	} // End Of doPost()
} //End Of Class
