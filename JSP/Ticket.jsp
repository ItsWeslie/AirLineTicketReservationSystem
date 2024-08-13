

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>StarkAirLines</title>
    <link rel="stylesheet" type="text/css" href="Ticket.css">
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
</ul>

    </nav>    
    

    <div class="overlay"></div>
    <div class="container">
        <h1>Book your flight</h1>
        <form class="booking-form" action="Ticket" method="post">

            <label for="name">Name :</label>
            <input type="text" id="name" name="name" placeholder=" Your Name" required>

            <label for="age">Age :</label>
            <input type="text" id="age" name="age" placeholder="Your Age " required>
            
            <label for="contact">Contact no :</label>
            <input type="text" id="contact" name="contact" placeholder="Your contact number" required>

            <label for="flight-name">Flight name :</label>
            <input type="text" id="flight-name" name="flight-name" placeholder="Flight name" required>

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

            <button type="submit" class="button" onclick="">Submit</button>
            <div class="popup" id="popup">
                <img src="tick.jpg">
                <h2>Successfully ticket booked </h2>
                <p>your details has been successfully submitted!</p>
                <button type="button" onclick="closePopup()">OK</button>
            </div>
        </form>
    </div>
</div>

<script>
    let popup=document.getElementById("popup");
    function openPopup()
    {
     popup.classList.add("open-popup");   
    }
    function closePopup()
    {
     popup.classList.remove("open-popup");   
    }
</script>
</body>
</html>
