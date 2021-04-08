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
 * Servlet implementation class Register
 */
@WebServlet(name = "RegisterForm", urlPatterns = { "/RegisterForm" })
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String uname=null;
	private String email=null;
	private String pass=null;
	private String mobno=null;
	private String utype=null;
	public Boolean status=false;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		uname=request.getParameter("username");
		email=request.getParameter("email");
		pass=request.getParameter("password");
		mobno=request.getParameter("mobno");
		utype=request.getParameter("utype");
		
		if (uname!=null && email!=null && pass!=null && mobno!=null && utype!=null) {
			if (uname!="" && email!="" && pass!="" && mobno!="" && utype!="") {
				status=true;
				request.setAttribute("status",status);
//				out.print("<h1>he</h1>");
			}else {
//				Data add kara req me fir dispatch.
				request.setAttribute("status",status);
			}
		}else {
			request.setAttribute("status",status);
		}
		
		out.print("<style>");
		out.print("td{padding:10px;margin:10px;}");
		out.print("table{margin:auto;}");
		out.print("h1{\r\n" + 
				"		text-align:center;\r\n" + 
				"		background: linear-gradient(45deg,rgba(145,124,145,0.5),hsla(145,50%,50%,0.6));\r\n" + 
				"	}");
		out.print("td:nth-child(odd){font-weight:bold}");
		out.print("</style>");
		
		RequestDispatcher rd=request.getRequestDispatcher("SuccessServlet");
		
		out.println("<h1>"+uname+" Registered Details</h1>");
//		second servlet ke pass jakr uska reponse is servlet me add include krta.
		rd.include(request, response);
		
		out.println("<table border='1' style='background:linear-gradient(45deg,rgba(145,124,145,0.5),hsla(145,50%,50%,0.6));padding:10px;'>");
		out.println("<tr>");
		out.println("<td>Username : </td><td>"+uname+"</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>Email :</td><td>"+email+"</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>Mobile No :</td><td>"+mobno+"</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>Type :</td><td>"+utype+"</td>");
		out.println("</tr>");
		
		out.println("</table>");
		
		out.println("<a href='index.html'>Home</a>");
		
		out.print("	<h1>All Right Reserved  , 2021</h1>");
		
	}

}
