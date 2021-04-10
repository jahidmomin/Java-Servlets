package com.signupmodule.user;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection con=null;
    PreparedStatement pst=null;
	protected void processReq(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String name,email,mobno,pass;
		name=request.getParameter("username");
		email=request.getParameter("email");
		mobno=request.getParameter("mobno");
		pass=request.getParameter("pass");
		
		PrintWriter out=response.getWriter();
//		out.print(name+" "+email+" "+mobno+" "+pass);
		
//		connection
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "scott", "tiger");

			if (con != null) {
				System.out.println("Connected to Oracle Server");
				pst=con.prepareStatement("INSERT INTO signup values(?,?,?,?)");
				pst.setString(1,name);
				pst.setString(2,email);
				pst.setString(3,mobno);
				pst.setString(4,pass);
				
				if (pst.executeUpdate()!=0) {
					out.print("<h1>Successfully Done</h1>");
				} else {
					out.print("<h1>Failes to register</h1>");
				}
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processReq(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
