<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>ViBienDa</title>
<link rel="stylesheet" href="https://unpkg.com/leaflet@1.6.0/dist/leaflet.css"/>
<script src="https://unpkg.com/leaflet@1.6.0/dist/leaflet.js"></script>

<!-- Barra de busqueda -->
<script src="https://cdn-geoweb.s3.amazonaws.com/esri-leaflet/0.0.1-beta.5/esri-leaflet.js"></script>
<script src="https://cdn-geoweb.s3.amazonaws.com/esri-leaflet-geocoder/0.0.1-beta.5/esri-leaflet-geocoder.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn-geoweb.s3.amazonaws.com/esri-leaflet-geocoder/0.0.1-beta.5/esri-leaflet-geocoder.css">

		<style>
body,
html {
  height: 100%;
  font-family:Arial;
}
  
#map {
  width: 100%;
  height: 100%;
  z-index:100;
}
#mapSearchContainer{
  position:fixed;
  top:20px;
  right: 40px;
  height:30px;
  width:180px;
  z-index:110;
  font-size:10pt;
  color:#5d5d5d;
  border:solid 1px #bbb;
  background-color:#f8f8f8;
}
.pointer{
  position:absolute;
  top:86px;
  left:60px;
  z-index:99999;
}
		</style>
</head>

<body>

<!-- Insertar barra superior -->


	
	<div id="map"></div>
	<div class='pointer'><< Click search button</div>
	<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/leaflet/0.7.3/leaflet.js" data-require="leaflet@0.7.3" data-semver="0.7.3"></script>
	<script type="text/javascript" src="/searchMap.js"></script>

</body>
</html>