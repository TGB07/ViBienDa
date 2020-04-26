<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
		<link rel="stylesheet" href="./css/index.css">
    	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
		<title>ViBienDa</title>
	</head>

	<body>
	
	<div class=wrapper>	
	
		<!-- NAV-BAR -->
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
		  	<a class="navbar-brand" href="#">Home</a>
		  	<ul class="navbar-nav">
		    	<li class="nav-item">
		      		<a class="nav-link" href="#">Ranking</a>
		    	</li>
		    	<li class="nav-item">
		      		<a class="nav-link" href="#">FAQ</a>
		    	</li>
		  	</ul>
		</nav>
		
		<!-- TITLE -->
		<div class="title">	
			<img src="./img/background1.jpg" alt="logo"></img>
			<h1>ViBienDa</h1>			
			<div class="searchbar">
				<form class="search" action="SearchController" method="post">
					<input type="text" placeholder="Introduzca el nombre de una localización">
					<button type="submit"><i class="fa fa-arrow-right"></i></button>
				</form>
			</div>			
			<div class="mapButton">
				<form action="/searchMapView.jsp">
					<input type="submit" value="Mapa interativo" name="mapBtn">
				</form>
			</div>		
		</div>
	<!-- NAV-BAR -->
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
		  	<a class="navbar-brand" href="#">Home</a>
		  	<ul class="navbar-nav">
		    	<li class="nav-item">
		      		<a class="nav-link" href="#">Ranking</a>
		    	</li>
		    	<li class="nav-item">
		      		<a class="nav-link" href="#">FAQ</a>
		    	</li>
		  	</ul>
		</nav>
		
		<!-- QUE ES VIBIENDA -->
		<div class="queEs">
			<div class="top-half">
				<h1>Qué es ViBienDa</h1>
			</div>
			<div class="bottom-half">
				<p>Lorem Ipsum</p>
			</div>
		</div>
		
		<!-- SOBRE NOSOTROS -->
		<div class="aboutUs">
			<div class="top-half">
				<h1>Sobre nosotros</h1>
				<p>Lorem Ipsum</p>
			</div>
			<div class="bottom-half">
				<p>Lorem ipsum</p>
			</div>
		</div>


	
	</div>		
		<div class="mapButton">
			<form action="/searchMapView.jsp">
				<input type="submit" value="Mapa interativo" name="mapBtn">
			</form>
		</div>
	</body>
</html>