package aiss.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import aiss.model.foursquare.FoursquareSearch;
import aiss.model.foursquare.list.FoursquareList;
import aiss.model.foursquare.listD.FoursquareListDetails;
import aiss.model.resources.FoursquareResource;

public class FoursquareResourceTests {

	String code="BXMS2GPO4EX4AJGWGA3XCQ2K4TFQ4K2245QEXPXEUSZWVCAE"; //hay que iniciar sesion para generar el code y cambiarlo
	FoursquareResource fsResource = new FoursquareResource();
	
	@Test
	public void testGetRecommendedVenues() throws UnsupportedEncodingException {
		Double lat = 38.8949855;
		Double lon = -77.0365708;
		Double radio = 10.0;
		System.out.println("Busqueda de lugares cercanos (" + lat + ", " + lon + ") en un radio de " + radio + ".");
		FoursquareSearch res = fsResource.getRecommendedVenues(lat, lon, radio);
		
		if(res.getResponse().getVenues().size()==0) {
			res = null;
		}
		if(res!=null) {
			System.out.println("Búsqueda correcta.");
		}
		assertNotNull("Los resultados no pueden estar vacíos.", res);
	}
	
	@Test
	public void testGetFoursquareAccessToken() throws UnsupportedEncodingException {
		System.out.println("Obtencion del accessToken a partir del code: " + code);
		String res = fsResource.getFoursquareAccessToken(code);
		
		if(res.isEmpty()) {
			res = null;
		}
		if(res!=null) {
			System.out.println("Obtencion del token correcta.");
		}
		assertNotNull("Los resultados no pueden estar vacíos.", res);
	}
	
	@Test
	public void testGetUserLists() throws UnsupportedEncodingException {		
		String token= fsResource.getFoursquareAccessToken(code);
		FoursquareList res = fsResource.getUserLists(token);
		
		if(res.getResponse().getLists().getItems()==null) {
			//si el usuario no tiene listas?
			res = null;
		}
		if(res!=null) {
			System.out.println("Obtencion de las listas del usuario correcta.");
		}
		assertNotNull("Los resultados no pueden estar vacíos.", res);
	}
	
	@Test
	public void testAddVenue() throws UnsupportedEncodingException {		
		String token= fsResource.getFoursquareAccessToken(code);
		
		String listId= fsResource.getUserLists(token).getResponse().getLists().getItems().get(0).getId();
		String venueId = "57acf9af498e6b8d5376c2d4";
		
		boolean res = fsResource.addVenue(token, listId, venueId);
		
		if(res) {
			System.out.println("Se añadio correctamente el lugar a la lista del usuario.");
		}
		assertTrue("No se ha podido añadir el lugar a la lista", res);
	}
	
	@Test
	public void testCreateList() throws UnsupportedEncodingException {		
		String token= fsResource.getFoursquareAccessToken(code);
		
		String name= "LISTA PARA LAS PRUEBAS JUNIT";
		String descripcion = "Esto es una prueba para los tests de JUNIT";
		
		boolean res = fsResource.createList(token, name, descripcion);
		
		if(res) {
			System.out.println("Se creo correctamente la lista.");
		}
		assertTrue("No se ha podido crear la lista", res);
	}
	
	@Test
	public void testGetVenuesList() throws UnsupportedEncodingException {		
		String token= fsResource.getFoursquareAccessToken(code);
		String listId= fsResource.getUserLists(token).getResponse().getLists().getItems().get(0).getId();

		FoursquareListDetails res = fsResource.getVenuesList(token, listId);
		
		if(res.getResponse().getList().getListItems().getItems().size()==0) {
			res = null;
		}
		if(res!=null) {
			System.out.println("Obtencion de los detalles de las listas del usuario.");
		}
		assertNotNull("Los resultados no pueden estar vacíos.", res);
	}
}
