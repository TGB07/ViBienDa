<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" 
	href="https://www.w3schools.com/w3css/4/w3.css">
	
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
<!-- NavBar import -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<!-- ACCORDION/POPUP -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script 
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script 
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
	
<!-- fondo gris del popup -->
<style>
	.modal-backdrop.show{
		opacity: .5;
	}
</style>
    
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
			<p>Seleccione la lista de la que desea obtener sus lugares
				guardados.</p>

			<div class="panel-group" id="accordion">
				<c:forEach items="${requestScope.listasLugares}" var="lista"
					varStatus="loop">
					<!--  -->
					<div class="panel panel-default">
					
						<div class="panel-heading">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion" style="display:block; height: 100%; width: 100%;"
									href='#collapse<c:out value="${loop.index}"/>'> <c:out
										value="${lista.key}" />
								</a>
							</h4>
						</div>
						<div id="collapse<c:out value="${loop.index}"/>" class="panel-collapse collapse">
							<div class="panel-body">
								<div class="panel-info">
									<p>
										Descripcion:
										<c:out value="${lista.value[1]}" />
									</p>
									<p>
										Numero de seguidores:
										<c:out value="${lista.value[2]}" />
									</p>

									<p>Lugares:</p>
									<ul>
										<c:forEach items="${lista.value[3]}" var="venue" varStatus="i">
											<li>
												<p>
													Nombre:
													<c:out value="${venue.name}" />
												</p>
											</li>
										</c:forEach>
									</ul>

								</div>

							</div>
						</div>
					</div>

				</c:forEach>
				<!--  -->
			</div>

			<div class="addList">

				<div class="modad popup">

					<button type="button" class="btn btn-info btn-lg"
						data-toggle="modal" data-target="#myModal">Añadir lista</button>

					<!-- Contenido -->
					<div class="modal fade" id="myModal" role="dialog">
						<div class="modal-dialog">

							<!-- Contenido popup -->
							<div class="modal-content">
								<!-- Titulo popup -->
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
									<h4 class="modal-title">
										Introduzca la informacion de la lista a crear:
									</h4>
								</div>
								<!-- Fin titulo -->

								<!-- Cuerpo -->
								<div class="modal-body">
									<form class="addListForm" action="/CreateVenuesListController?code=<c:out value="${code}"/>#=" method="POST">
										<label for="lName">Nombre de la lista:</label><br>
										<input type="text" id="name" name="name" placeholder="Introduzca el nombre.."><br>
										<label for="lDescription">Descripcion de la lista:</label><br>
										<textarea name="descripcion" rows="5" columns="30" placeholder="Introduzca la descripcion-.."></textarea><br>
										<button type="submit" class="addListButton">Añadir</button>
									</form>
								</div>
								<!-- Fin cuerpo -->

								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Volver</button>
								</div>

							</div>
							<!-- Fin contenido popup -->


						</div>
					</div>
					<!-- Fin contenido -->

				</div>

			</div>

		</div>

	</div>



</body>
</html>