/*	>- MAPA DE generalStatsView.jsp -<
 * 	
 * 	Este mapa se situara en la localizacion proporcionada tanto por la barra de busqueda como por el mapa interactivo.
 * 	Se representara en el mismo el conjunto de lugares recomendados por Foursquare en un radio determinado.
 * 	
 * 	En caso de no estar logueado, los popup de cada lugar tendran mostraran un boton para añadir dicho lugar pero redirigiran
 * 	a la autenticacion mediante OAuth.
 * 	En caso contrario, se mostraran las listas del usuario entre las cuales seleccionara a la que desea añadir el lugar asociado
 * 	al popup.
 * 
 */	

//	Creamos el objeto de tipo mapa y establecemos la geolocalizacion del mismo
var map = L.map('map').setView([lat, lon], 15);

L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
}).addTo(map);

L.control.scale().addTo(map);

var marker;
var venue;
var popup;
var seleccion = '';

//	Procesamos el contenido de los popups de los lugares a representar en el mapa.
for(var i = 0; i<venues.length; i++){
	venue = venues[i];
	marker = L.marker([venue.lat, venue.lon])
		.addTo(map);
	
	//	Si las listas asociadas al usuario no son nulas añadiremos la opcion de seleccionar la lista a la que añadir el lugar.
	if(listas.length!==0){
		seleccion = '<label for="lists">Seleccione una lista</label>' +
			'<select id="listId" name="listId" form="addVenueForm">';
		for(var j = 0; j<listas.length; j++){
			seleccion = seleccion + '<option value="' + listas[j].id + '">' + listas[j].name + '</option>';
			console.log(seleccion);
		}
		seleccion = seleccion + '</select>';
	}

	marker.bindPopup('<p><strong>' + venue.name + '</strong></p>' +
			'<form id="addVenueForm" class="addVenue" action="AddVenueToListController" method="POST">' +
			'<input name="venueId" id="venueId" type="hidden" value="' + venue.id + '">' + 
			seleccion +
			'<button type="submit">Añadir lugar</button>' +
			'</form>');
}