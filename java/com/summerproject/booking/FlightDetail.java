package com.summerproject.booking;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
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

/**
 * Servlet implementation class FlightDetail
 */
public class FlightDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		 PrintWriter out =response.getWriter();
			
			Connection con=null;
			PreparedStatement pst=null;
			ResultSet rs=null;
			RequestDispatcher rd = request.getRequestDispatcher("");
			HttpSession session = request.getSession();
			try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/summerproject","root","SamWeslie@14");
			
			String sql = "select id,fname,takeoff,landing,dtdate from flight";
			
			pst = con.prepareStatement(sql);
			
			rs = pst.executeQuery();
			
			out.println("id"+"      "+"fname"+"      	"+"takeoff"+"      	"+"landing"+"      	"+"dtdate\n");
			
			out.println();
			while(rs.next())
			{
				String id = rs.getString("id");
				String fname = rs.getString("fname");
				String takeoff = rs.getString("takeoff");
				String landing = rs.getString("landing");
				String dtdate = rs.getString("dtdate");
				
				    request.setAttribute("id", id);
					request.setAttribute("fname", fname);
					request.setAttribute("takeoff", takeoff);
					request.setAttribute("landing", landing);
					request.setAttribute("dtdate", dtdate);
					
					
					
					out.println(id+"      "+fname+"      "+takeoff+"      "+landing+"      "+dtdate);
					
					out.println();
					
				
				
			}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				try 
				{
				con.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
	}

}
