<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GeneralStatsView</title>
</head>
<body>

	<!-- NOMBRE POR EL QUE SE REALIZA LA BUSQUEDA -->
	<c:out value="${param.bar}" />
	
	<!--  EN CASO DE BUSCAR POR MAPA EL NOMBRE SE PRINTA ASI -->
	<span><c:out value="${nombreLL}" /></span>
	
	<br>

	<div class=parametros>

		<c:forEach items="${requestScope.incidentes}" var="incidente">
		
			<span> <c:out value="${incidente.key}" />: </span>
			<span> <c:out value="${incidente.value}" />%</span>
			
			<br>
		</c:forEach> 

		
	</div>
		
		<span> Latitud del nombre: <c:out value="${lat}"></c:out> </span>
		<br>
		<span> Longitud del nombre: <c:out value="${lon}"></c:out> </span>
		<br> <br>
		
		<form class="noticiasForm" action="NewsController" method="post">
			<input name="loc" type="hidden" value="${ param.bar=='' ? nombreLL : param.bar}" >
			<!-- Podriamos hacer que la tematica fuese con un type=select, pero tendriamos que ver en que categorias dividiriamos las noticias -->
			<input name="tematica" type="text" placeholder="Temática de las noticias">
			<select name="orden">
				<option value="relevance">Relevancia</option>
				<option value="publishedAt">Fecha de publicación</option>
				<option value="popularity">Popularidad de las fuentes</option>
			</select>
			<input type="submit" value="Ver noticias relacionadas con este lugar">
		</form>
		<br><br>
		
		<c:forEach items="${requestScope.lVenues}" var="venue">
			<span> LugarRecomendado: <c:out value="${venue}" /></span>
			<br>
		</c:forEach>


</body>
</html>