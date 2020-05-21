package aiss.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.foursquare.FoursquareToken;
import aiss.model.foursquare.list.FoursquareList;
import aiss.model.foursquare.list.Item_;
import aiss.model.foursquare.list.Photo_;
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
		
		request.setAttribute("code", code);
		
		if(code!=null || "".equals(code)) {
			
			FoursquareResource fsResource = new FoursquareResource();
			FoursquareToken fsAcessToken= fsResource.getFoursquareAccessToken(code);
			
			String accessToken = fsAcessToken.getAccessToken();
			request.setAttribute("accessToken", accessToken);
						
			log.log(Level.FINE, "AccessToken retrieved " + accessToken);
					
			FoursquareList fl = fsResource.getUserLists(accessToken);
			
			List<Item_> listaDelUsuario = fl.getResponse().getLists().getItems();
			Map<String, String> infoListasDelUsuario = new HashMap<String, String>();//clave: id lista; valor: nombre lista 
			List<aiss.model.foursquare.listD.List> detallesListaUsuario = new ArrayList<aiss.model.foursquare.listD.List>();
			
			//	[nombre | descripcion, followers, photo, venues]
			Map<String, Set<Object>> m = new HashMap<String, Set<Object>>();
			for(int i = 0; i<listaDelUsuario.size(); i++) {
				Item_ lista = listaDelUsuario.get(i);
				String id = lista.getId();
				String name = lista.getName();
				Photo_ photo = lista.getPhoto(); 
				
				if(!m.containsKey(name)) {
					aiss.model.foursquare.listD.List detalles = fsResource.getVenuesList(accessToken, id).getResponse().getList();
					String description = detalles.getDescription();
					Integer followers = detalles.getFollowers().getCount();
					List<aiss.model.foursquare.listD.Item_> venues = detalles.getListItems().getItems();
					
					Set<Object> s = new HashSet<Object>();
					s.add(description);
					s.add(followers);
					s.add(venues);
					m.put(name, s);
				}
			}
			
			request.setAttribute("listasLugares", m);
			
//			for (int i = 0; i < listaDelUsuario.size(); i++) {
//				String id= listaDelUsuario.get(i).getId();
//				String nLista= listaDelUsuario.get(i).getName();
//				infoListasDelUsuario.put(id, nLista);
//				detallesListaUsuario.add(fsResource.getVenuesList(accessToken, id).getResponse().getList());
//			}
			
//			request.setAttribute("infoListasDelUsuario", infoListasDelUsuario);
//			request.setAttribute("listaDelUsuario", listaDelUsuario);
//			request.setAttribute("detallesListaUsuario", detallesListaUsuario);
			
			// Forward view
			request.getRequestDispatcher("/userVenuesView.jsp").forward(request, response);
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
