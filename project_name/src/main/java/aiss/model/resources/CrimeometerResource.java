package aiss.model.resources;

import java.io.IOException;
import java.util.logging.Logger;

import org.apache.http.protocol.HTTP;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import aiss.model.crimeometer.CrimeStatsLLSearch;

public class CrimeometerResource {
	
	private static final String Crimeometer_API_KEY = "k3RAzKN1Ag14xTPlculT39RZb38LGgsG8n27ZycG";
	private static final Logger log = Logger.getLogger(CrimeometerResource.class.getName());
	public static final MediaType JSON= MediaType.parse("application/json; charset=utf-8");
		 	
	 
	public CrimeStatsLLSearch getCrimeStatsLL(Double lat, Double lon) throws IOException {
		
		String uri = "https://api.crimeometer.com/v1/incidents/stats?lat="+ lat + "&lon=" + lon + "&distance=15km&datetime_ini=2019-04-20T15:53:00.000Z&datetime_end=2020-04-20T15:53:00.000Z&source=0";
		
		OkHttpClient client = new OkHttpClient();
						
		Request request = new Request.Builder()
				.addHeader(HTTP.CONTENT_TYPE, "application/json")
				.addHeader("x-api-key", Crimeometer_API_KEY)
                .url(uri)
                .build();
		
		Response response = client.newCall(request).execute();
						
		//Definimos ObjectMapper para extraer el cuerpo de la respuesta:

		ObjectMapper mapper = new ObjectMapper();

		 //Extraemos el cuerpo de la respuesta:

		 JsonNode jsonNode = mapper.readTree(response.body().string());

		 //Y lo convertimos en cadena de texto

		String JSONContent = jsonNode.toString();
		 
		//Finalmente, usamos otro ObjectMapper para convertir el texto en objecto Java

		ObjectMapper mapper2 = new ObjectMapper();

		CrimeStatsLLSearch search = mapper2.readValue(JSONContent, CrimeStatsLLSearch.class);                        

		return search;
	}
}