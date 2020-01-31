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
		margin: 10px;
	}
	
	#elimina {
		display: inline-block;
		margin: 0 auto;
		width: 100%;
		margin: 10px;
	}
	
	#aggiorna {
		float: right;
		width: 100%;
		margin: 10px;
	}
</style>
</head>


<body>
	<div style="text-align: center;"><h3>GESTIONE DEL NEGOZIO</h3></div>
	<div class ="c">
	<div class="addcontrol-page" id="aggiungi">

		<div class="form ">
			<div class="addp-form">
  				 <input type="text" name="Tipo" id="Tipo" placeholder="Tipo(al plurale)"/>
      			  Scegli la categoria:
      			 <select name="Descrizione" id="Descrizione" >
				    <option value="verdura">verdura</option>
				    <option value="ortaggio">ortaggio</option>
				    <option value="carne">carne</option>
				    <option value="formaggi">formaggi</option>
				    <option value="frutta">frutta</option>
				    <option value="altro">altro</option>
  				 </select>
  				 <br>
  				 <br>
      			 <input type="text" name="Prezzo" id="Prezzo" placeholder="Prezzo"/>
      			 Scegli l'immagine:
      			 <select style="width: 100px" name="Img" id="Img" >
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
  				 <br>
       			 <button type="submit" id="btnaddp" onclick="addp(event)">AGGIUNGI UN PRODOTTO</button>
    		</div>
    	</div>
    </div>
    <div class="udpatecontrol-page" id="elimina">
    		<div class="form">

			<div class="updatep-form">
			 	  <input type="number" name="pr1" id="pr1" placeholder="id"/>
  				 <input type="text" name="Tipo" id="Tipo" placeholder="Tipo(al plurale)"/>
      			  Scegli la categoria:
      			 <select name="Descrizione" id="Descrizione" >
				    <option value="verdura">verdura</option>
				    <option value="ortaggio">ortaggio</option>
				    <option value="carne">carne</option>
				    <option value="formaggi">formaggi</option>
				    <option value="frutta">frutta</option>
				    <option value="altro">altro</option>
  				 </select>
  				 <br>
  				 <br>
      			 <input type="text" name="Prezzo" id="Prezzo" placeholder="Prezzo"/>
      			 Scegli l'immagine:
      			 <select style="width: 100px" name="Img" id="Img" >
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
  				 <br>
       			 <button type="submit" id="btnupdatep" onclick="updatep(event)">AGGIORNA UN PRODOTTO</button>
    		</div>
  		</div>
  	</div>
  	<div class="deletecontrol-page" id="aggiorna">
  		<div class="form">
			<div class="deletep-form">
  				 	  <input type="number" name="idprodo" id="idprodo" placeholder="idprodo"/>
       			 <button type="submit" id="btndeletep" onclick="deletep(event)">ELIMINA PRODOTTO</button>
    		</div>
  		</div>
  	</div>
  </div>
	<div style="text-align: center;">
		<button type="button" onclick="returnhomeprodotto()"><strong>CONFERMA</strong></button>
		<p id="opened"></p>
	</div>
</body>
</html>