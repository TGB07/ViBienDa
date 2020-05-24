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
		
		//	Code necesario para obtener posteriormente el accessToken de OAuth
		HttpSession session = request.getSession();		
		String code = (String) session.getAttribute("code");
		request.setAttribute("code", code);
		
		//	Comprobamos la respuesta del code
		if (code!=null || "".equals(code) ) {
			
			FoursquareResource fsResource = new FoursquareResource();
			//	Peticion del token
			String accessToken= fsResource.getFoursquareAccessToken(code);
			request.setAttribute("accessToken", accessToken);
			
			//	Parametros necesarios para añadir una venue a una lista
			String listId= request.getParameter("listId");
			String venueId= request.getParameter("venueId");
			
			//	Añadimos la venue a la lista
			boolean result = fsResource.addVenue(accessToken, listId, venueId);
	
			request.setAttribute("addVenueToList", result);
			
			//	Redirigimos a la vista de listas del usuario
			request.getRequestDispatcher("/GetAllUserListsController").forward(request, response);
		} else {
			//	Si el code es nulo redirigimos a la autenticacion
			log.log(Level.WARNING, "No se ha iniciado sesion, debe iniciarla en la pagina de Foursquare");
			response.sendRedirect("https://foursquare.com/oauth2/authenticate?client_id=YRUTVRBHN10TPG4FAI5HJ1PLV4VIFBL10TSFWT13DAWA4KBD&response_type=code&redirect_uri=http://localhost:8090/GetAllUserListsController");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
