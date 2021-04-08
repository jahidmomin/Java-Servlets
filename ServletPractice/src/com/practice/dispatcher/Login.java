package com.practice.dispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String username=null;
	private String pass=null;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		username=request.getParameter("username");
		pass=request.getParameter("password");
		RequestDispatcher rd=null;
		
		if (username!="" && username!=null && pass!="" && pass!=null ) {
			if (username.equals("jahid") && pass.equals("12345")) {
				 
				 request.setAttribute("username","jahid");
				 rd=request.getRequestDispatcher("Dashboard");
			     rd.forward(request, response);
			     
			} else {
				
				request.setAttribute("status","Wrong Credentials");
				rd=request.getRequestDispatcher("LoginFails");
				rd.include(request, response);
				
			}
		} else {
			
			request.setAttribute("status","Empty Input Fields");
			rd=request.getRequestDispatcher("LoginFails");
			rd.include(request, response);
			
		}
		
	}

}
