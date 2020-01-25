<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Agriturismo Sarella</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Sarella agriturismo">
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="styles/bootstrap-4.1.2/bootstrap.min.css">

<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.3.4/owl.carousel.css">
<link rel="stylesheet" type="text/css" href="styles/prodottoSingolo.css">
<link rel="stylesheet" type="text/css" href="styles/responsive.css">

<link rel="stylesheet" href="styles/icomoon.css">
<link rel="stylesheet" href="styles/ionicons.min.css">

<script src="js/jquery-3.3.1.min.js"></script>
<script src="plugins/OwlCarousel2-2.3.4/owl.carousel.js"></script>
<script src="js/custom.js"></script>


</head>
  
  <body>
  
  <!-- Intestazione -->

	<header class="header">
		<div class="header_content d-flex flex-row align-items-center justify-content-start">
			<div class="logo"> <a href="#">Agriturismo Sarella</a></div>
			<div class="ml-auto d-flex flex-row align-items-center justify-content-start">
				<nav class="main_nav">
					<ul class="d-flex flex-row align-items-start justify-content-start">
						 <%if(request.getSession().getAttribute("logged") == null || !(boolean)request.getSession().getAttribute("logged")){%>
							<li><a href="Loginform.jsp">Login</a></li>
						 <%}
					  	 else if (request.getSession().getAttribute("logged") != null && (boolean)request.getSession().getAttribute("logged")){%>
					  		<li><a href="logout">Logout</a></li>
					  	 <%}%>
						<li ><a href="index.jsp">Home</a></li>
						<li><a href="vediprodotti">Negozio</a></li>
						<li><a href="#">Lista dei desideri</a></li>
					</ul>
			   </nav>
			   <% if (request.getSession().getAttribute("logged") != null && (boolean)request.getSession().getAttribute("logged")){%>
					<nav class="main_nav">
					<ul class="d-flex flex-row align-items-start justify-content-start">
						<li class="active"><a  href="addcart"><span id="carrello" class="icon-shopping_cart">[0]</span ></a></li>
					</ul>
				</nav>
			   <%}%>
			</div>
		</div>

	<!-- Menu Scorrevole -->
	
	<div class="hamburger"><i class="fa fa-bars"  aria-hidden="true"></i></div>
	</header>

	<!-- Menu -->

	<div class="menu trans_400 d-flex flex-column align-items-end justify-content-start">
		<div class="menu_close"><i class="fa fa-times" aria-hidden="true"></i></div>
		<div class="menu_content">
			<nav class="menu_nav text-right">
				<ul>
					 <% if(request.getSession().getAttribute("logged") == null || !(boolean)request.getSession().getAttribute("logged")){%>
						<li><a href="Loginform.jsp">Login</a></li>
				     <%}
				     else if (request.getSession().getAttribute("logged") != null && (boolean)request.getSession().getAttribute("logged")){%>
						  <li><a href="logout">Logout</a></li>
					 <%}%>
					<li ><a href="index.jsp">Home</a></li>
					<li><a href="vediprodotti">Negozio</a></li>
					<li><a href="#">Lista dei desideri</a></li>
			   </ul>
		   </nav>
		</div>
		<div class="menu_extra">
		<% if (request.getSession().getAttribute("logged") != null && (boolean)request.getSession().getAttribute("logged")){%>
			<nav class="main_nav">
					<ul class="d-flex flex-row align-items-start justify-content-start">
						<li><a  href="addcart"><span id="carrello" class="icon-shopping_cart">[0]</span ></a></li>
					</ul>
				</nav>
	    <%}%>
		</div>
	</div>
    <!-- END nav -->

   <div class="home">
		<div class="home_slider_container">
			<div class="owl-carousel home_slider">
				
				<!-- Prima Slide -->
				<div class="slide">
					<div class="background_image" style="background-image:url(images/index_1.jpg)"></div>
					<div class="home_container">
						<div class="container">
							<div class="row">
								<div class="col">
									<div class="home_content text-center">
										<div class="home_title">PRODOTTO SINGOLO</div>
											<p class="descrizione">Acquista i prodotti dei tuoi sogni...</p>
											<a href="#prodotto" class="bottone trans_200">DETTAGLI</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			 </div>
		</div>		
	</div>
   
  <c:forEach var="prodotto" items="${prodotto}">
    <section id="prodotto"  class="ftco-section1">
    	<div class="container">
    		<div class="row">
    			<div   class="col-lg-6 mb-5 ">
    				<a href="#" class="cursore"><img style="border: 1px solid orange" src="${prodotto.img}.jpg"  alt=""></a>
    			</div>
    			<div class="col-lg-6 dettagli-prodotto pl-md-5 ">
    				<h3 >${prodotto.tipo}</h3>
    				<div class="d-flex">
							<p class="text-left mr-4" id="recensioni">
								<a href="#"><span  class="ion-ios-star-outline"></span></a>
								<a href="#"><span  class="ion-ios-star-outline"></span></a>
								<a href="#"><span  class="ion-ios-star-outline"></span></a>
								<a href="#"><span  class="ion-ios-star-outline"></span></a>
								<a href="#"><span  class="ion-ios-star-outline"></span></a>
							</p>
							<p class="text-left mr-4">
								<a href="#" class="mr-2" style="color: #000;">100 <span style="color: orange;">Recensioni</span></a>
							</p>
							<p class="text-left">
								<a href="#" class="mr-2" style="color: #000;">500 <span style="color: orange;">Venduti</span></a>
							</p>
						</div>
    				<p class="price"><span>${prodotto.prezzo}</span></p>
    				<p>${prodotto.descrizione}</p>
						<div class="row mt-4">
							<div class="col-md-6">
								<div class="form-group d-flex">
		              				<div class="select-wrap">
	                  					<div class="icon"><span class="ion-ios-arrow-down"></span></div>
	                  					<select name="" id="" class="form-control">
						                  	<option value="">Small</option>
						                    <option value="">Medium</option>
						                    <option value="">Large</option>
						                    <option value="">Extra Large</option>
	                 					 </select>
	                				</div>
		            			</div>
							</div>
							<div class="w-100"></div>
							<div class="input-group col-md-6 d-flex mb-3">
		             			<span class=" mr-2">
		                			<button type="button" class="quantity-left-minus btn"  data-type="minus" data-field="">
		                  				 <i class="ion-ios-remove"></i>
		                			</button>
		            			</span>
		             			<input type="text" id="quantity" name="quantity" class="form-control " value="1" min="1" max="100">
		             			<span class="input-group-btn ml-2">
		                			<button type="button" class="quantity-right-plus btn"  data-type="plus" data-field="">
		                     			<i class="ion-ios-add"></i>
		                 			</button>
		             			</span>
	          				</div>
	          				<div class="w-100"></div>
	          				<div class="col-md-12">
	          					<p style="color: #000;">In teoria la quantita andrebbe qua!</p>
	          				</div>
          				</div>
          				<p><a href="cart.html" class="btn btn-black py-3 px-5">Aggiungi al carrello</a></p>
    				</div>
    			</div>
    		</div>
    	</section>
    </c:forEach>
    	
       <section class="ftco-section">
	    	<div class="container">
				<div class="row justify-content-center mb-3 pb-3">
	          		<div class="col-md-12 heading-section text-center">
	          			<span class="subheading">Prodotti</span>
	            		<h2 class="mb-4">Prodotti relativi:</h2>
	          		</div>
	       	   </div>   		
	       </div>
	   </section>
	   
	 <div class="divCatalogo">
		<c:forEach var="prodotto" items="${prodotto}">
			<div class="divProdotto ${prodotto.descrizione}">
  				<div class="prodotto"> 
  					<a href="#" class="proiezione"><img src="${prodotto.img}.jpg" alt="peperone">
  						<span class="sconto">50%</span> 
  					</a>
  					<div class="text py-3 pb-4 px-3 text-center"> 
  						<h3><a id="tipo" href="#" onclick="aggiungiAlCarrello()">${prodotto.tipo}</a></h3>
  						<div class="d-flex">
    						<p class="prezzo">${prodotto.prezzo} euro</p>
   						</div>
	   					<div class="bottoni d-flex px-3">
	   						<div class="m-auto d-flex">
	   							<a href="#" class="add-to-cart d-flex justify-content-center align-items-center text-center">
	   								<span><i class="ion-ios-menu"></i></span>
	   							</a>
	   							<a href="addCart" class="buy-now d-flex justify-content-center align-items-center mx-1">
	   								<span><i class="ion-ios-cart"></i></span>
	   							</a>
	   							<a href="#" class="heart d-flex justify-content-center align-items-center ">
	   								<span><i class="ion-ios-heart"></i></span>
	   							</a>
	  						</div>
	  					</div>
  					</div>
  				</div>
    		</div>		    	
		</c:forEach>
    </div>
     
     <!-- Footer -->
	<footer  class="footer">
		<div class="footer_content">
			<div class="container">
				<div class="row">
					<div class="col">
						<div class="footer_logo_container text-center">
							<div class="footer_logo">
								<a href="#"></a>
								<div>Agriturismo Sarella</div>
								<div>Dal 1945</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row footer_row">
					
					<!-- Address -->
					<div class="col-lg-3">
						<div class="footer_title">Il nostro indirizzo</div>
						<div class="footer_list">
							<ul>
								<li>complanare 180</li>
								<li>88025 Cancello</li>
								<li>IT</li>
							</ul>
						</div>
					</div>

					<!-- Reservations -->
					<div class="col-lg-3">
						<div class="footer_title">Contatti</div>
						<div class="footer_list">
							<ul>
								<li>Tel: 345 5667 889</li>
								<li>Fax; 6783 4567 889</li>
								<li>contatto@hotelSarella.com</li>
							</ul>
						</div>
					</div>

					<!-- Newsletter -->
					<div class="col-lg-3">
						<div class="footer_title">Newsletter</div>
						<div class="newsletter_container">
							<form action="#" class="newsletter_form" id="newsletter_form">
								<input type="email" class="newsletter_input" placeholder="Your email address" required="required">
								<button class="newsletter_button">Iscriviti</button>
							</form>
						</div>
					</div>

					<!-- Footer images -->
					<div class="col-lg-3">
						<div class="certificates d-flex flex-row align-items-start justify-content-lg-between justify-content-start flex-lg-nowrap flex-wrap">
							<div class="cert"><img src="images/cert_1.png" alt=""></div>
							<div class="cert"><img src="images/cert_2.png" alt=""></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</footer>
    	

  </body>
</html>