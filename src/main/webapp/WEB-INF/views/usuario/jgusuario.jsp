<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!-- Libreria JSTL core -->    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>  

<!-- librería Security -->
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Campeones</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
 		<link rel="stylesheet" 
              href="<c:url value="/resources/css/CampeonesFondo.css"/>">  
	<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
	<link href="https://fonts.googleapis.com/css?family=Raleway&display=swap" rel="stylesheet" />
	              
</head>
<body>
	    	<!-- si el usuario está en sesión -->
	<security:authorize access="isAuthenticated()">
    <!-- navbar-->
    <%@include file="/WEB-INF/views/shared/navbar2.jsp" %>
<br>
<c:forEach var="roljg" items="${bRoljg}">
	<div class="card mb-3" style="max-width: 540px;">
	  <div class="row g-0">
	    <div class="col-md-4">
	     			<c:set var="typeImage" value="${fn:substringAfter(imagencampeones.nombre,'.')}"/>
					<img class="img-fluid rounded-start" src="data:image/${typeImage};base64,${roljg.imagencampeones.getBase64Imagencampeones()}" 
					/>
	    </div>
	    <div class="col-md-8">
	      <div class="card-body">
	        <h5 class="card-title">${roljg.nombre}</h5>
	        <p class="card-text">${roljg.descripcion}</p>
	        <p class="card-text"><small class="text-muted">JG</small></p>
	      </div>
	    </div>
	  </div>
	</div>
</c:forEach>
	    <!-- footer -->
    <%@include file="/WEB-INF/views/shared/footer2.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
		</security:authorize>
		<!-- si el usuario es visitante -->
	<security:authorize access="isAnonymous()">
		<% response.sendRedirect("http://localhost:8090/lol/login/"); %>
	</security:authorize>
</body>
</html>