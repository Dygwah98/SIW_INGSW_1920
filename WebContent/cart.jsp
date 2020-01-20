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
<link rel="stylesheet" type="text/css" href="styles/Carrello.css">
<link rel="stylesheet" type="text/css" href="styles/responsive.css">

<link rel="stylesheet" href="styles/icomoon.css">
<link rel="stylesheet" href="styles/ionicons.min.css">



<script src="js/jquery-3.3.1.min.js"></script>
<script src="plugins/OwlCarousel2-2.3.4/owl.carousel.js"></script>
<script src="js/custom.js"></script>
<script src="js/carrello.js"></script>

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
						<li><a href="negozio.jsp">Negozio</a></li>
						<li><a href="#">Lista dei desideri</a></li>
					</ul>
			   </nav>
			   <% if (request.getSession().getAttribute("logged") != null && (boolean)request.getSession().getAttribute("logged")){%>
					<nav class="main_nav">
					<ul class="d-flex flex-row align-items-start justify-content-start">
						<li><a  href="cart.jsp"><span id="carrello" class="icon-shopping_cart">[0]</span ></a></li>
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
					<li><a href="negozio.jsp">Negozio</a></li>
					<li><a href="#">Lista dei desideri</a></li>
			   </ul>
		   </nav>
		</div>
		<div class="menu_extra">
		<% if (request.getSession().getAttribute("logged") != null && (boolean)request.getSession().getAttribute("logged")){%>
			<nav class="main_nav">
					<ul class="d-flex flex-row align-items-start justify-content-start">
						<li><a  href="cart.jsp"><span id="carrello" class="icon-shopping_cart">[0]</span ></a></li>
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
										<div class="home_title">CARRELLO</div>
											<p class="descrizione">Acquista i prodotti dei tuoi sogni...</p>
											<a href="#piu" class="bottone trans_200">DETTAGLI</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			 </div>
		</div>		
	</div>

    <section id="piu" class="ftco-section ftco-cart">
			<div class="container">
				<div class="row">
    			<div class="col-md-12">
    				<div class="cart-list">
	    				<table class="table">
						    <thead class="thead-primary">
						      <tr class="text-center">
						        <th>&nbsp;</th>
						        <th>&nbsp;</th>
						        <th>Nome Prodotto</th>
						        <th>Prezzo</th>
						        <th>Quantità</th>
						      </tr>
						    </thead>
						    <tbody style="background-color: white;">
						      <tr class="text-center">
						        <td class="product-remove"><a href="#"><span class="ion-ios-close"></span></a></td>
						        
						        <td class="image-prod"><div class="img" style="background-image:url(images/product-3.jpg);"></div></td>
						        
						        <td class="product-name">
						        	<h3>Fagiolini</h3>
						        	<p> Baccello verde e acerbo, raccolto e consumato con il suo baccello</p>
						        </td>
						        
						        <td class="prezzo">3.90 euro</td>
						        
						        <td class="quantity">
						        	<div class="input-group mb-3">
					             		<a href="#piu" onclick="decrementa()" class="previous round">-</a>
					             			<input id="valore" type="text" name="quantity" class="quantity form-control input-number" value="0" min="1" max="100">
					          			<a href="#piu" onclick="incrementa()"  class="next round">+</a>
					          		</div>
					          </td>
						        
						      </tr><!-- END TR-->
						    </tbody>
						  </table>
					  </div>
    			</div>
    		</div>
    		<div class="row">
    			<div class="col-md-12">
    				<div class="cart-list">
	    				<table class="table">
						    <thead class="thead-secondary">
						      <tr class="text-center">
						        <th>&nbsp;</th>
						        <th>&nbsp;</th>
						        <th>Stanza</th>
						        <th>Servizi</th>
						        <th>Prezzo</th>
						        <th>num</th>
						        <th>Check-in</th>
						        <th>Check-out</th>
						      </tr>
						    </thead>
						    <tbody style="background-color: white;">
						      <tr class="text-center">
						        <td class="product-remove"><a href="#"><span class="ion-ios-close"></span></a></td>
						        
						        <td class="image-prod"><div class="img" style="background-image:url(images/booking_1.jpg);"></div></td>
						        
						        <td >
						        	<p>Singola</p>
						        </td>
						        
						        <td >
						        	<p> 
						        		<ul>
						        			<li>bagno</li>
						        			<li>doccia</li>
						        			<li>frigo-bar</li>
						        			<li>tv</li>
						        		</ul>
						        	</p>
						        </td>
						        
						        <td class="prezzo">100 euro</td>
						        
						        <td class="quantity">
						        	<div class="input-group mb-3">
					             		<a href="#" onclick="decrementa()" class="previous round">-</a>
					             			<input id="valore" type="text" name="quantity" class="quantity form-control input-number" value="0" min="1" max="100">
					          			<a href="#piu"  class="next round">+</a>
					          		</div>
					          </td>
						        <td class="prezzo">15 ottobre</td>
						        <td class="prezzo">20 ottobre</td>
						      </tr><!-- END TR-->
						    </tbody>
						  </table>
					  </div>
    			</div>
    		</div>
    		
    		<div class="container">
    			<div  class="col-lg-4 mt-5 cart-wrap ">
    				<div class="cart-total mb-3">
    					<h4>Resoconto</h4>
    					<p class="d-flex">
    						<span><b>1x</b></span>
    						<span class="corrispondente">Fagiolini</span>
    					</p>
    					<p class="d-flex">
    						<span><b>1x</b></span>
    						<span class="corrispondente">Singola</span>
    					</p>
    					<hr>
    					<p class="d-flex total-price">
    						<span><b>Totale</b></span>
    						<span class="corrispondente">103,90 euro</span>
    					</p>
    				</div>
    				<p><a href="checkout.jsp" class="btn btn-primary py-3 px-4">Procedi al pagamento</a></p>
    			</div>
    		</div>
	</div>
	</section>

	
   <footer class="footer">
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