package com.capgemini.myweb.servelets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetEmployeeServlets extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String idVal = req.getParameter("id");
		
		// Get Config Param
		ServletConfig config = (ServletConfig) getServletConfig();
		String configParamVal1 = config.getInitParameter("myConfigParam");
		
		// Get Context 
		
		ServletContext context =getServletContext();
		String contextParamVal  = context.getInitParameter("myContextParam");
		
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Employee id :"+ idVal);
		out.println("name = Khan");
		out.println("salary = 87658");
		
		
		out.println("<br><br> Context Param Value = " + contextParamVal);
		
		//Displaying Config Value 
//		out.println("<br><br> Config Param Value = " + configParamVal1);

		out.println("</body>");
		out.println("</html>");
		
		
	
		
	}// End of doGet
	

}// End of Class
