<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>

<html>
  <head>
  	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<!-- NavBar import -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  	
  	<!-- CSS -->
  	<link rel="stylesheet" href="./css/parameterStatsView.css">
  </head>
  
  <body>
  
  	<!-- NAV-BAR -->
	<jsp:include page="navbar.html" />
	
  	<!-- TABS -->
  	<div class="verticalTabs">
  	<div class="tab">
  		  <h1>GRAFICOS</h1>
		  <button class="tablinks active" onclick="openGraph(event, 'Grafico1')">Diagrama de barras</button>
		  <button class="tablinks" onclick="openGraph(event, 'Grafico2')">Diagrama de sectores</button>
	</div>
		<!-- GRAFICO 1 -->
		<div id="Grafico1" class="tabcontent" style = "display:block;">
		  <div id="chart_div" style="width: 900px; height: 500px;"></div>
		</div>
		<!-- GRAFICO 2 -->
		<div id="Grafico2" class="tabcontent" style = "display:block; visibility:hidden">
    		<div id="piechart_3d" style="width: 900px; height: 500px; display: block;"></div>
		</div>
	</div>
	
	
	<!-- INFORMACION -->
	<div class=info>La página actual permite visualizar de forma detallada los datos de un determinado 
	crimen para la localización dada. Dicha información está disponible de forma anual y representada 
	mediante un diagrama de barras y un diagrama de sectores de forma trimestral. De esta forma, podrás 
	seleccionar el año del que deseas obtener la información y ver representada de forma clara y concisa
	 la misma mediante los dos tipos de gráficos proporcionados.</div>
    

  	  <!-- javascript -->
	  <script type="text/javascript">
			
	  		var crime = "${tipoCrimen}";
			var trimestres = [];
			var trimestre;
			<c:forEach items="${requestScope.parameterStats}" var="entry">
				trimestre = {
						trimestre:"${entry.key}",
						count:"${entry.value}",
				};
				trimestres.push(trimestre);
			</c:forEach>
	  </script>
	  
	  <script type="text/javascript" src="./js/gcharts.js"></script>
	  <script type="text/javascript" src="./js/verticalTabs.js"></script>
	  
	  <script>
	  		google.charts.load("current", {packages: ["corechart"]});
	  		var visualization = new google.visualization.ComboChart(container);
	  </script>
  </body>
</html>