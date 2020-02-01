function ckout(event){
    $.ajax({
       type: "GET",
       url: "checkout",
       success:function(){
    	   	window.location.replace("checkout.jsp");
       },
       error : function (e, status, error) {
    	   
    	   if(e.status == 412) {
    		   alert("carrello vuoto impossibile procedere con l'ordine")    	   
    	   }
       }
    });
}

