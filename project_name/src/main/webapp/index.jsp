<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<title>ViBienDa</title>
	</head>

	<body>
	
		<div class="topnav">
			<div id ="home" class ="home" onclick='document.getElementById("home").scrollIntoView({behavior: "smooth"})'>
				<i class="fa fa-question-circle-o"></i>
			</div>
			
			<div id="ranking" class="ranking" onclick='location.href("/faq.jsp")'>
				<i class="fa fa-home"></i>
			</div>
			
			<div class ="faq" onclick='location.href("/faq.jsp")'>
				<i class="fa fa-question-circle-o"></i>
			</div>	
		</div>
		
		<div class="searchbar">
			<img src="" alt="logo"></img>
			<form class="search" action="REDIRECCION" method="post">
				<input name="bar" type="text" value="Introduzca el nombre de una localización">
			</form>
		</div>
	</body>
</html>