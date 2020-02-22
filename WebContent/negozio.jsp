<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Negozio</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Sarella agriturismo">
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="styles/bootstrap-4.1.2/bootstrap.min.css">

<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.3.4/owl.carousel.css">
<link rel="stylesheet" type="text/css" href="styles/Negozio.css">
<link rel="stylesheet" type="text/css" href="styles/responsive.css">
<link rel="stylesheet" type="text/css" href="styles/menuATendina.css">

<link rel="stylesheet" href="styles/icomoon.css">
<link rel="stylesheet" href="styles/ionicons.min.css">

<script src="js/jquery-3.3.1.min.js"></script>
<script src="plugins/OwlCarousel2-2.3.4/owl.carousel.js"></script>
<script src="js/custom.js"></script>
<script src="js/menuATendina.js"></script>



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
						<li class="active"><a href="vediprodotti">Negozio</a></li>
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
		<div class="home_slider_container">
			<div class="owl-carousel home_slider">
				
				<!-- Prima Slide -->
				<div class="slide">
					<div class="background_image" style="background-image:url(images/shop/slide_ortaggi_1_.jpg)"></div>
					<div class="home_container">
						<div class="container">
							<div class="row">
								<div class="col">
									<div class="home_content text-center">
										<div class="home_title">VERDURE</div>
										<p class="descrizione">Le nostre verdure sono frutto di una coltivazione mirata e accurata....
											<br>Offriamo i migliori prodotti vegetariani sul mercato.
										</p>
										<a href="#piu" class="bottone trans_200">DETTAGLI</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

				<!-- Seconda Slide -->
				<div class="slide">
					<div class="background_image" style="background-image:url(images/shop/slide_ortaggi_2_.jpg)"></div>
					<div class="home_container">
						<div class="container">
							<div class="row">
								<div class="col">
									<div class="home_content text-center">
										<div class="home_title">ORTAGGI</div>
										<p class="descrizione">I nostri ortaggi sono frutto di una coltivazione mirata e accurata....
											<br>Offriamo i migliori prodotti vegetariani sul mercato.
										</p>
										<a href="#piu" class="bottone trans_200">DETTAGLI</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

				<!-- Terza Slide -->
				<div class="slide">
					<div class="background_image" style="background-image:url(images/shop/slide_carne_3_.jpg)"></div>
					<div class="home_container">
						<div class="container">
							<div class="row">
								<div class="col">
									<div class="home_content text-center">
										<div class="home_title">CARNI</div>
										<p class="descrizione">I nostri animali pascolano liberamente!!
											<br>Offriamo i migliori prodotti di carne sul mercato.
										</p>
										<a href="#piu" class="bottone_carne trans_200">DETTAGLI</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				
				<!-- Quarta Slide -->
				<div class="slide">
					<div class="background_image" style="background-image:url(images/shop/slide_formaggi_4_.jpg)"></div>
					<div class="home_container">
						<div class="container">
							<div class="row">
								<div class="col">
									<div class="home_content text-center">
										<div class="home_title">FORMAGGI</div>
										<p class="descrizione">Formaggi a lunga stagionatura...
											<br>Formaggi e latticini sempre freschi!!
										</p>
										<a href="#piu" class="bottone_carne trans_200">DETTAGLI</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>
			
			
			<!-- slider -->
			<div class="home_slider_dots_container">
				<div class="home_slider_dots">
					<ul id="home_slider_custom_dots" class="home_slider_custom_dots d-flex flex-row align-items-start justify-content-start">
						<li class="home_slider_custom_dot active">01.</li>
						<li class="home_slider_custom_dot">02.</li>
						<li class="home_slider_custom_dot">03.</li>
						<li class="home_slider_custom_dot">04.</li>
					</ul>
				</div>
			</div>
			
		</div>
	</div>

	<!-- body -->
	
	
	
	<section id="piu" class="ftco-section">
    	<div class="container">
				<div class="row justify-content-center mb-3 pb-3">
          <div class="col-md-12 heading-section text-center ">
          	<span class="subheading">Biologici a km0</span>
            <h2 class="mb-4">Breve storia sui nostri prodotti..</h2>
            <p>Il Biologico: una vera e propria passione per gli italiani che ha portato la nostra nazione al sesto posto nel mondo in termini di fatturato. Un fatturato da record, un mercato che è cresciuto anche in anni in cui si registravano solo continue contrazioni dei consumi. Le ragioni di questo amore sono molte ma, venite a scoprirlo nel nostro AGRITURISMO e vi renderete conto voi stessi dei vantaggi che questo tipo di agricoltura garantisce (che sono molti e innegabili).</p>
          </div>
        </div>   		
    	</div>
    	<form id = "cerca" class="example"  action="#" style="margin:auto;max-width:300px">
  		<input id="testo" type="text" placeholder="cerca..." name="search2">
  		<a id="lente" href = "javascript:;" onclick = "this.href='vedifiltri?filtro=' + document.getElementById('testo').value"><i class="fa fa-search"></i></a>
		</form>
    </section>
   
 
	<div id="cate" class="categories">
	  	<div ><h4>Categorie:</h4></div>
	  	<div class="sidebar_list">
			  <a style="color: #ffa37b;" href="vedifiltri?filtro=all">Tutti i prodotti</a>
			  <a href="vedifiltri?filtro=verdura" >Verdura</a>
			  <a href="vedifiltri?filtro=ortaggio">Ortaggio</a>
			  <a href="vedifiltri?filtro=carne">Carni</a>
			  <a href="vedifiltri?filtro=formaggi">Formaggi</a>
			  <a href="vedifiltri?filtro=frutta">Frutta</a>
			  <a href="vedifiltri?filtro=altro">Altro</a>
			  <div  class="elementi2">
				  <a  onclick="myFunction2()" class="dropbtn2">Ordina</a>
					  <div id="myDropdown2" class="dropdown-content2">
						    <a href="vedifiltri?filtro=prezzo">Prezzo</a>
						    <a href="vedifiltri?filtro=alfabetico">Alfabetico</a>
					  </div>
			 </div>
	     </div>
	</div>
	
	 <div class="divCatalogo">
		<c:forEach var="prodotto" items="${prodotto}">
			<div class="divProdotto ${prodotto.descrizione}">
  				<div class="prodotto"> 
  					<a href="singolo?tipo=${prodotto.tipo}&category=${prodotto.descrizione}" class="proiezione"><img src="${prodotto.img}.jpg" alt="peperone">
  						
  					</a>
  					<div class="text py-3 pb-4 px-3 text-center"> 
  						<h3><a id="tipo" href="#" onclick="aggiungiAlCarrello()">${prodotto.tipo}</a></h3>
  						<div class="d-flex">
    						<p class="prezzo">${prodotto.prezzo} euro</p>
   						</div>
   						
	   					<div class="bottoni d-flex px-3">
	   						<div class="m-auto d-flex">
	   							<a href="singolo?tipo=${prodotto.tipo}&category=${prodotto.descrizione}" class="add-to-cart d-flex justify-content-center align-items-center text-center">
	   								<span><i class="ion-ios-menu"></i></span>
	   							</a>
	   							<%if (request.getSession().getAttribute("logged") != null && (boolean)request.getSession().getAttribute("logged")){%>
	   							<a href="addpcart?tip=${prodotto.tipo}" class="buy-now d-flex justify-content-center align-items-center mx-1">
	   								<span><i class="ion-ios-cart"></i></span>
	   							</a>} <%}%>
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
	</div>
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
								<li>Frazione Moulin, 1</li>
								<li>11010, Roisan</li>
								<li>IT</li>
							</ul>
						</div>
					</div>

					<!-- Reservations -->
					<div class="col-lg-3">
						<div class="footer_title">Contatti</div>
						<div class="footer_list">
							<ul>
								<li>Tel: 0968 789653</li>
								<li>Fax; 6783 4567 889</li>
								<li>agriturismoSIW2020@gmail.com</li>
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
	
<script src="js/Negozio.js"></script>
</body>
</html>