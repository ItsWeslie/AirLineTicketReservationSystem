


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.summerproject.booking.Booking" %>
    <%@page import="jakarta.servlet.RequestDispatcher,
jakarta.servlet.ServletException,
jakarta.servlet.http.HttpServlet,
 jakarta.servlet.http.HttpServletRequest,
 jakarta.servlet.http.HttpServletResponse,
java.io.IOException,java.io.PrintWriter,java.sql.Connection,java.sql.DriverManager,java.sql.PreparedStatement,java.sql.ResultSet" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>StarkAirLines</title>
    <link rel="stylesheet" href="Result.css">
    <link rel="shortcut icon" href="AirPlaneLogo.jpg"
        type="image/x-icon">
</head>
<body>
<%

String flightname = (String) request.getAttribute("fname");
String departure = (String) request.getAttribute("takeoff");
String arrival = (String) request.getAttribute("landing");
String dept_date = (String) request.getAttribute("dtdate");
	
%>

    <div class="overlay"></div>
    <div class="container">
        <h1>Your Flight Details</h1>
        <div class="flight-details">
            <p><strong>Flight status :  Available</strong> <span id="departure"></span></p>
            <p><strong>Flight name : <%=(flightname) %></strong> <span id="departure"></span></p>
            <p><strong>Departure :<%=(departure) %></strong> <span id="departure"></span></p>
            <p><strong>Arrival :<%=(arrival) %></strong> <span id="arrival"></span></p>
            <p><strong>Departure Date :<%=(dept_date)%></strong> <span id="departureDate"></span></p>
            
        </div>
    </div>
</body>
</html>
    