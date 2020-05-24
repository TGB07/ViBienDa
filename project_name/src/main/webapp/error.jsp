<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Error Page</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
		
	<!-- NavBar import -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
	<!-- CSS -->
	<link rel="stylesheet" href="./css/error.css">
</head>


<body>
	<div class=wrapper>
		<!-- NAV-BAR -->
		<jsp:include page="navbar.html"/>
		
		<!-- Imagen de eror -->
		<div class=errorImg>
			<img class="imagenError" alt="Error imagen" src="/img/skyline.png">
		</div>
		
		<!-- Mensaje de error -->
		<div class=mensajeError>
			<h1>Algo ha salido mal :(</h1>
			<!-- Decide el mensaje en funcion del error -->
			<p><%
				switch(request.getAttribute("errorType").toString()){
				case "LLERROR": out.println("No ha sido posible localizar el lugar indicado");break;
				case "NEWSERROR": out.println("No hay noticias");break;
				case "TOKENERROR": out.println("No puedes acceder a esta función sin iniciar sesión");break;
				default: out.println("Error desconocido");break;
				}
			%></p>
			<button class=volver onclick="location.href='index.jsp'">Volver al inicio</button>
		</div>
	
	</div>
</body>
</html>