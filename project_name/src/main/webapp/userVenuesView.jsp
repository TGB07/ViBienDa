<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- NavBar import -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

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
								<a data-toggle="collapse" data-parent="#accordion"
									href="#collapse<c:out value="${loop.index}"/>"> <c:out
										value="${lista.key}" />
								</a>
							</h4>
						</div>
						<div id="collapse1" class="panel-collapse collapse in">
							<div class="panel-body">
								<div class="panel-info">
									<p>
										Descripcion:
										<c:out value="${lista.value[0]}" />
									</p>
									<p>
										Numero de seguidores:
										<c:out value="${lista.value[1]}" />
									</p>
								</div>

								<!-- Popup -->
								<div class="modad popup">

									<button type="button" class="btn btn-info btn-lg"
										data-toggle="modal" data-target="#myModal">Ver lugares</button>

									<!-- Contenido -->
									<div class="modal fade" id="myModal" role="dialog">
										<div class="modal-dialog">

											<!-- Contenido popup -->
											<div class="modal-content">
												<!-- Titulo popup -->
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal">&times;</button>
													<h4 class="modal-title"><c:out value="${lista.key}" /></h4>
												</div>
												
												<c:forEach items="${lista.value[2]}" var="venue">
														<div>
															<p>Nombre:<c:out value="${venue.name}" /></p>
															<p>Rating:<c:out value="${venue.rating}" /></p>
															<p>¿Has estado aqui?<c:out value="${venue.beenHere}" /></p>
														</div>
													</c:forEach>
												
												<!-- Fin titulo -->
												
												<!-- Cuerpo -->
												<div class="modal-body">
												
													
												
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
								<!-- Fin popup -->

							</div>
						</div>
					</div>

				</c:forEach>
				<!--  -->
			</div>
		</div>

	</div>



</body>
</html>