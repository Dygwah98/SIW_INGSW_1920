function ckout(event){
    $.ajax({
       type: "GET",
       url: "checkout",
       success:function(){
    	   window.location.replace("checkout.jsp");
       },
        error : function () {
        	alert("carrello vuoto impossibile procedere con l'ordine")
     	   window.location.replace("cart.jsp");
        }
    });
}