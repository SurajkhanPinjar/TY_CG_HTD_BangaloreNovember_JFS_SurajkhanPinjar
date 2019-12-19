package com.capgemini.myweb.servelets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.myweb.service.EmployeeServImpl;
import com.capgemini.myweb.service.EmployeeService;

@WebServlet ("/deleteEmp")
public class DeleteEmpServlet extends HttpServlet {
	private EmployeeService serv = new EmployeeServImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	HttpSession session = req.getSession(false);
	
	if (session != null) {
		// Valid session
		int empId =Integer.parseInt(req.getParameter("empId")) ;
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		
		if (serv.deleteEmployee(empId)) {
			out.println("<h3 style='color : red'>Employee record for  "+empId + "deleted </h3>");
			
			
		} else {
			out.println("<h3 style='color : red'>Employee Id  "+empId + " Not Found </h3>");
		}
		
		
		out.println("<body>");
		out.println("<html>");
		req.getRequestDispatcher("./delete.html").include(req, resp);
		
	} else {
		// Invalid 
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h3 style = 'color :red ' >Please Login First</h3>");
		out.println("</body>");
		out.println("</html>");
		req.getRequestDispatcher("./login.html").include(req, resp);
	}
		 
		
	}// End Of doGet()

}//
