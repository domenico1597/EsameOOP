package filter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Vector;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import exception.*;


/** Questa classe contiene il test della classe FilterTotal, verificando il corretto
 *  lancio dell' eccezione WrongComparisonException.
 * 
 * @author Domenico Ciavarella
 * @author Daniele Cota
 * 
 */
public class FilterTotalTest {
	
	FilterTotal filter;
	private Vector<String> countryelements;
	private Vector<String> genreelements;
	
	/** Inizializza le componenti utili al test
    * @throws java.lang.Exception
    */
	@BeforeEach
	void setUp() throws Exception {
		countryelements = new Vector<String>();
		genreelements = new Vector<String>();
	}
	
	
	/** Serve per distruggere ciò che è stato creato dal setUp
     * @throws java.lang.Exception
     */
	@AfterEach
	void tearDown() throws Exception {
		
	}
	
	
    /** Questo Test verifica se viene generata correttamente l'eccezione WrongComparisonException
     * su CountryComparison.
	 */
    @Test
    @DisplayName("Corretta generazione dell'eccezione WrongComparisonException.")
    void WrongComparisonExceptionTest1() {
		
    	countryelements.add("GB");
        countryelements.add("FR");
        genreelements.add("Rock");
        genreelements.add("Pop");
        
        filter = new FilterTotal("stati", countryelements, "Genre", genreelements);
    	
        WrongComparisonException e = assertThrows(WrongComparisonException.class, () -> {filter.getFilter();});
    
        assertEquals("stati non è una stringa ammessa. Inserisci una stringa tra 'Country' e 'All'", e.getMessage());    
    }
	
    /** Questo Test verifica se viene generata correttamente l'eccezione WrongComparisonException
     * su GenreComparison.
	 */
    @Test
    @DisplayName("Corretta generazione dell'eccezione WrongComparisonException.")
    void WrongComparisonExceptionTest2() {
		
    	countryelements.add("GB");
        countryelements.add("FR");
        genreelements.add("Rock");
        genreelements.add("Pop");
        
        filter = new FilterTotal("Country", countryelements, "genere", genreelements);
    	
        WrongComparisonException e = assertThrows(WrongComparisonException.class, () -> {filter.getFilter();});
    
        assertEquals("genere non è una stringa ammessa. Inserisci una stringa tra 'Genre' e 'All'", e.getMessage());    
    }
	
    

}