
function addprenotazione(event){
    $.ajax({
       type: "POST",
       url: "addprenotazione",
     
       data: {
           checkin : $("#checkin").val(),
           checkout : $("#checkout").val(),
           n_camera : $("#n_camera").val(),
       },
       success:function(){
    	   alert("Prenotazione registrata corretamente");
    	   window.location.replace("viewroom");
    	  
       },
        error : function () {
            alert("La Prenotazione non è stata registrata corretamente");
     	   window.location.replace("prenotazioneroom.jsp");

        }
    });
}

function addp(event){
    $.ajax({
       type: "POST",
       url: "addproduct",
     
       data: {
           Tipo : $("#Tipo").val(),
           Descrizione : $("#Descrizione").val(),
           Prezzo : $("#Prezzo").val(),
           Img : $("#Img").val()           
       },
       success:function(){
    	   alert("Prodotto Inserito corretamente");
    	   window.location.replace("gestioneProdotti.jsp");
    	  
       },
        error : function () {
            alert("il prodotto non è stato inserimento corretamente");
     	   window.location.replace("gestioneProdotti.jsp");

        }
    });
}
function updatep(event){
    $.ajax({
       type: "POST",
       url: "updateprodotto",
     
       data: {
    	   Pr1 : $("#pr1").val(),
           Tipo1 : $("#Tipo1").val(),
           Descrizione1 : $("#Descrizione1").val(),
           Prezzo1 : $("#Prezzo1").val(),
           Img1 : $("#Img1").val() 
       },
       success:function(){
    	   alert("Prodotto aggiornato corretamente");
    	   window.location.replace("gestioneProdotti.jsp");

    	  
       },
        error : function () {
            alert("il prodotto non è stato aggiornato corretamente o id prodotto non corretto");
     	   window.location.replace("gestioneProdotti.jsp");

        }
    });
}
function deletep(event){
    $.ajax({
       type: "POST",
       url: "deleteprodotto",
     
       data: {
           idprodo : $("#idprodo").val()
       },
       success:function(){
    	   alert("Prodotto eliminato corretamente");
    	   window.location.replace("gestioneProdotti.jsp");
    	  
       },
        error : function () {
            alert("il prodotto non è stato eliminato corretamente o id prodotto non corretto");
     	   window.location.replace("gestioneProdotti.jsp");

        }
    });
    
}
function returnhomeprodotto(event){
    $.ajax({
       type: "POST",
       url: "index.jsp",
       success:function(){
    	   var answer = window.confirm("Confermi le operazioni svolte? I dati nei form andranno persi")
    	   if(answer)
    		   window.location.replace("index.jsp");
    	   else{}
    	  
       },
       error : function () {
    	   alert("Errore nella conferma, riprova");
    	   window.location.replace("gestioneProdotti.jsp");
       
       }
    });
    
}
function addc(event){
    $.ajax({
       type: "POST",
       url: "rooms_servlet",
     
       data: {
    	   Id1 : $("#Id1").val(),
    	   Tipo1 : $("#Tipo1").val(),
           Descrizione1 : $("#Descrizione1").val(),
           numMaxPersone1 : $("#numMaxPersone1").val(),
           Img1 : $("#Img1").val(),
           Prezzo1 : $("#Prezzo1").val()
       },
       success:function(){
    	   alert("Camera Inserita corretamente");
    	   window.location.replace("gestioneCamere.jsp");
    	  
       },
        error : function () {
            alert("la camera  non è stata inserita corretamente");
     	   window.location.replace("gestioneCamere.jsp");

        }
    });
}
function updatec(event){
    $.ajax({
       type: "POST",
       url: "updaterooms_servlet",
     
       data: {
    	   Id2 : $("#Id2").val(),
    	   Tipo2 : $("#Tipo2").val(),
           Descrizione2 : $("#Descrizione2").val(),
           numMaxPersone2 : $("#numMaxPersone2").val(),
           Img2 : $("#Img2").val(),
           Prezzo2 : $("#Prezzo2").val()
       },
       success:function(){
    	   alert("camera aggiornata corretamente");
    	   window.location.replace("gestioneCamere.jsp");

    	  
       },
        error : function () {
            alert("il prodotto non è stato aggiornato corretamente o id prodotto non corretto");
     	   window.location.replace("gestioneCamere.jsp");

        }
    });
}
function deletec(event){
    $.ajax({
       type: "POST",
       url: "deleterooms_servlet",
     
       data: {
    	   Id3 : $("#Id3").val()
       },
       success:function(){
    	   alert("Camera eliminata corretamente");
    	   window.location.replace("gestioneCamere.jsp");
    	  
       },
        error : function () {
            alert("l'id non corrisponde oppure la camera è stata prenotata");
     	   window.location.replace("gestioneCamere.jsp");

        }
    });
    
}


