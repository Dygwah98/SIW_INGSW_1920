<?xml version="1.0" encoding="iso-8859-1"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
      "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
<title>GESTIONE CAMERE</title>
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
				<input type="text" name="Id1" id="Id1" placeholder="ID" /> <input
					type="text" name="Tipo1" id="Tipo1" placeholder="Tipo" /> <input
					type="text" name="Descrizione1" id="Descrizione1"
					placeholder="Descrizione" /> <input type="text"
					name="numMaxPersone1" id="numMaxPersone1"
					placeholder="numMaxPersone"><input type="text"
					name="Prezzo1" id="Prezzo1" placeholder="Prezzo" />
				<button type="submit" id="btnaddc" onclick="addc(event)">addroom!</button>
			</div>
		</div>
	</div>
	<div class="updatecontrol-page">

		<div class="form">

			<div class="addp-form">
				<input type="text" name="Id2" id="Id2" placeholder="ID" /> 
				<input
					type="text" name="Tipo2" id="Tipo2" placeholder="Tipo" /> <input
					type="text" name="Descrizione2" id="Descrizione2"
					placeholder="Descrizione" /> <input type="text"
					name="numMaxPersone2" id="numMaxPersone2"
					placeholder="numMaxPersone"> <input type="text"
					name="Prezzo2" id="Prezzo2" placeholder="Prezzo" />
					<button type="submit" id="btnaddc" onclick="updatec(event)">updateroom!</button>
			</div>
		</div>
	</div>
	<div class="deletecontrol-page">

		<div class="form">

			<div class="addp-form">
				<input type="text" name="Id3" id="Id3" placeholder="ID" />
				<button type="submit" id="btnaddc" onclick="deletec(event)">deleteroom!</button>
			</div>
		</div>
	</div>
	<div>
		<button type="button" onclick="returnhomeroom()">conferma</button>
		<p id="opened"></p>
	</div>
</body>
</html>