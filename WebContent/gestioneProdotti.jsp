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
		body{ background-image: url("images/shop/gestioneNegozio1.jpg");}
  </style>
</head>

<body>
	<div style="text-align: center; font-size: 20px; font-weight:bolder; paddind:1px;"><h3 style="color:white;">GESTIONE DEL NEGOZIO</h3></div>
	<div class ="c">
	<div class="addcontrol-page" id="aggiungi">
		<div class="form ">
			<div class="addp-form">

  				 <select name="Tipo" id="Tipo">
  				    <option >Tipologia:</option>
				    <option value="pomodori">pomodori</option>
				    <option value="fagiolini">fagiolini</option>
				    <option value="pecorino">pecorino</option>
				    <option value="maiale">maiale</option>
				    <option value="latte">latte</option>
				    <option value="broccoli">broccoli</option>
				    <option value="agli">agli</option>
				    <option value="cavolfiori">cavolfiori</option>
				    <option value="cipolle">cipolle</option>
				    <option value="mele">mele</option>
				    <option value="peperoni">peperoni</option>
				    <option value="peperoncini">peperoncini</option>
				    <option value="succhi">succhi</option>
				    <option value="emmental">emmental</option>
				    <option value="grana">grana</option>
				    <option value="vitello">vitello</option>
				    <option value="uova">uova</option>
				    <option value="pere">pere</option>
					<option value="ciliegie">ciliegie</option>
					<option value="uva">uva</option>
					<option value="arance">arance</option>
					<option value="pollo">pollo</option>
  				 </select>
      			  <br>
      			<select name="Descrizione" id="Descrizione">
      				<option >Categoria:</option>
				    <option value="verdura">verdura</option>
				    <option value="ortaggio">ortaggio</option>
				    <option value="carne">carne</option>
				    <option value="formaggi">formaggi</option>
				    <option value="frutta">frutta</option>
				    <option value="altro">altro</option>
  				 </select>
  				 <br>
  				 <select name="Img" id="Img" >
      			 	<option >Immagine:</option>
				    <option value="pomodori">pomodori</option>
				    <option value="fagiolini">fagiolini</option>
				    <option value="pecorino">pecorino</option>
				    <option value="maiale">maiale</option>
				    <option value="latte">latte</option>
				    <option value="broccoli">broccoli</option>
				    <option value="agli">agli</option>
				    <option value="cavolfiori">cavolfiori</option>
				    <option value="cipolle">cipolle</option>
				    <option value="mele">mele</option>
				    <option value="peperoni">peperoni</option>
				    <option value="peperoncini">peperoncini</option>
				    <option value="succhi">succhi</option>
				    <option value="emmental">emmental</option>
				    <option value="grana">grana</option>
				    <option value="vitello">vitello</option>
				    <option value="uova">uova</option>
				    <option value="pere">pere</option>
					<option value="ciliegie">ciliegie</option>
					<option value="uva">uva</option>
					<option value="arance">arance</option>
					<option value="pollo">pollo</option>
  				 </select>
      			 <input type="text" name="Prezzo" id="Prezzo" placeholder="Prezzo"/>
      			 
  				 <br>
  				 <br>
       			 <button type="submit" id="btnaddp" onclick="addp(event)">AGGIUNGI UN PRODOTTO</button>
    		</div>
    	</div>
    </div>
    <div class="udpatecontrol-page" id="aggiorna">
    		<div class="form">

			<div class="updatep-form">
			 	  <input type="number" name="pr1" id="pr1" placeholder="Id"/>
  				 <select name="Tipo1" id="Tipo1">
  				    <option >Tipologia:</option>
				    <option value="pomodori">pomodori</option>
				    <option value="fagiolini">fagiolini</option>
				    <option value="pecorino">pecorino</option>
				    <option value="maiale">maiale</option>
				    <option value="latte">latte</option>
				    <option value="broccoli">broccoli</option>
				    <option value="agli">agli</option>
				    <option value="cavolfiori">cavolfiori</option>
				    <option value="cipolle">cipolle</option>
				    <option value="mele">mele</option>
				    <option value="peperoni">peperoni</option>
				    <option value="peperoncini">peperoncini</option>
				    <option value="succhi">succhi</option>
				    <option value="emmental">emmental</option>
				    <option value="grana">grana</option>
				    <option value="vitello">vitello</option>
				    <option value="uova">uova</option>
				    <option value="pere">pere</option>
					<option value="ciliegie">ciliegie</option>
					<option value="uva">uva</option>
					<option value="arance">arance</option>
					<option value="pollo">pollo</option>
  				 </select>
  				 <br>
      			 <select name="Descrizione1" id="Descrizione1">
      				<option >Categoria:</option>
				    <option value="verdura">verdura</option>
				    <option value="ortaggio">ortaggio</option>
				    <option value="carne">carne</option>
				    <option value="formaggi">formaggi</option>
				    <option value="frutta">frutta</option>
				    <option value="altro">altro</option>
  				 </select>
  				 
      			 <br>
      			 <select name="Img1" id="Img1" >
      			 	<option >Immagine:</option>
				    <option value="pomodori">pomodori</option>
				    <option value="fagiolini">fagiolini</option>
				    <option value="pecorino">pecorino</option>
				    <option value="maiale">maiale</option>
				    <option value="latte">latte</option>
				    <option value="broccoli">broccoli</option>
				    <option value="agli">agli</option>
				    <option value="cavolfiori">cavolfiori</option>
				    <option value="cipolle">cipolle</option>
				    <option value="mele">mele</option>
				    <option value="peperoni">peperoni</option>
				    <option value="peperoncini">peperoncini</option>
				    <option value="succhi">succhi</option>
				    <option value="emmental">emmental</option>
				    <option value="grana">grana</option>
				    <option value="vitello">vitello</option>
				    <option value="uova">uova</option>
				    <option value="pere">pere</option>
					<option value="ciliegie">ciliegie</option>
					<option value="uva">uva</option>
					<option value="arance">arance</option>
					<option value="pollo">pollo</option>
  				 </select>
  				 <br>
      			 <input type="text" name="Prezzo1" id="Prezzo1" placeholder="Prezzo"/>
       			 <button type="submit" id="btnupdatep" onclick="updatep(event)">AGGIORNA UN PRODOTTO</button>
    		</div>
  		</div>
  	</div>
  	<div class="deletecontrol-page" id="elimina">
  		<div class="form">
			<div class="deletep-form">
  				 	  <input type="number" name="idprodo" id="idprodo" placeholder="Id"/>
       			 <button type="submit" id="btndeletep" onclick="deletep(event)">ELIMINA PRODOTTO</button>
    		</div>
  		</div>
  	</div>
  </div>
	<div style="text-align: center;">
		<button class="button" type="button" onclick="returnhomeprodotto()"><strong>CONFERMA</strong></button>
		<p id="opened"></p>
	</div>
</body>
</html>