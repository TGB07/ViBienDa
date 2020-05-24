package aiss.model.resources;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.http.protocol.HTTP;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import aiss.model.crimeometer.CrimeStatsLLSearch;

public class CrimeometerResource {
	
	//	TEST API KEY
//	private static final String Crimeometer_API_KEY = "k3RAzKN1Ag14xTPlculT39RZb38LGgsG8n27ZycG";
	private static final String Crimeometer_API_KEY = "gE9XyNl7P4351razeB2Al3sE2yMOItV76iuOFIMT";
	
	private static final Logger log = Logger.getLogger(CrimeometerResource.class.getName());
	public static final MediaType JSON= MediaType.parse("application/json; charset=UTF-8");
	
	public CrimeStatsLLSearch getCrimeStatsLL(Double lat, Double lon) throws IOException {
		//	Establecemos un periodo si no es proporcionado en la request
		return getCrimeStatsLL(lat,lon,"2019-01-01T15:53:00.000Z","2020-01-01T15:53:00.000Z");
	}
	
	public CrimeStatsLLSearch getCrimeStatsLL(Double lat, Double lon, String dateIni, String dateFin) throws IOException {
				
		String uri = "https://api.crimeometer.com/v1/incidents/stats?lat="+ lat + "&lon=" + lon + "&distance=15km&datetime_ini="+dateIni+"&datetime_end="+dateFin+"&source=0";
		
		log.log(Level.FINE, "Crimeometer URI: " + uri);
		
		//	La peticion requiere el uso de cabeceras que añadimos a continuacion
		HttpUrl.Builder urlBuilder = HttpUrl.parse(uri).newBuilder();
		OkHttpClient client = new OkHttpClient();
						
		Request request = new Request.Builder()
				.addHeader(HTTP.CONTENT_TYPE, "application/json")
				.addHeader("x-api-key", Crimeometer_API_KEY)
                .url(urlBuilder.build().toString())
                .build();
		
		Response response = client.newCall(request).execute();
						
		//	Definimos ObjectMapper para extraer el cuerpo de la respuesta
		ObjectMapper mapper = new ObjectMapper();

		//	Extraemos el cuerpo de la respuesta y lo convertimos en cadena de texto
		JsonNode jsonNode = mapper.readTree(response.body().string());
		String JSONContent = jsonNode.toString();
		 
		//	Usamos otro ObjectMapper para convertir el texto en objecto Java
		ObjectMapper mapper2 = new ObjectMapper();

		CrimeStatsLLSearch search = mapper2.readValue(JSONContent, CrimeStatsLLSearch.class);                        
		return search;
	}
}