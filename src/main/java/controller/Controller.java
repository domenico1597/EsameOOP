package controller;
 

import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import stats.EuroCountries;
import filter.FilterTotal;
import filter.FilterGenreTotal;
import filter.FilterStats;
import exception.*;

/** Questa classe contiene le rotte che il client può effettuare
*
*
* @author Domenico Ciavarella
* @author Daniele Cota
*
*
*/


@RestController

public class Controller {


	/** Rotta di tipo POST che filtra gli eventi in base alle richieste inserite dall'utente nel body  
	 * 
	 *  Parametri richiesti:
	 *  
	 * @param CountryComparison: ("All")     -  Seleziona gli eventi di tutti i paesi europei.
	 * @param CountryComparison: ("Country") -  Seleziona gli eventi dei paesi scelti dall'utente in CountryElements.
	 * @param CountryElements: - Vettore contenente i countryCode dei paesi europei scelti dall'utente.
	 * @param GenreComparison: ("All")   -  Seleziona gli eventi di tutti i generi.
	 * @param GenreComparison: ("Genre") -  Seleziona gli eventi dei generi scelti dall'utente in GenreElements.
	 * @param GenreElements: - Vettore contenente il nome dei generi scelti dall'utente.
	 *  
	 *  @return per ogni nazione, il numero totale di eventi di ciascun genere scelto dall'utente.
	 *  
	 *  @throws WrongComparisonException
	 *  @throws WrongCountryException
	 */
	
	
	
@PostMapping(value = "/total")
public ResponseEntity<Object> total(@RequestBody String body) throws WrongComparisonException, WrongGenreException {
	
	JSONObject object = new JSONObject(body);
	JSONArray array = new JSONArray();
	
	EuroCountries countries = new EuroCountries();
	
	String CountryComparison = object.getString("CountryComparison");
	
	
	array = object.getJSONArray("CountryElements");
	
	Vector<String> Countryelements = new Vector<String>(array.length());
	
	for(int i = 0; i < array.length(); i++) {
		
		JSONObject obj = new JSONObject();
		obj = array.getJSONObject(i);
Countryelements.add(obj.getString("CountryName"));
	}

	
	if (CountryComparison.equals("All"))
		Countryelements = countries.getEuroCountries();
	
	JSONArray array2 = new JSONArray();
	
	array2 = object.getJSONArray("GenreElements");
	
	Vector<String> Genreelements = new Vector<String>(array2.length());
	
	for (int j = 0; j < array2.length(); j++) {
		JSONObject obj2 = new JSONObject();
		obj2 = array2.getJSONObject(j);
		Genreelements.add(obj2.getString("GenreName"));
	}
	

	 
	String GenreComparison = object.getString("GenreComparison");
	

	FilterTotal filter = new FilterTotal(CountryComparison, Countryelements, GenreComparison, Genreelements);

    try {	
	return new ResponseEntity<>(filter.getFilter().toString(),HttpStatus.OK);
    }
    catch(WrongComparisonException e) {
        return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
    }
	catch(WrongGenreException e) {
        return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
    }
	catch(WrongCountryException e) {
    	return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	}   




/** Rotta di tipo POST che filtra gli eventi in base alle richieste inserite dall'utente nel body  
 * 
 *  Parametri richiesti:
 *  
 * @param CountryComparison: ("All")     -  Seleziona gli eventi di tutti i paesi europei.
 * @param CountryComparison: ("Country") -  Seleziona gli eventi dei paesi scelti dall'utente in CountryElements.
 * @param CountryElements: - Vettore contenente i countryCode dei paesi europei scelti dall'utente.
 *  
 *  @return per ogni nazione scelta, il numero di eventi raggruppati per genere.
 *  
 *  @throws WrongComparisonException
 *  @throws WrongGenreException
*/


@PostMapping(value = "/genretotal")
public ResponseEntity<Object> genretotal(@RequestBody String body)  throws WrongComparisonException, WrongGenreException {
	
	JSONObject object = new JSONObject(body);
	JSONArray array = new JSONArray();
	
	EuroCountries countries = new EuroCountries();
	
	String CountryComparison = object.getString("CountryComparison");
	
	array = object.getJSONArray("CountryElements");
	
	Vector<String> Countryelements = new Vector<String>(array.length());
	
	for(int i = 0; i < array.length(); i++) {
		
		JSONObject obj = new JSONObject();
		obj = array.getJSONObject(i);
Countryelements.add(obj.getString("CountryName"));
	}

	
	if (CountryComparison.equals("All"))
		Countryelements = countries.getEuroCountries();
	
	FilterGenreTotal filter = new FilterGenreTotal(CountryComparison, Countryelements);

	 try {	
			return new ResponseEntity<>(filter.getFilter().toString(),HttpStatus.OK);
		    }
		    catch(WrongComparisonException e) {
		    	return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		    }
			catch(WrongGenreException e) {
		        return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		    }
			catch(WrongCountryException e) {
		    	return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
			}
}   




/** Rotta di tipo POST che filtra gli eventi in base alle richieste inserite dall'utente nel body  
 * 
 *  Parametri richiesti:
 *  
 * @param CountryComparison: ("All")     -  Seleziona gli eventi di tutti i paesi europei.
 * @param CountryComparison: ("Country") -  Seleziona gli eventi dei paesi scelti dall'utente in CountryElements.
 * @param CountryElements: - Vettore contenente i countryCode dei paesi europei scelti dall'utente.
 * @param GenreComparison: ("All")   -  Seleziona gli eventi di tutti i generi.
 * @param GenreComparison: ("Genre") -  Seleziona gli eventi dei generi scelti dall'utente in GenreElements.
 * @param GenreElements: - Vettore contenente il nome dei generi scelti dall'utente.
 *  
 *  @return il numero medio, massimo e minimo di eventi mensili per ogni nazione e/o genere specificato dall'utente.
 *  
 *  @throws WrongComparisonException
 *  @throws WrongGenreException
 */


@PostMapping(value = "/stats")
public ResponseEntity<Object> stats(@RequestBody String body) throws WrongComparisonException, WrongGenreException {
	
	JSONObject object = new JSONObject(body);
	JSONArray array = new JSONArray();
	
	EuroCountries countries = new EuroCountries();
	
	String CountryComparison = object.getString("CountryComparison");
	
	array = object.getJSONArray("CountryElements");
	
	Vector<String> Countryelements = new Vector<String>(array.length());
	
	for(int i = 0; i < array.length(); i++) {
		
		JSONObject obj = new JSONObject();
		obj = array.getJSONObject(i);
Countryelements.add(obj.getString("CountryName"));
	}

	
	if (CountryComparison.equals("All"))
		Countryelements = countries.getEuroCountries();
	
	JSONArray array2 = new JSONArray();
	
	array2 = object.getJSONArray("GenreElements");
	
	Vector<String> Genreelements = new Vector<String>(array2.length());
	
	for (int j = 0; j < array2.length(); j++) {
		JSONObject obj2 = new JSONObject();
		obj2 = array2.getJSONObject(j);
		Genreelements.add(obj2.getString("GenreName"));
	}
	

	 
	String GenreComparison = object.getString("GenreComparison");
	
	FilterStats filter = new FilterStats(CountryComparison, Countryelements, GenreComparison, Genreelements);

    try {	
	return new ResponseEntity<>(filter.getFilter().toString(),HttpStatus.OK);
    }
    catch(WrongComparisonException e) {
    	return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
    }
	catch(WrongGenreException e) {
        return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
    }
	catch(WrongCountryException e) {
    	return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
	}

}
}

	
	


