package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.opencage.LLNameSearch;

public class OpenCageResource {

	private static final String OpenCage_API_KEY = "07cecfd3cd97455b87fae72871cefe05";
	//Clave pruebas
//	private static final String OpenCage_API_KEY = "d83410cb3adb485497f280a62deb45f6";
	private static final Logger log = Logger.getLogger(OpenCageResource.class.getName());
 
	public LLNameSearch getLatitudLongitud(String query) throws UnsupportedEncodingException {

		ClientResource cr = null;
		LLNameSearch llnameSearch=null;
		
		String queryFormatted = URLEncoder.encode(query, "UTF-8");
		String uri = "https://api.opencagedata.com/geocode/v1/json?q=" + queryFormatted +"&key=" + OpenCage_API_KEY + "&language=es&pretty=1&no_annotations=1&language=es&limit=1";
		
		log.log(Level.FINE, "OpenCage URI: " + uri);
		
		try {
			cr = new ClientResource(uri);
			llnameSearch = cr.get(LLNameSearch.class);
		}
		catch (ResourceException re){
			System.err.println("Error when retrieving the latitude/longitude" + cr.getResponse().getStatus());
		}
		
		return llnameSearch;
	}
	
	public LLNameSearch getNombreLL(Double lat, Double lon) throws UnsupportedEncodingException {

		ClientResource cr = null;
		LLNameSearch llnameSearch=null;
		
		String uri = "https://api.opencagedata.com/geocode/v1/json?q=" + lat + "+" + lon +"&key=" + OpenCage_API_KEY + "&language=es&pretty=1&no_annotations=1&limit=1&min_confidence=3";
		
		log.log(Level.FINE, "OpenCage URI: " + uri);
		
		try {
			cr = new ClientResource(uri);
			llnameSearch = cr.get(LLNameSearch.class);
		}
		catch (ResourceException re){
			System.err.println("Error when retrieving the latitude/longitude" + cr.getResponse().getStatus());
		}
		
		return llnameSearch;
	}
}