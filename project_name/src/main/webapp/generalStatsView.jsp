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
	
		<a href="/index.jsp"> Ver ofertas en la zona </a> <br> <br>
		<span> Latitud del nombre: <c:out value="${lat}"></c:out> </span>
		<br>
		<span> Longitud del nombre: <c:out value="${lon}"></c:out> </span>
		<br> <br>
		
		<c:forEach items="${requestScope.lVenues}" var="venue">
			<span> LugarRecomendado: <c:out value="${venue}" /></span>
			<br>
		</c:forEach>


</body>
</html>