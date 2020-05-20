<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>

<html>
  <head>
  	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  </head>
  <body>
    <div id="chart_div" style="width: 900px; height: 500px;"></div>

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
	  
	  <script>
	  		google.charts.load("current", {packages: ["corechart"]});
	  		var visualization = new google.visualization.ComboChart(container);
	  </script>
  </body>
</html>