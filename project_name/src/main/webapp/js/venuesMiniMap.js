/*MINIMAPA DE GENERAL STATS VIEW*/
var map = L.map('map').setView([lat, lon], 15);

L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
}).addTo(map);


L.control.scale().addTo(map);

var marker;
var venue;
var popup;
var seleccion = '';
var listasVacias = (listas === undefined || listas.length == 0);

for(var i = 0; i<venues.length; i++){
	venue = venues[i];
	marker = L.marker([venue.lat, venue.lon])
		.addTo(map);
	//marker.bindPopup(venue.name);
	//	Necesitamos enviar el id de la venue y de la lista
	
	if(!listasVacias){
		seleccion = '<label for="lists">' + Seleccione  + '</label>' +
			'<select id="listas" name="listsId" form="addVenueForm">';
		for(var j = 0; j<listas.length; j++){
			//	El array listas que recibimos ha de contener objetos con el nombre y el id de la lista
			seleccion = seleccion + '<option value="' + lista[j].id + '">' + lista[j].name + '</option>';
		}
		seleccion = seleccion + "</select>";
	}
	
	
	marker.bindPopup('<p><strong>' + venue.name + '</strong></p>' +
			'<form id="addVenueForm" class="addVenue" action="AddVenueToListController" method="POST">' + 
			'<input name="venueId" type="hidden" value="' + venue.id + '">' +
			seleccion +
			'<button type="submit">Añadir lugar</button>' +
			'</form>'
			);
}