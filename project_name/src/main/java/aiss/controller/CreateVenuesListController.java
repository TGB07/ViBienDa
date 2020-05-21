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

public class CreateVenuesListController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(CreateVenuesListController.class.getName()); 
	
	public CreateVenuesListController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String code = request.getParameter("code");
		
		request.setAttribute("code", code);
		
		if(code != null || "".equals(code)) {	
			FoursquareResource fsResource = new FoursquareResource();
			FoursquareToken fsAcessToken= fsResource.getFoursquareAccessToken(code);
			
			String accessToken = fsAcessToken.getAccessToken();
			request.setAttribute("accessToken", accessToken);
			
			log.log(Level.FINE, "AccessToken retrieved " + accessToken);
			
			String name= request.getParameter("name");
			String descripcion= request.getParameter("descripcion");
			
			boolean result= fsResource.createList(accessToken, name, descripcion);
			
			request.setAttribute("createUserList", result);
						
			request.getRequestDispatcher("/GetAllUserListsController").forward(request, response);
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