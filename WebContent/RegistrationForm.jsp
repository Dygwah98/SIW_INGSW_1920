<?xml version="1.0" encoding="iso-8859-1"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
      "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
  <meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
  <title>RegistrationForm</title>
  <meta name="generator" content="Amaya, see http://www.w3.org/Amaya/" />
  <link href="styles/RegistrationForm.css" rel="stylesheet" type="text/css" />
</head>
<body>
<form class="decor"  method="post" action="${pageContext.request.contextPath}/RegisterUser">
  <div class="form-left-decoration"></div>
  <div class="form-right-decoration"></div>
  <div class="circle"></div>
  <div class="form-inner">
    <h3>Registrazione</h3>
    <input type="text" name="name" placeholder="Nome">
    <input type="text" name="cognome" placeholder="Cognome">
    <input type="date" name="data"placeholder="DataDiNascita"> 
    <input type="text"name="username" placeholder="Username">
    <input type="password" name="password"placeholder="Password">
    <input type="email" name="email" placeholder="Email">
    <input type="submit" value="Inviare">
  </div>
</form>
</body>
</html>
