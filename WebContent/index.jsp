<!DOCTYPE html>
<html lang="en">
<head>
<title>Agriturismo Sarella</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="The River template project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="styles/bootstrap-4.1.2/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.3.4/owl.carousel.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.3.4/owl.theme.default.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.3.4/animate.css">
<link href="plugins/jquery-datepicker/jquery-ui.css" rel="stylesheet" type="text/css">
<link href="plugins/colorbox/colorbox.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="styles/main_styles.css">
<link rel="stylesheet" type="text/css" href="styles/responsive.css">

<link rel="stylesheet" href="styles/icomoon.css">
<link rel="stylesheet" href="styles/ionicons.min.css">
<link rel="stylesheet" type="text/css" href="styles/menuATendina.css">

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="js/menuATendina.js"></script>
</head>
<body>
	
	<div class="super_container">
	
	<!-- Header -->
	<header class="header">
		<div class="header_content d-flex flex-row align-items-center justify-content-start">
			<div class="logo"><a href="#">Agriturismo Sarella</a></div>
			<div class="ml-auto d-flex flex-row align-items-center justify-content-start">
				<nav class="main_nav">
					<ul class="d-flex flex-row align-items-start justify-content-start">
					<% if((request.getSession().getAttribute("logged") == null || !(boolean)request.getSession().getAttribute("logged")) && (request.getSession().getAttribute("admin") == null || !(boolean)request.getSession().getAttribute("admin")) ){%>
						<li><a href="Loginform.jsp">Login</a></li>
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
								    <a href="gestioneCamere.jsp">GestioneCamere</a>
								    <a href="gestionePost.jsp">GestionePost</a>
								    <a href="logout">Logout</a>
							  </div>
						</div>
					<%} %>
						<li class="active"><a href="home">Home</a></li>
						<li><a href="vediprodotti">Negozio</a></li>
						<li><a href="viewroom">Rooms</a></li>
						<li><a href="viewpost">Blog</a></li>
						<li><a href="contact.jsp">Contattaci</a></li>
					</ul>
				</nav>
				<% if (request.getSession().getAttribute("logged") != null && (boolean)request.getSession().getAttribute("logged")){%>
				<!--  <div class="book_button"><a href="carrello.jsp">Carrello</a></div> -->
				<nav class="main_nav">
					<ul class="d-flex flex-row align-items-start justify-content-start">
						<li><a  href="addcart"><span id="carrello" class="icon-shopping_cart">[0]</span ></a></li>
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
					<li><a href="Loginform.jsp">Login</a></li>
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
								<a href="gestioneCamere.jsp">GestioneCamere</a>
								<a href="gestionePost.jsp">GestionePost</a>
								<a href="logout">Logout</a>
							</div>
					</div>
					<%}%>
					<li class="active"><a href="index.jsp">Home</a></li>
					<li ><a href="vediprodotti">Negozio</a></li>
					<li><a href="viewroom">Rooms</a></li>
					<li><a href="viewpost">Blog</a></li>
					<li><a href="contact.jsp">Contattaci</a></li>
				</ul>
			</nav>
		</div>
		<div class="menu_extra">
		<% if (request.getSession().getAttribute("logged") != null && (boolean)request.getSession().getAttribute("logged")) { %>
			<!--  <div class="book_button"><a href="carrello.jsp">Carrello</a></div> -->
				<nav class="main_nav">
					<ul class="d-flex flex-row align-items-start justify-content-start">
						<li><a  href="addcart"><span id="carrello" class="icon-shopping_cart">[0]</span ></a></li>
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
		<div class="home_slider_container">
			<div class="owl-carousel owl-theme home_slider">
				
				<!-- Slide -->
				<div class="slide">
					<div class="background_image" style="background-image:url(images/index_1.jpg)"></div>
					<div class="home_container">
						<div class="container">
							<div class="row">
								<div class="col">
									<div class="home_content text-center">
										<div class="home_title">Agriturismo Sarella</div>
										<div class="booking_form_container">
									
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

				<!-- Slide -->
				<div class="slide">
					<div class="background_image" style="background-image:url(images/index_1.jpg)"></div>
					<div class="home_container">
						<div class="container">
							<div class="row">
								<div class="col">
									<div class="home_content text-center">
										<div class="home_title">Agriturismo Sarella</div>
										<div class="booking_form_container">
											<form action="#" class="booking_form">
												<div class="d-flex flex-xl-row flex-column align-items-start justify-content-start">
													<div class="booking_input_container d-flex flex-lg-row flex-column align-items-start justify-content-start">
														<div><input type="text" class="datepicker booking_input booking_input_a booking_in" placeholder="Check in" required="required"></div>
														<div><input type="text" class="datepicker booking_input booking_input_a booking_out" placeholder="Check out" required="required"></div>
														<div><input type="number" class="booking_input booking_input_b" placeholder="Children" required="required"></div>
														<div><input type="number" class="booking_input booking_input_b" placeholder="Room" required="required"></div>
													</div>
													<div><button class="booking_button trans_200">Book Now</button></div>
												</div>
											</form>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

				<!-- Slide -->
				<div class="slide">
					<div class="background_image" style="background-image:url(images/index_1.jpg)"></div>
					<div class="home_container">
						<div class="container">
							<div class="row">
								<div class="col">
									<div class="home_content text-center">
										<div class="home_title">Agriturismo Sarella</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>
			
			<!-- Home Slider Dots -->
			<div class="home_slider_dots_container">
				<div class="home_slider_dots">
					<ul id="home_slider_custom_dots" class="home_slider_custom_dots d-flex flex-row align-items-start justify-content-start">
					</ul>
				</div>
			</div>
			
		</div>
	</div>

	<!-- Features -->

	<div class="features">
		<div class="container">
			<div class="row">
				
				<!-- Icon Box -->
				<div class="col-lg-4 icon_box_col">
					<div class="icon_box d-flex flex-column align-items-center justify-content-start text-center">
						<div class="icon_box_icon"><img src="images/icon_1.svg" class="svg" alt="https://www.flaticon.com/authors/monkik"></div>
						<div class="icon_box_title"><h2>Favoloso Agriturismo</h2></div>
						<div class="icon_box_text">
						</div>
					</div>
				</div>

				<!-- Icon Box -->
				<div class="col-lg-4 icon_box_col">
					<div class="icon_box d-flex flex-column align-items-center justify-content-start text-center">
						<div class="icon_box_icon"><img src="images/icon_2.svg" class="svg" alt="https://www.flaticon.com/authors/monkik"></div>
						<div class="icon_box_title"><h2>Grande piscina</h2></div>
						<div class="icon_box_text">
						</div>
					</div>
				</div>

				<!-- Icon Box -->
				<div class="col-lg-4 icon_box_col">
					<div class="icon_box d-flex flex-column align-items-center justify-content-start text-center">
						<div class="icon_box_icon"><img src="images/icon_3.svg" class="svg" alt="https://www.flaticon.com/authors/monkik"></div>
						<div class="icon_box_title"><h2>Stanze lussuose</h2></div>
						<div class="icon_box_text">
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>

	<!-- Gallery -->

	<div class="gallery">
		<div class="gallery_slider_container">
			<div class="owl-carousel owl-theme gallery_slider">
				
				<!-- Slide -->
				<div class="gallery_item">
					<div class="background_image" style="background-image:url(images/gallery_1.jpg)"></div>
					<a class="colorbox" href="images/gallery_1.jpg"></a>
				</div>

				<!-- Slide -->
				<div class="gallery_item">
					<div class="background_image" style="background-image:url(images/gallery_2.jpg)"></div>
					<a class="colorbox" href="images/gallery_2.jpg"></a>
				</div>

				<!-- Slide -->
				<div class="gallery_item">
					<div class="background_image" style="background-image:url(images/gallery_3.jpg)"></div>
					<a class="colorbox" href="images/gallery_3.jpg"></a>
				</div>

				<!-- Slide -->
				<div class="gallery_item">
					<div class="background_image" style="background-image:url(images/gallery_4.jpg)"></div>
					<a class="colorbox" href="images/gallery_4.jpg"></a>
				</div>

			</div>
		</div>
	</div>

	<!-- About -->

	<div class="about">
		<div class="container">
			<div class="row">
				
				<!-- About Content -->
				<div class="col-lg-6">
					<div class="about_content">
						<div class="about_title"><h2>Sarella / 50 anni di eccellenza</h2></div>
						<div class="about_text">
						</div>
					</div>
				</div>

				<!-- About Images -->
				<div class="col-lg-6">
					<div class="about_images d-flex flex-row align-items-center justify-content-between flex-wrap">
						<img src="images/about_1.png" alt="">
						<img src="images/about_2.png" alt="">
						<img src="images/about_3.png" alt="">
					</div>
				</div>
			</div>
		</div>
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
</div>

<script src="js/jquery-3.3.1.min.js"></script>
<script src="styles/bootstrap-4.1.2/popper.js"></script>
<script src="styles/bootstrap-4.1.2/bootstrap.min.js"></script>
<script src="plugins/greensock/TweenMax.min.js"></script>
<script src="plugins/greensock/TimelineMax.min.js"></script>
<script src="plugins/scrollmagic/ScrollMagic.min.js"></script>
<script src="plugins/greensock/animation.gsap.min.js"></script>
<script src="plugins/greensock/ScrollToPlugin.min.js"></script>
<script src="plugins/OwlCarousel2-2.3.4/owl.carousel.js"></script>
<script src="plugins/easing/easing.js"></script>
<script src="plugins/progressbar/progressbar.min.js"></script>
<script src="plugins/parallax-js-master/parallax.min.js"></script>
<script src="plugins/jquery-datepicker/jquery-ui.js"></script>
<script src="plugins/colorbox/jquery.colorbox-min.js"></script>
<script src="js/custom.js"></script>
</body>
</html>