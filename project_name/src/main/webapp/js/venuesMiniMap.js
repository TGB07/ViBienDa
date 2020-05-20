/*MINIMAPA DE GENERAL STATS VIEW*/
var map = L.map('map').setView([lat, lon], 10);

L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
}).addTo(map);


L.control.scale().addTo(map);

var marker;
var venue;
var popup;
for(var i = 0; i<venues.length; i++){
	venue = venues[i];
	marker = L.marker([venue.lat, venue.lon])
		.addTo(map);
	marker.bindPopup(venue.name)
		.openPopup();
}