package com.practice.hiddenfields;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class S1
 */
@WebServlet(name = "HS1", urlPatterns = { "/hs1" })
public class HS1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		out.print("<form action='hs2'>");
		out.print("<label>Enter Your Last Name :</label>");
		out.print("<input type='text' name='lname' />");
		out.print("<input type='hidden' value='"+request.getParameter("uname")+"' name='uname'/>");
		out.print("<input type='submit' value='Submit'/>");
		out.print("</form>");
		
		
	}

}
