package com.practice.hiddenfields;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/hs2")
public class HS2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		out.println("<h1>Welcome Servlet 2</h1>");
		out.println("<html>");
		out.println("<center>");
		out.println("<h1>Welcome Servlet 2</h1>");
		out.println("<h1>Your First Name Is : "+request.getParameter("uname")+"</h1>");
		out.println("<h1>Your Last Name Is : "+request.getParameter("lname")+"</h1>");
		out.println("</center>");
		out.println("</html>");
	}


}
