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

@WebServlet("/createcookies")
public class CreateCookies  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//create Cookies
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		Cookie myCookie = new Cookie("empName", "Surajkhan");
		myCookie.setMaxAge(7);
		resp.addCookie(myCookie);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("./cookie.html");
		dispatcher.include(req, resp);
		out.println("<html>");
		out.println("<body>");
		out.println("<h2> Cookie Create Successfully :) </h2>");
		out.println("</body>");
		out.println("</html>");
	
	}

}
