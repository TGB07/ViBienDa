/*DIAGRAMA DE BARRAS*/
	  google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawVisualization);
      function drawVisualization() {
        // Some raw data (not necessarily accurate)
        var data = google.visualization.arrayToDataTable([
          ['Meses', 			  	   				crime	 		,			"Average"			   ],
          ['Enero-Marzo',  			parseFloat(trimestres[3].count) ,	parseFloat(trimestres[3].count)],
          ['Abril-Junio',  			parseFloat(trimestres[2].count) ,  	parseFloat(trimestres[2].count)],
          ['Julio-Octubre',  		parseFloat(trimestres[1].count) , 	parseFloat(trimestres[1].count)],
          ['Noviembre-Diciembre',   parseFloat(trimestres[0].count) ,	parseFloat(trimestres[0].count)]
        ]);

        var options = {
          title : 'Numero de incidencias del tipo ' + crime + ' por trimestre',
          series: {0:{type: 'bars', color: 'royalblue'}, 1: {type: 'line', visibleInLegend: false, color: 'red'}},
          legend: {position: 'right', textStyle: {color: 'black', fontSize: 16}}
        };

        var chart = new google.visualization.ComboChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }

/*DIAGRAMA DE SECTORES*/
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Trimestre', 						crime			   ],
          ['Enero-Marzo',   		parseFloat(trimestres[3].count)],
          ['Abril-Junio',      		parseFloat(trimestres[2].count)],
          ['Julio-Octubre',  		parseFloat(trimestres[1].count)],
          ['Noviembre-Diciembre', 	parseFloat(trimestres[0].count)]
        ]);

        var options = {
          title: 'Numero de incidencias del tipo ' + crime + ' por trimestre',
          is3D: true,
          colors: ['royalblue', 'skyblue', 'lightblue', '#17a2b8']
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
        chart.draw(data, options);
      } 