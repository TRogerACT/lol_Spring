<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- Libreria JSTL core -->    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Libreria Spring Form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
		<link rel="shortcut icon" href="resources/imagenes/jiro.png" type="image/x-icon">  
</head>
<body>
	<div align="center">
	<h3>REGISTRAR</h3>
	
	<form:form name="" method="post" modelAttribute="roltop">
		NOMBRE:<form:input type="text" path="nombre"/> <br>
		DESCRIPCION:<form:input type="text" path="descripcion"/> <br>
		
		<font>IMAGEN:</font> 	
		<form:select path="imagencampeones.imagenId">
			<form:options items="${bImagenc}" itemValue="imagenId" itemLabel="nombre"/>
		</form:select><br>				
		
		<button type="submit">Guardar</button>
		<button type="button"
				onclick="location.href='<c:url value="/campeones"/>'">CANCELAR</button>
	</form:form>
	</div>
</body>
</html>