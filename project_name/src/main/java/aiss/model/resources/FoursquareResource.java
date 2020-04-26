package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.foursquare.FoursquareSearch;

public class FoursquareResource {
	
	private static final String Foursquare_Client_Id = "HADL3PWUYW1AT3W0XHX4MQALAY22K1RMD2JIUBX5HXPTJYNC";
	private static final String Foursquare_Client_Secret = "JR3ENW0XR5FAURWCPLZS5INDLFPB4IYOWYDNUXL0AXRWEGVT";

	private static final Logger log = Logger.getLogger(FoursquareResource.class.getName());
	
	public FoursquareSearch getRecommendedVenues(Double lat, Double lon) throws UnsupportedEncodingException {
		
		ClientResource cr=null;
		FoursquareSearch recommendedVenues=null; 
		
		String uri = "https://api.foursquare.com/v2/venues/explore?client_id=" + Foursquare_Client_Id + "&client_secret=" + Foursquare_Client_Secret + "&ll=" + lat + "," + lon + "&v=20200101&radius=100&pretty=1";
		
		log.log(Level.FINE, "Foursquare URI: " + uri);
		
		try {
			cr = new ClientResource(uri);
			recommendedVenues = cr.get(FoursquareSearch.class);
		}
		catch (ResourceException re){
			System.err.println("Error when retrieving the recommendedVenues" + cr.getResponse().getStatus());
		}
		return recommendedVenues;
	}

}
