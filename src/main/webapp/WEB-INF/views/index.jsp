<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- librería Security -->
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
   
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Animate CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"/>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<title>index</title>                     
		<link rel="shortcut icon" href="resources/imagenes/jiro.png" type="image/x-icon">   		            
		<link rel="stylesheet" 
              href="<c:url value="/resources/css/fondonew.css"/>">                 
</head>
  <body>
    	<!-- si el usuario está en sesión -->
	<security:authorize access="isAuthenticated()">
    <!-- navbar-->
    <%@include file="/WEB-INF/views/shared/navbar.jsp" %>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>    
	
	<script src="https://unpkg.com/vue"></script>
	<script src="https://unpkg.com/vue-router@3.4.9/dist/vue-router.js"></script>
	
	</security:authorize>
		<!-- si el usuario es visitante -->
	<security:authorize access="isAnonymous()">
		<% response.sendRedirect("http://localhost:8090/lol/login/"); %>
	</security:authorize>
	    <!-- footer -->
    <%@include file="/WEB-INF/views/shared/footer2.jsp" %>
  </body>
</html>