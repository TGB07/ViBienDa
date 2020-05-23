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
		 * 	Para las noticias necesitamos:
		 * 		- q: keywords en el titulo y cuerpo de las noticias
		 * 		- qInTitle:	keywords en el titulo unicamente
		 * 		- from: tiempo inicio
		 * 		- to: tiempo fin
		 * 		- sortBy: {publishedAt, relevancy, popularity}
		 * 		- page: pagina de la consulta (20 predeterminado, 100 maximo)
		 */
		
		/*
		 * 	Reenviamos a traves de un form en generalStatsView.jsp los datos que necesitamos para la request
		 * 	siendo algunos de estos ocultos
		 */
		
		String localizacion = request.getParameter("loc");
		String tematica = request.getParameter("tematica");
		String orden = request.getParameter("orden");
		
		NewsResource newsResource = new NewsResource();
		/*	No tenemos que realizar un checkeo sobre si los parametros son nulos
		 * 	ya que obligamos en el form a insertar la tematica o la establecemos
		 * 	por defecto a una cadena vacia (para que aparezcan todo tipo de noticias)
		 * 	al igual que ponemos que el orden este predeterminado en uno de los tipos
		 * 	que esta puesto arriba
		 */
		
		NewsSearch newsResponse = newsResource.getNewsSearch(localizacion, tematica, orden);
		//	Hay que ver que conviene mas pasar como keyword en titulo o en general
		
		if(newsResponse.getTotalResults()==0) {
			log.log(Level.INFO, "No news available at the given location");
			//	Se deja constancia en el log, pero es en el jsp donde tenemos que indicar que no se han encontrado noticias
			//	mirando el tamaño de la lista de articulos que pasamos abajo en el jsp
			request.setAttribute("errorType", "NEWSERROR");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
		
		else {
		
		List<Article> articulos = newsResponse.getArticles();
		/*	De los articulos nos puede interesar:
		 * 		- title
		 * 		- description
		 * 		x content -> Lo descarto porque con la descripcion tenemos un resumen
		 * 		- url: Para que el usuario pueda ir a la noticia
		 * 		- urlToImage: Mostramos la imagen dada en la noticia en pequeño
		 * 
		 * 	Le pasaremos al jsp la lista de articulos que procesaremos en este (parece que en el de 4square/crimeometer habeis usado string pero se pueden objetos)
		 */
				
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