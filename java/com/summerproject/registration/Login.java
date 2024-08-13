package com.summerproject.registration;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String username = request.getParameter("username");
		String uemail= request.getParameter("username");
		String upwd= request.getParameter("password");
		HttpSession session = request.getSession();
		RequestDispatcher dispatch = null;
		 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/summerproject","root","SamWeslie@14");
			PreparedStatement pst = con.prepareStatement("select * from users where (uemail=? and upwd=?) or (uname=? and upwd=?)");
			pst.setString(1, uemail);
			pst.setString(2, upwd);
			pst.setString(3, username);
			pst.setString(4, upwd);
			
			
			
			ResultSet rs = pst.executeQuery();
			if(rs.next())
			{
				session.setAttribute("name", rs.getString("uname"));
				session.setAttribute("username", rs.getString("uname"));
				dispatch = request.getRequestDispatcher("index.jsp");
				
			}
			else
			{
				request.setAttribute("status", "failed");
				dispatch = request.getRequestDispatcher("login.jsp");
			}
			
			dispatch.forward(request, response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
