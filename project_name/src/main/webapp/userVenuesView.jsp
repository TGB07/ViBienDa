<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<title>UserVenuesStatsView</title>
</head>

<body>

	<div class="wrapper">
		<!-- NAV-BAR -->
		<jsp:include page="navbar.html" />

		<!-- Listas del usuario -->
		<div class="container">
			<h2>Mis listas de lugares favoritos:</h2>
			<h2>NOMBRE DEL USUARIO</h2>
			<p>Seleccione la lista de la que desea obtener sus lugares guardados.</p>
			
			<div class="panel-group" id="accordion">
			
				<!--  -->
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4 class="panel-title">
							<a data-toggle="collapse" data-parent="#accordion"
								href="#collapse1">AQUI ES UN c:out</a>
						</h4>
					</div>
					<div id="collapse1" class="panel-collapse collapse in">
						<div class="panel-body">
							<div class="panel-info">
								c:out DE LA DESCRIPCION, SEGUIDORES, ETC
							</div>
							
							
							
						</div>
					</div>
				</div>
				<!--  -->
			</div>
		</div>

	</div>



</body>
</html>