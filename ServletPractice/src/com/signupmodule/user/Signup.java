package com.signupmodule.user;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

//use annotation ->handle ->extra info -> jvm-> multipart form.
@MultipartConfig
@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection con=null;
    PreparedStatement pst=null;
	protected void processReq(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, InterruptedException {
		  
		PrintWriter out=response.getWriter();
		String name,email,mobno,pass;
		name=request.getParameter("username");
		email=request.getParameter("email");
		mobno=request.getParameter("mobno");
		pass=request.getParameter("pass");
		// we can store file and imgs in Part obj
		Part part = request.getPart("profile");
		String fileName = extractFileName(part);
		
		//	    out.println(fileName);
		//		out.print(name+" "+email+" "+mobno+" "+pass);
		
	try {
			Thread.sleep(3000);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "scott", "tiger");

			if (con != null) {
				System.out.println("Connected to Oracle Server");
				pst=con.prepareStatement("INSERT INTO signup values(?,?,?,?,?)");
				
				pst.setString(1,name);
				pst.setString(2,email);
				pst.setString(3,mobno);
				pst.setString(4,pass);
				pst.setString(5,fileName);
				int i=pst.executeUpdate();
//				int i=1;
				
				
				if (i!=0) {
					InputStream is=part.getInputStream();
					byte [] data=new byte[is.available()];
					
					//put a stream in byte arr.
					
					is.read(data);
					String path=request.getRealPath("/")+"img"+File.separator+fileName;
//					out.print(path);
					FileOutputStream fos=new FileOutputStream(path);
					//write data on above path
					fos.write(data);
					out.print("success");
				} else {
					out.print("failure");
				}
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	 String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length()-1);
			}
		}
		return "";
	 }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processReq(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
