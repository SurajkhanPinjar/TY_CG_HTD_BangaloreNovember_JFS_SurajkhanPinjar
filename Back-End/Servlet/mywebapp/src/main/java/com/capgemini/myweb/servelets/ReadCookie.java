package com.capgemini.myweb.servelets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/readcookies")
public class ReadCookie extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		
		Cookie[] cookies = req.getCookies();
//		resp.setContentType("text/html");
//		PrintWriter out1 = resp.getWriter();
		
		req.getRequestDispatcher("./cookie.html").include(req, resp);
		
		out.println("<html>");
		out.println("<body>");

		if (cookies != null) {
		for (Cookie cookie : cookies) {
			out.println("Cookie Name :"+cookie.getName());
			out.println("<br>Cookie value : "+cookie.getValue());
		}
		} else {
			out.println("<h2>No cookies found :(</h2>");
		}
				
//		out.println("<h2> Cookie Create Successfully :) </h2>");
		out.println("</body>");
		out.println("</html>");
	
	}

}
