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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">	
<link rel="stylesheet" href="https://unpkg.com/leaflet@1.6.0/dist/leaflet.css" />
<script src="https://unpkg.com/leaflet@1.6.0/dist/leaflet.js"></script>
<script src="http://cdn-geoweb.s3.amazonaws.com/esri-leaflet/1.0.0-rc.2/esri-leaflet.js"></script>
<script src="http://cdn-geoweb.s3.amazonaws.com/esri-leaflet-geocoder/0.0.1-beta.5/esri-leaflet-geocoder.js"></script>
<link rel="stylesheet" type="text/css" href="http://cdn-geoweb.s3.amazonaws.com/esri-leaflet-geocoder/0.0.1-beta.5/esri-leaflet-geocoder.css">	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<style>
	#map{
		bottom:0;
		right:0;
    	height:50%;
    	width:50%;
    	z-index:900;
	}

</style>

<title>GeneralStatsView</title>
</head>
<body>

	<!--  EN CASO DE BUSCAR POR MAPA EL NOMBRE SE PRINTA ASI -->
	<span><c:out value="${nombreLL}" /></span>

	<br>
	<script>
			var map = L.map('map').setView([37.0902, -95.7129], 5);

			L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
			    attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
			}).addTo(map);


			L.control.scale().addTo(map);

			var searchControl = new L.esri.Controls.Geosearch().addTo(map);

			var results = new L.LayerGroup().addTo(map);

			searchControl.on('results', function(data){
				results.clearLayers();
			});

			var popup = L.popup();

			function onMapClick(e){
				// + "(" + e.latlng.lat.toString().substring(0, 5) + "," + e.latlng.lng.toString().substring(0, 5) + ")"
				popup
					.setLatLng(e.latlng)
					.setContent('<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">'+
							"Seleccione el radio en kilómetros:" +
							'<form class="search" action="SearchController" method="post">' +
							'<input id="radio" name="radio" type="number" min="0" max="100" step="1" value="10">' +
							'<input name="lat" type="hidden" value="' + e.latlng.lat + '">' +
							'<input name="lon" type="hidden" value="' + e.latlng.lng + '">' +
							'<button type="submit"><i class="fa fa-arrow-right"></i></button>' +
							'</form>')
					.openOn(map);
			}

			map.on('click', onMapClick);
			</script>
	
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
						<div class="w3-grey w3-round-xlarge" style="width: 90%">
							<div class="w3-container w3-blue w3-round-xlarge"
								style="width: ${incidente.value}%">
								<span> <c:out value="${incidente.value}" />%
								</span>
							</div>
						</div>
					</span>
					<br>
				</c:forEach>
			</div>

		</div>
		<!-- Parte derecha grid -->
		<div class="w3-col s8 w3-dark-grey w3-center">
			<br> <br> <span> Latitud del nombre: <c:out
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

			<div id="map"></div>
		</div>
		
		<!--
		<c:forEach items="${requestScope.lVenues}" var="venue">
			<span> LugarRecomendado: <c:out value="${venue}" /></span>
			<br>
		</c:forEach>
		-->

	</div>
</body>
</html>