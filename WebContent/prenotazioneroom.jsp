<?xml version="1.0" encoding="iso-8859-1"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
      "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
  <meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
  <title>booking</title>
  <meta name="generator" content="Amaya, see http://www.w3.org/Amaya/" />
    <link href="styles/LoginForm.css" rel="stylesheet" type="text/css" />
  
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="js/admingestione.js"></script>
</head>
<body>
<div class="addcontrol-page">

		<div class="form">

			<div class="addp-form">
				<input type="date" name="checkin" id="checkin" placeholder="checkin" /> <input
					type="date" name="checkout" id="checkout" placeholder="checkout" /> <input
					type="text" name="n_camera" id="n_camera"
					placeholder="n_camera" />
				<button type="submit" id="btnapr" onclick="addprenotazione(event)">addroom!</button>
			</div>
		</div>
	</div>
	<button type="submit" id="btnapr" onclick="returnhomeprenotazioni(event)">returnviewroom</button>
	
</body>
</html>
