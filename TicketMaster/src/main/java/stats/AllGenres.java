package stats;


import org.json.JSONObject;

public class AllGenres {
	
int nActionAdventure = 0;
int nAlternative = 0;
int nAnimation = 0;
int nArtHouse = 0;
int nAquatics = 0;
int nAthleticRaces = 0;
int nBadminton = 0;
int nBalladsRomantic = 0;
int nBandy = 0;
int nBaseball = 0;
int nBasketball = 0;
int nBiathlon = 0;
int nBlues = 0;
int nBodyBuilding = 0;
int nBoxing = 0;
int nChansonFrancaise = 0;
int nChildrensMusic = 0;
int nChildrensTheatre = 0;
int nCircusSpecialtyActs = 0;
int nClassical = 0;
int nComedy = 0;
int nCommunityCivic = 0;
int nCountry = 0;
int nCricket = 0;
int nCultural = 0;
int nCurling = 0;
int nCycling = 0;
int nDance = 0;
int nDanceElectronic = 0;
int nDocumentary = 0;
int nDrama = 0;
int nEquestrian = 0;
int nEspectaculo = 0;
int neSports = 0;
int nExtreme = 0;
int nFamily = 0;
int nFashion = 0;
int nFieldHockey = 0;
int nFineArt = 0;
int nFitness = 0;
int nForeign = 0;
int nFloorball = 0;
int nFolk = 0;
int nFootball = 0;
int nGolf = 0;
int nGymnastics = 0;
int nHandball = 0;
int nHipHopRap = 0;
int nHobbySpecialInterestExpos = 0;
int nHockey = 0;
int nHoliday = 0;
int nHorror = 0;
int nIceShows = 0;
int nIceSkating = 0;
int nIndoorSoccer = 0;
int nJazz = 0;
int nLacrosse = 0;
int nLatin = 0;
int nMagicIllusion = 0;
int nMartialArts = 0;
int nMedievalRenaissance = 0;
int nMetal = 0;
int nMiscellaneous = 0;
int nMiscellaneousTheatre = 0;
int nMotorsportsRacing = 0;
int nMultimedia = 0;
int nMusic = 0;
int nNBA = 0;
int nNetball = 0;
int nnewAge = 0; 
int nOpera = 0; 
int nOther = 0; 
int nPadel = 0; 
int nPerformanceArt = 0;
int nPop = 0;
int nPuppetry = 0; 
int nRB = 0;
int nReggae = 0;
int nReligious = 0; 
int nRinguette = 0; 
int nRock = 0;
int nRodeo = 0; 
int nRollerDerby = 0; 
int nRollerHockey = 0; 
int nRugby = 0;
int nScienceFiction = 0; 
int nSpectacular = 0;
int nSkiJumping = 0; 
int nSkiing = 0; 
int nSoccer = 0; 
int nSoftball = 0; 
int nSquash = 0; 
int nSurfing = 0; 
int nSwimming = 0; 
int nTableTennis = 0; 
int nTennis = 0; 
int nTheatre = 0;
int nToros = 0;
int nTrackField = 0;
int nUndefined = 0;
int nUrban = 0;
int nVariety = 0;
int nVolleyball = 0;
int nWaterpolo = 0;
int nWorld = 0;
int nWrestling = 0;



public JSONObject getGenres() {
	JSONObject genres = new JSONObject();

	    genres.put("Action/Adventure",nActionAdventure);
		genres.put("Alternative",nAlternative);
		genres.put("Animation",nAnimation);
		genres.put("Arthouse",nArtHouse);
		genres.put("Aquatics",nAquatics);
	    genres.put("Athletic Races",nAthleticRaces);
	    genres.put("Badminton", nBadminton);
	    genres.put("Ballads/Romantic",nBalladsRomantic);
	    genres.put("Bandy",nBandy);
	    genres.put("Baseball",nBaseball);
		genres.put("Basketball",nBasketball);
		genres.put("Biathlon",nBiathlon);
		genres.put("Blues",nBlues);
		genres.put("Body Building",nBodyBuilding);
	    genres.put("Boxing",nBoxing);
	    genres.put("Chanson Francaise",nChansonFrancaise);
	    genres.put("Children's Music",nChildrensMusic);
	    genres.put("Children's Theatre",nChildrensTheatre);
		genres.put("Circus & Specialty Acts",nCircusSpecialtyActs);
		genres.put("Classical",nClassical);
		genres.put("Comedy",nComedy);
		genres.put("Community/Civic",nCommunityCivic);
		genres.put("Country",nCountry);
		genres.put("Cricket",nCricket);
		genres.put("Cultural",nCultural);
		genres.put("Curling",nCurling);
		genres.put("Cycling",nCycling);
		genres.put("Dance",nDance);
		genres.put("Dance/Electronic",nDanceElectronic);
		genres.put("Documentary",nDocumentary);
		genres.put("Drama", nDrama);
		genres.put("Equestrian",nEquestrian);
		genres.put("Espectaculo",nEspectaculo);
		genres.put("eSports",neSports);
		genres.put("Extreme",nExtreme);
		genres.put("Family",nFamily); 
		genres.put("Fashion",nFashion);
		genres.put("FieldHockey",nFieldHockey);
		genres.put("FineArt",nFineArt);
		genres.put("Fitness",nFitness);
		genres.put("Foreign",nForeign);
		genres.put("Floorball",nFloorball);
		genres.put("Folk",nFolk);
		genres.put("Football",nFootball);
		genres.put("Golf",nGolf);
		genres.put("Gymnastics",nGymnastics);
		genres.put("Handball",nHandball);
		genres.put("Hip-Hop/Rap",nHipHopRap);
		genres.put("Hobby/Special Interest Expos",nHobbySpecialInterestExpos);
		genres.put("Hockey",nHockey);
	    genres.put("Holiday",nHoliday);
		genres.put("Horror",nHorror);
		genres.put("Ice Shows",nIceShows);
		genres.put("Ice Skating",nIceSkating);
		genres.put("Indoor Soccer",nIndoorSoccer);
		genres.put("Jazz",nJazz);
		genres.put("Lacrosse",nLacrosse);
		genres.put("Latin",nLatin);
		genres.put("Magic & Illusion",nMagicIllusion);
		genres.put("Martial Arts",nMartialArts);
		genres.put("Medieval/Renaissance",nMedievalRenaissance);
	    genres.put("Metal",nMetal);
		genres.put("Miscellaneous",nMiscellaneous); 
		genres.put("Miscellaneous Theatre",nMiscellaneousTheatre);
		genres.put("Motorsports/Racing",nMotorsportsRacing);
		genres.put("Multimedia",nMultimedia);
		genres.put("Music",nMusic);
		genres.put("NBA",nNBA);
		genres.put("Netball",nNetball);
		genres.put("New Age",nnewAge);
		genres.put("Opera",nOpera);
		genres.put("Other",nOther);
		genres.put("Padel",nPadel);
		genres.put("Performance Art",nPerformanceArt);
	    genres.put("Pop",nPop);
	    genres.put("Puppetry",nPuppetry);
	    genres.put("R&B",nRB);
		genres.put("Reggae",nReggae);
		genres.put("Religious",nReligious);
		genres.put("Ringuette",nRinguette);
		genres.put("Rock",nRock);
		genres.put("Rodeo",nRodeo);
		genres.put("RollerDerby",nRollerDerby);
		genres.put("RollerHockey",nRollerHockey);
        genres.put("Rugby",nRugby);
		genres.put("Science Fiction",nScienceFiction);
	    genres.put("Spectacular",nSpectacular);
	    genres.put("Ski Jumping",nSkiJumping);
	    genres.put("Skiing",nSkiing);
	    genres.put("Soccer",nSoccer);
	    genres.put("Softball",nSoftball);
	    genres.put("Squash",nSquash);
	    genres.put("Surfing",nSurfing);
	    genres.put("Swimming",nSwimming);
	    genres.put("Table Tennis",nTableTennis);
	    genres.put("Tennis",nTennis);
		genres.put("Theatre",nTheatre);
		genres.put("Toros",nToros);
		genres.put("Track & Field",nTrackField);
		genres.put("Undefined",nUndefined);
		genres.put("Urban",nUrban);
		genres.put("Variety",nVariety);
		genres.put("Volleyball",nVolleyball);
		genres.put("Waterpolo",nWaterpolo);
		genres.put("World",nWorld);
	    genres.put("Wrestling",nWrestling);
		
return genres;
	
}



public void CompareGenre (String genreName)  {
	
	if (genreName.equals("Action/Adventure")) nActionAdventure++;
	
	if (genreName.equals("Alternative")) nAlternative++;
	
	if (genreName.equals("Animation")) nAnimation++;
	
	if (genreName.equals("Arthouse")) nArtHouse++;
	
	if (genreName.equals("Aquatics")) nAquatics++;
	
	if (genreName.equals("Athletic Races")) nAthleticRaces++;
	
	if (genreName.equals("Badminton")) nBadminton++;
	
	if (genreName.equals("Ballads/Romantic")) nBalladsRomantic++;
	
	if (genreName.equals("Bandy")) nBandy++;
	
	if (genreName.equals("Baseball")) nBaseball++;
	
	if (genreName.equals("Basketball")) nBasketball++;
	
	if (genreName.equals("Biathlon")) nBiathlon++;
	
	if (genreName.equals("Blues")) nBlues++;
	
	if (genreName.equals("Body Building")) nBodyBuilding++;

	if (genreName.equals("Boxing")) nBoxing++;
	
	if (genreName.equals("Chanson Francaise")) nChansonFrancaise++;
	
	if (genreName.equals("Children's Music")) nChildrensMusic++;
	
	if (genreName.equals("Children's Theatre")) nChildrensTheatre++;
	
	if (genreName.equals("Circus & Specialty Acts")) nCircusSpecialtyActs++;

	if (genreName.equals("Classical")) nClassical++;
	
	if (genreName.equals("Comedy")) nComedy++;
	
	if (genreName.equals("Community/Civic")) nCommunityCivic++;

	if (genreName.equals("Country")) nCountry++;
	
	if (genreName.equals("Cricket")) nCricket++;
	
	if (genreName.equals("Cultural")) nCultural++;
	
	if (genreName.equals("Curling")) nCurling++;
	
	if (genreName.equals("Cycling")) nCycling++;

	if (genreName.equals("Dance")) nDance++;
	
	if (genreName.equals("Dance/Electronic")) nDanceElectronic++;
	
	if (genreName.equals("Documentary")) nDocumentary++;
	
	if (genreName.equals("Drama")) nDrama++;
	
	if (genreName.equals("Equestrian")) nEquestrian++;
	
	if (genreName.equals("Espectaculo")) nEspectaculo++;
	
	if (genreName.equals("eSports")) neSports++;
	
	if (genreName.equals("Extreme")) nExtreme++;

	if (genreName.equals("Family")) nFamily++;
	
	if (genreName.equals("Fashion")) nFashion++;
	
	if (genreName.equals("FieldHockey")) nFieldHockey++;
	
	if (genreName.equals("FineArt")) nFineArt++;
	
	if (genreName.equals("Fitness")) nFitness++;
	
	if (genreName.equals("Foreign")) nForeign++;
	
	if (genreName.equals("Floorball")) nFloorball++;
	
	if (genreName.equals("Folk")) nFolk++;
	
	if (genreName.equals("Football")) nFootball++;
	
	if (genreName.equals("Golf")) nGolf++;
	
	if (genreName.equals("Gymnastics")) nGymnastics++;
	
	if (genreName.equals("Handball")) nHandball++;

	if (genreName.equals("Hip-Hop/Rap")) nHipHopRap++;
	
	if (genreName.equals("Hobby/Special Interest Expos")) nHobbySpecialInterestExpos++;
	
	if (genreName.equals("Hockey")) nHockey++;
	
	if (genreName.equals("Holiday")) nHoliday++;
	
	if (genreName.equals("Horror")) nHorror++;
	
	if (genreName.equals("Ice Shows")) nIceShows++;
	
	if (genreName.equals("Ice Skating")) nIceSkating++;
	
	if (genreName.equals("Indoor Soccer")) nIndoorSoccer++;

	if (genreName.equals("Jazz")) nJazz++;
	
	if (genreName.equals("Lacrosse")) nLacrosse++;
	
	if (genreName.equals("Latin")) nLatin++;
	
	if (genreName.equals("Magic & Illusion")) nMagicIllusion++;
	
	if (genreName.equals("Martial Arts")) nMartialArts++;
	
	if (genreName.equals("Medieval/Renaissance")) nMedievalRenaissance++;
	
	if (genreName.equals("Metal")) nMetal++;
	
	if (genreName.equals("Miscellaneous")) nMiscellaneous++;

	if (genreName.equals("Miscellaneous Theatre")) nMiscellaneousTheatre++;
	
	if (genreName.equals("Motorsports/Racing")) nMotorsportsRacing++;
	
	if (genreName.equals("Multimedia")) nMultimedia++;
	
	if (genreName.equals("Music")) nMusic++;
	
	if (genreName.equals("NBA")) nNBA++;
	
	if (genreName.equals("Netball")) nNetball++;
	
	if (genreName.equals("New Age")) nnewAge++;
	
	if (genreName.equals("Opera")) nOpera++;
	
	if (genreName.equals("Other")) nOther++;
	
	if (genreName.equals("Padel")) nPadel++;
	
	if (genreName.equals("Performance Art")) nPerformanceArt++;

	if (genreName.equals("Pop")) nPop++;
	
	if (genreName.equals("Puppetry")) nPuppetry++;
	
	if (genreName.equals("R&B")) nRB++;
	
	if (genreName.equals("Reggae")) nReggae++;
	
	if (genreName.equals("Religious")) nReligious++;
	
	if (genreName.equals("Ringuette")) nRinguette++;
	
	if (genreName.equals("Rock")) nRock++;
	
	if (genreName.equals("Rodeo")) nRodeo++;
	
	if (genreName.equals("RollerDerby")) nRollerDerby++;
	
	if (genreName.equals("RollerHockey")) nRollerHockey++;

	if (genreName.equals("Rugby")) nRugby++;
	
	if (genreName.equals("Science Fiction")) nScienceFiction++;
	
	if (genreName.equals("Spectacular")) nSpectacular++;
	
	if (genreName.equals("Ski Jumping")) nSkiJumping++;
	
	if (genreName.equals("Skiing")) nSkiing++;
	
	if (genreName.equals("Soccer")) nSoccer++;
	
	if (genreName.equals("Softball")) nSoftball++;
	
	if (genreName.equals("Squash")) nSquash++;
	
	if (genreName.equals("Surfing")) nSurfing++;
	
	if (genreName.equals("Swimming")) nSwimming++;
	
	if (genreName.equals("Table Tennis")) nTableTennis++;
	
	if (genreName.equals("Tennis")) nTennis++;
	
	if (genreName.equals("Theatre")) nTheatre++;
	
	if (genreName.equals("Toros")) nToros++;
	
	if (genreName.equals("Track & Field")) nTrackField++;
	
	if (genreName.equals("Undefined")) nUndefined++;
	
	if (genreName.equals("Urban")) nUrban++;
	
	if (genreName.equals("Variety")) nVariety++;
	
	if (genreName.equals("Volleyball")) nVolleyball++;
	
	if (genreName.equals("Waterpolo")) nWaterpolo++;
	
	if (genreName.equals("World")) nWorld++;
	
	if (genreName.equals("Wrestling")) nWrestling++;
	
}


}