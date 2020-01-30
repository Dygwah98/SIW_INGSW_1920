function payment1(event){
    $.ajax({
       type: "GET",
       url: "paym",
       success:function(){
    	  
    	   window.location.replace("index.jsp");
    	   alert("pagamento avvenuto con successo");

       },
        error : function () {
     	   window.location.replace("index.jsp");
    	   alert("errore pagamento riprovare");

        }
    });
}
