package aiss.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.IOException;
import java.time.LocalDateTime;

import org.junit.Test;

import aiss.model.crimeometer.CrimeStatsLLSearch;
import aiss.model.resources.CrimeometerResource;

public class CrimeometerResourceTests {

	CrimeometerResource coResource = new CrimeometerResource();
	
	@Test
	public void testGetCrimeStats() throws IOException {
		Double lat = 38.8949855;
		Double lon = -77.0365708;
		String fechaInicio = "2019-01-01T15:53:00.000Z";
		String fechaFin = "2020-01-01T15:53:00.000Z";
		System.out.println("Busqueda de crímenes en (" + lat + ", " + lon + ") "
				+ "desde " + fechaInicio + " hasta " + fechaFin + ".");
		CrimeStatsLLSearch res = coResource.getCrimeStatsLL(lat, lon, fechaInicio, fechaFin);
		
		if(res.getTotalIncidents()==0) {
			res = null;
		}
				
		LocalDateTime fi = LocalDateTime.parse(fechaInicio.replace("Z", ""));
		LocalDateTime ff = LocalDateTime.parse(fechaFin.replace("Z", ""));
		if(ff.isBefore(fi)) {
			res = null;
		}
		
		if(res!=null) {
			System.out.println("Búsqueda correcta.");
		}
		assertNotNull("Los resultados no pueden estar vacíos", res);
	}
	
	@Test
	public void testGetCrimeStatsNull() throws IOException {
		Double lat = 51.952659;
		Double lon = 7.632473;
		String fechaInicio = "2019-01-01T15:53:00.000Z";
		String fechaFin = "2020-01-01T15:53:00.000Z";
		System.out.println("Busqueda de crímenes en (" + lat + ", " + lon + ") "
				+ "desde " + fechaInicio + " hasta " + fechaFin + ".");
		CrimeStatsLLSearch res = coResource.getCrimeStatsLL(lat, lon, fechaInicio, fechaFin);
		
		if(res.getTotalIncidents()==0) {
			res = null;
		}
				
		LocalDateTime fi = LocalDateTime.parse(fechaInicio.replace("Z", ""));
		LocalDateTime ff = LocalDateTime.parse(fechaFin.replace("Z", ""));
		
		if(ff.isBefore(fi)) {
			res = null;
		}

		if(res==null) {
			System.out.println("Fallo correcto.");
		}
		assertNull("El resultado devuelve null si no existen crimenes en dicha localizacion o si la fecha de inicio no es anterior a la de fin", res);
	}
	
}
