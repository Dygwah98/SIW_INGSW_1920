
var slideIndex = 0;
showSlides();

//IMMAGINI SLIDE INTESTAZIONE
function showSlides() {
	  var i;
	  var slides = document.getElementsByClassName("slide");
	  var dots = document.getElementsByClassName("home_slider_custom_dot");
	  for (i = 0; i < slides.length; i++) {
	    //slides[i].style.display = "none";  
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
  for (i = 0; i < x.length; i++) {
    w3RemoveClass(x[i], "mostraProdotti");
    if (x[i].className.indexOf(c) > -1) w3AddClass(x[i], "mostraProdotti");
  }
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
    var current = document.getElementsByClassName(" active");
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

//ORDINA
function ordina() {
	  var list, i, switching, b, shouldSwitch;
	  list = document.getElementByClass("divCatalogo");
	  switching = true;
	  /* Make a loop that will continue until
	  no switching has been done: */
	  while (switching) {
	    // start by saying: no switching is done:
	    switching = false;
	    b = list.getElementsByTagName("DIV");
	    // Loop through all list-items:
	    for (i = 0; i < (b.length - 1); i++) {
	      // start by saying there should be no switching:
	      shouldSwitch = false;
	      /* check if the next item should
	      switch place with the current item: */
	      if (b[i].innerHTML.toLowerCase() > b[i + 1].innerHTML.toLowerCase()) {
	        /* if next item is alphabetically
	        lower than current item, mark as a switch
	        and break the loop: */
	        shouldSwitch = true;
	        break;
	      }
	    }
	    if (shouldSwitch) {
	      /* If a switch has been marked, make the switch
	      and mark the switch as done: */
	      b[i].parentNode.insertBefore(b[i + 1], b[i]);
	      switching = true;
	    }
	  }
}