<?xml version="1.0" encoding="iso-8859-1"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
      "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
  <meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
  <title>GESTIONE PRODOTTI</title>
  <meta name="generator" content="Amaya, see http://www.w3.org/Amaya/" />
  <link href="styles/LoginForm.css" rel="stylesheet" type="text/css" />
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  
    <script src="js/admingestione.js"></script>
  
</head>


<body>
	<div class="addcontrol-page">

		<div class="form">
			<div class="addp-form">
  				 <input type="text" name="Tipo" id="Tipo" placeholder="Tipo"/>
      			 <input type="text" name="Descrizione" id="Descrizione" placeholder="Descrizione"/>
      			 <input type="text" name="Prezzo" id="Prezzo" placeholder="Prezzo"/>
      			 Scegli l'immagine:
      			 <select name="Img" id="Img" >
				    <option value="pomodoro">pomodoro</option>
				    <option value="fagiolini">fagiolini</option>
				    <option value="pecorino">pecorino</option>
				    <option value="cavolo">cavolo</option>
  				 </select>
  				 <br>
  				 <br>
       			 <button type="submit" id="btnaddp" onclick="addp(event)">addproduct!</button>
    		</div>
    	</div>
    </div>
    <div class="udpatecontrol-page">
    		<div class="form">

			<div class="updatep-form">
			 	  <input type="number" name="pr1" id="pr1" placeholder="id"/>
  				 <input type="text" name="Tipo1" id="Tipo1" placeholder="Tipo"/>
      			 <input type="text" name="Descrizione1" id="Descrizione1" placeholder="Descrizione"/>
      			 <input type="text" name="Prezzo1" id="Prezzo1" placeholder="Prezzo"/>
       			 <button type="submit" id="btnupdatep" onclick="updatep(event)">updateproduct!</button>
    		</div>
  		</div>
  	</div>
  	<div class="deletecontrol-page">
  		<div class="form">
			<div class="deletep-form">
  				 	  <input type="number" name="idprodo" id="idprodo" placeholder="idprodo"/>
       			 <button type="submit" id="btndeletep" onclick="deletep(event)">deleteproduct!</button>
    		</div>
  		</div>
  	</div>
	<div>
		<button type="button" onclick="returnhome()">tornaadhome</button>
		<p id="opened"></p>
	</div>

</body>
</html>