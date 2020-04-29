<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>ViBienDa</title>
	
	<!-- NavBar import -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
	
	
	<link rel="stylesheet" href="https://unpkg.com/leaflet@1.6.0/dist/leaflet.css" />
	<script src="https://unpkg.com/leaflet@1.6.0/dist/leaflet.js"></script>
	
	<script src="http://cdn-geoweb.s3.amazonaws.com/esri-leaflet/1.0.0-rc.2/esri-leaflet.js"></script>
	<script src="http://cdn-geoweb.s3.amazonaws.com/esri-leaflet-geocoder/0.0.1-beta.5/esri-leaflet-geocoder.js"></script>
	<link rel="stylesheet" type="text/css" href="http://cdn-geoweb.s3.amazonaws.com/esri-leaflet-geocoder/0.0.1-beta.5/esri-leaflet-geocoder.css">
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

			<style>
	body,
	html {
	  height: 100%;
	  font-family:Arial;	
	}
	  
	#map {
	  width: 100%;
	  height: 100%;
	  z-index: 0;
	}
	#map .geocoder-control-input{
		margin-top: 130px;
		width: 25px;
	}
	.leaflet-control-zoom{
		position: absolute;
		top: 55px;
	}
	.titulito{
		position: absolute;
		top: 80px;
		width: 100%;
		display: flex;
		align-items: center;
		justify-content: center;
		z-index:2;	
	}
	.titulito h2{
		color: white;
		font-size: 25px;
		text-align: center;
		width: 50%;
		background:black;
		opacity: 0.5;
		border-radius: 50px;
		height: 60px;
		padding-left:20px;
		padding-right:20px;
		display: flex;
		align-items: center;
		justify-content: center;
	}
	@media screen and (max-width: 575px){
		#map .geocoder-control-input{
			margin-top: 185px;
			width: 25px;
		}
		.leaflet-control-zoom{
			position: absolute;
			top: 110px;
		}
	}
	
			</style>
</head>

<body>

	<!-- NAV-BAR -->
	<jsp:include page="navbar.html"/>
	
	<div class = titulito>
		<h2>Haga click en la localización que desee</h2>
	</div>

	<div id="map"></div>
	<script type="text/javascript" src="/searchMap.js"></script>

</body>
</html>