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
		body{ background-image: url("images/booking.jpg");}
  </style>
</head>

<body>
	<div style="text-align: center; font-size: 20px; font-weight:bolder; paddind:1px;"><h3 style="color:white;">GESTIONE DELLE CAMERE</h3></div>
	<div class ="c">
	<div class="addcontrol-page" id="aggiungi">
		<div class="form ">
			<div class="addp-form">
				 <input type="text" name="Id1" id="Id1" placeholder="ID"/>
  				 <select name="Tipo1" id="Tipo1">
  				    <option >Tipologia:</option>
				    <option value="singola">singola</option>
				    <option value="doppia">doppia</option>
				    <option value="tripla">tripla</option>
  				 </select>
      			  <br>
      			<input type="text" name="Descrizione1" id="Descrizione1" placeholder="descrizione"/>
      			<input type="text" name="numMaxPersone1" id="numMaxPersone1" placeholder="num_persone"/>
  				 <br>
  				 <select name="Img1" id="Img1" >
      			 	<option >Immagine:</option>
				    <option value="singola">singola</option>
				    <option value="doppia">doppia</option>
				    <option value="tripla">tripla</option>
  				 </select>
      			 <input type="text" name="Prezzo1" id="Prezzo1" placeholder="Prezzo"/>
      			 
  				 <br>
  				 <br>
       			 <button type="submit" id="btnaddc" onclick="addc(event)">AGGIUNGI UNA CAMERA</button>
    		</div>
    	</div>
    </div>
    <div class="udpatecontrol-page" id="aggiorna">
    		<div class="form">
				<div class="addp-form">
				 <input type="text" name="Id2" id="Id2" placeholder="ID"/>
  				 <select name="Tipo2" id="Tipo2">
  				    <option >Tipologia:</option>
				    <option value="singola">singola</option>
				    <option value="doppia">doppia</option>
				    <option value="tripla">tripla</option>
  				 </select>
      			  <br>
      			<input type="text" name="Descrizione2" id="Descrizione2" placeholder="descrizione"/>
      			<input type="text" name="numMaxPersone2" id="numMaxPersone2" placeholder="num_persone"/>
  				 <br>
  				 <select name="Img2" id="Img2" >
      			 	<option >Immagine:</option>
				    <option value="singola">singola</option>
				    <option value="doppia">doppia</option>
				    <option value="tripla">tripla</option>
  				 </select>
      			 <input type="text" name="Prezzo2" id="Prezzo2" placeholder="Prezzo"/>
      			 
  				 <br>
  				 <br>
       			 <button type="submit" id="btnaddc" onclick="updatec(event)">AGGIORNA UNA CAMERA</button>
    		</div>
  			</div>
  	</div>
  	<div class="deletecontrol-page" id="elimina">
  		<div class="form">
			<div class="deletep-form">
  				 	  <input type="text" name="Id3" id="Id3" placeholder="ID"/>
       			 <button type="submit" id="btnaddc" onclick="deletec(event)">ELIMINA UNA CAMERA</button>
    		</div>
  		</div>
  		<div style="text-align: center;">
		<button class="button" type="button" onclick="returnhomeroom()"><strong>CONFERMA</strong></button>
		<p id="opened"></p>
	</div>
  	</div>
  </div>
	
</body>
</html>