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


public class UpdateFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flightname = request.getParameter("flightName2");
		String departure = request.getParameter("departure2");
		String arrival = request.getParameter("arrival2");
		String dpdate = request.getParameter("departureDate2");
		String flight_id = request.getParameter("f_id");
		
		RequestDispatcher dispatch = null;
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/summerproject","root","SamWeslie@14");
			PreparedStatement pst = con.prepareStatement("update flight set takeoff=?,landing=?,dtdate=? where id=? ");
			
			pst.setString(1, departure);
			pst.setString(2, arrival);
			pst.setString(3, dpdate);
			pst.setString(4,flight_id);
			
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
