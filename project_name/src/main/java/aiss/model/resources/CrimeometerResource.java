package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;

import aiss.model.crimeometer.CrimeometerLLSearch;

public class CrimeometerResource {
	
	private static final String Crimeometer_API_KEY = "07cecfd3cd97455b87fae72871cefe05";
	private static final Logger log = Logger.getLogger(CrimeometerResource.class.getName());
	
	public CrimeometerLLSearch getCrimeData(String query) throws UnsupportedEncodingException {
		
		//PONER LOS HEADERS PARA APIKEY
		String queryFormatted = URLEncoder.encode(query, "UTF-8");
		String uri = "http://api.crimeometer.com/v1/incidents/raw-data?lat=" + queryFormatted + "&lon=" + queryFormatted + "&distance=15km&datetime_ini=2019-04-20T15:53:00.000Z&datetime_end=2020-04-20T15:53:00.000Z";
				
		log.log(Level.FINE, "Crimeometer URI: " + uri);
		
		ClientResource cr = new ClientResource(uri);
		CrimeometerLLSearch crimedataSearch = cr.get(CrimeometerLLSearch.class);
		
		return crimedataSearch;
	}
}