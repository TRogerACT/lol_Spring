<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- Libreria JSTL core -->    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    

<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>listar</title>
		<link rel="shortcut icon" href="resources/imagenes/jiro.png" type="image/x-icon">  
</head>
<body>
	<div align="center">
	<h3>LISTAR</h3>
	<a class="texto" href="<c:url value='/index'/>">INDEX</a> <br><br>
	<a class="texto" href="<c:url value='/roljg_registrar'/>">REGISTRAR</a> <br><br>
	
	<table>
		<tr>
			<td><b>ID</b></td>
			<td><b>NOMBRE</b></td>
			<td><b>DESCRIPCION</b></td>
			<td><b>IMAGEN</b></td>
		</tr>
		
		<c:forEach var="roljg" items="${bRoljg}">
		<tr>
			<td>${roljg.jgId}</td>
			<td>${roljg.nombre}</td>
			<td>${roljg.descripcion}</td>
			
				<td>				
					<c:set var="typeImage" value="${fn:substringAfter(imagencampeones.nombre,'.')}"/>
					<img src="data:image/${typeImage};base64,${roljg.imagencampeones.getBase64Imagencampeones()}" 
					width="100" height="100"/>
				</td>
			<td>
				<a href="<c:url value="/roljg_editar/${roljg.jgId}"/>">EDITAR</a>
				<a href="<c:url value="/roljg_borrar/${roljg.jgId}"/>">BORRAR</a>
			</td>				
		</tr>
		</c:forEach>

	</table>
	</div>
</body>
</html>