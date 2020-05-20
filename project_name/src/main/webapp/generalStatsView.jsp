<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
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
		<div class="w3-col s4 w3-green w3-center">
			<br> <br>
			<!-- NOMBRE POR EL QUE SE REALIZA LA BUSQUEDA -->
			<h1>
				<c:out value="${param.bar}" />
			</h1>
			<!-- Parte de estadisticas de crimeness -->

			<div class=parametros>
				<p>Estadísticas de crímenes</p>
				<c:forEach items="${requestScope.incidentes}" var="incidente">
					<span> <c:out value="${incidente.key}" />:
						<span class="w3-grey w3-round-xlarge"><br>
							<span class="w3-container w3-blue w3-round-xlarge"
								style="width: ${incidente.value}%"><br>
								<span> <c:out value="${incidente.value}" />%
								</span>
							</span>
						</span>
					</span>
					<br>
				</c:forEach>
			</div>
		</div>


		<!-- Parte derecha grid -->
		<div class="w3-col s8 w3-dark-grey w3-center">
			
			<br> <br> <br> <span> Latitud del nombre: <c:out
					value="${lat}"></c:out>
			</span> <br> <span> Longitud del nombre: <c:out value="${lon}"></c:out>
			</span> <br> <br>

			<form class="noticiasForm" action="NewsController" method="post">
				<input name="loc" type="hidden"
					value="${ param.bar=='' ? nombreLL : param.bar}">
				<!-- Podriamos hacer que la tematica fuese con un type=select, pero tendriamos que ver en que categorias dividiriamos las noticias -->
				<input name="tematica" type="text"
					placeholder="Temática de las noticias"> <select
					name="orden">
					<option value="relevance">Relevancia</option>
					<option value="publishedAt">Fecha de publicación</option>
					<option value="popularity">Popularidad de las fuentes</option>
				</select> <input type="submit"
					value="Ver noticias relacionadas con este lugar">
			</form>
			<br> <br>
		</div>
		
		<c:set var="lat" value="${lat}"/>
		<c:set var="lon" value="${lon}"/>
		<script>
			var lat = '${lat}';
			var lon = '${lon}';
		</script>
		<div id="map"></div>
		

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

		</script>

	</div>
	<!--  EN CASO DE BUSCAR POR MAPA EL NOMBRE SE PRINTA ASI -->
	<span><c:out value="${nombreLL}" /></span>

	<br>
	<script type="text/javascript" src="./js/venuesMiniMap.js"></script>
</body>
</html>