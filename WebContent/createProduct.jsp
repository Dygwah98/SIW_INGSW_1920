
<?xml version="1.0" encoding="iso-8859-1"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
      "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
  <meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
  <title>AddRoom</title>
  <meta name="generator" content="Amaya, see http://www.w3.org/Amaya/" />
  <link href="styles/RegistrationForm.css" rel="stylesheet" type="text/css" />
</head>
<body>
<form class="decor"  method="post" action="${pageContext.request.contextPath}/product_servlet" >
  <div class="form-left-decoration"></div>
  <div class="form-right-decoration"></div>
  <div class="circle"></div>
  <div class="form-inner">
    <h3>INSERISCI UN NUOVO PRODOTTO</h3>
     <input type="text" name="Id" placeholder="id">
    <input type="text" name="Tipo"placeholder="nome">
    <input type="text" name="Descrizione" placeholder="Descrizione">
    <input type="text" name="Prezzo"placeholder="prezzo">
    <input type="submit" value="Invia">
  </div>
</form>
</body>
</html>