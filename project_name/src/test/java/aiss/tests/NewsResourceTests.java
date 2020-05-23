package aiss.tests;

import static org.junit.Assert.assertNotNull;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import aiss.model.news.NewsSearch;
import aiss.model.resources.NewsResource;

public class NewsResourceTests {

	NewsResource nResource = new NewsResource();
	
	@Test
	public void testGetNews() throws UnsupportedEncodingException {
		String keywords = "Avispa";
		String keywordsTitulo = "Letal";
		String orden = "popularity";
		System.out.println("Test NewsAPI: Probando búsqueda de noticias con '" + keywords + "' y '" + keywordsTitulo + "' ordenado por " + orden);
		NewsSearch res = nResource.getNewsSearch(keywords, keywordsTitulo, orden);
		
		if(res.getTotalResults()==0) {
			res = null;
		}
		if(res != null) {
			System.out.println("Búsqueda correcta.");
		}
		assertNotNull("Los resultados no pueden estar vacíos.", res);
	}
	
}
