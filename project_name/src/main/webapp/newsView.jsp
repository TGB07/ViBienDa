<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>NewsView</title>
</head>
<body>
	
	<c:forEach items="${requestScope.articulos}" var="articulo">
		<span>Titulo: <c:out value="${articulo.getTitle()}"/></span><br>
		<span>Descripcion: <c:out value="${articulo.getDescription()}"/></span><br>
		<span><a href="${articulo.getUrl()}">Ir a la noticia</a></span><br>
		<span><img src="${articulo.getUrlToImage()}" alt="No hay foto disponible para la noticia" height="100" width="100"></span><br><br>
	</c:forEach>
	
</body>
</html>