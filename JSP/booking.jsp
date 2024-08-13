


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>StarkAirLines</title>
    <link rel="stylesheet" type="text/css" href="Booking.css">
    <link rel="shortcut icon" href="AirPlaneLogo.jpg"
        type="image/x-icon">
</head>
<body>

<div class="menu">
    <nav>
        <h2>Stark Airlines</h2>
<ul>
<li> <a href="index.jsp"> Home</a></li> 
<li><a href="AboutStarkAirlines.jsp">About</a> </li>
<li><a href="Contact.jsp">Contact</a></li>
<li><a href="Ticket.jsp">Ticket booking</a></li>

</ul>

    </nav>    
    <div class="overlay"></div>
    <div class="container">
        <h1>Search Flight</h1>
        <form class="booking-form" action="search-flight" method="post">
            <label for="departure">Departure/From :</label>
            <input type="text" id="departure" name="departure" placeholder="City or Airport" required>

            <label for="arrival">Arrival/To :</label>
            <input type="text" id="arrival" name="arrival" placeholder="City or Airport" required>

            <label for="departure-date">Departure Date :</label>
            <input type="date" id="departure-date" name="departure-date" required>

            <label for="return-date">Return Date :</label>
            <input type="date" id="return-date" name="return-date">

            <label for="passengers">Passengers :</label>
            <select id="passengers" name="passengers" required>
                <option value="1">1 Adult</option>
                <option value="2">2 Adults</option>
                <option value="3">3 Adults</option>
                <option value="4">4 Adults</option>
                <option value="5">5 Adults</option>
                <option value="6">6 Adults</option>
            </select>

            <button type="submit" class="button">Search Flights</button>
        </form>
    </div>
    </div>
</body>
</html>
