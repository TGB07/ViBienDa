package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.news.NewsSearch;


public class NewsResource {

	//private static final String NEWS_API_KEY = "07cecfd3cd97455b87fae72871cefe05";
	private static final String NEWS_API_KEY = "32ac6198302142a7935dfae92fd12d99";
	private static final Logger log = Logger.getLogger(NewsResource.class.getName());

	public NewsSearch getNewsSearch(String keywords, String keywordsTitulo, String orden) throws UnsupportedEncodingException {

		ClientResource cr = null;
		NewsSearch newsSearch=null;
		
		//String queryFormatted = URLEncoder.encode(query, "UTF-8");
		//String uri = "https://newsapi.org/v2/everything?q=" + queryFormatted + "&apiKey=" + NEWS_API_KEY;
		
		String keywordsEncoded = URLEncoder.encode(keywords, "UTF-8");
		String keywordsTituloEncoded = URLEncoder.encode(keywords, "UTF-8");
		/*
		 * 	Puede que haya que hacer un procesado de los parametros de orden si no se puede establecer
		 * 	una correspondencia entre la eleccion en el form y los que acepta la request (creo que si se
		 * 	puede con un multiple, pero no estoy seguro)
		 * 
		 */
		
		String uri = "https://newsapi.org/v2/everything?q=" + keywordsEncoded + "&qInTitle=" + keywordsTituloEncoded + "&sortBy=" + orden + "&apiKey=" + NEWS_API_KEY;
		
		log.log(Level.FINE, "NewsAPI URI: " + uri);
		
		try {
			cr = new ClientResource(uri);
			newsSearch = cr.get(NewsSearch.class);
		}
		catch (ResourceException re){
			System.err.println("Error when retrieving the news with that query" + cr.getResponse().getStatus());
		}
		return newsSearch;
	}
}