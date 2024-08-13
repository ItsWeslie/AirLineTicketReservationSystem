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


public class AddFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flightname = request.getParameter("flightName");
		String departure = request.getParameter("departure");
		String arrival = request.getParameter("arrival");
		String dpdate = request.getParameter("departureDate");
		
		RequestDispatcher dispatch = null;
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/summerproject","root","SamWeslie@14");
			PreparedStatement pst = con.prepareStatement("insert into flight(fname,takeoff,landing,dtdate) values(?,?,?,?) ");
			pst.setString(1, flightname);
			pst.setString(2, departure);
			pst.setString(3, arrival);
			pst.setString(4, dpdate);
			
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
