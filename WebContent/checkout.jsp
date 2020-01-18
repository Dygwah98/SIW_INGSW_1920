<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<link rel="stylesheet" type="text/css" href="styles/checkout.css">
<link rel="stylesheet" type="text/css" href="styles/responsive.css">

<link rel="stylesheet" href="styles/icomoon.css">
<link rel="stylesheet" href="styles/ionicons.min.css">



<script src="js/jquery-3.3.1.min.js"></script>
<script src="plugins/OwlCarousel2-2.3.4/owl.carousel.js"></script>
<script src="js/custom.js"></script>
<script src="js/carrello.js"></script>
  </head>
  <body class="goto-here">
  
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
										<div class="home_title">CHECKOUT</div>
											<p class="descrizione">Procedi al pagamento..</p>
											<a href="#sezione2" class="bottone trans_200">DETTAGLI</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			 </div>
		</div>		
	</div>
  
    
   <div id="sezione2" class="riga_pagamento_principale">
  <div class="colonna_pagamento_principale">
    <div class="pagamento_principale">
      <form action="checkout.jsp">
      
        <div  class="riga_pagamento_principale">
          <div class="colonna_pagamento_secondaria">
            <h3>Dati Personali</h3>
            <label for="fname"><i class="fa fa-user"></i> Nominativo *</label>
            <input type="text" id="fname" name="firstname" placeholder="nome e cognome" required>
            <label for="email"><i class="fa fa-envelope"></i> Email</label>
            <input type="text" id="email" name="email" placeholder= "antonio@example.com">
            <label for="adr"><i class="fa fa-address-card-o"></i> Indirizzo *</label>
            <input type="text" id="adr" name="address" placeholder="via e numero civico" required>
            <label for="city"><i class="fa fa-institution"></i> Citt� *</label>
            <input type="text" id="city" name="city" placeholder="citt�">

            <div class="riga_pagamento_principale">
              <div class="colonna_pagamento_secondaria">
                <label for="state">Stato *</label>
                <input type="text" id="state" name="state" placeholder="stato" required>
              </div>
              <div class="colonna_pagamento_secondaria">
                <label for="zip">Codice Postale *</label>
                <input type="text" id="zip" name="zip" placeholder="88025" required>
              </div>
            </div>
          </div>

          <div class="colonna_pagamento_secondaria">
            <h3>Pagamento</h3>
            <label for="fname">Carte accettate</label>
            <div class="contenitore_carta">
              <i class="fa fa-cc-visa" style="color:navy;"></i>
              <i class="fa fa-cc-amex" style="color:blue;"></i>
              <i class="fa fa-cc-mastercard" style="color:red;"></i>
              <i class="fa fa-cc-discover" style="color:orange;"></i>
            </div>
            <label for="cname">Nome proprietario *</label>
            <input type="text" id="cname" name="cardname" placeholder="nome e cognome" required>
            <label for="ccnum">Numero carta di credito *</label>
            <input type="text" id="ccnum" name="cardnumber" placeholder="1111-2222-3333-4444" required>
            <label for="expmonth">Mese *</label>
            <input type="text" id="expmonth" name="expmonth" placeholder="mese" required>
            <div class="riga_pagamento_principale">
              <div class="colonna_pagamento_secondaria">
                <label for="expyear">Anno *</label>
                <input type="text" id="expyear" name="expyear" placeholder="anno" required>
              </div>
              <div class="colonna_pagamento_secondaria">
                <label for="cvv">CVV *</label>
                <input type="text" id="cvv" name="cvv" placeholder="cvv" required>
              </div>
            </div>
          </div>
          
        </div>
        <label>
          <input type="checkbox" checked="checked" name="sameadr"> Memorizza indirizzo come predefinito
        </label>
        <input type="submit" value="Invia Ordine" class="pulsante_checkout">
      </form>
    </div>
  </div>
  <div class="colonna_pagamento_terzaria">
    <div class="pagamento_principale">
      <h4><a href="cart.jsp">Carrello</a> <span class="prezzo_carrello" style="color:black"><i class="fa fa-shopping-cart"></i> <b>4</b></span></h4>
      <p><a href="#">Prodotto uno</a> <span class="prezzo_carrello">15 euro</span></p>
      <p><a href="#">Prodotto due</a> <span class="prezzo_carrello">5 euro</span></p>
      <p><a href="#">Prodotto tre</a> <span class="prezzo_carrello">8 euro</span></p>
      <p><a href="#">Prodotto quattro</a> <span class="prezzo_carrello">2 euro</span></p>
      <hr>
      <p>Totale <span class="prezzo_carrello" style="color:black"><b>30 euro</b></span></p>
    </div>
  </div>

</div>
    
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

		
  <script src="js/jquery.min.js"></script>
  <script src="js/jquery-migrate-3.0.1.min.js"></script>
  <script src="js/popper.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/jquery.easing.1.3.js"></script>
  <script src="js/jquery.waypoints.min.js"></script>
  <script src="js/jquery.stellar.min.js"></script>
  <script src="js/owl.carousel.min.js"></script>
  <script src="js/jquery.magnific-popup.min.js"></script>
  <script src="js/aos.js"></script>
  <script src="js/jquery.animateNumber.min.js"></script>
  <script src="js/bootstrap-datepicker.js"></script>
  <script src="js/scrollax.min.js"></script>
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
  <script src="js/google-map.js"></script>
  <script src="js/main.js"></script>

  
    
  </body>
</html>