package com.summerproject.booking;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Ticket extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		PrintWriter out =response.getWriter();
		
		String name= request.getParameter("name");
		String age= request.getParameter("age");
		String contact= request.getParameter("contact");
		String fname= request.getParameter("flight-name");
		String takeoff= request.getParameter("departure");
		String landing= request.getParameter("arrival");
		String dtdate= request.getParameter("departure-date");
		String rtdate= request.getParameter("return-date");
		String passcount= request.getParameter("passengers");
		
		int return_len = rtdate.length();
		
		try {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/summerproject","root","SamWeslie@14");
		
		String sql = "select fname,takeoff,landing,dtdate from flight";
		
		pst = con.prepareStatement(sql);
		
		rs = pst.executeQuery();
		
		while(rs.next())
		{
			
			String flightname = rs.getString("fname");
			String departure = rs.getString("takeoff");
			String arrival = rs.getString("landing");
			String dept_date = rs.getString("dtdate");
			
		if(flightname.equals(fname)&&departure.equals(takeoff)&&arrival.equals(landing)&&dept_date.equals(dtdate))	
		{
		
		if(return_len>0)
		{
		pst = con.prepareStatement("insert into ticket(passname,age,con_num,fname,takeoff,landing,dtdate,rtdate,passcount) values(?,?,?,?,?,?,?,?,?) ");
		pst.setString(1, name);
		pst.setString(2, age);
		pst.setString(3, contact);
		pst.setString(4, fname);
		pst.setString(5, takeoff);
		pst.setString(6, landing);
		pst.setString(7, dtdate);
		pst.setString(8, rtdate);
		pst.setString(9, passcount);
		
		}
		else
		{
			pst = con.prepareStatement("insert into ticket(passname,age,con_num,fname,takeoff,landing,dtdate,rtdate,passcount) values(?,?,?,?,?,?,?,?,?) ");
			pst.setString(1, name);
			pst.setString(2, age);
			pst.setString(3, contact);
			pst.setString(4, fname);
			pst.setString(5, takeoff);
			pst.setString(6, landing);
			pst.setString(7, dtdate);
			pst.setNull(8, java.sql.Types.VARCHAR);
			pst.setString(9, passcount);
			
		}
		}
		else
		{
			response.sendRedirect("result2.jsp");
		}
		}
		int rowCount = pst.executeUpdate();
		
		if(rowCount>0)
		{
		
			
			
			out.print("Ticket booked successfully");
		/*while(rs.next())
		{
			String  pass_name= rs.getString("passname");
			String pass_age = rs.getString("age");
			String pass_c_no = rs.getString("con_num");
			String f_name = rs.getString("fname");
			String  take= rs.getString("takeoff");
			
			String land = rs.getString("landing");
			String dtdat = rs.getString("dtdate");
			String rtdat = rs.getString("rtdate");
			String pass_coun = rs.getString("passcount");
			
			
			out.print("pass_name");
		}*/
		
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
