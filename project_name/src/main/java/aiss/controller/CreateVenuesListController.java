package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resources.FoursquareResource;

public class CreateVenuesListController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(CreateVenuesListController.class.getName()); 
	
	public CreateVenuesListController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//	Code a recibido a traves de la autenticacion
		String code = request.getParameter("code");
		request.setAttribute("code", code);
		
		//	Comprobamos la respuesta del code
		if(code != null || "".equals(code)) {	
			
			FoursquareResource fsResource = new FoursquareResource();
			//	Peticion del token
			String accessToken= fsResource.getFoursquareAccessToken(code);
			request.setAttribute("accessToken", accessToken);
			
			log.log(Level.FINE, "AccessToken retrieved " + accessToken);
			
			//	Parametros necesarios para crear una lista
			String name= request.getParameter("name");
			String descripcion= request.getParameter("descripcion");
			
			//	Creamos la lista
			boolean result= fsResource.createList(accessToken, name, descripcion);
			
			request.setAttribute("createUserList", result);
			
			//	Redirigimos a la vista de listas del usuario
			request.getRequestDispatcher("/GetAllUserListsController").forward(request, response);
		}
		else {
			//	Si el code es nulo redirigimos a la autenticacion
			log.log(Level.FINE, "Accediendo a usuario sin token, se devuelve a la vista de datos de nuevo");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}