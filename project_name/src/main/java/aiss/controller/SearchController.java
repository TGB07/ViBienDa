package aiss.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.resteasy.core.NoMessageBodyWriterFoundFailure;

import aiss.model.crimeometer.CrimeStatsLLSearch;
import aiss.model.crimeometer.ReportType;
import aiss.model.foursquare.FoursquareSearch;
import aiss.model.foursquare.Response;
import aiss.model.foursquare.Venue;
import aiss.model.opencage.Geometry;
import aiss.model.opencage.LLNameSearch;
import aiss.model.opencage.Result;
import aiss.model.resources.CrimeometerResource;
import aiss.model.resources.FoursquareResource;
import aiss.model.resources.OpenCageResource;

/**
 * Servlet implementation class SearchController
 */
@SuppressWarnings("unused")
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Parametro de busqueda

		// Cadena insertada en la barra de busqueda
		String barQuery = request.getParameter("bar");
		OpenCageResource ocResource = new OpenCageResource();

		// Parametros de la busqueda (lat, lon, radio)
		Double lat = null, lon = null;
		Double radio = 10.;
		if (barQuery == null) {
			// Se ha realizado el request a traves del mapa interactivo

			lat = Double.parseDouble(request.getParameter("lat"));
			lon = Double.parseDouble(request.getParameter("lon"));
			radio = Double.parseDouble(request.getParameter("radio"));

			// Obtenemos el nombre a partir de las coordenadas
			LLNameSearch LLtoName = ocResource.getNombreLL(lat, lon);

			if (LLtoName.getResults() != null && LLtoName.getResults().size() >= 1) {
				String nombreLL = LLtoName.getResults().get(0).getComponents().getCounty().replace("County", "");

				// Añadimos los parametros de busqueda para usos posteriores
				request.setAttribute("lat", lat);
				request.setAttribute("lon", lon);
				request.setAttribute("nombreLL", nombreLL);

			} else {
				// Informamos del error
				log.log(Level.INFO, "LUGAR NO DISPONIBLE");
				// Establecemos el tipo de error
				request.setAttribute("errorType", "LLERROR");
				// Redirigimos a la vista de error
				request.getRequestDispatcher("/error.jsp").forward(request, response);
			}

		} else {
			// Se ha realizado el request a traves de la barra de busqueda

			// Cargamos las coordenadas asociadas a la query
			ocResource = new OpenCageResource();
			LLNameSearch ocrResponse = ocResource.getLatitudLongitud(barQuery);
			List<Result> results = ocrResponse.getResults();

			if (results != null && !results.isEmpty()) {
				// Obtenemos los valores de los parametros
				Geometry g = results.get(0).getGeometry();
				lat = g.getLat();
				lon = g.getLng();
				request.setAttribute("lat", lat);
				request.setAttribute("lon", lon);
			} else {
				log.log(Level.WARNING, "No coordinates for the given location");

				request.setAttribute("errorType", "LLERROR");
				// Redirigimos a la pagina de error ya que este atributo es necesario
				request.getRequestDispatcher("/error.jsp").forward(request, response);
			}
		}

////		Load crime data
//		CrimeometerResource coResource = new CrimeometerResource();
//
//		//	Crimenes a partir de las coordenadas		
//		CrimeStatsLLSearch coResponse = coResource.getCrimeStatsLL(lat, lon);
//
//		Integer totalDelitos = coResponse.getTotalIncidents();
//		
//		//	Procesamos los datos para obtener un resumen de los mismos
//		Map<String, Double> incidenteTotal = new HashMap<String, Double>();
//
//		if (totalDelitos == 0) {
//			//	Informamos de que no existen datos para la localizacion
//			log.log(Level.INFO, "No crime data at the given location");
//		} else {
//			//	Contamos el numero de incidentes de cada tipo
//			List<ReportType> reportes = coResponse.getReportTypes();
//
//			for (ReportType r : reportes) {
//				incidenteTotal.put(r.getType(), r.getCount().doubleValue());
//			}
//
//			// Calculamos los porcentajes asociados a los distintos tipos de delitos
//			for (Map.Entry<String, Double> entry : incidenteTotal.entrySet()) {
//				incidenteTotal.put(entry.getKey(), (entry.getValue().doubleValue() / totalDelitos) * 100);
//			}
//			request.setAttribute("incidentes", incidenteTotal);
//		}

		// INCIDENTES PARA PROBAR
		Map<String, Double> incidenteTotal = new HashMap<String, Double>();
		incidenteTotal.put("incidente1", 10.2);
		incidenteTotal.put("incidente2", 20.8);
		incidenteTotal.put("incidente3", 38.5);
		incidenteTotal.put("incidente4", 11.5);
		incidenteTotal.put("incidente5", 19.0);
		incidenteTotal.put("incidente6", 10.2);
		incidenteTotal.put("incidente7", 20.8);
		incidenteTotal.put("incidente8", 38.5);
		incidenteTotal.put("incidente9", 11.5);
		incidenteTotal.put("incidente10", 19.0);
		request.setAttribute("incidentes", incidenteTotal);

		// Load recommended venues

		FoursquareResource fsResource = new FoursquareResource();
		FoursquareSearch fsSearch = fsResource.getRecommendedVenues(lat, lon, radio);

		Venue item = null;
		List<String> lVenues = new ArrayList<String>();

		if (fsSearch != null) {
			//	Guardamos la lista de lugares recomendados
			List<Venue> items = fsSearch.getResponse().getVenues();

			if (items != null && !items.isEmpty()) {
				request.setAttribute("lVenues", items);
			} else {
				log.log(Level.INFO, "No recommended venues at the given location");
			}
		}

		// Forward view
		request.getRequestDispatcher("/generalStatsView.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}