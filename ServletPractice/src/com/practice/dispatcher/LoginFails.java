package com.practice.dispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginFails
 */
@WebServlet("/LoginFails")
public class LoginFails extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		PrintWriter out=resp.getWriter();
//		out.print("<h3> Login Empty Fileds </h3>");
//	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(req, resp);
		PrintWriter out=resp.getWriter();
		out.print("<h3>"+req.getAttribute("status")+"</h3>");
	}

}
