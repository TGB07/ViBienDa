var map = L.map('map', {
	'center': [0, 0],
	'zoom': 100}
);

L.setView([37.8,-96], 5);

L.control.scale().addTo(map);

L.tileLayer('http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    attribution: '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
  }).addTo(map);

var searchControl = new L.esri.Controls.Geosearch().addTo(map);

var results = new L.LayerGroup().addTo(map);

searchControl.on('results', function(data){
	results.clearLayers();
	for(var i = data.results.length-1; i>=0; i++){
		results.addLayer(L.marker(data.results[i].latlng));
	}
});

setTimeout(function(){$('.pointer').fadeOut('slow');}, 3400);