package filter;

import java.util.Iterator;
import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONObject;

import stats.Stats;
import stats.StatsManagement;
import exception.VoidGetException;
import exception.WrongCountryException;

/** Questa classe contiene i metodi necessari al filtraggio degli eventi per la rotta /genretotal.
 * 
 * @author Domenico Ciavarella
 * @author Daniele Cota
 *
 */

public class TotalGenreFilter {
	
	Stats stats = new StatsManagement();
	
	VoidGetException Exception = new VoidGetException();


	 /** Questo metodo calcola, per ogni genere, il numero totale di eventi che hanno luogo nei paesi inseriti.
		 * Restituisce un JSONArray contenente JSONObject che rappresentano i paesi, i generi
		 * e il numero totale di eventi di ciascuno di essi.
		 * 
		 * @param countries 
		 * @throws WrongCountryException se viene inserito il countryCode di un paese non europeo. 
		 */
		
public JSONArray TotalGenreCountry(Vector<String> countries) throws WrongCountryException {
	
	Exception.countryVectorException(countries);
	
	JSONArray TotalGenreEvents = new JSONArray();
	
	Iterator<String> iterator = countries.iterator();
	
	int i = 0;
	

	while (iterator.hasNext()) {
	
		
	JSONObject object = new JSONObject();
	JSONObject country = new JSONObject();
	
	country.put("country", countries.get(i));
	object = stats.getTotalGenre(iterator.next());

	TotalGenreEvents.put(country);
	TotalGenreEvents.put(object);
	i++;
	
	}

return TotalGenreEvents;
}

}
