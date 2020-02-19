
function addcomm(event){
	 $.ajax({
	       type: "POST",
	       url: "commenta",
	     
	       data: {
	           recensione : $("#recensione").val(),
	           ID : $("#ID").val()
	       },
	       success:function(){
	    	   alert("Commento Inserito corretamente");
	    	   window.location.replace("viewpost");
	    	  
	       },
	        error : function () {
	            alert("Il Commento non è stato inserimento corretamente");
	        }
	    });
}