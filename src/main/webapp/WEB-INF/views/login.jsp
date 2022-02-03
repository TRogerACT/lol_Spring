<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" 
              href="<c:url value="/resources/css/login.css"/>"/>
    <title>LOGIN</title>
</head>
<body>
    <div class="container">
        <div class="row justify-content-center pt-5 mt-5 m-1">
            <div class="col-md-6 col-sm-8 col-xl-4 col-lg-5 formulario">
            
			 	<form name="" method="post" action="/lol/login">
					<div class="form-group text-center pt-3">
                        <h1 class="text-light">INICIAR SESIÓN</h1>
                    </div>
                    <div class="form-group text-center pt-3">
						<!-- token de seguridad -->
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						
						<!-- mensaje para credenciales erróneos -->
						<c:if test="${param.error != null}">
							<p style="color: red">¡Error, acceso denegado!</p>
						</c:if>
						
						<!-- mensaje luego de cerrar sesión -->
						<c:if test="${param.logout != null}">
							<p style="color: green">¡Usted se ha desconectado!</p>
						</c:if>
					</div>
					<div class="form-group text-center pt-3">
					 <input class="form-control" type="text" name="txtUsername" placeholder="Ingrese su Usuario"/> <br>
					 <input class="form-control" type="password" name="txtPassword" placeholder="Ingrese su Contraseña"/> <br><br>
					
					<button class="btn btn-block ingresar" type="submit">INICIAR SESIÓN</button>
					<br> 
					<br>
					<a class="olvide1" href="<c:url value='/Inicio'/>">INICIO</a>
					</div>
				</form>
            </div>
        </div>
    </div>



    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</body>
</html>