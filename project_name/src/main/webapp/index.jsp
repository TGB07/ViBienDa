<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<title>ViBienDa</title>
	
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<!-- CSS -->
		<link rel="stylesheet" href="./css/index.css">
    	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    	
    	<!-- NavBar import -->
    	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
	</head>

	<body>
	
	<div class=wrapper>	
	
		<!-- NAV-BAR -->
		<jsp:include page="navbar.html"/>
		
		<!-- Contenido central -->
		<div class="title">	
			<img src="./img/background1.jpg" alt="logo"></img>
			<h1>ViBienDa</h1>
			<!-- Barra de busqueda -->			
			<div class="searchbar">
				<form class="search" action="SearchController" method="post">
					<input name="bar" type="text" placeholder="Introduzca el nombre de una localización" required="required">
					<button type="submit"><i class="fa fa-arrow-right"></i></button>
				</form>
			</div>			
			<!-- Boton mapa interactivo -->
			<div class="mapButton">
				<form action="/searchMapView.jsp" method = post>
					<input type="submit" value="Mapa interactivo" name="mapBtn">
				</form>
			</div>		
			
		</div>
	</div>
	</body>
</html>