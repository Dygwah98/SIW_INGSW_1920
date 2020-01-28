


var slideIndex = 0;
showSlides();

//IMMAGINI SLIDE INTESTAZIONE
function showSlides() {
	  var i;
	  var slides = document.getElementsByClassName("slide");
	  var dots = document.getElementsByClassName("home_slider_custom_dot");
	  for (i = 0; i < slides.length; i++) {
	   // slides[i].style.display = "none";  
	  }
	  slideIndex++;
	  if (slideIndex > slides.length) {slideIndex = 1}    
	  for (i = 0; i < dots.length; i++) {
	    dots[i].className = dots[i].className.replace(" active", "");
	  }
	  slides[slideIndex-1].style.display = "block";  
	  dots[slideIndex-1].className += " active";
	  setTimeout(showSlides, 2000); // Change image every 2 seconds
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

