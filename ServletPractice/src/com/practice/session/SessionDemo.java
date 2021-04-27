package com.practice.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionDemo
 */
@WebServlet("/sessiondemo")
public class SessionDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	
//	Session 
//	used for state mngmnt
//	Time Expire / invalidate / browser close
//	HttpSession
//	setAttribute(k,v) / getAttribute(key);
//	getId()
//	removeAttribute(k)
//	invalidate();
// HttpSession s=req.getSession()
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 	response.setContentType("text/html");  
	        PrintWriter out = response.getWriter();  
	          
	        String n=request.getParameter("userName");  
	        out.print("Welcome "+n);  
	        
//	        create and set .
	        HttpSession session=request.getSession();  
	        session.setAttribute("uname",n);
	        
	        out.print("<a href='sessiondemo2'>visit</a>");  
	}

	

}
