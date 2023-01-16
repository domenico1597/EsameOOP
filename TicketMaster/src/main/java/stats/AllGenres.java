package stats;

import org.json.JSONObject;

/** Questa classe contiene tutti i generi ammessi da Ticketmaster con rispettivi contatori.
 * 
 * @author Domenico Ciavarella
 * @author Daniele Cota
 *
 */

public class AllGenres {
	

int nAlternative = 0;
int nAquatics = 0;
int nAthleticRaces = 0;
int nBasketball = 0;
int nBlues = 0;
int nBoxing = 0;
int nChildrensTheatre = 0;
int nCircusSpecialtyActs = 0;
int nClassical = 0;
int nComedy = 0;
int nCommunityCivic = 0;
int nCountry = 0;
int nCricket = 0;
int nCycling = 0;
int nDance = 0;
int nDanceElectronic = 0;
int nEquestrian = 0;
int nFamily = 0;
int nFashion = 0;
int nFolk = 0;
int nHipHopRap = 0;
int nHobbySpecialInterestExpos = 0;
int nIceShows = 0;
int nJazz = 0;
int nMagicIllusion = 0;
int nMartialArts = 0;
int nMetal = 0;
int nMiscellaneous = 0;
int nMiscellaneousTheatre = 0;
int nMotorsportsRacing = 0;
int nPerformanceArt = 0;
int nPop = 0;
int nReggae = 0;
int nRock = 0;
int nRugby = 0;
int nRB = 0;
int nSpectacular = 0;
int nTheatre = 0;
int nUndefined = 0;
int nVariety = 0;
int nVolleyball = 0;
int nWorld = 0;
int nWrestling = 0;


/**  Questo metodo serve a restituire tutti i generi con il rispettivo contatore.
 *  Verrà richiamato dallo StatsManagement dopo aver incrementato i contatori.
 * @return JSONObject
 */
public JSONObject getGenres() {
	JSONObject genres = new JSONObject();

		genres.put("Alternative",nAlternative);
		genres.put("Aquatics",nAquatics);
		genres.put("Rock",nRock);
	    genres.put("Athletic Races",nAthleticRaces);
		genres.put("Basketball",nBasketball);
		genres.put("Blues",nBlues);
	    genres.put("Boxing",nBoxing);
	    genres.put("Children's Theatre",nChildrensTheatre);
		genres.put("Circus & Specialty Acts",nCircusSpecialtyActs);
		genres.put("Classical",nClassical);
		genres.put("Comedy",nComedy);
		genres.put("Community/Civic",nCommunityCivic);
		genres.put("Country",nCountry);
		genres.put("Cricket",nCricket);
		genres.put("Cycling",nCycling);
		genres.put("Dance",nDance);
		genres.put("Dance/Electronic",nDanceElectronic);
		genres.put("Equestrian",nEquestrian);
		genres.put("Family",nFamily); 
		genres.put("Fashion",nFashion);
		genres.put("Folk",nFolk);
	    genres.put("Hip-Hop/Rap",nHipHopRap);
		genres.put("Hobby/Special Interest Expos",nHobbySpecialInterestExpos);
		genres.put("Ice Shows",nIceShows);
		genres.put("Jazz",nJazz);
		genres.put("Magic & Illusion",nMagicIllusion);
		genres.put("Martial Arts",nMartialArts);
	    genres.put("Metal",nMetal);
		genres.put("Miscellaneous",nMiscellaneous); 
		genres.put("Miscellaneous Theatre",nMiscellaneousTheatre);
		genres.put("Motorsports/Racing",nMotorsportsRacing);
		genres.put("Performance Art",nPerformanceArt);
	    genres.put("Pop",nPop); 
		genres.put("Reggae",nReggae);
		genres.put("Rock",nRock);
        genres.put("Rugby",nRugby);
		genres.put("R&B",nRB);
	    genres.put("Spectacular",nSpectacular);
		genres.put("Theatre",nTheatre); 
		genres.put("Undefined",nUndefined);
		genres.put("Variety",nVariety);
		genres.put("Volleyball",nVolleyball);
		genres.put("World",nWorld);
	    genres.put("Wrestling",nWrestling);
		
return genres;
	
}


/** Questo metodo verrà richiamato dallo StatsManagement per incrementare il contatore
 *  del relativo evento.
 * 
 * @param genreName (il nome del genere dell'evento da confrontare)
 */

public void CompareGenre (String genreName)  {
	
	if (genreName.equals("Alternative")) nAlternative++;
	
	if (genreName.equals("Aquatics")) nAquatics++;
	
	if (genreName.equals("Rock")) nRock++;
	
	if (genreName.equals("Athletic Races")) nAthleticRaces++;
	
	if (genreName.equals("Basketball")) nBasketball++;
	
	if (genreName.equals("Blues")) nBlues++;

	if (genreName.equals("Boxing")) nBoxing++;
	
	if (genreName.equals("Children's Theatre")) nChildrensTheatre++;
	
	if (genreName.equals("Circus & Specialty Acts")) nCircusSpecialtyActs++;

	if (genreName.equals("Classical")) nClassical++;
	
	if (genreName.equals("Comedy")) nComedy++;
	
	if (genreName.equals("Community/Civic")) nCommunityCivic++;

	if (genreName.equals("Country")) nCountry++;
	
	if (genreName.equals("Cricket")) nCricket++;
	
	if (genreName.equals("Cycling")) nCycling++;

	if (genreName.equals("Dance")) nDance++;
	
	if (genreName.equals("Dance/Electronic")) nDanceElectronic++;
	
	if (genreName.equals("Equestrian")) nEquestrian++;

	if (genreName.equals("Family")) nFamily++;
	
	if (genreName.equals("Fashion")) nFashion++;
	
	if (genreName.equals("Folk")) nFolk++;

	if (genreName.equals("Hip-Hop/Rap")) nHipHopRap++;
	
	if (genreName.equals("Hobby/Special Interest Expos")) nHobbySpecialInterestExpos++;
	
	if (genreName.equals("Ice Shows")) nIceShows++;

	if (genreName.equals("Jazz")) nJazz++;
	
	if (genreName.equals("Magic & Illusion")) nMagicIllusion++;
	
	if (genreName.equals("Martial Arts")) nMartialArts++;
	
	if (genreName.equals("Metal")) nMetal++;
	
	if (genreName.equals("Miscellaneous")) nMiscellaneous++;

	if (genreName.equals("Miscellaneous Theatre")) nMiscellaneousTheatre++;
	
	if (genreName.equals("Motorsports/Racing")) nMotorsportsRacing++;
	
	if (genreName.equals("Performance Art")) nPerformanceArt++;

	if (genreName.equals("Pop")) nPop++;
	
	if (genreName.equals("Reggae")) nReggae++;
	
	if (genreName.equals("Rock")) nRock++;

	if (genreName.equals("Rugby")) nRugby++;
	
	if (genreName.equals("R&B")) nRB++;
	
	if (genreName.equals("Spectacular")) nSpectacular++;
	
	if (genreName.equals("Theatre")) nTheatre++;
	
	if (genreName.equals("Undefined")) nUndefined++;
	
	if (genreName.equals("Variety")) nVariety++;
	
	if (genreName.equals("Volleyball")) nVolleyball++;
	
	if (genreName.equals("World")) nWorld++;
	
	if (genreName.equals("Wrestling")) nWrestling++;
	
}


}