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
		
		<c:forEach items="${requestScope.venues}" var="venue">
			<span> LugarRecomendado: <c:out value="${venue.name}" /></span>
			<br>
		</c:forEach>


</body>
</html>