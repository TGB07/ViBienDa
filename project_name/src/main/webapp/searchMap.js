var map = L.map('map').setView([37.0902, -95.7129], 5);

L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
}).addTo(map);

L.control.scale().addTo(map);

var searchControl = new L.esri.Controls.Geosearch().addTo(map);

var results = new L.LayerGroup().addTo(map);

searchControl.on('results', function(data){
	results.clearLayers();
});

map.on('click', function(e){
	var coord = e.latlng;
	var lat = coord.lat;
	var lng = coord.lng;
	var req = lat+";"+lng;
	
	$.ajax({
		url:'/SearchController',
		type: 'GET',
		data: {
			reqVal: req
		},
		success: function(data){
			window.location.href = "/generalStatsView.jsp";
		}
	});
});