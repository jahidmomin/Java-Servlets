package com.practice.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookiesDemo3
 */
@WebServlet("/request3")
public class CookiesDemo3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		//cookie check
		
		Cookie [] carr=request.getCookies();
		boolean f=false;
		String name=null;
		
		if (carr==null) {
			response.sendRedirect("request2");
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
					"	<p>Welcome Back Again To Website</p>\r\n" + 
					"	");
			out.print("Thank You .. Visit Again");
		} else {
			out.print("You Are New User");
		}
	}

}
