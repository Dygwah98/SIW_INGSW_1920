<!DOCTYPE html>
<html lang="en">
<head>
<title>Contact</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="The River template project">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" type="text/css" href="styles/bootstrap-4.1.2/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="styles/contact.css">
<link rel="stylesheet" type="text/css" href="styles/contact_responsive.css">

<link rel="stylesheet" type="text/css" href="styles/menuATendina.css">
<script src="js/menuATendina.js"></script>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="styles/mappa.css">
<style>
	.logo a:hover{color:white;}
</style>

</head>
<body>

<div class="super_container">
	
	<!-- Header -->

	<header class="header">
		<div class="header_content d-flex flex-row align-items-center justify-content-start">
			<div class="logo"><a style="text-decoration: none;"href="#">Agriturismo Sarella</a></div>
			<div class="ml-auto d-flex flex-row align-items-center justify-content-start">
				<nav class="main_nav">
					<ul class="d-flex flex-row align-items-start justify-content-start">
					<% if((request.getSession().getAttribute("logged") == null || !(boolean)request.getSession().getAttribute("logged")) && (request.getSession().getAttribute("admin") == null || !(boolean)request.getSession().getAttribute("admin")) ){%>
						<li><a href="login-registration.jsp">Login</a></li>
					<%} else if (request.getSession().getAttribute("logged") != null && (boolean)request.getSession().getAttribute("logged")){%>
						 <div class="dropdown">
							  <li><a onclick="myFunction()" class="dropbtn">${username}</a></li>
							  <div id="myDropdown" class="dropdown-content">
								    <a href="#">Storico Ordini</a>
								    <a href="logout">Logout</a>
							  </div>
						</div>
					<%} else if (request.getSession().getAttribute("admin") != null && (boolean)request.getSession().getAttribute("admin")){%>
						  <div class="dropdown">
							  <li><a onclick="myFunction()" class="dropbtn">Admin</a></li>
							  <div id="myDropdown" class="dropdown-content">
								    <a href="gestioneProdotti.jsp">GestioneNegozio</a>
								    <a href="gestionePost.jsp">GestionePost</a>
								    <a href="logout">Logout</a>
							  </div>
						</div>
					<%} %>
						<li><a href="home">Home</a></li>
						<li><a href="vediprodotti">Negozio</a></li>
						<li><a href="viewpost">Blog</a></li>
						<li class="active"><a href="contact.jsp">Contattaci</a></li>
					</ul>
				</nav>
				<% if (request.getSession().getAttribute("logged") != null && (boolean)request.getSession().getAttribute("logged")){%>
				<!--  <div class="book_button"><a href="carrello.jsp">Carrello</a></div> -->
				<nav class="main_nav">
					<ul class="d-flex flex-row align-items-start justify-content-start">
						<li><a  href="addcart"><span id="carrello" class="icon-shopping_cart"></span ></a></li>
					</ul>
				</nav>
				<%}%>
				<!--  
				<div class="header_phone d-flex flex-row align-items-center justify-content-center">
					<img src="images/phone.png" alt="">
					<span>3339290840</span>
				</div>
				-->
				<!-- Hamburger Menu -->
				<div class="hamburger"><i class="fa fa-bars" aria-hidden="true"></i></div>
			</div>
		</div>
	</header>

	<!-- Menu -->

	<div class="menu trans_400 d-flex flex-column align-items-end justify-content-start">
		<div class="menu_close"><i class="fa fa-times" aria-hidden="true"></i></div>
		<div class="menu_content">
			<nav class="menu_nav text-right">
				<ul>
				<% if((request.getSession().getAttribute("logged") == null || !(boolean)request.getSession().getAttribute("logged"))&& (request.getSession().getAttribute("admin") == null || !(boolean)request.getSession().getAttribute("admin"))){%>
					<li><a href="login-registration.jsp">Login</a></li>
				<%} else if (request.getSession().getAttribute("logged") != null && (boolean)request.getSession().getAttribute("logged")){%>
					<div class="dropdown">
						<li><a onclick="myFunction()" class="dropbtn">${username}</a></li>
							<div id="myDropdown" class="dropdown-content">
								<a href="#">Storico Ordini</a>
								<a href="logout">Logout</a>
							</div>
					</div>
				<%} else if (request.getSession().getAttribute("admin") != null && (boolean)request.getSession().getAttribute("admin")){%>
					<div class="dropdown">
						<li><a onclick="myFunction()" class="dropbtn">Admin</a></li>
							<div id="myDropdown" class="dropdown-content">
								<a href="gestioneProdotti.jsp">GestioneNegozio</a>
								<a href="gestionePost.jsp">GestionePost</a>
								<a href="logout">Logout</a>
							</div>
					</div>
					<%}%>
					<li ><a href="index.jsp">Home</a></li>
					<li ><a href="vediprodotti">Negozio</a></li>
					<li><a href="viewpost">Blog</a></li>
					<li class="active"><a href="contact.jsp">Contattaci</a></li>
				</ul>
			</nav>
		</div>
		<div class="menu_extra">
		<% if (request.getSession().getAttribute("logged") != null && (boolean)request.getSession().getAttribute("logged")) { %>
			<!--  <div class="book_button"><a href="carrello.jsp">Carrello</a></div> -->
				<nav class="main_nav">
					<ul class="d-flex flex-row align-items-start justify-content-start">
						<li><a  href="addcart"><span id="carrello" class="icon-shopping_cart"></span ></a></li>
					</ul>
				</nav>
				<%}%>
				<!--  
				<div class="header_phone d-flex flex-row align-items-center justify-content-center">
					<img src="images/phone.png" alt="">
					<span>3339290840</span>
				</div>
				-->
		</div>
	</div>
	<!-- Home -->

	<div class="home">
		<div class="background_image" style="background-image:url(images/contact.jpg)"></div>
		<div class="home_container">
			<div class="container">
				<div class="row">
					<div class="col">
						<div class="home_content text-center">
							<div class="home_title">Contattaci</div>
							<div class="booking_form_container">
								
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<br>
	
	<div class="container-fluid">
    <div class="row">
      <div class="col">
      </div>
    </div>
    <div class="row mb-2">
      <div class="col">
        <input class="form-control" id="search" type="text" placeholder="Cerca..." />
      </div>
    </div>
    <div class="row">
      <div class="col">
        <div id="map"></div>
      </div>
    </div>
  </div>
 
  <!-- Bootstrap scripts. -->
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  
  <!-- Google Maps scripts. -->
  <script src="js/mappa.js"></script>
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDrN4ZY_5WQrsmJBSWBTyPkcVQAfUN_QM4&callback=createMap&libraries=places" async defer></script>
	

	<!-- Contact -->

	<div  class="contact">
		<div  class="container">
			<div class="row">
				
				<!-- Contact Content -->
						<div class="contact_list">
							<ul>
								<li>Indirizzo: Viale John Fitzgerlad Kennedy, Cancello CZ</li>
								<li>Telefono:  0968 789653</li>
								<li>E-mail:    sarellaHotel@gmail.com</li>
							</ul>
						</div>
						<div style="float:right; margin-left: 200px;" class="contact_form_container">
							<form action="#" class="contact_form" id="contact_form">
								<div class="row">
									<div class="col-md-6 input_container">
										<input type="text" class="contact_input" placeholder="Nome" required="required">
									</div>
									<div class="col-md-6 input_container">
										<input type="email" class="contact_input" placeholder="e-mail" required="required">
									</div>
								</div>
								<div class="input_container"><input type="text" class="contact_input" placeholder="Oggetto"></div>
								<div class="input_container"><textarea class="contact_input contact_textarea" placeholder="Messaggio" required="required"></textarea></div>
								<button class="button">Invia</button>
							</form>
						</div>
			</div>
		</div>
	</div>

	<!-- Footer -->

	<footer class="footer">
		<div class="footer_content">
			<div class="container">
				<div class="row">
					<div class="col">
						<div class="footer_logo_container text-center">
							<div class="footer_logo">
								<a href="#"></a>
								<div>Agriturismo Sarella</div>
								<div>since 1945</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row footer_row">
					
					<!-- Address -->
					<div class="col-lg-3">
						<div class="footer_title">Our Address</div>
						<div class="footer_list">
							<ul>
								<li>Beach Str. 345</li>
								<li>67559 Miami</li>
								<li>USA</li>
							</ul>
						</div>
					</div>

					<!-- Reservations -->
					<div class="col-lg-3">
						<div class="footer_title">Reservations</div>
						<div class="footer_list">
							<ul>
								<li>Tel: 345 5667 889</li>
								<li>Fax; 6783 4567 889</li>
								<li>reservations@hotelriver.com</li>
							</ul>
						</div>
					</div>

					<!-- Newsletter -->
					<div class="col-lg-3">
						
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
		<div class="copyright">
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
</div>
	</footer>
</div>

<script src="js/jquery-3.3.1.min.js"></script>
<script src="plugins/OwlCarousel2-2.3.4/owl.carousel.js"></script>
<script src="js/contact.js"></script>
</body>
</html>