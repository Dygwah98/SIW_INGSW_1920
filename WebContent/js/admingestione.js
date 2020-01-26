function addp(event){
    $.ajax({
       type: "POST",
       url: "addproduct",
     
       data: {
           Tipo : $("#Tipo").val(),
           Descrizione : $("#Descrizione").val(),
           Prezzo : $("#Prezzo").val()
       },
       success:function(){
    	   alert("Prodotto Inserito corretamente");
    	   window.location.replace("vediprodotti");
    	  
       },
        error : function () {
            alert("il prodotto non è stato inserimento corretamente");
            window.location.replace("vediprodotti");
        }
    });
}
function updatep(event){
    $.ajax({
       type: "POST",
       url: "updateprodotto",
     
       data: {
    	   Pr1 : $("#pr1").val(),
           Tipo : $("#Tipo").val(),
           Descrizione : $("#Descrizione").val(),
           Prezzo1 : $("#Prezzo1").val()
       },
       success:function(){
    	   alert("Prodotto aggiornato corretamente");
    	   window.location.replace("vediprodotti");
    	  
       },
        error : function () {
            alert("il prodotto non è stato aggiornato corretamente o id prodotto non corretto");
            window.location.replace("vediprodotti");
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
    	   window.location.replace("vediprodotti");
    	  
       },
        error : function () {
            alert("il prodotto non è stato eliminato corretamente o id prodotto non corretto");
            window.location.replace("vediprodotti");
        }
    });
}