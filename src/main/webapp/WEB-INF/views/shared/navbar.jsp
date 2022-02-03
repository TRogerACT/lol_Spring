
<!-- librería Security -->
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>



	<div id="app">
	
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	  <div class="container-fluid">
	    <!-- Icono de NAVBAR -->
	    <nav class="navbar navbar-dark">
	    <div class="container-fluid">
	        <a class="navbar-brand" href="<c:url value='/index'/>">
	        <img src="<c:url value='resources/imagenes/jiro.png'/>" alt="" width="30" height="25" class="d-inline-block align-top">        
	        </a>
	    </div>
	    </nav>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarSupportedContent">
	      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
	        <li class="nav-item">   
	        	<a class="nav-link active" aria-current="page"href="<c:url value='/liderg_listar'/>">LIDERES</a>                 
	        </li>	
	        <li class="nav-item dropdown">
	          <a aria-current="page" class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown">
	            EQUIPOS
	          </a>
	          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
	            <li><a class="dropdown-item" href="<c:url value='/equipos_listar'/>">EQUIPOS</a></li>
	            <li><a class="dropdown-item" href="<c:url value='/imagen_listar'/>">IMAGENES</a></li>
	          </ul>
	        </li>   
	        <li class="nav-item">   
	        	<a class="nav-link active" aria-current="page"href="<c:url value='/grietas_listar'/>">GRIETAS</a>                 
	        </li>	              
	        <li class="nav-item dropdown">
	          <a aria-current="page" class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown">
	            CAMPEONES
	          </a>
	          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
	            <li><a class="dropdown-item" href="<c:url value='/campeones'/>">CAMPEONES</a></li>
	            <li><a class="dropdown-item" href="<c:url value='/imagen_campeones_listar'/>">IMAGENES</a></li>
	          </ul>
	        </li> 
	        <li class="nav-item">   
	        	<a class="nav-link active" aria-current="page" href="#">MUCHOS A MUCHOS</a>                 
	        </li>	
	        <li class="nav-item">   
			<a>aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa</a>            
	        </li>
	        <li class="nav-item">   
	        		<security:authentication property="principal.username" var="username"/>
		
					<a  class="nav-link active"  aria-current="page"> Bienvenido <b>${username}</b></a>            
	        </li>	 	          
	      </ul>			
	      <form class="d-flex">
	      	<a class="btn btn-outline-light" href="<c:url value='/logout'/>">BYE</a>
	      </form>
	    </div>
	  </div>
	</nav>
	</div>