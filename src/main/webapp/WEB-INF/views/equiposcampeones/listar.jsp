<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- Libreria JSTL core -->    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listar</title>  
		<link rel="shortcut icon" href="resources/imagenes/jiro.png" type="image/x-icon">                             
</head>
<body>
	<div align="center">
	<h3>GRIETAS - LISTAR</h3>
	<a class="texto" href="<c:url value='/index'/>">INDEX</a> <br><br>
	<a class="texto" href="<c:url value='null'/>">REGISTRAR</a> <br><br>
	<table>
		<tr>
			<td><b>EQUIPOS ID</b></td>
			<td><b>EQUIPOS</b></td>
			<td><b>TOP</b></td>
			<td><b>JG</b></td>
			<td><b>MID</b></td>
			<td><b>ADC</b></td>
			<td><b>SUP</b></td>
		</tr>
		<c:forEach var="object" items="${bEquiposcampeones}">
			<tr>
                <td>${object[0]}</td>
                <td>${object[1]}</td>
                <td>${object[2]}</td>
                <td>${object[3]}</td>
                <td>${object[4]}</td>
                <td>${object[5]}</td>  
                <td>${object[6]}</td>                                                				
			</tr>		
		</c:forEach>
	</table>
	</div>
</body>
</html>