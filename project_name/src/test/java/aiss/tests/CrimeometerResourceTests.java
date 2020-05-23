package aiss.tests;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

import com.google.appengine.repackaged.org.joda.time.LocalDate;

import aiss.model.crimeometer.CrimeStatsLLSearch;
import aiss.model.resources.CrimeometerResource;

public class CrimeometerResourceTests {

	CrimeometerResource coResource = new CrimeometerResource();
	
	@Test
	public void testGetCrimeStats() throws IOException {
		Double lat = 99.123;
		Double lon = -30.71;
		String fechaInicio = "2019-01-01T15:53:00.000Z";
		String fechaFin = "2020-01-01T15:53:00.000Z";
		System.out.println("Test Crimeometer: Probando búsqueda de crímenes en (" + lat + ", " + lon + ") "
				+ "desde " + fechaInicio + " hasta " + fechaFin + ".");
		CrimeStatsLLSearch res = coResource.getCrimeStatsLL(lat, lon, fechaInicio, fechaFin);
		
		//	Comprobamos la existencia de resultados
		if(res.getTotalIncidents()==0) {	//	REVISAR, en un tramo corto puede no haber
			res = null;
		}
		
		LocalDate fi = LocalDate.parse(fechaInicio);
		LocalDate ff = LocalDate.parse(fechaFin);
		if(ff.isBefore(fi)) {
			res = null;
		}
		
		if(res!=null) {
			System.out.println("Búsqueda correcta.");
		}
		assertNotNull("Los resultados no pueden estar vacíos.", res);
	}
	
}
