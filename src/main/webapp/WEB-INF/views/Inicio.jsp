<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta charset="utf-8">
	<meta name="viewreport" content="width=device-width, initial-scale=1.0">
	<title>
		inicio
	</title>
	<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
	<link href="https://fonts.googleapis.com/css?family=Raleway&display=swap" rel="stylesheet" />

<title>index</title>      
               
		<link rel="shortcut icon" href="resources/imagenes/jiro.png" type="image/x-icon">   	
		<link rel="stylesheet" 
              href="<c:url value="/resources/css/index.css"/>">         
	<meta charset="UTF-8">
<link rel="stylesheet" 
              href="<c:url value="/resources/css/cartas.css"/>">
	<title>inicio</title>
	<link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">                                  
</head>
  <body>
  	<div class="container-fluid banner">
		<div class="row">
			<div class="col-md-12">
				<nav class="navbar navbar-md">
					<div class="navbar-brand"></div>
					<ul class="nav">
						<li class="nav-item">
							<a class="nav-link" href="#"></a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="#"></a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="#"></a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="<c:url value="/login/"/>">LOGIN</a>
						</li>
					</ul>
				</nav>
			</div>
		</div>
	</div>
	<br>
	<br>
	<br>
	<br>

	<section class="portafolio">
		<div class="portafolio-container">
			<section class="portafolio-item">
				<img src="<c:url value='resources/img/1.jpg'/>" alt="" class="portafolio-img">
				<section class="portafolio-text">
					<h2>Grieta del Invocador </h2>
					<p>Dos equipos de cinco campeones compiten a lo largo de tres calles y una extensa jungla la cual esconde poderosas mejoras e importantes objetivos neutrales.</p>
				</section>
			</section>
			<section class="portafolio-item">
				<img src="<c:url value='resources/img/2.jpg'/>" alt="" class="portafolio-img">
				<section class="portafolio-text">
					<h2>El Bosque Retorcido</h2>
					<p>El Bosque Retorcido es el segundo Campo de la Justicia que se ha añadido a League of Legends. Cuenta con dos calles y equipos de tres campeones.</p>
				</section>
			</section>
			<section class="portafolio-item">
				<img src="<c:url value='resources/img/3.jpg'/>" alt="" class="portafolio-img">
				<section class="portafolio-text">
					<h2>El Abismo de los Lamentos</h2>
					<p>El Abismo de los Lamentos cuenta con dos equipos de cinco campeones que se enfrentan en una única calle.</p>
				</section>
			</section>
		</div>
	</section>	
    <!-- footer -->
    <%@include file="/WEB-INF/views/shared/footer.jsp" %>
  </body>
</html>