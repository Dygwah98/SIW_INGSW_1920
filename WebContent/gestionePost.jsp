<?xml version="1.0" encoding="iso-8859-1"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
      "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
<title>GESTIONE POST</title>
<meta name="generator" content="Amaya, see http://www.w3.org/Amaya/" />
<link href="styles/LoginForm.css" rel="stylesheet" type="text/css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="js/admingestione.js"></script>
<style>
.c {
	width: 100%;
	display: flex;
	flex-direction: row;
	flex-wrap: nowrap;
	justify-content: space-between;
	text-align: center;
}

#aggiungi {
	float: left;
	width: 100%;
}

#elimina {
	display: inline-block;
	width: 100%;
}

#aggiorna {
	float: right;
	width: 100%;
}
</style>
</head>
<body>
	
	<div class="addcontrol-page">

		<div class="form">

			<div class="addp-form">
				<input type="text" name="Titolo" id="Titolo" placeholder="titolo" /> 
				<input type="text" name="Messaggio" id="Messaggio" placeholder="messaggio" /> 
				<input type="file" name="Immagine" id="Immagine" placeholder="img" /> 
				<button type="submit" id="btnaddc" onclick="addPost(event)">INSERISCI POST</button>
			</div>
		</div>
	</div>
	<div class="updatecontrol-page">

		<div class="form">

			<div class="addp-form">
				<input type="text" name="Identificativo" id="Identificativo" placeholder="id" />
				<input type="text" name="Titolo2" id="Titolo2" placeholder="titolo" /> 
				<input type="text" name="Messaggio2" id="Messaggio2" placeholder="messaggio" /> 
				<input type="file" name="Immagine2" id="Immagine2" placeholder="img" /> 
				<button type="submit" id="btnaddc" onclick="updatePost(event)">AGGIORNA POST</button>
			</div>
		</div>
	</div>
	<div class="deletecontrol-page">

		<div class="form">

			<div class="addp-form">
				<input type="text" name="Identificativo2" id="Identificativo2" placeholder="id" />
				<button type="submit" id="btnaddc" onclick="deletePost(event)">ELIMINA POST</button>
			</div>
		</div>
	</div>
	<div>
		<button type="button" onclick="returnhomepost()">Conferma</button>
		<p id="opened"></p>
	</div>
</body>
</html>