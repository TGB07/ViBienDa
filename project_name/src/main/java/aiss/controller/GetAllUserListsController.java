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

public class GetAllUserListsController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(GetAllUserListsController.class.getName()); 
	
	public GetAllUserListsController() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * Obtenemos los parametros de la uri, en este caso para el OUATH obtenemos el code que se genera cuando el usuario acepta
		 * los terminos de condiciones y uso. (Ver vista para CallBackURI)
		 */
		
		String code = request.getParameter("code");
		
		FoursquareResource fsResource = new FoursquareResource();
		FoursquareToken fsAcessToken= fsResource.getFoursquareAccessToken(code);
		
		String accessToken = fsAcessToken.getAccessToken();
		
		request.setAttribute("accessToken", accessToken);
		
		log.log(Level.FINE, "AccessToken retrie ved " + accessToken);
		
		// Forward view
		request.getRequestDispatcher("/userVenuesView.jsp").forward(request, response);;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
