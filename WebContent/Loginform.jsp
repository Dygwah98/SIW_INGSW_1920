<?xml version="1.0" encoding="iso-8859-1"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
      "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
  <meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
  <title>Nuovo</title>
  <meta name="generator" content="Amaya, see http://www.w3.org/Amaya/" />
  <link href="styles/login.css" rel="stylesheet" type="text/css" />
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
   <script src="js/login1.js"></script>
   <style>
   body{
	background-image: url("images/sfondo.jpg");
	}
	</style>

</head>

<body>

<div class="container" id="container">
	<div class="form-container sign-up-container">
		<form class="decor"  method="post" action="${pageContext.request.contextPath}/RegisterUser">
			<h1>Crea un account</h1>
			<input type="text" name="name" placeholder="nome">
		    <input type="text" name="cognome" placeholder="cognome">
		    <input type="date" name="data" placeholder="data di nascita"> 
		    <input type="text"name="username" placeholder="username">
		    <input type="password" name="password"placeholder="password">
		    <input type="email" name="email" placeholder="email">
		    <button type="submit">registrati</button>
		</form>
	</div>
	<div class="form-container sign-in-container">
		<form action="#">
			<h1>Accedi</h1>
			<input type="text" id="username" placeholder="username" />
			<input type="password" id="password" placeholder="password" />
			<button type="submit" id="btnLogin" onclick="logi(event)">Accedi</button>
		</form>
	</div>
	<div class="overlay-container">
		<div class="overlay">
			<div class="overlay-panel overlay-left">
				<h1>Bentornato!</h1>
				<p>Usa le tue credenziali di accesso</p>
				<button class="ghost" id="signIn">Accedi</button>
			</div>
			<div class="overlay-panel overlay-right">
				<h1>Benvenuto!</h1>
				<p>Crea delle nuove credenziali di accesso</p>
				<button class="ghost" id="signUp">Inzia</button>
			</div>
		</div>
	</div>
</div>
 <script src="js/login.js"></script>


</body>
</html>
