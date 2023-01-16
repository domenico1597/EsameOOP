package stats;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import exception.*;


/** Questa classe contiene il test della classe StatsManagement, verificando il corretto lancio delle eccezioni WrongCountryException
 * e WrongValueException
 * 
 * @author Domenico Ciavarella
 * @author Daniele Cota
 * 
 */
public class StatsManagementTest {
	
	StatsManagement stats; 
	
	
	/** Inizializza le componenti utili al test
    * @throws java.lang.Exception
    */
	@BeforeEach
	void setUp() throws Exception {
		
		stats = new StatsManagement();
		
	}
	
	
	/** Serve per distruggere ciò che è stato creato dal setUp
     * @throws java.lang.Exception
     */
	@AfterEach
	void tearDown() throws Exception {
		
	}
	
	
    /** Questo Test verifica se viene generata correttamente l'eccezione WrongCountryException
	 */
    @Test
    @DisplayName("Corretta generazione dell'eccezione WrongCountryException.")
    void WrongCountryExceptionTest() {
            	
        WrongCountryException e = assertThrows(WrongCountryException.class, () -> {stats.getCountryEvents("US");});
    
        assertEquals("US non è un valore ammesso.", e.getMessage());    
    }
	
	
    /** Questo Test verifica se viene generata correttamente l'eccezione WrongGenreException
	 */
    @Test
    @DisplayName("Corretta generazione dell'eccezione WrongGenreException.")
    void WrongGenreExceptionTest() {
            	
        WrongGenreException e = assertThrows(WrongGenreException.class, () -> {stats.getGenreEvents("GB", "musica");});
    
        assertEquals("musica non è un valore ammesso.", e.getMessage());    
    }
	
    

}