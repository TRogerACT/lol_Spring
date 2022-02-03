<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>index</title>
        <link rel="stylesheet" 
              href="<c:url value="/resources/css/IndexFondo.css"/>"/>
        <link rel="stylesheet" 
              href="<c:url value="/resources/css/EstilosZoom2.css"/>"/>    
        <link rel="stylesheet" 
              href="<c:url value="/resources/css/EstilosZoom3.css"/>"/> 
		<link rel="shortcut icon" href="resources/imagenes/jiro.png" type="image/x-icon">                                             
</head>
<body>
	<div align="center">
	<h3><a title="INDEX" id="container1" class="ex1" href="<c:url value='/index'/>"><img src="<c:url value='resources/imagenes/menu.png'/>" width="160" height="75"></a></h3>
	</div>	
	<div align="left">
	<img src="<c:url value='resources/imagenes/transparente.png'/>" width="100" height="100">
	<img src="<c:url value='resources/imagenes/transparente.png'/>" width="64" height="64">
	<a title="IMAGENES_EQUIPOS" id="container" class="ex2" href="<c:url value='/imagen_listar'/>"><img src="<c:url value='resources/imagenes/imagen1.png'/>" width="300" height="300"></a>
	<img src="<c:url value='resources/imagenes/transparente.png'/>" width="100" height="100">
	<img src="<c:url value='resources/imagenes/transparente.png'/>" width="100" height="100">
	<img src="<c:url value='resources/imagenes/transparente.png'/>" width="50" height="50">
	<img src="<c:url value='resources/imagenes/transparente.png'/>" width="60" height="60">
	<img src="<c:url value='resources/imagenes/transparente.png'/>" width="30" height="30">
	<a title="IMAGENES_CAMPEONES" id="container" class="ex2" href="<c:url value='/imagen_campeones_listar'/>"><img src="<c:url value='resources/imagenes/imagen2.png'/>" width="300" height="300"></a>
	<img src="<c:url value='resources/imagenes/transparente.png'/>" width="100" height="100">
	<img src="<c:url value='resources/imagenes/transparente.png'/>" width="100" height="100">
	</div>		<p></p>
</body>
</html>