package com.capgemini.myweb.servelets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.IOP.ServiceContext;

public class DateServelet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//Current System date and Time
		Date date = new Date();
		
		// get The Context 
		ServletContext context =getServletContext();
		String contextParamVal  = context.getInitParameter("myContextParam");
		
		// Get Config Param
		ServletConfig config = (ServletConfig) getServletContext();
		String configParamVal1 = config.getInitParameter("myConfigParam");
		
		
		resp.setContentType("text/html");
		resp.setHeader("refresh", "1");
		
		PrintWriter out = resp.getWriter();
		out.print("<html>");
		out.print("<h2>Current System date & Time - <br> "+ date + "</h2>");
		out.println("<br><br> Context Param Value = " + contextParamVal);
		out.println("<br><br> Context Param Value = " + configParamVal1);
		out.print("</html>");
		super.doGet(req, resp);
	} // End of doGet()
	
} //End Of Class
