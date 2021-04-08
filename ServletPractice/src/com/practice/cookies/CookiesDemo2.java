package com.practice.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookiesDemo2
 */
@WebServlet("/request2")
public class CookiesDemo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
//		fetch cookies values.
		Cookie [] carr=request.getCookies();
		boolean f=false;
		String name=null;
		
		if (carr==null) {
			response.sendRedirect("cookieForm.html");
		} else {
			for (Cookie cookie : carr) {
				String tname=cookie.getName();
				if (tname.equals("username")) {
					f=true;
					name=cookie.getValue();
				}
			}
		}
		
		
		if (f) {
			out.print("<h1>Hello ,"+name+"</h1>\r\n" + 
					"<p>Welcome Back To Website</p>\r\n" + 
					" ");
			out.print("<a href='request3'>Click To GO Next Page</a>");
		} else {
			out.print("<h1>New User Detect</h1>");
			out.print("<a href='request3'>Click To GO Next Page</a>");
		}
	
		
	}

}
