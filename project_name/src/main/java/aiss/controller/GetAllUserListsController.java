package aiss.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aiss.model.foursquare.list.FoursquareList;
import aiss.model.foursquare.list.Item_;
import aiss.model.foursquare.listD.Venue;
import aiss.model.resources.FoursquareResource;

public class GetAllUserListsController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(GetAllUserListsController.class.getName());

	public GetAllUserListsController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * Obtenemos los parametros de la uri, en este caso para el OUATH obtenemos el
		 * code que se genera cuando el usuario acepta los terminos de condiciones y
		 * uso.
		 */
		
		String code = request.getParameter("code");

		//	Obtenemos la variable de sesion
		HttpSession session = request.getSession();
		//	Añadimos a la sesion el codigo asociado a nuestra cuenta proporcionado
		session.setAttribute("code", code);
		//	Añadimos a la request el codigo asociado a nuestra cuenta proporcionado
		request.setAttribute("code", code);

		//	Si el codigo devuelto no es nulo
		if (code != null) {
			
			//	Obtenemos el token a traves de otro endpoint en la API
			FoursquareResource fsResource = new FoursquareResource();
			String accessToken = fsResource.getFoursquareAccessToken(code);
			
			//	Añadimos a sesion el token para futuros accesos
			session.setAttribute("accessToken", accessToken);
			//	Añadimos a la request el token para futuros accesos
			request.setAttribute("accessToken", accessToken);

			log.log(Level.FINE, "AccessToken retrieved " + accessToken);

			//	Realizamos la peticion de las listas del usuario
			FoursquareList fl = fsResource.getUserLists(accessToken);
			
			//	Comprobamos que la respuesta sea la correcta
			if (fl == null) {
				log.log(Level.WARNING, "ERROR RETRIEVING USERS LIST. RETURNING TO INDEX");
				request.setAttribute("errorType", "TOKENERROR");
				request.getRequestDispatcher("GetAllUserListsController").forward(request, response);
			} else {
				//	Obtenemos los objetos asociados a las listas
				List<Item_> listaDelUsuario = fl.getResponse().getLists().getItems();
				
				//	Procesamos en un map los nombres de las listas y sus datos asociados (id, descripcion, venues, etc)
				Map<String, List<Object>> m = new HashMap<String, List<Object>>();
				for (int i = 0; i < listaDelUsuario.size(); i++) {
					//	Obtenemos los datos de la lista
					Item_ lista = listaDelUsuario.get(i);
					String id = lista.getId();
					String name = lista.getName();
					aiss.model.foursquare.listD.List detalles = fsResource.getVenuesList(accessToken, id).getResponse()
							.getList();
					String description = detalles.getDescription();
					Integer followers = detalles.getFollowers().getCount();
					List<aiss.model.foursquare.listD.Item_> listaDeItems = detalles.getListItems().getItems();

					List<Venue> venues = new ArrayList<Venue>();
					for (int j = 0; j < listaDeItems.size(); j++) {
						venues.add(listaDeItems.get(j).getVenue());
					}
					
					//	Añadimos a una lista los datos mas relevantes para añadirlos a la sesion
					List<Object> s = new ArrayList<Object>();
					s.add(id);
					s.add(description);
					s.add(followers);
					s.add(venues);
					
					session.setAttribute(name, id);
			
					if (!m.containsKey(name)) {
						m.put(name, s);
					} else {
						List<Object> l = m.get(name);
						l.add(s);
						m.put(name, s);
					}
				}
				//	Mantenemos en sesion los nombres de las listas para procesarlos en jsp
				List<String> listNames = new ArrayList<String>(m.keySet());
				session.setAttribute("nombresListas", listNames);

				request.setAttribute("listasLugares", m);
				
				// Forward view
				request.getRequestDispatcher("/userVenuesView.jsp").forward(request, response);
			}
		} else {
			log.log(Level.FINE, "Accediendo a usuario sin token, se devuelve a la vista de datos de nuevo");
			request.setAttribute("errorType", "TOKENERROR");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
