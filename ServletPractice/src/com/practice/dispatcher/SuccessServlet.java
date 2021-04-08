package com.practice.dispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SuccessServlet
 */
@WebServlet("/SuccessServlet")
public class SuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuccessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    private String RegStatus=null;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String color="red";
		response.setContentType("text/html");
		out.print("<style>");
		out.print("h2{\r\n" + 
				"		text-align:center;\r\n" + 
				"		background: linear-gradient(45deg,rgba(145,124,145,0.5),hsla(145,50%,50%,0.6));color:green;\r\n");
		out.print("</style>");
		
		if ((boolean) request.getAttribute("status")) {
			RegStatus="Register Successfully :)";
			color="green";
		}else {
			RegStatus="Registration Failed :(";
		}

		out.println("<h2>"+RegStatus+"</h2>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
