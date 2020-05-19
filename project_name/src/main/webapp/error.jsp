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
</head>


<body>
	<div class=wrapper>
		<!-- NAV-BAR -->
		<jsp:include page="navbar.html"/>
		
		<div class=error>
			<img class="imagenError" alt="Error imagen" src="">
		</div>
		
		<div class=mensajeError>
			<p>Algo no funciona. Vuelve a la página principal.</p>
		</div>
	
	</div>
</body>
</html>