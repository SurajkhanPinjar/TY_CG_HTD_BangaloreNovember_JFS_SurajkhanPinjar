 package com.capgemini.myweb.servelets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/redirect")
public class RedirectServlets extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		String url = "http://www.youtube.com";
//		String url = "./currentDate";
//		String url = "http://localhost:8081/mywebapp/getEmployee";
		String url1 =  "./getEmployee";  // Internal Resource  & Relative Path
		resp.sendRedirect(url1);
		
	}

}
