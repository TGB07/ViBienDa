package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.foursquare.FoursquareSearch;
import aiss.model.foursquare.FoursquareToken;
import aiss.model.foursquare.list.FoursquareList;
import aiss.model.foursquare.listD.FoursquareListDetails;

public class FoursquareResource {
	
	//ID CUENTA PRINCIPAL MAIN NO BORRAR
//	private static final String Foursquare_Client_Id = "HADL3PWUYW1AT3W0XHX4MQALAY22K1RMD2JIUBX5HXPTJYNC";
//	private static final String Foursquare_Client_Secret = "JR3ENW0XR5FAURWCPLZS5INDLFPB4IYOWYDNUXL0AXRWEGVT";
	
	private static final String Foursquare_Client_Id = "YRUTVRBHN10TPG4FAI5HJ1PLV4VIFBL10TSFWT13DAWA4KBD";
	private static final String Foursquare_Client_Secret = "FQIHWAEF3FXIXIBY1JHRB2ZRV1LISTUXSTYMQNUMHP4B1M55";
	private static final String CALLBACK_URI = "http://localhost:8090/GetAllUserListsController";

	private static final Logger log = Logger.getLogger(FoursquareResource.class.getName());
		
	public FoursquareSearch getRecommendedVenues(Double lat, Double lon, Double radio) throws UnsupportedEncodingException {
		
		ClientResource cr=null;
		FoursquareSearch recommendedVenues=null;
		
		String uri = "https://api.foursquare.com/v2/venues/search?client_id=" + Foursquare_Client_Id + "&client_secret=" + Foursquare_Client_Secret + "&ll=" + lat + "," + lon + "&v=20200101&intent=browse&limit=50&radius=" + radio*1000;
		
		log.log(Level.FINE, "Foursquare getVenues URI: " + uri);
		
		try {
			cr = new ClientResource(uri);
			recommendedVenues = cr.get(FoursquareSearch.class);
		}
		catch (ResourceException re){
			System.err.println("Error when retrieving the recommendedVenues" + cr.getResponse().getStatus());
		}
		return recommendedVenues;
	}
	
	public String getFoursquareAccessToken(String code) throws UnsupportedEncodingException {
		ClientResource cr = null;
				
		String uri = "https://foursquare.com/oauth2/access_token?client_id=" + Foursquare_Client_Id + "&client_secret=" + Foursquare_Client_Secret + "&grant_type=authorization_code&redirect_uri=" + CALLBACK_URI + "&code=" + code;
		log.log(Level.FINE, "FoursquareAccessToken URI: " + uri);
		
		String result="";
		
		try {
			cr = new ClientResource(uri);
			cr.setEntityBuffering(true);
			result= cr.post("",FoursquareToken.class).getAccessToken();
			
			result = cr.get(FoursquareToken.class).getAccessToken();
		}
		catch (ResourceException re) {
			System.err.println("Error when retrieving the accessToken" + cr.getResponse().getStatus());
		}
		return result;
	}
	
	public FoursquareList getUserLists(String token) throws UnsupportedEncodingException{
		
		ClientResource cr = null;
		FoursquareList fl= null;
		
		//PARAMETRO self para usuario actual
		String uri = "https://api.foursquare.com/v2/users/self/lists?oauth_token=" + token + "&group=created" + "&v=20200101";
		log.log(Level.FINE, "FoursquareGetUserLists URI:" + uri);
		
		try {
			cr= new ClientResource(uri);
			fl= cr.get(FoursquareList.class);
		}
		catch (ResourceException re) {
			System.err.println("Error when retrieving the userLists" + cr.getResponse().getStatus());
		}
		
		return fl;
	}
	
	public boolean addVenue(String token, String listId, String venueId) throws UnsupportedEncodingException {
		
		ClientResource cr = null;
		boolean result=true;
		
		String uri = "https://api.foursquare.com/v2/lists/" + listId + "/additem?oauth_token=" + token + "&venueId=" + venueId + "&v=20200101";
		System.out.println(uri);
		log.log(Level.FINE, "Foursquare AddVenue URI:" + uri);
		
		try {
			cr = new ClientResource(uri);
			cr.post(" ");
		}
		catch (ResourceException re) {
			result=false;
			System.err.println("Error when adding a venue to the list" + cr.getResponse().getStatus());
		}
		return result;
	}
	
	public boolean createList(String token, String name, String descripcion) throws UnsupportedEncodingException {
		
		ClientResource cr = null;
		boolean result=true;
		
		String uri = "https://api.foursquare.com/v2/lists/add?oauth_token=" + token + "&name=" + name + "&description=" + descripcion + "&v=20200101";
		log.log(Level.FINE, "Foursquare CreateList URI:" + uri);

		try {
			cr = new ClientResource(uri);
			cr.post(" ");
		}
		catch (ResourceException re) {
			result=false;
			System.err.println("Error when creating a list" + cr.getResponse().getStatus());
		}
		return result;
	}
	
	public FoursquareListDetails getVenuesList(String token, String listId) throws UnsupportedEncodingException {
		
		ClientResource cr= null;
		FoursquareListDetails fld=null;
		
		String uri= "https://api.foursquare.com/v2/lists/" + listId + "?oauth_token=" + token + "&v=20200101";
		log.log(Level.FINE, "Foursquare VenuesListDetails URI:" + uri);
		
		try {
			cr= new ClientResource(uri);
			fld= cr.get(FoursquareListDetails.class);
		}
		catch(ResourceException re) {
			System.err.println("Error when retriving the details of a user list" + cr.getResponse().getStatus());
		}
		return fld;
	}
	
}