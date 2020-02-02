<?xml version="1.0" encoding="iso-8859-1"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
      "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
  <meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
  <title>GESTIONE PRODOTTI</title>
  <meta name="generator" content="Amaya, see http://www.w3.org/Amaya/" />
  <link href="styles/gestioneAdmin.css" rel="stylesheet" type="text/css" />
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="js/admingestione.js"></script>
  <style>
		body{ background-image: url("images/gestionePost.jpg");}
  </style>
</head>
<body>
	<div style="text-align: center; font-size: 20px; font-weight:bolder; paddind:1px;"><h3 style="color:white;">GESTIONE DEL BLOG</h3></div>
	<div class ="c">
	<div class="addcontrol-page" id="aggiungi">

		<div class="form">

			<div class="addp-form">
				<input type="text" name="Titolo" id="Titolo" placeholder="titolo" /> 
				<input type="text" name="Messaggio" id="Messaggio" placeholder="messaggio" /> 
				<select name="Immagine" id="Immagine" >
      			 	<option >Immagine:</option>
				    <option value="servizi">servizi</option>
				    <option value="stanze">stanze</option>
				    <option value="ristorante">ristorante</option>
  				 </select> 
				<button type="submit" id="btnaddc" onclick="addPost(event)">INSERISCI POST</button>
			</div>
		</div>
	</div>
	<div class="updatecontrol-page" id="aggiorna">

		<div class="form">

			<div class="addp-form">
				<input type="text" name="Identificativo" id="Identificativo" placeholder="id" />
				<input type="text" name="Titolo2" id="Titolo2" placeholder="titolo" /> 
				<input type="text" name="Messaggio2" id="Messaggio2" placeholder="messaggio" /> 
				<select name="Immagine2" id="Immagine2" >
      			 	<option >Immagine:</option>
				    <option value="servizi">servizi</option>
				    <option value="stanze">stanze</option>
				    <option value="ristorante">ristorante</option>
  				 </select>  
				<button type="submit" id="btnaddc" onclick="updatePost(event)">AGGIORNA POST</button>
			</div>
		</div>
	</div>
	<div class="deletecontrol-page" id="elimina">

		<div class="form">

			<div class="addp-form">
				<input type="text" name="Identificativo2" id="Identificativo2" placeholder="id" />
				<button type="submit" id="btnaddc" onclick="deletePost(event)">ELIMINA POST</button>
			</div>
		</div>
	</div>
</div>
<div style="text-align: center;">
		<button class="button" type="button" onclick="returnhomepost()"><strong>CONFERMA</strong></button>
		<p id="opened"></p>
	</div>
</body>
</html>