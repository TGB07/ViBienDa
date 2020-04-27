package aiss.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.foursquare.FoursquareSearch;
import aiss.model.foursquare.Item;
import aiss.model.foursquare.Venue;
import aiss.model.opencage.Geometry;
import aiss.model.opencage.LLNameSearch;
import aiss.model.opencage.Result;
import aiss.model.resources.FoursquareResource;
import aiss.model.resources.OpenCageResource;

/**
 * Servlet implementation class SearchController
 */
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger log = Logger.getLogger(SearchController.class.getName());
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		
//		String query = request.getParameter("reqVal");	//	Tomamos la query del input con name bar que forma la search bar
//		System.out.println("============================================================================"+query);
//		String[] s = query.split(";");
//		Double lat = Double.parseDouble(s[0]);
//		Double lon = Double.parseDouble(s[1]);
//		request.setAttribute("lat", lat);
//		request.setAttribute("lon", lon);
//		
//		//Forward view
//		request.getRequestDispatcher("/generalStatsView.jsp").forward(request, response);

		//////////////////////////////////////////////////////////////////////////////////////////
			
		String query = request.getParameter("bar");	//	Tomamos la query del input con name bar que forma la search bar
		
		//	Load coordinates
		OpenCageResource ocResource = new OpenCageResource();
		LLNameSearch ocrResponse = ocResource.getLatitudLongitud(query);
		List<Result> results = ocrResponse.getResults();
		Double lat, lon;
		
		if(results!=null && !results.isEmpty()) {
			Geometry g = results.get(0).getGeometry();
			lat = g.getLat();
			lon = g.getLng();
			request.setAttribute("lat", lat);
			request.setAttribute("lon", lon);
			
//			//	Load crime data
//			CrimeometerResource coResource = new CrimeometerResource();
//			CrimeometerLLSearch coResponse = coResource.getCrimeData(lat, lon);
//			Integer totalDelitos = coResponse.getTotalIncidents();
//			Map<String, Long> incidenteTotal = new HashMap<String, Long>();
//			
//			if(totalDelitos==0) {
//				log.log(Level.INFO, "No crime data at the given location");
//			} else {
//
//			List<Incident> incidentes = coResponse.getIncidents();
//
//				 for(Incident i : incidentes){
//			            String tipo = i.getIncidentOffense();
//			            if(!incidenteTotal.containsKey(tipo)){
//			                incidenteTotal.put(tipo, 1L);
//			            } else {
//			                incidenteTotal.put(tipo, incidenteTotal.get(tipo)+1);
//			            }
//			        }
//						
//		//coResponse.getIncidents().parallelStream().collect(Collectors.groupingBy(i -> i.getIncidentOffense(), Collectors.counting()));
//				 
//				//	Calculamos los porcentajes asociados a los distintos tipos de delitos
//				for(Map.Entry<String, Long> entry: incidenteTotal.entrySet()) {
//					incidenteTotal.put(entry.getKey(), entry.getValue()/totalDelitos*100);
//				}
//			}
//			request.setAttribute("incidentes", incidenteTotal);
			
			//	Load recommended venues
			
			FoursquareResource fsResource = new FoursquareResource();
			FoursquareSearch fsSearch = fsResource.getRecommendedVenues(lat, lon);
			List<Item> items = fsSearch.getResponse().getGroups().get(0).getItems();

			if(items!=null && !items.isEmpty()) {
				
				List<Venue> venues=new ArrayList<Venue>();
				
				for (int i = 0; i < items.size(); i++) {
					venues.add(items.get(i).getVenue());
				}
				
//				List<Venue> venues = items.stream().map(i -> i.getVenue()).collect(Collectors.toList());
				request.setAttribute("venues", venues);
			} else {
				log.log(Level.INFO, "No recommended venues at the given location");
			}
			
			//Forward view
			request.getRequestDispatcher("/generalStatsView.jsp").forward(request, response);

		} else {
			log.log(Level.WARNING, "No coordinates for the given location");
			
			//Redirigimos a la pagina de error ya que este atributo es necesario
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}