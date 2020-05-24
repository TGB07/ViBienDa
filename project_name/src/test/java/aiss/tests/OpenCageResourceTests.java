package aiss.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import aiss.model.opencage.LLNameSearch;
import aiss.model.resources.OpenCageResource;

public class OpenCageResourceTests {
	
	OpenCageResource ocResource = new OpenCageResource();
	
	@Test
	public void testGetNombre() throws UnsupportedEncodingException {
		Double lat = 51.952659;
		Double lon = 7.632473; 
		System.out.println("Obtener la localizacion a partir de las coordenadas (" + lat + "," + lon + ")");
		LLNameSearch res = ocResource.getNombreLL(lat, lon);
		
		if(res.getTotalResults()==0) {
			res = null;
		}
		if(res!=null) {
			System.out.println("Busqueda correcta.");
		}
		assertNotNull("Los resultados no pueden estar vacíos.", res);
	}
	
	@Test
	public void testGetLatLon() throws UnsupportedEncodingException {
		String localizacion = "New Jersey";
		
		System.out.println("Obtener las coordenadas de '" + localizacion + "'");
		LLNameSearch res = ocResource.getLatitudLongitud(localizacion);
		
		if(res.getTotalResults()==0) {
			res = null;
		}
		if(res!=null) {
			System.out.println("Busqueda correcta.");
		}
		assertNotNull("Los resultados no pueden estar vacíos.\n", res);
	}
	
	//TEST DE NULL
	@Test
	public void testGetLatLonNull() throws UnsupportedEncodingException {
		String localizacion = "ESTOVAADEVOLVERNULL!!!";
		
		System.out.println("Obtener las coordenadas de '" + localizacion + "'");
		LLNameSearch res = ocResource.getLatitudLongitud(localizacion);
		
		if(res.getTotalResults()==0) {
			res=null;
			System.out.println("Fallo correcto");
		}
		assertNull("El resultado devuelve null al no existir dicha localizacion", res);
	}

}
