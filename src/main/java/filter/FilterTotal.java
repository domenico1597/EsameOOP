package filter;

import java.util.Iterator;
import java.util.Vector;
import org.json.JSONArray;


import exception.*;

/** Questa classe contiene i metodi necessari al filtraggio per la rotta "/total".
 * 
 * @author Domenico Ciavarella
 * @author Daniele Cota
 */ 
public class FilterTotal {
	
	private String CountryComparison;
	private String GenreComparison;
	private Vector<String> CountryElements = new Vector<String>();
	private Vector<String> GenreElements = new Vector<String>();
	

	
	/** Costruttore della classe
	 * 
	 * 
	 * @param CountryComparison è una stringa che rappresenta se si vogliono confrontare 
	 * tutte le nazioni europee o solo quelle scelte dall'utente.
	 * 
	 * @param CountryElements è un vettore contenente le nazioni scelte dall'utente.
	 * 
	 * @param GenreComparison è una stringa che rappresenta se si vogliono confrontare
	 *  tutti i generi o solo quelli scelti dall'utente.
	 *  
	 * @param GenreElements è un vettore contenente i generi scelti dall'utente.
	 */
	public FilterTotal(String CountryComparison, Vector<String> CountryElements, String GenreComparison, Vector<String> GenreElements) {
		this.CountryComparison = CountryComparison;
		this.CountryElements = CountryElements;
	this.GenreComparison = GenreComparison;
    this.GenreElements = GenreElements;
	}
	
	
	/** Questo metodo filtra il GenreComparison e richiama altri metodi in base alla scelta effettuata dall'utente.
	 * 
	 * @return
	 * @throws WrongComparisonException
	 * @throws WrongGenreException
	 * @throws WrongCountryException
	 */
	
	
	
	public JSONArray getFilter() throws WrongComparisonException, WrongGenreException, WrongCountryException {
		
		JSONArray array = new JSONArray();
		if (CountryComparison.equals("Country")||CountryComparison.equals("All")) {
			if (GenreComparison.equals("Genre")||GenreComparison.equals("All")) {
		if (GenreComparison.equals("All")) {
			CountryFilter filter = new CountryFilter();
			array = filter.TotalEventsCountry(CountryElements);
		}
		
		if(GenreComparison.equals("Genre")) {
			
			Iterator<String> iterator = GenreElements.iterator();
			
			while (iterator.hasNext()) {
				GenreFilter filter = new GenreFilter();
				
				JSONArray array2 = new JSONArray();
			array2 = filter.TotalEventsGenre(CountryElements, iterator.next());
		
			array.put(array2);
			
		}
	
		}
	}
		
		else throw new WrongComparisonException(GenreComparison + (" non è una stringa ammessa. Inserisci una stringa tra 'Genre' e 'All'"));
		}
	    else throw new WrongComparisonException(CountryComparison + (" non è una stringa ammessa. Inserisci una stringa tra 'Country' e 'All'"));
		return array;
		
	 }
	 
}

