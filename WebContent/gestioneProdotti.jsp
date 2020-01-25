<?xml version="1.0" encoding="iso-8859-1"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
      "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
  <meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
  <title>GESTIONE PRODOTTI</title>
  <meta name="generator" content="Amaya, see http://www.w3.org/Amaya/" />
  <link href="styles/RegistrationForm.css" rel="stylesheet" type="text/css" />
  <style>
  
  	
  	.c{
  		width:100%;
    	display: flex;                 
  		flex-direction: row;            
  		flex-wrap: nowrap;              
  		justify-content: space-between; 
  		text-align: center;
  	}
  	
  	#aggiungi{
  		float:left; width: 100%;
  	}
  	
  	#elimina{
  		display: inline-block;
  		 width: 100%;
  	}
  	
  	#aggiorna{
  		float:right; width: 100%;
  	}
  	
  </style>
</head>


<body>
	<div class="c">
		<form id="aggiungi" class="decor"  method="post" action="${pageContext.request.contextPath}/addproduct" >
		  
		  <div class="form-inner">
		   	<h3>INSERISCI UN NUOVO PRODOTTO</h3>
			    <input type="text" name="Tipo"placeholder="nome">
			    <input type="text" name="Descrizione" placeholder="Descrizione">
			    <input type="text" name="Prezzo"placeholder="prezzo">
			    <input type="submit" value="Invia">
		  </div>
		</form>
	
		<form id="elimina" class="decor"  method="post" action="${pageContext.request.contextPath}/deleteprodotto" >
		 
		  <div class="form-inner">
		    <h3>ELIMINA UN PRODOTTO</h3>
		     <input type="text" name="Id" placeholder="id">
		     <input type="submit" value="Invia">
		  </div>
		</form>
		
		<form id="aggiorna" class="decor"  method="post" action="${pageContext.request.contextPath}/updateprodotto" >
		  
		  <div class="form-inner">
		    <h3>AGGIORNA UN PRODOTTO</h3>
		     	<input type="text" name="Id" placeholder="id">
			    <input type="text" name="Tipo" placeholder="Tipo">
			    <input type="text" name="Descrizione" placeholder="Descrizione">
			    <input type="text" name="Prezzo" placeholder="prezzo"> 
			    <input type="submit" value="Invia">
		  </div>
		</form>
	</div>
</body>
</html>