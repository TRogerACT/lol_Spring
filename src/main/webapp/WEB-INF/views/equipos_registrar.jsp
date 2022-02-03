<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- Libreria JSTL core -->    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Libreria Spring Form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


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
</head>
<body>
    	<!-- si el usuario está en sesión -->
	<security:authorize access="isAuthenticated()">
<div class="container-xl">
	<div class="table-responsive">
		<div class="table-wrapper">
			<div class="table-title">
				<div class="row">
					<div class="col-sm-6">
						<h2><b>EQUIPOS REGISTAR</b></h2>
					</div>
					<div class="col-sm-6">
						
						<button class="btn btn-success" type="button"
							onclick="location.href='<c:url value="/equipos_listar"/>'">CANCELAR</button>
				
					</div>
				</div>
			</div>
			<table class="table table-striped table-hover">
				<form:form name="" method="post" modelAttribute="equipos"><br>
					NOMBRES: <form:input type="text" path="nombres"/> <br>
					<br>	
					REGISTRO: <form:input type="date" path="registro"/> <br>
					<br>	
					IMAGEN: 
					<form:select path="imagen.imagenId">
						<form:options items="${bImagen}" itemValue="imagenId" itemLabel="nombre"/>
					</form:select><br>
					<br>	
					LIDER: 
					<form:select path="liderg.lidergId">
						<form:options items="${bLiderg}" itemValue="lidergId" itemLabel="nombre"/>
					</form:select>	<br>
					<br>	
					MAPA: 
					<form:select path="grietas.grietasId">
						<form:options items="${bGrietas}" itemValue="grietasId" itemLabel="nombre"/>
					</form:select>	<br>					
					
					<br>
					<button class="btn btn-success" type="submit">GUARDAR</button>
				</form:form>	
			</table>
		</div>
	</div>        
</div>
		</security:authorize>
		<!-- si el usuario es visitante -->
	<security:authorize access="isAnonymous()">
		<% response.sendRedirect("http://localhost:8090/lol/login/"); %>
	</security:authorize>
</body>
</html>