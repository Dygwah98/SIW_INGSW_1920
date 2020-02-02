function payment1(event){
    $.ajax({
       type: "GET",
       url: "paym",
       success:function(){
    	   alert("pagamento avvenuto con successo");
    	   window.location.replace("index.jsp");
    	   

       },
        error : function () {
          alert("errore pagamento riprovare");
     	   window.location.replace("checkout.jsp");
    	   

        }
    });
}

$(document).ready(function(){
	  $("form").submit(function(e){
		  e.preventDefault();
	    $("#conferma").hide();
	    $("#paga").show();
	    
	  });
	});

$(document).ready(function(){
	$( "#reset" ).click(function() {
		  location.replace("checkout.jsp");
		});
});
