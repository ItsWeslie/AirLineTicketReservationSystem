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
 * Servlet implementation class TicketDetails
 */
public class TicketDetails extends HttpServlet {
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
			
			String sql = "select passname,age,con_num,fname,takeoff,landing,dtdate,passcount from ticket";
			
			pst = con.prepareStatement(sql);
			
			rs = pst.executeQuery();
			
			out.println("name"+"      		"+"age"+" 	 	    "+"contact number"+"  	 	   "+"flight name"+" 	   	 	 "+"takeoff"+"  	 	  "+"landing"+" 	  	   "+"departure date"+"  	 "+"passenger count\n");
			
			out.println();
			while(rs.next())
			{
				String passname = rs.getString("passname");
				String age = rs.getString("age");
				String con_num = rs.getString("con_num");
				String fname = rs.getString("fname");
				String takeoff = rs.getString("takeoff");
				String landing = rs.getString("landing");
				String dtdate = rs.getString("dtdate");
				String passcount = rs.getString("passcount");
				
				    request.setAttribute("passname", passname);
				    request.setAttribute("age", age);
				    request.setAttribute("con_num", con_num);
					request.setAttribute("fname", fname);
					request.setAttribute("takeoff", takeoff);
					request.setAttribute("landing", landing);
					request.setAttribute("dtdate", dtdate);
					request.setAttribute("passcount", passcount);
					
					
					
					out.println(passname+"      		"+age+" 	 	    "+con_num+"  	 	   "+fname+" 	   	  "+takeoff+"  	 	   "+landing+" 	  	   "+dtdate+"  	 	   "+passcount);
					
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
