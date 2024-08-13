package com.summerproject.booking;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class DeleteFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flight_id = request.getParameter("f_id");
		
		RequestDispatcher dispatch = null;
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/summerproject","root","SamWeslie@14");
			PreparedStatement pst = con.prepareStatement("delete from flight where id=? ");
			
			pst.setString(1,flight_id);
			
			int rowCount=pst.executeUpdate();
			
			dispatch = request.getRequestDispatcher("AdminDash.jsp");
		
			dispatch.forward(request, response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
