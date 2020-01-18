<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Booking</title>
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
<link rel="stylesheet" type="text/css" href="styles/booking.css">
<link rel="stylesheet" type="text/css" href="styles/booking_responsive.css">
<link rel="stylesheet" type="text/css" href="styles/Carrello.css">

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
						 <% if(request.getSession().getAttribute("logged") == null || !(boolean)request.getSession().getAttribute("logged")){%>
						<li><a href="Loginform.jsp">Login</a></li>
						 <%}
						  else if (request.getSession().getAttribute("logged") != null && (boolean)request.getSession().getAttribute("logged")){%>
						  <li><a href="logout">Logout</a></li>
						  <%}%>
						<li><a href="index.jsp">Home</a></li>
						<li><a href="about.jsp">About us</a></li>
						<li><a href="booking.jsp">Rooms</a></li>
						<li><a href="blog.jsp">Blog</a></li>
						<li><a href="contact.jsp">Contact</a></li>
					</ul>
				</nav>
			 <% if (request.getSession().getAttribute("logged") != null && (boolean)request.getSession().getAttribute("logged")){%>
				<div class="book_button"><a href="carrello.jsp">Carrello</a></div>
				 <%}%>
				<div class="header_phone d-flex flex-row align-items-center justify-content-center">
					<img src="images/phone.png" alt="">
					<span>3339290840</span>
				</div>

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
					 <% if(request.getSession().getAttribute("logged") == null || !(boolean)request.getSession().getAttribute("logged")){%>
						<li><a href="Loginform.jsp">Login</a></li>
						 <%}
						  else if (request.getSession().getAttribute("logged") != null && (boolean)request.getSession().getAttribute("logged")){%>
						  <li><a href="logout">Logout</a></li>
						  <%}%>
					<li><a href="index.jsp">Home</a></li>
					<li><a href="about.jsp">About us</a></li>
					<li><a href="booking.jsp">Rooms</a></li>
					<li><a href="blog.jsp">Blog</a></li>
					<li><a href="contact.jsp">Contact</a></li>
				</ul>
			</nav>
		</div>
		<div class="menu_extra">
		 <% if (request.getSession().getAttribute("logged") != null && (boolean)request.getSession().getAttribute("logged")){%>
				<div class="menu_book text-right"><a href="carrello.jsp">Carrello</a></div>
				 <%}%>
			<div class="menu_book text-right"><a href="#">Carrello</a></div>
			<div class="menu_phone d-flex flex-row align-items-center justify-content-center">
				<img src="images/phone-2.png" alt="">
				<span>3339290840</span>
			</div>
		</div>
	</div>

	<!-- Home -->

	<div class="home">
		<div class="background_image" style="background-image:url(images/booking.jpg)"></div>
		<div class="home_container">
			<div class="container">
				<div class="row">
					<div class="col">
						<div class="home_content text-center">
							<div class="home_title">Book a room</div>
							<div class="booking_form_container">
								<form action="#" class="booking_form" id="booking_form">
									<div class="d-flex flex-xl-row flex-column align-items-start justify-content-start">
										<div class="booking_input_container d-flex flex-row align-items-start justify-content-start flex-wrap">
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
	<!-- Room -->
	<div class="row">
    			<div class="col-md-12">
    				<div class="cart-list">
	    				<table class="table">
						    <thead class="thead-secondary">
						      <tr class="text-center">
						        <th>&nbsp;</th>
						        <th>&nbsp;</th>
						        <th>Tipo</th>
						        <th>Tipo</th>
						        <th>Descrizione</th>
						        <th>maxpersone</th>
						        <th>occupata</th>
						        <th>prezzo</th>
						      
						      </tr>
						    </thead>
						    <c:forEach var="room" items="${room}">
						    <tbody style="background-color: white;">
						      <tr class="text-center">
						        <td class="product-remove"><a href="#"><span class="ion-ios-close"></span></a></td>
						        
						        <td class="image-prod"><div class="img" style="background-image:url(${room.img }.jpg);"></div></td>
						        <td >
						        	<p>${room.tipo}</p>
						        </td>
						        
						        <td >
						        	<p>${room.tipo}</p>
						        </td>
						        
						        <td >
						        	<p> 
						        		<ul>
						        			${room.descrizione}
						        		</ul>
						        	</p>
						        </td>
						         <td >
						        	<p> 
						        		<ul>
						        			${room.maxpersone}
						        		</ul>
						        	</p>
						        </td>
						          <td >
						        	<p> 
						        		<ul>
						        			${room.occupata}
						        		</ul>
						        	</p>
						        </td>
						        <td class="prezzo">${room.prezzo}</td>
						      </tr><!-- END TR-->
						    </tbody>
						    </c:forEach>
						  </table>
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
								<div>Agriturismo  Sarella</div>
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
						<div class="footer_title">Newsletter</div>
						<div class="newsletter_container">
							<form action="#" class="newsletter_form" id="newsletter_form">
								<input type="email" class="newsletter_input" placeholder="Your email address" required="required">
								<button class="newsletter_button">Subscribe</button>
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
		<div class="copyright">
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
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
<script src="js/booking.js"></script>
</body>
</html>