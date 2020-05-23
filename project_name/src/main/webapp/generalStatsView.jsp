<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- NavBar import -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<!-- Map import -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://unpkg.com/leaflet@1.6.0/dist/leaflet.css" />
<script src="https://unpkg.com/leaflet@1.6.0/dist/leaflet.js"></script>
<script
	src="http://cdn-geoweb.s3.amazonaws.com/esri-leaflet/1.0.0-rc.2/esri-leaflet.js"></script>
<script
	src="http://cdn-geoweb.s3.amazonaws.com/esri-leaflet-geocoder/0.0.1-beta.5/esri-leaflet-geocoder.js"></script>
<link rel="stylesheet" type="text/css"
	href="http://cdn-geoweb.s3.amazonaws.com/esri-leaflet-geocoder/0.0.1-beta.5/esri-leaflet-geocoder.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- CSS -->
<link rel="stylesheet" href="./css/generalStatsView.css">

<title>GeneralStatsView</title>
</head>
<body>



	<div class=wrapper>

		<!-- NAV-BAR -->
		<jsp:include page="navbar.html" />

		<!-- Parte izquierda grid -->
		<div class="w3-col s4 w3-blue w3-center">
			<br> <br>
			<!-- NOMBRE POR EL QUE SE REALIZA LA BUSQUEDA -->
			<h1>
				<c:out value="${param.bar}"/>
			</h1>
			<!-- Parte de estadisticas de crimeness -->

			<div class=parametros>
				<p>Estadísticas de crímenes</p>
				<c:forEach items="${requestScope.incidentes}" var="incidente">
					<form action=CrimeStatsController method = POST>
						<input type=hidden name=lat value="${lat}">
						<input type=hidden name=lon value="${lon}">
						<input type=hidden name=tipoCrimen value="${incidente.key}">	
						
						<button type=submit class = "incidentButton">	
							<span> <c:out value="${incidente.key}:" />
								<div class="w3-gray w3-round-xlarge gris">		
									<div class="w3-container w3-green w3-round-xlarge"
										style="width: ${incidente.value}%">
										<span class=porcentaje> <c:out value="${incidente.value}" />%
										</span>
									</div>
								</div>
							</span>
						</button>
					</form>
				</c:forEach>
			</div>
		</div>


		<!-- Parte derecha grid -->
		<div class="w3-col s8 w3-dark-grey w3-center">
			
			<form class="noticiasForm" action="NewsController" method="post">
				<input name="loc" type="hidden"
					value="${ param.bar=='' ? nombreLL : param.bar}">
				<!-- Podriamos hacer que la tematica fuese con un type=select, pero tendriamos que ver en que categorias dividiriamos las noticias -->
				<span><i class="fa fa-map"></i></span>
				<span class="textoBuscar">Noticias en la zona</span>
				<input class = "tematica" name="tematica" type="text"
					placeholder="Temática de las noticias"> 
				<select name="orden">
					<option value="relevance" selected disabled>Ordenar por...</option>
					<option value="relevance">Relevancia</option>
					<option value="publishedAt">Fecha de publicación</option>
					<option value="popularity">Popularidad de las fuentes</option>
				</select> <input type="submit"
					value="Ver noticias" class=noticiasBtn>
			</form>
			<!-- MAPA -->
			<div id="map"><span class=lugares>LUGARES CERCANOS</span></div>
			
			
			<!-- FORSQUARE LOGIN -->
			<div class=foursquareLogin>
				<span class=img><img src='./img/foursquare-logo.png' alt='fs logo'></span>
				<span class=texto>Inicia sesión con FourSquare para más ventajas!</span>
				
				<c:if test="${empty code}">
					
					<form action="" method="post">
						<input type="hidden" name="code" value="${code}">
					</form>
				
					<span class=loginBtn><button class=btn onclick='location.href="https://foursquare.com/oauth2/authenticate?client_id=HADL3PWUYW1AT3W0XHX4MQALAY22K1RMD2JIUBX5HXPTJYNC&response_type=code&redirect_uri=http://localhost:8090/GetAllUserListsController"'>LOGIN</button></span>
				</c:if>
				
				<c:if test="${not empty code}">
				
					<form action="GetAllUserListsController" method="post">
						<input type="hidden" name="code" value="${code}">
						<span class=loginBtn><button class=btn>Ir a mis listas</button></span>
					</form>
					
				</c:if>
				
				
			</div>
		</div>
		
		<c:set var="lat" value="${lat}"/>
		<c:set var="lon" value="${lon}"/>
		
		<script>
			var lat = '${lat}';
			var lon = '${lon}';
		</script>
		
		

		<script>
			var venues = [];
			var venue;
			<c:forEach items="${requestScope.lVenues}" var="venue">
				venue = {
						name:"${venue.name}",
						lat:"${venue.location.lat}",
						lon:"${venue.location.lng}",
				};
				venues.push(venue);
			</c:forEach>
			
			// Añadir a una variable de javascript las listas del usuario (estan en sesion)
			var listas=[];
			
		</script>

	</div>
	<!--  EN CASO DE BUSCAR POR MAPA EL NOMBRE SE PRINTA ASI -->
	<span><c:out value="${nombreLL}" /></span>

	<br>
	<script type="text/javascript" src="./js/venuesMiniMap.js"></script>
</body>
</html>