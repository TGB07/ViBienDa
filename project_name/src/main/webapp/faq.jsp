<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
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
<title>ViBienDa</title>
</head>

<body>
	<div class=wrapper>
		<!-- NAV-BAR -->
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
			<a class="navbar-brand" href="/index.jsp">Home</a>
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="#">Ranking</a></li>
				<li class="nav-item"><a class="nav-link" href="faq.jsp">FAQ</a></li>
			</ul>
		</nav>

		<!-- Contenedores de preguntas -->
		<div class="container">
			<br>
			<br>
			<br>
			<h2>FAQ</h2>
			<p>Las preguntas más frecuentes de nuestros usuarios.</p>
			<div id="accordion">
				<div class="card">
					<div class="card-header">
						<a class="card-link" data-toggle="collapse" href="#collapseOne">
							PRIMERA PREGUNTA </a>
					</div>
					<div id="collapseOne" class="collapse show"
						data-parent="#accordion">
						<div class="card-body">Lorem ipsum dolor sit amet,
							consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
							labore et dolore magna aliqua. Ut enim ad minim veniam, quis
							nostrud exercitation ullamco laboris nisi ut aliquip ex ea
							commodo consequat.</div>
					</div>
				</div>
				<div class="card">
					<div class="card-header">
						<a class="collapsed card-link" data-toggle="collapse"
							href="#collapseTwo"> SEGUNDA PREGUNTA </a>
					</div>
					<div id="collapseTwo" class="collapse" data-parent="#accordion">
						<div class="card-body">Lorem ipsum dolor sit amet,
							consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
							labore et dolore magna aliqua. Ut enim ad minim veniam, quis
							nostrud exercitation ullamco laboris nisi ut aliquip ex ea
							commodo consequat.</div>
					</div>
				</div>
				<div class="card">
					<div class="card-header">
						<a class="collapsed card-link" data-toggle="collapse"
							href="#collapseThree"> TERCERA PREGUNTA </a>
					</div>
					<div id="collapseThree" class="collapse" data-parent="#accordion">
						<div class="card-body">Lorem ipsum dolor sit amet,
							consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
							labore et dolore magna aliqua. Ut enim ad minim veniam, quis
							nostrud exercitation ullamco laboris nisi ut aliquip ex ea
							commodo consequat.</div>
					</div>
				</div>
			</div>
		</div>

	</div>

</body>
</html>