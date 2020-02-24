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
<link rel="stylesheet" type="text/css" href="styles/altro.css">

<link rel="icon" href="images/favicon.ico">

<link rel="stylesheet" href="styles/icomoon.css">
<link rel="stylesheet" href="styles/ionicons.min.css">

<script src="js/jquery-3.3.1.min.js"></script>
<script src="plugins/OwlCarousel2-2.3.4/owl.carousel.js"></script>
<script src="js/custom.js"></script>
<script src="js/menuATendina.js"></script>

<script src="js/checkout.js"></script>
<style>
	#check{
		cursor:pointer; color:white; background-color: transparent; border: none;
	}
	#check:hover {
		color: #ff7514;
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
						<li class="active"><a href="addcart">Negozio</a></li>
					</ul>
			   </nav>
			   <% if (request.getSession().getAttribute("logged") != null && (boolean)request.getSession().getAttribute("logged")){%>
				 <nav class="main_nav">
					<button id="check"  type="submit" id="btnchk" onclick="ckout(event)">CHECKOUT <span class="icon-shopping_cart">[<c:out  value="${elementi}" />]</span></button>
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
					<li class="active"><a href="addcart">Negozio</a></li>
			   </ul>
		   </nav>
		</div>
		<div class="menu_extra">
		<% if (request.getSession().getAttribute("logged") != null && (boolean)request.getSession().getAttribute("logged")){%>
				 <nav class="main_nav">
					<button id="check"  type="submit" id="btnchk" onclick="ckout(event)">CHECKOUT <span class="icon-shopping_cart">[<c:out  value="${elementi}" />]</span></button>
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
										<a href="#cate" class="bottone trans_200">DETTAGLI</a>
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
										<a href="#cate" class="bottone trans_200">DETTAGLI</a>
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
										<a href="#cate" class="bottone_carne trans_200">DETTAGLI</a>
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
										<a href="#cate" class="bottone_carne trans_200">DETTAGLI</a>
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
	
	 <section style="background-color: white; "class="about-us-area">
    <div class="container">
      <div class="row align-items-center">

        <!-- About Us Content -->
        <div class="col-12 col-lg-6">
          <div class="about-us-content mb-100">
            <!-- Section Heading -->
            <div class="section-heading">
              <p>produzione</p>
              <h2><span>Il futuro</span> dell agricoltura </h2>
              <img src="images/decor.png" alt="">
            </div>
            <p style="font-weight: bold;">Come cambiera l'agricoltura nei prossimi anni e quali sono le tecnologie che possono aiutare gli agricoltori a fare meglio il proprio lavoro, garantendo produzioni sostenibili sia dal punto di vista economico che ambientale?</p>
          </div>
        </div>

        <!-- Famie Video Play -->
        <div class="col-12 col-lg-6">
          <div class="about-us-thumbnail mb-100">
            <img src="images/19.jpg" alt="">
          </div>
        </div>

      </div>
    </div>
  </section>
  <!-- ##### About Us Area End ##### -->

  <!-- ##### Services Area Start ##### -->
  <section class="services-area d-flex flex-wrap">
    <!-- Service Thumbnail -->
    <div class="services-thumbnail bg-img jarallax" style="background-image: url('images/7.jpg');"></div>

    <!-- Service Content -->
    <div class="services-content section-padding-100-50 px-5">
      <div class="container-fluid">
        <div class="row">
          <div class="col-12">
            <!-- Section Heading -->
            <div class="section-heading">
              <p>Quello che noi facciamo</p>
              <h2><span>I nostri prodotti</span> e il nostro obiettivo</h2>
              <img src="images/decor.png" alt="">
            </div>
          </div>
        </div>

        <div class="row">
          <div class="col-12 mb-50">
            <p style="font-weight: bold;">I prodotti bio sono ormai su tutte le tavole degli italiani, nonostante ancora considerati prodotti di nicchia e l informazione non sia ancora proporzionale all importanza dell argomento. Mangiare cibi biologici significa avere rispetto della natura e del nostro corpo in quanto aiutano a condurre un alimentazione sana, salvaguardando l ecosistema che ci circonda.</p>
          </div>

          <!-- Single Service Area -->
          <div class="col-12 col-lg-6">
            <div class="single-service-area mb-50 wow fadeInUp" data-wow-delay="100ms">
              <!-- Service Title -->
              <div class="service-title mb-3 d-flex align-items-center">
                <img src="images/s1.png" alt="">
                <h5>Frutta &amp; Verdura</h5>
              </div>
              <p style="font-weight: bold;">Frutta e verdura sono alla base di un’alimentazione sana ed equilibrata. </p>
            </div>
          </div>

          <!-- Single Service Area -->
          <div class="col-12 col-lg-6">
            <div class="single-service-area mb-50 wow fadeInUp" data-wow-delay="200ms">
              <!-- Service Title -->
              <div class="service-title mb-3 d-flex align-items-center">
                <img src="images/s2.png" alt="">
                <h5>Carne &amp; Derivati</h5>
              </div>
              <p style="font-weight: bold;">Contribuiscono al mantenimento proteico necessario ad affrontare la giornata</p>
            </div>
          </div>

          <!-- Single Service Area -->
          <div class="col-12 col-lg-6">
            <div class="single-service-area mb-50 wow fadeInUp" data-wow-delay="300ms">
              <!-- Service Title -->
              <div class="service-title mb-3 d-flex align-items-center">
                <img src="images/s3.png" alt="">
                <h5>Late &amp; Derivati</h5>
              </div>
              <p style="font-weight: bold;">Soddisfano il fabbisogno giornaliero di molte persone la mattina, essenziale per il corpo. </p>
            </div>
          </div>

          <!-- Single Service Area -->
          <div class="col-12 col-lg-6">
            <div class="single-service-area mb-50 wow fadeInUp" data-wow-delay="400ms">
              <!-- Service Title -->
              <div class="service-title mb-3 d-flex align-items-center">
                <img src="images/s4.png" alt="">
                <h5>Riso &amp; Frumento</h5>
              </div>
              <p style="font-weight: bold;">Fanno si che il corpo raggiunga il proprio equilibrio grazie alla crusca. </p>
            </div>
          </div>

        </div>
      </div>
    </div>
  </section>
	
	
	
	<section style="background-color: white;" id="piu" class="ftco-section1">
    	<div class="container">
				<div class="row justify-content-center mb-3 pb-3">
          <div class="col-md-12 heading-section text-center ">
          	<span class="subheading">Biologici a km0</span>
            <h2 class="mb-4">Breve storia sui nostri prodotti..</h2>
            <p style="font-weight: bold;">Il Biologico: una vera e propria passione per gli italiani che ha portato la nostra nazione al sesto posto nel mondo in termini di fatturato. Un fatturato da record, un mercato che e cresciuto anche in anni in cui si registravano solo continue contrazioni dei consumi. Le ragioni di questo amore sono molte ma, venite a scoprirlo nel nostro AGRITURISMO e vi renderete conto voi stessi dei vantaggi che questo tipo di agricoltura garantisce (che sono molti e innegabili).</p>
          </div>
        </div>   		
    	</div>
    </section>
   
 
	<div style="background-color: white;" id="cate" class="categories">
		<div style="background-color: #F5F5DC; "><p style="font-weight: bold; font-size: 20px;">NEGOZIO</p></div>
	  	<div class="sidebar_list">
			  <a style="color: #ffa37b;" href="vedifiltri?filtro=all">Tutti i prodotti</a>
			  <a href="vedifiltri?filtro=verdura" >Verdura</a>
			  <a href="vedifiltri?filtro=ortaggio">Ortaggio</a>
			  <a href="vedifiltri?filtro=carne">Carni</a>
			  <a href="vedifiltri?filtro=formaggi">Formaggi</a>
			  <a href="vedifiltri?filtro=frutta">Frutta</a>
			  <a href="vedifiltri?filtro=altro">Altro</a>
	     </div>
	</div>
	 <section style="background-color: white; class="shop-area section-padding-0-100">
    	<div class="container">
    		<div class="row">
        <!-- Shop Filters -->
        <div class="col-12">
          <div class="shop-filters mb-30 d-flex align-items-center justify-content-between">
            <!-- Product Show -->
            <div class="product-show">
            </div>

            <!-- Product View Mode -->
            <div class="produtc-view-mode">
            
            </div>
          </div>
        </div>
      </div>

      <div class="row">
        <!-- Shop Sidebar Area -->
        <div class="col-12 col-md-4 col-lg-3">

          <!-- Shopping Cart -->
          <div class="shopping-cart mb-50">
            <h5 class="mb-30">Carrello</h5>
            <!-- Cart Table -->
            <div class="cart-table clearfix">
              <table class="table table-responsive">
                <!-- tbody -->
               <c:forEach var="prodc" items="${prodc}">
	                <tbody>
	                  <!-- Single Table Row -->
	                  <tr>
	                    <td class="cart_product_img">
	                      <a href="#"><img src="${prodc.img}.jpg" alt="Product"></a>
	                    </td>
	                    <td class="cart_product_desc">
	                      <p style="font-weight: bold;">${prodc.tipo}</p>
	                      <h6>1 x ${prodc.prezzo} euro</h6>
	                    </td>
	                    <td class="product-remove">
	                    	<a href="deleteprodottotocart?idcl=${prodc.idordine}&tipo=${prodc.tipo}"><span class="ion-ios-close"></span></a>
	                    </td>

	                  </tr>
	                  <!-- Single Table Row -->
	                </tbody>
	            </c:forEach>
              </table>
            </div>
            <!-- SubTotal -->
            <div class="cart-summary d-flex align-items-center justify-content-between">
              <div class="sub-total">
                <h6 style="font-weight: bold;">Totale</h6>
              </div>
              <div style="font-weight: bold;" class="total-price">
                 <c:out value="${totale} euro" default="Prezzo!" escapeXml="false"/>
              </div>
            </div>
            <!-- Checkout -->
            <button class="btn famie-btn checkout-btn mt-30 w-100" type="submit" id="btnchk" onclick="ckout(event)">CHECKOUT</button>
          </div>


          <!-- Single Widget Area -->
          <div class="single-widget-area">
            <!-- Title -->
            <h5 class="widget-title">Ordina per</h5>
            <!-- Cata List -->
            <ul class="cata-list shop-page">
              <li><a href="vedifiltri?filtro=alfabetico">Alfabetico</a></li>
              <li><a href="vedifiltri?filtro=prezzo">Prezzo crescente</a></li>
              <li><a href="vedifiltri?filtro=prezzo2">Prezzo decrescente</a></li>
            </ul>
          </div>


        </div>
        
         <div class="col-12 col-md-8 col-lg-9">
          <div class="row">
	
	
	 
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
      </div>

    </div>
    </div>
  </section>
	
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

 <!-- ##### All Javascript Files ##### -->
  <!-- jquery 2.2.4  -->
  <script src="js/js1/jquery.min.js"></script>
  <!-- Popper js -->
  <script src="js/js1/popper.min.js"></script>
  <!-- Bootstrap js -->
  <script src="js/js1/bootstrap.min.js"></script>
  <!-- Owl Carousel js -->
  <script src="js/js1/owl.carousel.min.js"></script>
  <!-- Classynav -->
  <script src="js/js1/classynav.js"></script>
  <!-- Wow js -->
  <script src="js/js1/wow.min.js"></script>
  <!-- Sticky js -->
  <script src="js/js1/jquery.sticky.js"></script>
  <!-- Magnific Popup js -->
  <script src="js/js1/jquery.magnific-popup.min.js"></script>
  <!-- Scrollup js -->
  <script src="js/js1/jquery.scrollup.min.js"></script>
  <!-- Jarallax js -->
  <script src="js/js1/jarallax.min.js"></script>
  <!-- Jarallax Video js -->
  <script src="js/js1/jarallax-video.min.js"></script>
  <!-- Active js -->
  <script src="js/js1/active.js"></script>
</body>
</html>