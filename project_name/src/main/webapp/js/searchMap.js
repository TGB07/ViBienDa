/*	>- BUSQUEDA POR CLICK EN EL MAPA -<
 * 
 * 	Cuando se haga click en una localizacion se enviaran sus coordenadas para la busqueda posterior
 * 	de estadisticas sobre crimenes, noticias y lugares recomendados en un radio establecido en kilometros.
 * 
 * 	Utilizamos un form con parametros ocultos insertado en un popup que aparecera cuando hagamos click
 * 	en cualquier localizacion del mapa.
 * 
 * 	Tambien cuenta con una barra de busqueda que nos permitira centrar el mapa en el lugar que escribamos.
 * 
 */

//	Creamos el objeto de tipo mapa y establecemos la geolocalizacion del mismo
//	De forma predeterminada esta situado en Estados Unidos
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

//	Creamos una funcion que al click muestre el popup anteriormente indicado
function onMapClick(e){
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