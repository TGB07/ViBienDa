package aiss.tests;

import static org.junit.Assert.assertNotNull;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import aiss.model.opencage.LLNameSearch;
import aiss.model.resources.OpenCageResource;

public class OpenCageResourceTests {
	
	OpenCageResource ocResource = new OpenCageResource();
	
	@Test
	public void testGetNombre() throws UnsupportedEncodingException {
		Double lat = 27.6;
		Double lon = -56.22;
		System.out.println("Test OpenCage: Probando búsqueda de localización a partir de las coordenadas (" + lat + "," + lon + ")");
		LLNameSearch res = ocResource.getNombreLL(lat, lon);
		
		//	Comprobamos la existencia de resultados
		if(res.getTotalResults()==0) {
			res = null;
		}
		if(res!=null) {
			System.out.println("Búsqueda correcta.");
		}
		assertNotNull("Los resultados no pueden estar vacíos.", res);
	}
	
	@Test
	public void testGetLatLon() throws UnsupportedEncodingException {
		String localizacion = "New Jersey";
		System.out.println("Test OpenCage: Probando búsqueda de coordenadas a partir de '" + localizacion + "'");
		LLNameSearch res = ocResource.getLatitudLongitud(localizacion);
		
		//	Comprobamos la existencia de resultados
		if(res.getTotalResults()==0) {
			res = null;
		}
		if(res!=null) {
			System.out.println("Búsqueda correcta.");
		}
		assertNotNull("Los resultados no pueden estar vacíos.", res);
	}

}
