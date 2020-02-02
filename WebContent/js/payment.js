function payment1(event){
    $.ajax({
       type: "GET",
       url: "paym",
       success:function(){
    	  
    	   window.location.replace("index.jsp");
    	   alert("pagamento avvenuto con successo");

       },
        error : function () {
     	   window.location.replace("checkout.jsp");
    	   alert("errore pagamento riprovare");

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
