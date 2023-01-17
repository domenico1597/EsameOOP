<h1 align="center"> Ticketmaster </h1>

<p align="justify"> La nostra applicazione consente all'utente di calcolare statistiche sugli eventi che avranno luogo in Europa. In particolare, permette di filtrare e visualizzare per regione e genere: il numero totale di eventi, il numero di eventi raggruppati per genere, il numero minimo/massimo/medio di eventi mensili. </p>


## **Indice**
* [Introduzione](#intro)
* [Diagrammi UML](#uml)
* [Rotte](#rotte)
* [CountryCode supportati](#countrycode)
* [Generi supportati](#generi)
* [Eccezioni](#eccezioni)
* [JUnit Test](#test)
* [Documentazione Javadoc](#doc)
* [Autori](#autor)

<a name="intro"></a>
## Introduzione
<p align="justify">

Il programma Ticketmaster permette di studiare gli eventi che avranno luogo in Europa, utilizzando le API del sito Ticketmaster, reperibili al seguente indirizzo: https://developer.ticketmaster.com/products-and-docs/apis/discovery-api/v2/#search-events-v2. 

L'applicazione consente di ottenere le informazioni relative agli eventi che si svolgono nei paesi europei, supportati da Ticketmaster, permettendo all'utente di scegliere, se visualizzare:

     1) il numero totale di eventi di uno o più stati e/o di raggruppare questi ultimi in base ad uno o più generi.
     
     2) il numero totale di eventi raggruppati per genere, relativi ad uno o più stati.
     
     3) le statistiche riguardanti il numero totale di eventi mensili, con stati/generi specificati dall'utente; in particolare: lo stato che presenta il maggior e il minor numero di eventi e la media degli eventi tra i vari stati.
     
</p>

<a name="uml"></a>
## Diagrammi UML

*Diagramma dei Casi d'Uso*
***
![DiagrammaCasiUso_0_1](https://user-images.githubusercontent.com/116668334/212487777-ff6b39c7-fdd7-4fab-aa8f-a775b659fdd2.jpg)


*Diagramma delle Classi*
***
![TicketmasterModel Class Diagram](https://user-images.githubusercontent.com/116668334/212713427-8b224e12-bc76-4b48-94b4-516f18539ca9.jpg)


*Diagramma delle Sequenze*
***
<b> N.B. Nei seguenti diagrammi delle sequenze, nel caso in cui il CountryComparison è "All" ogni rotta, nel Controller, farà inizialmente una chiamata alla classe EuroCountries, per aggiungere tutte gli stati, tramite il metodo getEuroCountries(). 
     
Viceversa, se il CountryComparison è "Country" il diagramma rimarrà invariato rispetto a quelli mostrati. </b>
***
Per la rotta <b> /total </b> con :

#### Genrecomparison: All
![TicketmasterModel Sequence Diagram](https://user-images.githubusercontent.com/116668334/212550729-ff8c634f-ca43-4bb2-ac7e-2ccc4c11f9c0.jpg)



#### Genrecomparison: Genre
![TicketmasterModel Sequence Diagram_2](https://user-images.githubusercontent.com/116668334/212550932-53187fbf-05fd-44c0-a313-695f013cc7ba.jpg)

***

Per la rotta <b> /stats </b> con :
#### Genrecomparison: All
![TicketmasterModel Sequence Diagram_4](https://user-images.githubusercontent.com/116668334/212551133-75954a90-037f-4d4e-92c7-dee5be57d2c6.jpg)
#### Genrecomparison: Genre
![TicketmasterModel Sequence Diagram_3](https://user-images.githubusercontent.com/116668334/212551018-0ed6a7a3-8428-4743-94b5-cee3ea9dfca2.jpg)
***

Per la rotta <b> /genretotal </b> :

![TicketmasterModel Sequence Diagram_5](https://user-images.githubusercontent.com/116668334/212551212-39b9d1e2-1450-4e7a-a999-67c44769dbd6.jpg)



<a name="rotte"></a>
## Rotte
<p align="justify">
L'utente può effettuare le richieste tramite Postman, all'indirizzo: <b> "localhost:8080" </b>

Le rotte definite sono le seguenti:

N° | Tipo | Rotta | Descrizione
----- | ------------ | -------------------- | ----------------------
[1](#1) | ` POST ` | `/total` | *Restituisce un JSONArray contenente il numero totale di eventi, che possono essere filtrati per uno o più stati e/o per uno o più generi.*
[2](#2) | ` POST ` | `/genretotal` | *Restituisce un JSONArray contenente i primi 500 eventi raggruppati per genere, che possono essere filtrati per uno o più stati.*
[3](#3) | ` POST ` | `/stats` | *Restituisce un JSONArray contenente le statistiche relative al numero minimo, massimo, medio di eventi mensili, che possono essere filtrati per uno o più stati e/o per uno o più generi.*

</p>

## Body della rotta e risposta JSON
Dal momento che tutte le rotte sono di tipo POST, l'utente necessita di un Body per effettuare le richieste.

### <p align="justify"> Requisiti per il corretto funzionamento delle rotte

Elemento | Descrizione
----- | ------------ |
| ` CountryComparison ` | *Richiede una stringa di tipo "Country" o "All".*
| ` CountryElements ` | *Vettore contenente tutti i countrycode inseriti dall'utente.*
| ` CountryName ` | *Richiede un countrycode ammesso da Ticketmaster.*
| ` GenreComparison ` | *Richiede una stringa di tipo "Genre" o "All".*
| ` GenreElements ` | *Vettore contenente tutti i generi inseriti dall'utente.*
| ` GenreName ` | *Richiede un genere ammesso da Ticketmaster.*
<br>   
<ul>     
<b> <li> Nel caso in cui l'utente vada ad inserire la stringa "All", veranno presi in considerazione, nella richiesta, tutti gli stati europei e tutti i generi, indipendentemente, dal contenuto di CountryElements e/o GenreElements. </li>
<br>
<li> Nel caso in cui l'utente vada ad inserire la stringa "Country" e/o "Genre", verranno presi in considerazione, nella richiesta, esclusivamente gli stati europei e/o i generi selezionati dall'utente. </li>
<br>
<li> N.B: Nel caso in cui CountryComparison è "All" potrebbe essere necessario ripetere più volte la chiamata in quanto l'utente potrebbe eccedere il numero di richieste al minuto concesse da Postman.     
</b>
</ul>

</p>

<a name="1"></a>
### 1.   /total
```
localhost:8080/total
```
Richiede un body di questo tipo:

     {
     "CountryComparison": "Country",
     "CountryElements": [
        {
          "CountryName": "GB"
        },
        {
          "CountryName": "FR"
        }
      ],

     "GenreComparison": "Genre",
     "GenreElements": [
        {
          "GenreName": "Rock"
        },
        {
          "GenreName": "Pop"
        }
     ]
     }

In tal caso, viene visualizzato il numero totale di eventi che si svolgono in Gran Bretagna e in Francia i cui generi sono Rock e Pop.

L'utente riceverà un JSONObject in risposta come segue:


![Screenshot (203)](https://user-images.githubusercontent.com/114992312/212469802-c660d598-f14b-465d-8233-1bdaa7501123.png)

<a name="2"></a>
### 2.   /genretotal
```
localhost:8080/genretotal
```
Richiede un body di questo tipo:

    {
     "CountryComparison": "Country",
     "CountryElements": [
        {
          "CountryName": "GB"
        },
        {
          "CountryName": "FR"
        }
      ]
     }
      
Nel caso sopracitato, viene visualizzato il numero totale di eventi, raggruppati per genere, che si svolgono in Gran Bretagna e in Francia.

L'utente riceverà un JSONObject in risposta come segue:

![Screenshot (207)](https://user-images.githubusercontent.com/114992312/212901486-2a446b50-eb2f-4ae2-a11a-15be6fdc31cf.png)

<a name="3"></a>
### 3.   /stats
```
localhost:8080/stats
```
Richiede un body di questo tipo:
     
     {
     "CountryComparison": "All",
     "CountryElements": [],

     "GenreComparison": "All",
     "GenreElements": []
      }
In tal caso, viene visualizzato lo stato con il minore e il maggiore numero totale di eventi mensili. 
Inoltre, viene visualizzata la media degli eventi totali mensili che si svolgono in tutti gli stati europei.

L'utente riceverà un JSONObject in risposta come segue:

![Screenshot (205)](https://user-images.githubusercontent.com/114992312/212469871-bd1cd615-0853-4a29-88b2-24fdbc224909.png)

<a name="countrycode"></a>
## CountryCode supportati

Di seguito vengono mostrati i countryCode degli stati europei supportati da Ticketmaster:

| Country | countryCode 
| ------------ | -------------------- 
| `Andorra` | `AD`
| `Austria`  |`AT`
| `Belgium` | `BE`
| `Bulgaria` | `BG`
| `Croatia`  |`HR`
| `Cyprus` | `CY`
| `Czech Republic` | `CZ`
| `Denmark`  |`DK`
| `Estonia` | `EE`
| `Faroe Islands`  |`FO`
| `Finland` | `FI`
| `France`  |`FR`
| `Georgia` | `GE`
| `Germany`  |`DE`
| `Gibraltar` | `GI`
| `Great Britain`  |`GB`
| `Greece` | `GR`
| `Hungary`  |`HU`
| `Iceland` | `IS`
| `Ireland`  |`IE`
| `Italy` | `IT`
| `Lithuania`  |`LT`
| `Luxembourg` | `LU`
| `Malta`  |`MT`
| `Monaco` | `MC`
| `Montenegro`  |`ME`
| `Netherlands` | `NL`
| `Northern Ireland`  |`ND`
| `Norway` | `NO`
| `Poland`  |`PL`
| `Portugal` | `PT`
| `Romania`  |`RO`
| `Russia` | `RU`
| `Serbia`  |`RS`
| `Slovakia` | `SK`
| `Slovenia`  |`SI`
| `Spain` | `ES`
| `Sweden`  |`SE`
| `Switzerland` | `CH`
| `Turkey`  |`TR`
| `Ukraine` | `UA`


<a name="generi"></a>
## Generi supportati

Di seguito vengono mostrati i generi supportati per le rotte /total e /stats:

| Generi |  
| ------------ | 
|`Alternative`|
|`Aquatics`|
|`AthleticRaces`|
|`Basketball`|
|`Blues`|
|`Boxing`|
|`ChildrensTheatre`|
|`CircusSpecialtyActs`|
|`Classical`|
|`Comedy`|
|`CommunityCivic`|
|`Country`|
|`Cricket`|
|`Cycling`|
|`Dance`|
|`DanceElectronic`|
|`Equestrian`|
|`Family`|
|`Fashion`|
|`Folk`|
|`HipHopRap`|
|`HobbySpecialInterestExpos`|
|`IceShows`|
|`Jazz`|
|`MagicIllusion`|
|`MartialArts`|
|`Metal`|
|`Miscellaneous`|
|`MiscellaneousTheatre`|
|`MotorsportsRacing`|
|`PerformanceArt`|
|`Pop`|
|`Reggae`|
|`Rock`|
|`Rugby`|
|`RB`|
|`Spectacular`|
|`Theatre`|
|`Undefined`|
|`Variety`|
|`Volleyball`|
|`World`|
|`Wrestling`|

<a name="eccezioni"></a>
## Eccezioni
Le rotte riportate sopra possono generare le seguenti ***eccezioni***:
  * Nel caso in cui l'utente inserisca un countryCode di uno stato non europeo oppure non esistente viene generata un'eccezione del tipo ***WrongCountryException*** che restituisce un messaggio di questo tipo:

   ```
    {country} non è un valore ammesso.
   ```
   * Nel caso in cui l'utente inserisca un genere non esistente viene generata un'eccezione del tipo ***WrongGenreException*** che restituisce un messaggio di questo tipo:

   ```
    {genre} non è un valore ammesso.
   ```
  * Nel caso in cui l'utente inserisca un Comparison diverso da Genre/Country/All viene generata un'eccezione del tipo ***WrongComparisonException*** che restituisce un messaggio di questo tipo:

   ```
    {CountryComparison} non è un valore ammesso. Scegliere un valore tra Country e All.

    {GenreComparison} non è un valore ammesso. Scegliere un valore tra Genre e All.   
   ```
<a name="test"></a>
## JUnit Test

Abbiamo implementato i seguenti [test](https://github.com/domenico1597/EsameOOP/tree/main/TicketMaster/src/test/java) per verificare il corretto funzionamento delle eccezioni implementate. A tal fine, vengono considerati i seguenti diagrammi delle classi:

<br>
     
1) Abbiamo testato l'effettivo funzionamento delle eccezioni riguardanti l'inserimento di un CountryComparison e/o di un GenreComparison errati.

<p align="center">
     
<img src="https://user-images.githubusercontent.com/116668334/212886861-ff08c756-faeb-4748-b1f9-ab90116dc1c9.jpg" width="367" height="267">
<img src="https://user-images.githubusercontent.com/116668334/212886881-39423218-54cd-4d4f-a008-d3deb88b0932.jpg" width="367" height="267">
<img src="https://user-images.githubusercontent.com/116668334/212886896-f7e45bbe-cbcb-43c8-8e95-caed9a37a4f9.jpg" width="367" height="267">
     
</p>
     
<br>
     
2) Abbiamo testato l'effettivo funzionamento delle eccezioni riguardanti l'inserimento di uno stato e/o di un genere errati.

<p align="center">

<img src="https://user-images.githubusercontent.com/116668334/212886937-6a05f945-d108-416f-9f68-6a2cba640685.jpg" width="367" height="267">
     
</p>

<a name="doc"></a>
## Documentazione Javadoc

Il codice Java è documentato in [Javadoc](https://github.com/domenico1597/EsameOOP/tree/main/TicketMaster/doc).

<a name="autor"></a>
## Autori
Hanno contribuito alla realizzazione di questo progetto:

Domenico Ciavarella <br>
Daniele Cota
