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
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Bootstrap CRUD Data Table for Database with Modal Form</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <link rel="stylesheet" 
              href="<c:url value="/resources/css/CSSLISTAR.css"/>"/>  
		<link rel="stylesheet" 
              href="<c:url value="/resources/css/EquiposFondo.css"/>">               
<meta charset="ISO-8859-1">
<title>Insert title here</title>                 
<script>
$(document).ready(function(){
	// Activate tooltip
	$('[data-toggle="tooltip"]').tooltip();
	
	// Select/Deselect checkboxes
	var checkbox = $('table tbody input[type="checkbox"]');
	$("#selectAll").click(function(){
		if(this.checked){
			checkbox.each(function(){
				this.checked = true;                        
			});
		} else{
			checkbox.each(function(){
				this.checked = false;                        
			});
		} 
	});
	checkbox.click(function(){
		if(!this.checked){
			$("#selectAll").prop("checked", false);
		}
	});
});
</script>
    <!-- Animate CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"/>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
	<title>index</title>                     
		<link rel="shortcut icon" href="resources/imagenes/jiro.png" type="image/x-icon">  
</head>
<body>
    	<!-- si el usuario está en sesión -->
	<security:authorize access="isAuthenticated()">
    <!-- navbar-->
    <%@include file="/WEB-INF/views/shared/navbar.jsp" %>
    
<div class="container-xl">
	<div class="table-responsive">
		<div class="table-wrapper">
			<div class="table-title">
				<div class="row">
					<div class="col-sm-6">
						<h2><b>EQUIPOS LISTAR</b></h2>
					</div>
					<div class="col-sm-6">
						<a class="btn btn-success" href="<c:url value='/equipos_registrar'/>">REGISTRAR</a>
						<a class="btn btn-success" href="<c:url value='/index'/>">INDEX</a>						
					</div>
				</div>
			</div>
			<table class="table table-striped table-hover">
				<tr>
					<td><b>ID</b></td>
					<td><b>NOMBRE</b></td>
					<td><b>REGISTRO</b></td>
					<td><b>IMAGEN</b></td>
					<td><b>LIDER</b></td>
					<td><b>MAPA</b></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>					
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td><b><font>ACCION</font></b></td>

				</tr>
				
				<c:forEach var="equipos" items="${bEquipos}">
				<tr>
					<td>${equipos.equiposId}</td>
					<td>${equipos.nombres}</td>
					<td>${equipos.registro}</td>
					<td>				
						<c:set var="typeImage" value="${fn:substringAfter(imagen.nombre,'.')}"/>
						<img src="data:image/${typeImage};base64,${equipos.imagen.getBase64Imagen()}" 
						width="100" height="100"/>
					</td>
					<td>${equipos.liderg.nombre}</td>
					<td>${equipos.grietas.nombre}</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>																		
					<td>
						<a href="<c:url value="/equipos_detalle/${equipos.nombres}"/>">DETALLE</a>
						<a href="<c:url value="/equipos_editar/${equipos.equiposId}"/>">EDITAR</a>
						<a href="<c:url value="/equipos_borrar/${equipos.equiposId}"/>">BORRAR</a>
					</td>
				</tr>
				
				</c:forEach>			
			</table>
		</div>
	</div>        
</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>    
	
	<script src="https://unpkg.com/vue"></script>
	<script src="https://unpkg.com/vue-router@3.4.9/dist/vue-router.js"></script>
		</security:authorize>
		<!-- si el usuario es visitante -->
	<security:authorize access="isAnonymous()">
		<% response.sendRedirect("http://localhost:8090/lol/login/"); %>
	</security:authorize>
</body>
</html>