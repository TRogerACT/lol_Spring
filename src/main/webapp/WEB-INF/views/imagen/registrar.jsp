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
		<link rel="shortcut icon" href="resources/imagenes/jiro.png" type="image/x-icon">  
		<link rel="stylesheet" 
              href="<c:url value="/resources/css/LidergFondo.css"/>">             
        <style>
          .thumb {
            height: 100px;
          }
        </style>      
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
							<h2><b>IMAGEN REGISTAR</b></h2>
						</div>
						<div class="col-sm-6">
							
							<button class="btn btn-success" type="button"
								onclick="location.href='<c:url value="/imagen_listar"/>'">CANCELAR</button>
					
						</div>
					</div>
				</div>
				<table class="table table-striped table-hover">
		       		<form:form name="" id="files" method="post" action="/lol/imagen_registrar" enctype="multipart/form-data">
		       				<br>
		       				<div align="center">
		       				<output id="imagenId"></output>
		       				</div>
							<br>
							SELECCIONAR IMAGEN <input type="file" id="files" name="picture" accept="image/jpeg,image/png"/><br>
					
		            		<br>
						<button class="btn btn-success" type="submit">GUARDAR</button>
					</form:form>		
				</table>
			</div>
		</div>        
	</div>
        <script>
              function archivo(evt) {
                  var files = evt.target.files; // FileList object
             
                  // Obtenemos la imagen del campo "file".
                  for (var i = 0, f; f = files[i]; i++) {
                    //Solo admitimos imágenes.
                    if (!f.type.match('image.*')) {
                        continue;
                    }
             
                    var reader = new FileReader();
             
                    reader.onload = (function(theFile) {
                        return function(e) {
                          // Insertamos la imagen
                         document.getElementById("imagenId").innerHTML = ['<img class="thumb" src="', e.target.result,'" title="', escape(theFile.name), '"/>'].join('');
                        };
                    })(f);
             
                    reader.readAsDataURL(f);
                  }
              }
             
              document.getElementById('files').addEventListener('change', archivo, false);
      </script>	
      			</security:authorize>
		<!-- si el usuario es visitante -->
	<security:authorize access="isAnonymous()">
		<% response.sendRedirect("http://localhost:8090/lol/login/"); %>
	</security:authorize>
</body>
</html>