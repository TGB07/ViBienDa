package aiss.tests;

import static org.junit.Assert.assertNotNull;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import aiss.model.foursquare.FoursquareSearch;
import aiss.model.foursquare.FoursquareSearch;
import aiss.model.resources.FoursquareResource;

public class FoursquareResourceTests {

	FoursquareResource fsResource = new FoursquareResource();
	
	@Test
	public void testGetRecommendedVenues() throws UnsupportedEncodingException {
		Double lat = 0.0;
		Double lon = 0.0;
		Double radio = 10.0;
		System.out.println("Test FourSquare: Probando búsqueda de lugares cercanos (" + lat + ", " + lon + ") en un radio de " + radio + ".");
		FoursquareSearch res = fsResource.getRecommendedVenues(lat, lon, radio);
		
		if(res.getResponse().getVenues().size()==0) {
			res = null;
		}
		if(res!=null) {
			System.out.println("Búsqueda correcta.");
		}
		assertNotNull("Los resultados no pueden estar vacíos.", res);
	}
	
	/*
	 * 	ToDo:
	 * 		- testGetAccessToken
	 * 		- testGetUserLists
	 * 		- testAddVenue
	 * 		- testCreateList
	 * 		- testGetVenuesList
	 * 		- testDeleteVenue
	 * 
	 */
	
}
