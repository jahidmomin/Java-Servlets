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
 * Servlet implementation class SessionDemo3
 */
@WebServlet("/sessiondemo3")
public class SessionDemo3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	        
	        HttpSession session=request.getSession();  
	        
	        if (session.getAttribute("uname")==null) {
	        	 out.print("Session not set");  
			}else {
	        
		        String n=(String)session.getAttribute("uname");  
		        out.print("Hello "+n);  
	        
			}
	        out.close();  
	        
	}

}
