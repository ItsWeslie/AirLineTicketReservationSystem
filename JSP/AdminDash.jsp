<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin-Dashboard</title>
    <link rel="shortcut icon" href="AirPlaneLogo.jpg"
        type="image/x-icon">
    <link rel="stylesheet" href="Admindash.css">
</head>
<body>
    <!-- Sidebar -->
    <div class="sidenav">
        <h2>Dashboard</h2>
        <br>
        <br>
        <form action="FlightDetail" method="post"><button type="submit">Flights</button></form>
        <form action="TicketDetails" method="post"><button type="submit">Tickets</button></form>
        

        <!-- Add more links as needed -->
    </div>

 

    <!-- Main Content -->
    <div class="main-content">
        <h1>Welcome to Admin Dashboard</h1>
        <div class="form-container">
            <form action="AddFlight" method="post">
                <div class="form-row">
                    <label for="flightName">Flight Name</label>
                    <input type="text" id="flightName" name="flightName" required>
                    
                    <label for="departure">Departure</label>
                    <input type="text" id="departure" name="departure" required>
                    
                    <label for="arrival">Arrival</label>
                    <input type="text" id="arrival" name="arrival" required>
                    
                    <label for="departureDate">Departure Date</label>
                    <input type="date" id="departureDate" name="departureDate" required>
                    
                    <button type="submit">Add flight</button>
                </div>
            </form>
        </div>

        <div class="form-container">
            <form action="UpdateFlight" method="post">
                <div class="form-row">
                    <label for="flightName2">Flight Name</label>
                    <input type="text" id="flightName2" name="flightName2" required>
                    
                    <label for="departure2">Departure</label>
                    <input type="text" id="departure2" name="departure2" required>
                    
                    <label for="arrival2">Arrival</label>
                    <input type="text" id="arrival2" name="arrival2" required>
                    
                    <label for="departureDate2">Departure Date</label>
                    <input type="date" id="departureDate2" name="departureDate2" required>
                    
                    <label for="f_id">Flight id</label>
                    <input type="text" id="f_id" name="f_id" required>
                    
                    
                    <button type="submit">Update</button>
                </div>
            </form>
        </div>

         <div class="form-container">
        <form action="DeleteFlight" method="post">
         <div class="deleteForm">
              <label for="f_id">Flight id</label>
                    <input type="text" id="f_id" name="f_id" required>
            <button class="delete" type="submit">Delete</button>
            </div>
        </form>
    </div>
    </div>
    
    
   
</body>
</html>
