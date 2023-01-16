package exception;

/** Questa classe contiene il metodo che segnala l'eccezione riguardante una stringa non ammessa
 *  per CountryComparison o per GenreComparison.
 *  
 * @author Domenico Ciavarella
 * @author Daniele Cota
 */ 

public class WrongComparisonException extends Exception {

	private static final long serialVersionUID = 1L;

	
	String message;
	
	
	/** Costruttore della classe
	 * @param message rappresenta il messaggio di errore.
	 */
	
public WrongComparisonException(String message) {
		
		this.message = message;
	}

/** Restituisce un messaggio di errore passato al costruttore quando viene inserita una stringa non ammessa
 * per CountryComparison o per GenreComparison.
 * @return String che contiene il messaggio d'errore che viene stampato
 */

public String getMessage() {
	return message;
}
		
}
