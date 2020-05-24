package aiss.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.news.Article;
import aiss.model.news.NewsSearch;
import aiss.model.resources.NewsResource;

/**
 * Servlet implementation class SearchController
 */
public class NewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(NewsController.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewsController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * Para las noticias tomamos: - q: keywords en el titulo y cuerpo de las
		 * noticias - qInTitle: keywords en el titulo unicamente - from: tiempo inicio -
		 * to: tiempo fin - sortBy: {publishedAt, relevancy, popularity} - page: pagina
		 * de la consulta (20 predeterminado, 100 maximo)
		 * 
		 */

		/*
		 * Obtenemos de generalStatsView.jsp los datos necesarios para la request. No
		 * tenemos que realizar un checkeo sobre si los parametros son nulos. Obligamos
		 * en el form a insertar la tematica o la establecemos por defecto a una cadena
		 * vacia (para que aparezcan todo tipo de noticias) al igual que ponemos un
		 * orden predeterminado.
		 */
		String localizacion = request.getParameter("loc");
		String tematica = request.getParameter("tematica");
		String orden = request.getParameter("orden");

		NewsResource newsResource = new NewsResource();
		// Realizamos la busqueda de noticias por zona, tematica y orden
		NewsSearch newsResponse = newsResource.getNewsSearch(localizacion, tematica, orden);

		if (newsResponse == null) {
			// No suponen un error, dejamos constancia en el log
			log.log(Level.INFO, "No news available at the given location");
			request.setAttribute("errorType", "NEWSERROR");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		} else {
			//	Obtenemos los articulos asociados a la busqueda
			List<Article> articulos = newsResponse.getArticles();
			
			//	Añadimos los articulos a la request para procesarlos en la vista
			request.setAttribute("articulos", articulos);

			// Forward view
			request.getRequestDispatcher("/newsView.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}