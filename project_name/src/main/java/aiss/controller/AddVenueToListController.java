package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aiss.model.resources.FoursquareResource;

public class AddVenueToListController extends HttpServlet {
		
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(AddVenueToListController.class.getName()); 
	
	public AddVenueToListController() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();		
		String code = (String) session.getAttribute("code");
		request.setAttribute("code", code);
				
		if (code!=null || "".equals(code) ) {
			
			FoursquareResource fsResource = new FoursquareResource();
			String accessToken= fsResource.getFoursquareAccessToken(code);
			request.setAttribute("accessToken", accessToken);
			
			String listId= request.getParameter("listId");
			String venueId= request.getParameter("venueId");
			
			boolean result = fsResource.addVenue(accessToken, listId, venueId);
	
			request.setAttribute("addVenueToList", result);
			
			request.getRequestDispatcher("/GetAllUserListsController").forward(request, response);
		} else {
			log.log(Level.FINE, "Accediendo a usuario sin token, se devuelve a la vista de datos de nuevo");
			response.sendRedirect("https://foursquare.com/oauth2/authenticate?client_id=YRUTVRBHN10TPG4FAI5HJ1PLV4VIFBL10TSFWT13DAWA4KBD&response_type=code&redirect_uri=http://localhost:8090/GetAllUserListsController");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
