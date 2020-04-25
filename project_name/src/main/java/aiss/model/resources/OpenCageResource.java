package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;

import aiss.model.opencage.LLNameSearch;

public class OpenCageResource {

	private static final String OpenCage_API_KEY = "07cecfd3cd97455b87fae72871cefe05";
	private static final Logger log = Logger.getLogger(OpenCageResource.class.getName());
	
	public LLNameSearch getLatitudLongitud(String query) throws UnsupportedEncodingException {

		String queryFormatted = URLEncoder.encode(query, "UTF-8");
		String uri = "http://api.opencagedata.com/geocode/v1/json?q=" + queryFormatted +"&key=" + OpenCage_API_KEY + "&language=es&pretty=1&no_annotations=1&limit=1&min_confidence=3";
		
		log.log(Level.FINE, "OpenCage URI: " + uri);
		
		ClientResource cr = new ClientResource(uri);
		LLNameSearch llnameSearch = cr.get(LLNameSearch.class);
		
		return llnameSearch;
	}
}