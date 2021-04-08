package com.practice.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookiesDemo3
 */
@WebServlet("/CookiesDemo3")
public class CookiesDemo3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.print("<h1>Hello ,"+request.getParameter("name")+"</h1>\r\n" + 
				"	<p>Welcome Back Again To Website</p>\r\n" + 
				"	");
		out.print("Thank You .. Visit Again");
	}

}
