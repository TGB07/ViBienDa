<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<title>ViBienDa</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<!-- NavBar import -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
		
		<link rel="stylesheet" href="./css/ranking.css">
		
		<title>ViBienDa</title>
		
	</head>
	
<body>
	<div class=wrapper>
	
		<!-- NAV-BAR -->
		<jsp:include page="navbar.html"/>
		
		<!-- SIDEBAR DE OPCIONES -->
		<div class="sidebar-container">
			<div id="mySidebar" class="sidebar">
			    
			    <h2>Selección de zona</h2>
				<form action="SearchController" autocomplete="off" method="post">
					<label for="state">Selecciona estado:</label>
					<input list="state" placeholder="Selecciona un estado" required="required" name="bar"> 
					<datalist id="state">
						<option value="Alabama">AL</option>
						<option value="Alaska">AK</option>
						<option value="Arizona">AZ</option>
						<option value="Arkansas">AR</option>
						<option value="California">CA</option>
						<option value="Colorado">CO</option>
						<option value="Washington">WA</option>
					</datalist> <input type="submit" value="Buscar">
				</form>			
		  	</div>
			<div id = "btn" class="btn" onclick="toggleNav(this)">
			  	<div class="bar1"></div>
				<div class="bar2"></div>
				<div class="bar3"></div>
		  	</div>  
		</div>
		
		<!-- SLIDER DE IMAGENES -->
		<div id="demo" class="carousel slide" data-ride="carousel">
			<ul class="carousel-indicators">
				<li data-target="#demo" data-slide-to="0" class="active"></li>
				<li data-target="#demo" data-slide-to="1"></li>
				<li data-target="#demo" data-slide-to="2"></li>
			</ul>
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img src="./img/top1.jpg" alt="top1" width="100vw" height="100vh">
					<div class="carousel-caption">
						<h3>1º</h3>
						<p> Clarks Ville </p>
						<p> Tenessee </p>
					</div>
				</div>
				<div class="carousel-item">
					<img src="./img/top2.jpg" alt="top2" width="100vw" height="100vh">
					<div class="carousel-caption">
						<h3>2º</h3>
						<p> Round rock </p>
						<p> Texas </p>
					</div>
				</div>
				<div class="carousel-item">
					<img src="./img/top3.jpg" alt="casa3" width="100vw" height="100vh">
					<div class="carousel-caption">
						<h3>3º</h3>
						<p> Fishers </p>
						<p> Indiana </p>
					</div>
				</div>
			</div>
			<a class="carousel-control-prev" href="#demo" data-slide="prev">
				<span class="carousel-control-prev-icon"></span>
			</a> <a class="carousel-control-next" href="#demo" data-slide="next">
				<span class="carousel-control-next-icon"></span>
			</a>
		</div>
	</div>
	
	<!-- scripts -->
	<script type="text/javascript">
		function toggleNav(x){
			var width = getComputedStyle(document.getElementById("mySidebar")).width;
			if(width.localeCompare("0px")==1){
				x.classList.remove("change");
				document.getElementById("mySidebar").style.width = "0";
				document.getElementById("btn").style.marginLeft= "0";
			}
			else{
				x.classList.add("change");
				document.getElementById("mySidebar").style.width = "250px";
				document.getElementById("btn").style.marginLeft = "250px";
			}
		}
	</script>

</body>
</html>