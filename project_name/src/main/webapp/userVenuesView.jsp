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
										value="${entry.key}" />
								</a>
							</h4>
						</div>
						<div id="collapse1" class="panel-collapse collapse in">
							<div class="panel-body">
								<div class="panel-info">
									<p>
										Descripcion:
										<c:out value="${entry.value.description}" />
									</p>
									<p>
										Numero de seguidores:
										<c:out value="${entry.value.followers}" />
									</p>
									<img
										src="<c:out value="${entry.value.prefix}"/>
										<c:out value="${entry.value.suffix}"/>"
										alt="No existe foto para este lugar.">
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
													<h4 class="modal-title"><c:out value="${entry.key}" /></h4>
												</div>
												<!-- Fin titulo -->
												
												<!-- Cuerpo -->
												<div class="modal-body">
												
													<c:forEach items="${entry.value.venues}" var="venue">
														<div>
															<p>Nombre:<c:out value="${venue.name}" /></p>
															<p>Rating:<c:out value="${venue.rating}" /></p>
															<p>¿Has estado aqui?<c:out value="${venue.beenHere}" /></p>
														</div>
													</c:forEach>
												
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