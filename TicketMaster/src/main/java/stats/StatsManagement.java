package stats;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import exception.VoidGetException;
import exception.WrongCountryException;
import exception.WrongGenreException;

/** Questa classe contiene i metodi che permettono di gestire le chiamate api al server di Ticketmaster. 
 * 
 * @author Domenico Ciavarella
 * @author Daniele Cota
 *
 */
public class StatsManagement implements Stats {
	
	private String apikey = "7elxdku9GGG5k8j0Xm8KWdANDgecHMV0";
	
	LocalDateTime data = LocalDateTime.now();
	
	VoidGetException Exception = new VoidGetException();
	
	IDconverter converter = new IDconverter();
	
	/** Questo metodo va a prendere da TicketMaster gli eventi in un paese tramite il suo countryCode.
	 * 
	 * @param countryCode
	 * 
	 * @return un JSONObject contenente tutti gli eventi che si svolgono in un determinato paese.
	 * 
	 * @throws WrongCountryException
	 */
	
	public JSONObject getCountryEvents (String countryCode)  throws WrongCountryException {
		
		Exception.countryStringException(countryCode);
		
		JSONObject countryEventsObject;
		
		String Url = "https://app.ticketmaster.com/discovery/v2/events?locale=*&countryCode=" + countryCode + "&apikey=" + apikey;
		
		RestTemplate restTemplate = new RestTemplate();
		
		countryEventsObject = new JSONObject(restTemplate.getForObject(Url, String.class));
		
		JSONObject pageObject = countryEventsObject.getJSONObject("page");
		int totalElements = pageObject.getInt("totalElements");
		
		JSONObject object = new JSONObject();
		
		object.put("country", countryCode);
		object.put("totalEvents", totalElements);
		
		return object;
		
	}
	
	
	/** Questo metodo va a prendere da TicketMaster gli eventi in un paese tramite il suo countryCode e li filtra in
	 * base al genere indicato.
	 * 
	 * @param countryCode
	 * @param genreName
	 * 
	 * @return un JSONObject contenente tutti gli eventi di un determinato genere che si svolgono in un paese.
	 * 
	 * @throws WrongCountryException
	 * @throws WrongGenreException
	 */
public JSONObject getGenreEvents (String countryCode, String genreName) throws WrongCountryException, WrongGenreException {
		
	Exception.countryStringException(countryCode);
	Exception.genreStringException(genreName);
	
	String genreId = converter.genreIdConverter(genreName);
		
		JSONObject genreEventsObject;
		
		String Url = "https://app.ticketmaster.com/discovery/v2/events?locale=*&countryCode=" + countryCode + "&genreId=" + genreId + "&apikey=" + apikey;
		
		RestTemplate restTemplate = new RestTemplate();
		
		genreEventsObject = new JSONObject(restTemplate.getForObject(Url, String.class));
		
		JSONObject pageObject = genreEventsObject.getJSONObject("page");
		int totalElements = pageObject.getInt("totalElements");
		
		JSONObject object = new JSONObject();
		
		object.put("country", countryCode);
		object.put("genre", genreName);
		object.put("totalEvents", totalElements);
		
		return object;
		
	}


/** Questo metodo va a prendere da TicketMaster gli eventi in un paese tramite il suo countryCode.
 * 
 * @param countryCode
 * @param  
 * 
 * @return un JSONObject contenente tutti gli eventi raggruppati per genere che si svolgono in un determinato paese.
 * 
 * @throws WrongCountryException
 */

public JSONObject getTotalGenre (String countryCode) throws WrongCountryException {
	
	Exception.countryStringException(countryCode);
	
	JSONObject countryEventsObject;
	JSONObject vuoto = new JSONObject();
	vuoto.put(countryCode,"non ha eventi");
	String Url = "https://app.ticketmaster.com/discovery/v2/events?locale=*&countryCode=" + countryCode + "&size=500&apikey=" + apikey;
	
	RestTemplate restTemplate = new RestTemplate();
	
	countryEventsObject = new JSONObject(restTemplate.getForObject(Url, String.class));
	
	JSONObject pageObject = countryEventsObject.getJSONObject("page");
	int totalElements = pageObject.getInt("totalElements");

	if (totalElements > 0 ) {
	JSONObject embeddedObject = countryEventsObject.getJSONObject("_embedded");
	
	JSONArray eventsArray = (JSONArray) embeddedObject.getJSONArray("events");
	AllGenres genres = new AllGenres();
	
	for (int i = 0; i < eventsArray.length(); i++) {
				
		JSONObject eventoTemp = (JSONObject) eventsArray.get(i);
	   if (eventoTemp.has("classifications")) { 
	   JSONArray classifications = (JSONArray) eventoTemp.get("classifications"); 
	     
		JSONObject classificationsTemp = (JSONObject) classifications.get(0);
		
		 if (classificationsTemp.has("genre")) { 

		JSONObject genreObject = (JSONObject) classificationsTemp.get("genre");
		String genrenameObject = (String) genreObject.getString("name");

		genres.CompareGenre(genrenameObject);
		
	   }
		 
	   }
	
	}
	
	JSONObject object = genres.getGenres();
	
return object;
	}
	
	else return vuoto;
	



	
}



/** Questo metodo va a prendere da TicketMaster gli eventi mensili che si svolgono
 *  in un determinato paese tramite il suo countryCode.
 * 
 * @param countryCode
 * 
 * @return un JSONObject contenente tutti gli eventi mensili che si svolgono in un determinato paese.
 * 
 * @throws WrongCountryException
 */

public JSONObject getCountryStats (String countryCode)  throws WrongCountryException {
	
	Exception.countryStringException(countryCode);
	
	JSONObject countryEventsObject;
	
	data = data.truncatedTo(ChronoUnit.SECONDS);
	
	String Url = "https://app.ticketmaster.com/discovery/v2/events?locale=*&countryCode=" + countryCode + "&endDateTime=" + data.plusMonths(1) + "Z&apikey=" + apikey;
	
	RestTemplate restTemplate = new RestTemplate();
	
	countryEventsObject = new JSONObject(restTemplate.getForObject(Url, String.class));
	
	JSONObject pageObject = countryEventsObject.getJSONObject("page");
	int totalElements = pageObject.getInt("totalElements");
	
	JSONObject object = new JSONObject();
	
	object.put("country", countryCode);
	object.put("totalEvents", totalElements);
	
	return object;
	
}


/** Questo metodo va a prendere da TicketMaster gli eventi mensili che si svolgono
 *  in un determinato paese tramite il suo countryCode e li filtra in base al genere indicato.
 * 
 * @param countryCode
 * @param genreName
 * @return un JSONObject contenente tutti gli eventi mensili che si svolgono in un determinato paese.
 * 
 * @throws WrongCountryException
 */


public JSONObject getGenreStats (String countryCode, String genreName) throws WrongCountryException, WrongGenreException {
	
	Exception.countryStringException(countryCode);
	Exception.genreStringException(genreName);
	String genreId = converter.genreIdConverter(genreName);
		
		JSONObject countryEventsObject;
		
		data = data.truncatedTo(ChronoUnit.SECONDS);
		
		String Url = "https://app.ticketmaster.com/discovery/v2/events?locale=*&countryCode=" + countryCode + "&genreId=" + genreId + "&endDateTime=" + data.plusMonths(1) + "Z&apikey=" + apikey;
		
		RestTemplate restTemplate = new RestTemplate();
		
		countryEventsObject = new JSONObject(restTemplate.getForObject(Url, String.class));
		
		JSONObject pageObject = countryEventsObject.getJSONObject("page");
		int totalElements = pageObject.getInt("totalElements");
		
		JSONObject object = new JSONObject();
		
		object.put("country", countryCode);
		object.put("genre", genreName);
		object.put("totalEvents", totalElements);
		
		return object;
		
	}


}