function returnhomeroom(event){
    $.ajax({
       type: "POST",
       url: "index.jsp",
       success:function(){
    	   var answer =window.confirm("Confermi le operazioni svolte? I dati nei form andranno persi")
    	   if(answer)
    		   window.location.replace("index.jsp");
    	   else{}
    	  
       },
        error : function () {
           window.location.replace("gestioneCamere.jsp");

        }
    });
}
function returnhomeprenotazioni(event){
    $.ajax({
       type: "POST",
       url: "index.jsp",
       success:function(){
    	   var answer =window.confirm("Confermi le operazioni svolte? I dati nei form andranno persi")
    	   if(answer)
    		   window.location.replace("viewroom");
    	   else{}
    	  
       },
        error : function () {
           window.location.replace("prenotazioneroom.jsp");

        }
    });
}
function addPost(event){
	 $.ajax({
	       type: "POST",
	       url: "NewPost",
	     
	       data: {
	           Titolo : $("#Titolo").val(),
	           Messaggio : $("#Messaggio").val(),
	           Immagine : $("#Immagine").val(),
	           Data : $("#Data").val()           
	       },
	       success:function(){
	    	   alert("Post Inserito corretamente");
	    	   window.location.replace("gestionePost.jsp");
	    	  
	       },
	        error : function () {
	            alert("Il Post non è stato inserimento corretamente");
	     	   window.location.replace("gestionePost.jsp");

	        }
	    });
}
function updatePost(event){
    $.ajax({
       type: "POST",
       url: "updatepost",
     
       data: {
    	   Identificativo : $("#Identificativo").val(),
    	   Titolo2 : $("#Titolo2").val(),
           Messaggio2 : $("#Messaggio2").val(),
           Immagine2 : $("#Immagine2").val(),
           Data2 : $("#Data2").val()    
       },
       success:function(){
    	   alert("Post aggiornato corretamente");
    	   window.location.replace("gestionePost.jsp");

    	  
       },
        error : function () {
            alert("Il post non è stato aggiornato corretamente o l'id post non corretto");
     	   window.location.replace("gestionePost.jsp");

        }
    });
}
function deletePost(event){
    $.ajax({
       type: "POST",
       url: "deletepost",
     
       data: {
    	   Identificativo2 : $("#Identificativo2").val()
       },
       success:function(){
    	   alert("Post eliminato corretamente");
    	   window.location.replace("gestionePost.jsp");
    	  
       },
        error : function () {
            alert("Il Post non  e stato eliminato corretamente o l'id post non corretto");
     	   window.location.replace("gestionePost.jsp");

        }
    });
    
}

function returnhomepost(event){
    $.ajax({
       type: "POST",
       url: "index.jsp",
       success:function(){
    	   var answer =window.confirm("Confermi le operazioni svolte? I dati nei form andranno persi")
    	   if(answer){
    		   window.location.replace("index.jsp");
    	   }
    	   else{}
    	  
       },
        error : function () {
           window.location.replace("gestionePost.jsp");

        }
    });
}

