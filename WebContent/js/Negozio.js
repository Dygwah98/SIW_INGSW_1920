
initHomeSlider();

function initHomeSlider()
	{
		if($('.home_slider').length)
		{
			var homeSlider = $('.home_slider');
			homeSlider.owlCarousel(
			{
				items:1,
				autoplay:true,
				loop:true,
				nav:false,
				smartSpeed:1500,
			});

			/* Custom dots events */
			if($('.home_slider_custom_dot').length)
			{
				$('.home_slider_custom_dot').on('click', function()
				{
					$('.home_slider_custom_dot').removeClass('active');
					$(this).addClass('active');
					homeSlider.trigger('to.owl.carousel', [$(this).index(), 1500]);
				});
			}

			/* Change active class for dots when slide changes by nav or touch */
			homeSlider.on('changed.owl.carousel', function(event)
			{
				$('.home_slider_custom_dot').removeClass('active');
				$('.home_slider_custom_dots li').eq(event.page.index).addClass('active');
			});
		}
	}

// PRODOTTI
filterSelection("all")
function filterSelection(c) {
  var x, i;
  x = document.getElementsByClassName("divProdotto");
  if (c == "all") c = "";
  var cont =0;
  for (i = 0; i < x.length; i++) {
    w3RemoveClass(x[i], "mostraProdotti");
    if (x[i].className.indexOf(c) > -1) w3AddClass(x[i], "mostraProdotti");
    if(x[i].className.indexOf(c) == -1) cont++;
  }
  if(cont == x.length)
  	alert('nessun elemento');
  
}

function w3AddClass(element, name) {
  var i, arr1, arr2;
  arr1 = element.className.split(" ");
  arr2 = name.split(" ");
  for (i = 0; i < arr2.length; i++) {
    if (arr1.indexOf(arr2[i]) == -1) {element.className += " " + arr2[i];}
  }
}

function w3RemoveClass(element, name) {
  var i, arr1, arr2;
  arr1 = element.className.split(" ");
  arr2 = name.split(" ");
  for (i = 0; i < arr2.length; i++) {
    while (arr1.indexOf(arr2[i]) > -1) {
      arr1.splice(arr1.indexOf(arr2[i]), 1);     
    }
  }
  element.className = arr1.join(" ");
}

var btnContainer = document.getElementById("cate");
var btns = btnContainer.getElementsByClassName("elementi");
for (var i = 0; i < btns.length; i++) {
  btns[i].addEventListener("click", function(){
    var current = document.getElementsByClassName("active");
    current[0].className = current[0].className.replace(" active", "");
    this.className += " active";
    //btns[i].className += " active";
  });
}

var cont=0;
function aggiungiAlCarrello() {
	cont++;
	var cart = document.getElementById("carrello");
	cart.innerHTML = "["+cont+"]";
}



$("#cerca").submit( function(e ) {
	
	var c = $("#testo").val();
    var x, i;
    x = document.getElementsByClassName("divProdotto");
    console.log(x.length);
    if (c == "all") c = "";
    var cont =0;
    for (i = 0; i < x.length; i++) {
      w3RemoveClass(x[i], "mostraProdotti");
      if (x[i].className.indexOf(c) > -1) w3AddClass(x[i], "mostraProdotti");
      if(x[i].className.indexOf(c) == -1) cont++;
    }
    if(cont == x.length)
    	alert('nessun elemento');
    e.preventDefault();
   
    
} );

//function filtroNegozio(filtro) {
//	$.ajax({
//		
//		type: "GET",
//		url: "vedifiltri?filtro=" + filtro,
//		
//		success:function() {
//			window.location.replace("negozio.jsp#testo");
//		},
//		
//		error:function() {
//			alert('Nessun prodotto trovato');
//			window.location.replace("negozio.jsp#piu'");
//		}
//	});
//}