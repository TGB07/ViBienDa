package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;

import aiss.model.foursquare.FoursquareSearch;

public class FoursquareResource {
	
	private static final String Foursquare_Client_Id = "HADL3PWUYW1AT3W0XHX4MQALAY22K1RMD2JIUBX5HXPTJYNC";
	private static final String Foursquare_Client_Secret = "JR3ENW0XR5FAURWCPLZS5INDLFPB4IYOWYDNUXL0AXRWEGVT";

	private static final Logger log = Logger.getLogger(FoursquareResource.class.getName());
	
	public FoursquareSearch getRecommendedVenues(Double lat, Double lon) throws UnsupportedEncodingException {
		
		String uri = "http://api.foursquare.com/v2/venues/explore?client_id=" + Foursquare_Client_Id + "&client_secret=" + Foursquare_Client_Secret + "&ll=" + lat + "," + lon + "&v=20200101&radius=100&pretty=1";
		
		log.log(Level.FINE, "Foursquare URI: " + uri);
		
		ClientResource cr = new ClientResource(uri);
		FoursquareSearch recommendedVenues = cr.get(FoursquareSearch.class);
		
		return recommendedVenues;
	}

}
