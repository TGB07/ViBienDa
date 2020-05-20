package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.foursquare.FoursquareToken;
import aiss.model.resources.FoursquareResource;

public class DeleteVenueFromListController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(DeleteVenueFromListController.class.getName()); 
	
	public DeleteVenueFromListController() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String code = request.getParameter("code");
		
		request.setAttribute("code", code);
		
		if(code!=null) {
			FoursquareResource fsResource = new FoursquareResource();
			FoursquareToken fsAcessToken= fsResource.getFoursquareAccessToken(code);
			
			String accessToken = fsAcessToken.getAccessToken();
			request.setAttribute("accessToken", accessToken);	
			
			String listId= request.getParameter("listId");
			String venueId= request.getParameter("venueId");
			
			boolean result = fsResource.deleteVenue(accessToken, listId, venueId);
			
			request.setAttribute("deleteVenueList", result);	
		}		
		else {
			log.log(Level.FINE, "Accediendo a usuario sin token, se devuelve a la vista de datos de nuevo");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
