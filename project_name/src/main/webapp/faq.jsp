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
				<li class="nav-item"><a class="nav-link" href="/ranking.jsp">Ranking</a></li>
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
							¿QUÉ ES VIBIENDA? </a>
					</div>
					<div id="collapseOne" class="collapse show"
						data-parent="#accordion">
						<div class="card-body">ViBienDa es un proyecto web que integra varias API
						a modo de mash-up. El objetivo es facilitar a los usuarios la información que
						propocionan los distintos servicios que integra nuestra app. Vibienda integra
						toda la información necesaria sobre lugares: índices de crimen, lugares cercanos,
						noticias...</div>
					</div>
				</div>
				<div class="card">
					<div class="card-header">
						<a class="collapsed card-link" data-toggle="collapse"
							href="#collapseTwo"> ¿A QUIÉN VA DIRIGIDO? </a>
					</div>
					<div id="collapseTwo" class="collapse" data-parent="#accordion">
						<div class="card-body">ViBienda va dirigido a usuarios que buscan viajar a distintos lugares
						del mundo. El usuario podrá mirar estadísticas sobre los datos que incorpora la aplicación, ver
						gráficos, navegar en búsqueda de noticias y utilizar mapas interactivos.</div>
					</div>
				</div>
				<div class="card">
					<div class="card-header">
						<a class="collapsed card-link" data-toggle="collapse"
							href="#collapseThree"> ¿QUÉ ES UNA API? </a>
					</div>
					<div id="collapseThree" class="collapse" data-parent="#accordion">
						<div class="card-body">Una API representa la capacidad de comunicación entre componentes de software.
						Se trata del conjunto de llamadas a ciertas bibliotecas que ofrecen acceso a ciertos servicios desde
						los procesos y representa un método para conseguir abstracción en la programación, generalmente 
						(aunque no necesariamente) entre los niveles o capas inferiores y los superiores del software. Uno de
						los principales propósitos de una API consiste en proporcionar un conjunto de funciones de uso general,
						por ejemplo, para dibujar ventanas o iconos en la pantalla. De esta forma, los programadores se benefician
						de las ventajas del API haciendo uso de su funcionalidad, evitándose el trabajo de programar 
						todo desde el principio. Las API asimismo son abstractas: el software que proporciona una cierta API
						generalmente es llamado la implementación de esa API..</div>
					</div>
				</div>
				
				<div class="card">
					<div class="card-header">
						<a class="collapsed card-link" data-toggle="collapse"
							href="#collapseFour"> ¿CÓMO OBTENEMOS LOS DATOS? </a>
					</div>
					<div id="collapseFour" class="collapse" data-parent="#accordion">
						<div class="card-body">Los datos son obtenidos a través llamadas a las APIs que integra
						nuestra aplicación web. Los datos son procesados y mostrados a los usuarios internamente
						en nuestra aplicación. Las API que se utilizan son:
						<p> - Foursquare</p>
						<p> - CrimeoMeter</p>
						<p> - OpenCage</p>
						<p> - NewsAPI</p>
						<p>También se utilizan librerías como Leaflet y GoogleCharts para presentar los datos.</p>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>

</body>
</html>