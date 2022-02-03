<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!-- librer�a Security -->
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>index</title>
</head>
<body>
	<h3>Hello World!</h3>
	
	<!-- si el usuario est� en sesi�n -->
	<security:authorize access="isAuthenticated()">
	
		<!-- nombre del usuario en sesi�n -->
		<security:authentication property="principal.username" var="username"/> 
	
		Bienvenido <b>${username}</b> <br><br>
		<a href="<c:url value='/logout'/>">Logout</a>
	</security:authorize>
	
	<!-- si el usuario es visitante -->
	<security:authorize access="isAnonymous()">
		<a href="<c:url value='/login'/>">Login</a>
	</security:authorize>
	
</body>
</html>