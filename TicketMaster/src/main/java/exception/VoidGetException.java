package exception;

import java.util.Vector;

/** Questa classe contiene i metodi necessari a riconoscere i valori ammessi dei parametri country e genre. 
 * 
* @author Domenico Ciavarella
* @author Daniele Cota
*/
public class VoidGetException {
	
		
/**metodo serve a valutare se il vettore di country inserito dall'utente
	   contiene i countryCode ammessi (appartenenti ad un paese europeo).
 * 
 * @param countries
 * @throws WrongCountryException
 */
	public void countryVectorException(Vector<String> countries) throws WrongCountryException {
		
		if (!countries.contains("AD") && !countries.contains("AT") && !countries.contains("BE") && !countries.contains("BG")
				&& !countries.contains("HR") && !countries.contains("CY") && !countries.contains("CZ") && !countries.contains("DK")
				&& !countries.contains("EE") && !countries.contains("FO") && !countries.contains("FI") && !countries.contains("FR")
				&& !countries.contains("DE") && !countries.contains("GE") && !countries.contains("GI") && !countries.contains("GB")
				&& !countries.contains("GR") && !countries.contains("HU") && !countries.contains("IS") && !countries.contains("IE")
				&& !countries.contains("IT") && !countries.contains("LT") && !countries.contains("LU") && !countries.contains("MT")
				&& !countries.contains("MC") && !countries.contains("ME") && !countries.contains("NL") && !countries.contains("ND")
				&& !countries.contains("NO") && !countries.contains("PL") && !countries.contains("PT") && !countries.contains("RO")
				&& !countries.contains("RU") && !countries.contains("RS") && !countries.contains("SK") && !countries.contains("SI")
				&& !countries.contains("ES") && !countries.contains("SE") && !countries.contains("CH") && !countries.contains("TR")
				&& !countries.contains("UA"))
				
			 throw new WrongCountryException(countries + " non è un valore ammesso.");
	}

	
	/** Questo metodo serve a valutare se il country inserito dall'utente è ammesso, ossia se il countryCode
	 * inserito appartiene ad un paese europeo.
	 * 
	 * @param country
	 * @throws WrongCountryException
	 */
	 
	
	public void countryStringException(String country) throws WrongCountryException {
		
		if (!country.equals("AD") && !country.equals("AT") && !country.equals("BE") && !country.equals("BG")
				&& !country.equals("HR") && !country.equals("CY") && !country.equals("CZ") && !country.equals("DK")
				&& !country.equals("EE") && !country.equals("FO") && !country.equals("FI") && !country.equals("FR")
				&& !country.equals("DE") && !country.equals("GE") && !country.equals("GI") && !country.equals("GB")
				&& !country.equals("GR") && !country.equals("HU") && !country.equals("IS") && !country.equals("IE")
				&& !country.equals("IT") && !country.equals("LT") && !country.equals("LU") && !country.equals("MT")
				&& !country.equals("MC") && !country.equals("ME") && !country.equals("NL") && !country.equals("ND")
				&& !country.equals("NO") && !country.equals("PL") && !country.equals("PT") && !country.equals("RO")
				&& !country.equals("RU") && !country.equals("RS") && !country.equals("SK") && !country.equals("SI")
				&& !country.equals("ES") && !country.equals("SE") && !country.equals("CH") && !country.equals("TR") 
				&& !country.equals("UA"))
				
			 throw new WrongCountryException(country + " non è un valore ammesso.");
		
	}
	
	

	/**Questo metodo serve a valutare se il vettore di genre inserito dall'utente è ammesso, ossia se i genre
	 * inseriti siano validi.
	 * 
	 * @param genres
	 * @throws WrongGenreException
	 */
	
	
	public void genreVectorException(Vector<String> genres) throws WrongGenreException {
		
		
		if (!genres.contains("Alternative") && !genres.contains("Aquatics") && !genres.contains("Athletic Races") 
				&& !genres.contains("Basketball") && !genres.contains("Blues") && !genres.contains("Boxing") && !genres.contains("Children's Theatre") && !genres.contains("Circus & Specialty Acts")
			    && !genres.contains("Classical") && !genres.contains("Comedy") && !genres.contains("Community/Civic") && !genres.contains("Country")
			    && !genres.contains("Cricket") && !genres.contains("Cycling") && !genres.contains("Dance") && !genres.contains("Dance/Electronic")
			    && !genres.contains("Equestrian") && !genres.contains("Family") && !genres.contains("Fashion") && !genres.contains("Folk")
			    && !genres.contains("Hip-Hop/Rap") && !genres.contains("Hobby/Special Interest Expos") && !genres.contains("Ice Shows") 
			    && !genres.contains("Jazz") && !genres.contains("Magic & Illusion") && !genres.contains("Martial Arts") 
			    && !genres.contains("Metal") && !genres.contains("Miscellaneous") && !genres.contains("Miscellaneous Theatre") 
			    && !genres.contains("Motorsports/Racing") && !genres.contains("Performance Art") && !genres.contains("Pop")
			    && !genres.contains("Reggae") && !genres.contains("Rock") && !genres.contains("Rugby") && !genres.contains("R&B") 
			    && !genres.contains("Spectacular") && !genres.contains("Theatre") && !genres.contains("Undefined") 
			    && !genres.contains("Variety") && !genres.contains("Volleyball") && !genres.contains("World") && !genres.contains("Wrestling")) 
				
			throw new WrongGenreException(genres + " non è un valore ammesso.");
		
	}
	

 
/**Questo metodo serve a valutare se il genre inserito dall'utente è ammesso.
 * 
 * @param genre
 * @throws WrongGenreException
 */
	
	public void genreStringException(String genre) throws WrongGenreException {
		
		
		if (!genre.equals("Alternative") && !genre.equals("Aquatics") && !genre.equals("Athletic Races") && !genre.equals("Basketball")
			    && !genre.equals("Blues") && !genre.equals("Boxing") && !genre.equals("Children's Theatre") && !genre.equals("Circus & Specialty Acts")
		        && !genre.equals("Classical") && !genre.equals("Comedy") && !genre.equals("Community/Civic") && !genre.equals("Country")
			    && !genre.equals("Cricket") && !genre.equals("Cycling") && !genre.equals("Dance") && !genre.equals("Dance/Electronic")
			    && !genre.equals("Equestrian") && !genre.equals("Family") && !genre.equals("Fashion") && !genre.equals("Folk")
			    && !genre.equals("Hip-Hop/Rap") && !genre.equals("Hobby/Special Interest Expos") && !genre.equals("Ice Shows") 
			    && !genre.equals("Jazz") && !genre.equals("Magic & Illusion") && !genre.equals("Martial Arts") && !genre.equals("Metal") 
			    && !genre.equals("Miscellaneous") && !genre.equals("Miscellaneous Theatre") && !genre.equals("Motorsports/Racing") 
			    && !genre.equals("Performance Art") && !genre.equals("Pop") && !genre.equals("Reggae") && !genre.equals("Rock") 
			    && !genre.equals("Rugby") && !genre.equals("R&B") && !genre.equals("Spectacular") && !genre.equals("Theatre") 
			    && !genre.equals("Undefined") && !genre.equals("Variety") && !genre.equals("Volleyball")
			    && !genre.equals("World") && !genre.equals("Wrestling")) 
				
			throw new WrongGenreException(genre + " non è un valore ammesso.");
	}
}
