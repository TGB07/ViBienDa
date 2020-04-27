<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>ViBienDa</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<style>
/* Make the image fully responsive */
.carousel-inner img {
	width: 100%;
	height: 100%;
}
</style>

</head>
<body>
	<div class=wrapper>
		<!-- NAV-BAR -->
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
			<a class="navbar-brand" href="/index.jsp">Home</a>
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="/ranking.jsp">Ranking</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="/faq.jsp">FAQ</a>
				</li>
			</ul>
		</nav>
		
		<br>
		<br>
		<br>

		<div>
			<h2>Selección de zona</h2>

			<form action="/action_page.php">
				<label for="cars">Selecciona estado:</label> <select id="cars"
					name="cars">
					<option value="alaska">Alaska</option>
					<option value="california">California</option>
					<option value="colorado">Colorado</option>
					<option value="washington">Washington</option>
				</select> <input type="submit">
			</form>
		</div>

		<div>
		Mostrando resultados de California
		</div>

		<div id="demo" class="carousel slide" data-ride="carousel">
			<ul class="carousel-indicators">
				<li data-target="#demo" data-slide-to="0" class="active"></li>
				<li data-target="#demo" data-slide-to="1"></li>
				<li data-target="#demo" data-slide-to="2"></li>
			</ul>
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img src="./img/casa1.jpg" alt="casa1" width="1100" height="500">
					<div class="carousel-caption">
						<h3>1º</h3>
						<a href="linkAOferta"> Primera casita </a>
						<p>topoten</p>
					</div>
				</div>
				<div class="carousel-item">
					<img src="./img/casa2.jpg" alt="casa2" width="1100" height="500">
					<div class="carousel-caption">
						<h3>2º</h3>
						<a href="linkAOferta"> Segunda casita </a>
						<p>Vistas al mar</p>
					</div>
				</div>
				<div class="carousel-item">
					<img src="./img/casa3.jpg" alt="casa3" width="1100" height="500">
					<div class="carousel-caption">
						<h3>3º</h3>
						<a href="linkAOferta"> Tercera casita </a>
						<p>no ta mal</p>
					</div>
				</div>
			</div>
			<a class="carousel-control-prev" href="#demo" data-slide="prev">
				<span class="carousel-control-prev-icon"></span>
			</a> <a class="carousel-control-next" href="#demo" data-slide="next">
				<span class="carousel-control-next-icon"></span>
			</a>
		</div>
	</div>

</body>
</html>