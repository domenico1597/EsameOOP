package stats;

/** Questa classe permette di convertire il nome di un genere nel suo ID corrispondente.
 * 
 * @author Domenico Ciavarella
 * @author Daniele Cota
 * 
 */
public class IDconverter {

	
	/** Questo metodo riceve in ingresso il nome del genere e lo converte nell'ID corrispondente.
	 * 
	 * @param genre genere inserito dall'utente 
	 * @return l'ID del corrispondente genre
	 */
	
public String genreIdConverter(String genre) {
		
		String genreId = null;
		
		if (genre.equals("Alternative")) genreId = "KnvZfZ7vAvv";
		else if (genre.equals("Aquatics")) genreId = "KnvZfZ7vAeI";
		else if (genre.equals("Athletic Races")) genreId = "KnvZfZ7vAet";
		else if (genre.equals("Basketball")) genreId = "KnvZfZ7vAde";
		else if (genre.equals("Blues")) genreId = "KnvZfZ7vAvd";
		else if (genre.equals("Boxing")) genreId = "KnvZfZ7vAdA";
		else if (genre.equals("Children's Theatre")) genreId = "KnvZfZ7v7na";
		else if (genre.equals("Circus & Specialty Acts")) genreId = "KnvZfZ7v7n1";
		else if (genre.equals("Classical")) genreId = "KnvZfZ7vAeJ";
		else if (genre.equals("Comedy")) genreId = "KnvZfZ7vAe1";
		else if (genre.equals("Community/Civic")) genreId = "KnvZfZ7vAAE";
		else if (genre.equals("Country")) genreId = "KnvZfZ7vAv6";
		else if (genre.equals("Cricket")) genreId = "KnvZfZ7vAdk";
		else if (genre.equals("Cycling")) genreId = "KnvZfZ7vAda";
		else if (genre.equals("Dance")) genreId = "KnvZfZ7v7nI";
		else if (genre.equals("Dance/Electronic")) genreId = "KnvZfZ7vAvF";
		else if (genre.equals("Equestrian")) genreId = "KnvZfZ7vAd1";
		else if (genre.equals("Family")) genreId = "KnvZfZ7vA1n";
		else if (genre.equals("Fashion")) genreId = "KnvZfZ7v7nn";
		else if (genre.equals("Folk")) genreId = "KnvZfZ7vAva";
		else if (genre.equals("Hip-Hop/Rap")) genreId = "KnvZfZ7vAv1";
		else if (genre.equals("Hobby/Special Interest Expos")) genreId = "KnvZfZ7vAAJ";
		else if (genre.equals("Ice Shows")) genreId = "KnvZfZ7v7lI";
		else if (genre.equals("Jazz")) genreId = "KnvZfZ7vAvE";
		else if (genre.equals("Magic & Illusion")) genreId = "KnvZfZ7v7lv";
		else if (genre.equals("Martial Arts")) genreId = "KnvZfZ7vA7d";
		else if (genre.equals("Metal")) genreId = "KnvZfZ7vAvt";
		else if (genre.equals("Miscellaneous")) genreId = "KnvZfZ7vA7A";
		else if (genre.equals("Miscellaneous Theatre")) genreId = "KnvZfZ7v7ld";
		else if (genre.equals("Motorsports/Racing")) genreId = "KnvZfZ7vA7k";
		else if (genre.equals("Performance Art")) genreId = "KnvZfZ7v7l6";
		else if (genre.equals("Pop")) genreId = "KnvZfZ7vAev";
		else if (genre.equals("Reggae")) genreId = "KnvZfZ7vAed";
		else if (genre.equals("Rock")) genreId = "KnvZfZ7vAeA";
		else if (genre.equals("Rugby")) genreId = "KnvZfZ7vA71";
		else if (genre.equals("R&B")) genreId = "KnvZfZ7vAee";
		else if (genre.equals("Spectacular")) genreId = "KnvZfZ7v7la";
		else if (genre.equals("Theatre")) genreId = "KnvZfZ7v7l1";
		else if (genre.equals("Undefined")) genreId = "KnvZfZ7v7ll";
		else if (genre.equals("Variety")) genreId = "KnvZfZ7v7lJ";
		else if (genre.equals("Volleyball")) genreId = "KnvZfZ7vAA7";
		else if (genre.equals("World")) genreId = "KnvZfZ7vAeF";
		else if (genre.equals("Wrestling")) genreId = "KnvZfZ7vAAk";
		
		return genreId;
		
	}
}
