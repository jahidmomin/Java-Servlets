package com.practice.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookiesDemo
 */
@WebServlet("/request1")
public class CookiesDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     *Cookies are textual info which stored in Key-value Pair
     *Stored in Client Browser
     *javax.servlet.http -> Cookie class
     *create a cookie object -> name-val pair.
     *Cookie c=new Cookie("name","xyz");
     *resp.addCookie(c);
     *Cookies [] carray = req.getCookies();
     *
     */


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.print("<h1>Hello , "+request.getParameter("name")+"</h1>\r\n" + 
				"	<p>Welcome To Website</p>\r\n" + 
				"	");
		out.print("<a href='/request2'>Click To GO Next Page</a>");
	}

}
