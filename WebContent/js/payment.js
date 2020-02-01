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

function pagamento(event) {
	

$.ajax({
	   data: $('#cash').serialize(),                 
	   success: function (data) {                       
		   $(function () {
			    $("#conferma").on('click', function () {
			        $("#paga").show();
			        $("#conferma").hide();
			    });
			});

	   },
	   error: function (xhr, text, error) {             
	      alert('Error: ' + error);
	   }
	});
}
