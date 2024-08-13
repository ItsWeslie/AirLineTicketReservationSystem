<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>StarkAirLines</title>
	<link rel="stylesheet" type="text/css" href="Contact.css">
    <link rel="shortcut icon" href="AirPlaneLogo.jpg"
        type="image/x-icon">
</head>
<body>
    <div class="menu">
		
		<nav>
			<h2>Stark Airlines</h2>

<ul>
    <li> <a href="StarkAirLines.jsp"> Home</a></li> 
    <li><a href="AboutStarkAirlines.jsp">About</a> </li>
    <li><a href="Contact.jsp">Contact</a></li>
    <li><a href="login.jsp">Login</a></li>
</ul>

        </nav>

<div class="contact-container">
    <form action="https://api.web3forms.com/submit" method="POST" class="contact-left">
        <div class="contact-left-title">
            <h2>Welcome!<br>Stark Airlines</h2>
            <hr>
        </div>
        <input type="hidden" name="access_key" value="5ddb92b1-79c5-4b73-97e3-286c4c62fc0b">
        <input type="text" name="name" placeholder="your name" class="contact-inputs" required>
        <input type="email" name="email" placeholder="your email" class="contact-inputs" required>
        <textarea name="message" placeholder="your message" class="contact-inputs" required></textarea>
        <button type="submit">Submit <img src="arrow_icon.png" alt=""></button>
    </form>

</div>


</body>
</html>