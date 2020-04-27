package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.http.protocol.HTTP;
import org.restlet.data.Header;
import org.restlet.engine.header.HeaderConstants;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;
import org.restlet.util.Series;


import aiss.model.crimeometer.CrimeometerLLSearch;

public class CrimeometerResource {
	
	private static final String Crimeometer_API_KEY = "07cecfd3cd97455b87fae72871cefe05";
	private static final Logger log = Logger.getLogger(CrimeometerResource.class.getName());
	
	 @SuppressWarnings("unchecked")
	  public void addHeader(ClientResource cr, String headerName, String headerValue) {
	    Series<Header> headers = (Series<Header>) cr.getRequest().getAttributes()
	        .get(HeaderConstants.ATTRIBUTE_HEADERS);

	    if (headers == null) {
	      headers = new Series<Header>(Header.class);
	     cr.getRequest().getAttributes().put(HeaderConstants.ATTRIBUTE_HEADERS, headers);
	    }
		headers.add(headerName, headerValue);
	}
	
	 	
	 
	public CrimeometerLLSearch getCrimeData(Double lat, Double lon) throws UnsupportedEncodingException {
		
		ClientResource cr=null;
		
		addHeader(cr, HTTP.CONTENT_TYPE, "application/json");			
		addHeader(cr, "x-api-key", Crimeometer_API_KEY);
		
		CrimeometerLLSearch crimedataSearch=null;
		
		String uri = "https://api.crimeometer.com/v1/incidents/raw-data?lat=" + lat + "&lon=" + lon + "&distance=15km&datetime_ini=2019-04-20T15:53:00.000Z&datetime_end=2020-04-20T15:53:00.000Z";
		
		log.log(Level.FINE, "Crimeometer URI: " + uri);
		
		try {
			cr = new ClientResource(uri);	
			crimedataSearch= cr.get(CrimeometerLLSearch.class);
		}
		
		catch (ResourceException re){
			System.err.println("Error getting crime data" + cr.getResponse().getStatus());
		}
		return crimedataSearch;
	}
}