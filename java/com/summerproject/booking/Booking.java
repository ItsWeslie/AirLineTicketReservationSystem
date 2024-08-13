package com.summerproject.booking;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class Booking extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String take= request.getParameter("departure");
		String land= request.getParameter("arrival");
		String dtdat= request.getParameter("departure-date");
		String rtdate= request.getParameter("return-date");
	
		
		PrintWriter out =response.getWriter();
		
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		RequestDispatcher rd = request.getRequestDispatcher("Result.jsp");
		HttpSession session = request.getSession();
		try {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/summerproject","root","SamWeslie@14");
		
		String sql = "select fname,takeoff,landing,dtdate from flight";
		
		pst = con.prepareStatement(sql);
		
		rs = pst.executeQuery();
		while(rs.next())
		{
			String fname = rs.getString("fname");
			String takeoff = rs.getString("takeoff");
			String landing = rs.getString("landing");
			String dtdate = rs.getString("dtdate");
			
			
			
			
			if(take.equals(takeoff)&&land.equals(landing)&&dtdat.equals(dtdate)) 
			{
				request.setAttribute("fname", fname);
				request.setAttribute("takeoff", takeoff);
				request.setAttribute("landing", landing);
				request.setAttribute("dtdate", dtdate);
				rd.forward(request, response);

			}
			else
			{
				
			}
		}
		response.sendRedirect("result2.jsp");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
			con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}
	
}
