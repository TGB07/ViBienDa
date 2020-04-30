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

var popup = L.popup();

function onMapClick(e){
	// + "(" + e.latlng.lat.toString().substring(0, 5) + "," + e.latlng.lng.toString().substring(0, 5) + ")"
	popup
		.setLatLng(e.latlng)
		.setContent('<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">'+
				"Seleccione el radio en kilómetros:" +
				'<form class="search" action="SearchController" method="post">' +
				'<input id="radio" name="radio" type="number" min="0" max="100" step="1" value="10">' +
				'<input name="lat" type="hidden" value="' + e.latlng.lat + '">' +
				'<input name="lon" type="hidden" value="' + e.latlng.lng + '">' +
				'<button type="submit"><i class="fa fa-arrow-right"></i></button>' +
				'</form>')
		.openOn(map);
}

map.on('click', onMapClick);