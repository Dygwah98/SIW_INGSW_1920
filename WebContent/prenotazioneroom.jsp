<?xml version="1.0" encoding="iso-8859-1"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
      "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
  <meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
  <title>booking</title>
  <meta name="generator" content="Amaya, see http://www.w3.org/Amaya/" />
  <link href="styles/RegistrationForm.css" rel="stylesheet" type="text/css" />
</head>
<body>
<form class="decor"  method="post" action="${pageContext.request.contextPath}/RegisterUser">
  <div class="form-left-decoration"></div>
  <div class="form-right-decoration"></div>
  <div class="circle"></div>
  <div class="form-inner">
    <h3>booking_room</h3>
    <input type="date" name="checkin"placeholder="checkin"> 
    <input type="date" name="checkout"placeholder="checkout"> 
    <input type="text" name="n_camera"placeholder="n_camera"> 
    <input type="submit" value="Inviare">
  </div>
</form>
</body>
</html>
