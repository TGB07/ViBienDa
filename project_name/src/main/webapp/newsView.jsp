<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!-- NavBar import -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">	
	<link rel="stylesheet" href="./css/newsView.css">
<title>NewsView</title>
</head>
<body>
	
	<div class="wrapper">
		<!-- NAV-BAR -->
		<jsp:include page="navbar.html" />
		
		
		<div class="news-container">
		<h1 class="heading">Noticias sobre: <%= request.getParameter("tematica") %></h1>
			<!-- Iteramos sobre las noticias y mostramos sus aspectos mas relevantes -->
			<c:forEach items="${requestScope.articulos}" var="articulo">
			<div class=noticia>
				<span class=titulo><c:out value="${articulo.getTitle()}"/></span><br>
				<span class=fecha><c:out value="${fn:substring(articulo.publishedAt,0,10)}"/></span><br>
				<span class=descripcion><c:out value="${articulo.getDescription()}"/></span><br>
				<span class=enlace><a href="${articulo.getUrl()}">Leer más</a></span><br>
				<span class=img><img src="${articulo.getUrlToImage()}" alt="No hay foto disponible para la noticia" height="100" width="100"></span><br><br>
			</div>
			</c:forEach>
		</div>
	</div>
	
</body>
</html>