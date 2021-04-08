package com.practice.cookies;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookiesDemo
 */
@WebServlet("/CookiesDemo")
public class CookiesDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     *Cookies are textual info which stored in Key-value Pair
     *Stored in Client Browser
     *
     */


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
