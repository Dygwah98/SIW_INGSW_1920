function logi(event){
    $.ajax({
       type: "POST",
       url: "login",
     
       data: {
           username : $("#username").val(),
           password : $("#password").val()
       },
       success:function(){
    	   window.location.replace("index.jsp");
       },
        error : function () {
            alert("USERNAME O PASSWORD ERRATI");
           
        }
    });
}