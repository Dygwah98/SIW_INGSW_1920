<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Singolo Post</title>
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
<link rel="stylesheet" type="text/css" href="styles/blog.css">
<link rel="stylesheet" type="text/css" href="styles/blog_responsive.css">
<script src="js/menuATendina.js"></script>
<link rel="stylesheet" type="text/css" href="styles/menuATendina.css">
<link rel="stylesheet" href="styles/icomoon.css">
<link rel="stylesheet" href="styles/ionicons.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<meta name="generator" content="Amaya, see http://www.w3.org/Amaya/" />
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  
 <link rel="stylesheet" href="styles/singoloPost.css">
<link rel="stylesheet" href="styles/about_responsive.css">
  
  <script src="js/commento.js"></script>
<style type="text/css">
.contieni{
	width: 100%;
  	display: flex;
  	flex-direction: row;
  	
}

.avatar {
  vertical-align: middle;
  width: 60px;
  height: 50px;
  border-radius: 50%;
}

</style>


</head>
<body>

	
	<!-- Intestazione -->

	<header class="header">
		<div class="header_content d-flex flex-row align-items-center justify-content-start">
			<div class="logo"> <a href="#">Agriturismo Paradise</a></div>
			<div class="ml-auto d-flex flex-row align-items-center justify-content-start">
				<nav class="main_nav">
					<ul class="d-flex flex-row align-items-start justify-content-start">
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
					<%} %>
						
						<li ><a href="index.jsp">Home</a></li>
						<li class="active"><a href="viewpost">Blog</a></li>
					</ul>
			   </nav>
			   <% if (request.getSession().getAttribute("logged") != null && (boolean)request.getSession().getAttribute("logged")){%>
				 <nav class="main_nav">
					<ul class="d-flex flex-row align-items-start justify-content-start">
						<li><a  href="addcart"><span id="carrello" class="icon-shopping_cart"></span ></a></li>
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
					<%} %>
					   
					<li ><a href="index.jsp">Home</a></li>
					<li class="active"><a href="vediprodotti">Negozio</a></li>
			   </ul>
		   </nav>
		</div>
		<div class="menu_extra">
		<% if (request.getSession().getAttribute("logged") != null && (boolean)request.getSession().getAttribute("logged")){%>
				<nav class="main_nav">
					<ul class="d-flex flex-row align-items-start justify-content-start">
						<li><a href="addcart"><span id="carrello" class="icon-shopping_cart"></span ></a></li>
					</ul>
				</nav>
	    <%}%>
		</div>
	</div>

	<!-- Home -->

	<div class="home">
		<div class="slide">
					<div class="background_image" style="background-image:url(images/profilo.jpg)"></div>
					<div class="home_container">
						<div class="container">
							<div class="row">
								<div class="col">
									<div class="home_content text-center">
										<div class="home_title">POST</div>
								</div>
							</div>
						</div>
					</div>
				</div>
	</div>

	<!-- Blog -->

	
	<div   class="blog">
		<div  class="container">
			<div class="row">
				
				<!-- Blog Posts -->
				<div class="col-lg-9">
					<div  class="blog_posts">
						
						<!-- Blog Post -->
						<c:forEach var="post" items="${post}">
							<div style="margin-top:60px;" class="blog_post">
							<div class="blog_post_title"><a href="#">${post.titolo}</a></div>
							<br>
								<div class="blog_post_image">
									<a href="singolopost?identificativo=${post.idPost}" ><img src="${post.img}.jpg" alt="peperone"></a>
									<div class="blog_post_date"><a href="#">${post.data}</a></div>
								</div>
								
							<br>
							<div style=" width: 100%; float:left;">
								<h6>Descrizione:</h6>
						    	<p style=" word-wrap:break-word;" >${post.messaggio}</p> 
						    </div>
							
							<% if (request.getSession().getAttribute("logged") != null && (boolean)request.getSession().getAttribute("logged")){%>
							<div>
								<input type="hidden" name="ID" id="ID" value="${post.idPost}" />
								<div class="input_container">
									<textarea name="recensione" id="recensione"  class="contact_input contact_textarea" placeholder="Messaggio..."></textarea>
								</div>
								<select name="valuta" id="valuta" style="  padding: 10px 10px 10px 10px; text-align: center" name="servizio" id="servizio" >
				      			 	<option  >valuta</option>
				      			 	<option value="Ottimo luogo!!">Ottimo luogo</option>
								    <option value="Servizio impeccabile!!">Servizio impeccabile</option>
								    <option value="Location incantevole!!">Location incantevole</option>
								    <option value="Ristorazione top!!">Ristorazione top</option>
  				 				</select> 
								<button class="button" type="submit" onclick="addcomm(event)">Recensisci</button> 
							</div>
							<%}%>
							
						</div>
						</c:forEach>

					</div>
				</div>
				
				<div class="col-lg-3">
					<div class="sidebar" style="margin-top: 240px;">
						
						<a class="button3" href="#review" >REVIEW</a>
					</div>
				</div>
				
			  

				<!-- Sidebar -->
				

			</div>
		</div>
	</div>
	
	<div class="testimonials" id="review">
		<div class="parallax_background parallax-window" data-parallax="scroll" data-image-src="images/testimonials.jpg" data-speed="0.8"></div>
		<div class="testimonials_overlay"></div>
		<div class="container">
			<div class="row">
				<div class="col">
					<div class="testimonials_slider_container">

						<!-- Testimonials Slider -->
						<div class="owl-carousel owl-theme test_slider">
							
							<!-- Slide -->
							<c:forEach var="commento" items="${commento}">
								<div  class="test_slider_item text-center">
									<div class="rating rating_5 d-flex flex-row align-items-start justify-content-center"><i></i><i></i><i></i><i></i><i></i></div>
									<div class="testimonial_title"><a href="#">${commento.valutazione}</a></div>
									<div class="testimonial_text">
										<p>${commento.testo}</p>
									</div>
									<div class="testimonial_image"><img src="${commento.img_utente}" alt=""></div>
									<div class="testimonial_author">${commento.username_cliente}</div>
								</div>
							</c:forEach>

						</div>
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
								<div>Agriturismo Paradise</div>
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
						<form class="decor"  method="post" action="${pageContext.request.contextPath}/addemail" >
							<input type="email" class="newsletter_input" name="email"placeholder="e-mail..." required="required">
							<button class="button" type="submit">Iscriviti</button>
						</form>
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
<script src="js/blog.js"></script>
<script src="js/about.js"></script>
</body>
</html>