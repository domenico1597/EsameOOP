package stats;

import org.json.JSONObject;

import exception.WrongCountryException;
import exception.WrongGenreException;

/** Questa classe è l'interfaccia di StatsManagement.
 * 
 * @author Domenico Ciavarella
 * @author Daniele Cota
 *
 */
public interface Stats {
	
	public abstract JSONObject getCountryEvents(String countryCode) throws WrongCountryException;
public abstract JSONObject getGenreEvents(String countryCode, String genreName) throws WrongCountryException, WrongGenreException;
public abstract JSONObject getTotalGenre(String countryCode) throws WrongCountryException;
public abstract JSONObject getCountryStats(String countryCode) throws WrongCountryException;
public abstract JSONObject getGenreStats(String countryCode, String genreName) throws WrongCountryException, WrongGenreException;
}
