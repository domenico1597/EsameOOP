package filter;

import java.util.Vector;
import org.json.JSONArray;

import exception.*;

/** Questa classe contiene i metodi necessari al filtraggio per la rotta "/genretotal".
 * 
 * @author Domenico Ciavarella
 * @author Daniele Cota
 */ 

public class FilterGenreTotal {

	private String CountryComparison;
	private Vector<String> CountryElements = new Vector<String>();
	
	
	/** Costruttore della classe
	 * 
	 * 
	 * @param CountryComparison è una stringa che rappresenta se si vogliono confrontare 
	 * tutte le nazioni europee o solo quelle scelte dall'utente.
	 * 
	 * @param CountryElements è un vettore contenente le nazioni scelte dall'utente.
	 * 
	 */
	
	public FilterGenreTotal(String CountryComparison, Vector<String> CountryElements) {
		
		this.CountryComparison = CountryComparison;
		this.CountryElements = CountryElements;
	}
	
	/** Questo metodo controlla la correttezza di CountryComparison e richiama un altro metodo per filtrare gli eventi.
	 * 
	 * @return
	 * @throws WrongComparisonException
	 * @throws WrongGenreException
	 * @throws WrongCountryException
	 */
	
	 public JSONArray getFilter() throws WrongComparisonException, WrongGenreException, WrongCountryException {
			
			JSONArray array = new JSONArray();
			
			if (CountryComparison.equals("Country")||CountryComparison.equals("All")) {
			TotalGenreFilter filter = new TotalGenreFilter();
			array = filter.TotalGenreCountry(CountryElements);
			}
			else throw new WrongComparisonException(CountryComparison + (" non è una stringa ammessa. Inserisci una stringa tra 'Country' e 'All'"));
			
			return array;
			
	
	
	
	
	 }
	
	
	
	
	
	
}
