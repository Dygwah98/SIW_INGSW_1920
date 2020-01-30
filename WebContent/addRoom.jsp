<?xml version="1.0" encoding="iso-8859-1"?>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
  <title>AddRoom</title>
  <meta name="generator" content="Amaya, see http://www.w3.org/Amaya/" />
  <link href="styles/RegistrationForm.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="decor">
  <div class="form-left-decoration"></div>
  <div class="form-right-decoration"></div>
  <div class="circle"></div>
  <form class="form-inner" method="post" action="${pageContext.request.contextPath}/rooms_servlet">
    <h3>AddRoom</h3>
    <input type="text" name="id" placeholder="id">
    <input type="text" name="Tipo" placeholder="Tipo">
    <input type="text" name="Descrizione" placeholder="Descrizione">
    <input type="text" name="numMaxPersone" placeholder="numMaxPersone"> 
    <input type="text" name="prezzo" placeholder="prezzo">
    <input type="submit" value="Inviare">
  </form>
</div>
</body>
</html>