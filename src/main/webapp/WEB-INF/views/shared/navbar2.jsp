
<!-- librería Security -->
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%> 
 
  	<div class="container-fluid banner">
		<div class="row">
			<div class="col-md-12">
				<nav class="navbar navbar-md">
					<div class="navbar-brand"></div>
					<ul class="nav">
						<li class="nav-item">
							<a class="nav-link" href="#"></a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="#"></a>
						</li>
				        <li class="nav-item">   
				        	<a class="nav-link active" aria-current="page"href="<c:url value='/usuario'/>">Inicio</a>                 
				        </li>	
						<li class="nav-item dropdown">
				          <a aria-current="page" class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown">
				            Campeones
				          </a>
				          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
				            <li><a class="dropdown-item" href="<c:url value='/Topusuario'/>">TOP</a></li>
				            <li><a class="dropdown-item" href="<c:url value='/Jgusuario'/>">JG</a></li>
				            <li><a class="dropdown-item" href="<c:url value='/Midusuario'/>">MID</a></li>
				            <li><a class="dropdown-item" href="<c:url value='/Adcusuario'/>">ADC</a></li>
				            <li><a class="dropdown-item" href="<c:url value='/Supusuario'/>">SUP</a></li>
				          </ul>
				        </li>  
				        <li class="nav-item">   
			        		<security:authentication property="principal.username" var="username"/>
				
							<a  class="nav-link active"  aria-current="page"> Bienvenido <b>${username}</b></a>            
	        			</li>	
					</ul>
					
					<form class="d-flex">
				      	<a class="btn btn-outline-light" href="<c:url value='/logout'/>">BYE</a>
				    </form>
				</nav>
			</div>
		</div>
	</div>