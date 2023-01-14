<h1 align="center"> Ticketmaster </h1>

<p align="justify"> La nostra applicazione consente all'utente di calcolare statistiche sugli eventi che avranno luogo in Europa. In particolare, permette di filtrare e visualizzare per regione e genere: il numero totale di eventi, il numero di eventi raggruppati per genere, il numero minimo/massimo/medio di eventi mensili. </p>


## **Indice**
* [Introduzione](#intro)
* [Diagrammi UML](#uml)
* [Avvio dell'applicazione](#avvio)
* [Rotte](#rotte)
* [Eccezioni](#eccezioni)
* [JUnit Test](#test)
* [Documentazione Javadoc](#doc)
* [Autori](#autor)

<a name="intro"></a>
## Introduzione
<p align="justify">
Il programma Ticketmaster permette di studiare gli eventi che avranno luogo in Europa, utilizzando le API del sito Ticketmaster, reperibili al seguente indirizzo: https://developer.ticketmaster.com/products-and-docs/apis/discovery-api/v2/#search-events-v2. 

L'applicazione consente di ottenere le informazioni relative agli eventi che si svolgono nei paesi europei supportati da Ticketmaster, permettendo all'utente di scegliere se visualizzare la globalità degli eventi di uno o più paesi e/o di raggruppare questi ultimi in base ad uno o più generi.
Inoltre, l'utente può effettuare delle statistiche sugli eventi per visualizzare:
quale tra i paesi selezionati presenti il maggior e il minor numero di eventi mensili.
la media degli eventi mensili dei paesi/generi specificati dall'utente.
</p>

<a name="uml"></a>
## Diagrammi UML

*Diagramma dei Casi d'Uso*
***
![DiagrammaCasiUso_0_1](https://user-images.githubusercontent.com/116668334/212486415-3820bf53-22d2-4b6c-a058-55df3ea6973f.jpg)

*Diagramma delle Classi*
***
*Diagramma delle Sequenze*
***

<a name="rotte"></a>
## Rotte
<p align="justify">
L'utente può effettuare le richieste tramite Postman, all'indirizzo: <b> "localhost:8080" </b>

Le rotte definite sono le seguenti:

N° | Tipo | Rotta | Descrizione
----- | ------------ | -------------------- | ----------------------
[1](#1) | ` POST ` | `/total` | *Restituisce un JSONArray contenente il numero totale di eventi, che possono essere filtrati per uno o più stati e/o per uno o più generi.*
[2](#2) | ` POST ` | `/genretotal` | *Restituisce un JSONArray contenente il numero totale di eventi raggruppati per genere, che possono essere filtrati per uno o più stati.*
[3](#3) | ` POST ` | `/stats` | *Restituisce un JSONArray contenente le statistiche relative al numero minimo, massimo, medio di eventi mensili, che possono essere filtrati per uno o più stati e/o per uno o più generi.*

</p>

## Body della rotta e risposta JSON
Dal momento che tutte le rotte sono di tipo POST, l'utente necessita di un Body per effettuare le richieste.

### <p align="justify"> Requisiti per il corretto funzionamento delle rotte

Elemento | Descrizione
----- | ------------ |
| ` CountryComparison ` | *Richiede una stringa di tipo "Country" o "All".*
| ` CountryElements ` | *Vettore contenente tutti gli idcountry inseriti dall'utente.*
| ` CountryName ` | *Richiede un idcountry ammesso da Ticketmaster.*
| ` GenreComparison ` | *Richiede una stringa di tipo "Genre" o "All".*
| ` GenreElements ` | *Vettore contenente tutti i generi inseriti dall'utente.*
| ` GenreName ` | *Richiede un genere ammesso da Ticketmaster.*
<br>   
<ul>     
<b> <li> Nel caso in cui l'utente vada ad inserire la stringa "All", veranno presi in considerazione, nella richiesta, tutti i paesi europei e tutti i generi, indipendentemente, dal contenuto di CountryElements e/o GenreElements. </li>
<br>
<li> Nel caso in cui l'utente vada ad inserire la stringa "Country" e/o "Genre", verranno presi in considerazione, nella richiesta, esclusivamente i paesi europei e/o i generi selezionati dall'utente. </li>
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
      
In tal caso, viene visualizzato il numero totale di eventi, raggruppati per genere, che si svolgono in Gran Bretagna e in Francia.

L'utente riceverà un JSONObject in risposta come segue:

![Screenshot (204)](https://user-images.githubusercontent.com/114992312/212469852-615a3fa4-4a82-430b-93a9-b4995f42e9b2.png)

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
In tal caso, viene visualizzato il paese con il minore e il maggiore numero totale di eventi mensili. 
Inoltre, viene visualizzata la media degli eventi totali mensili che si svolgono in tutti i paesi europei.

L'utente riceverà un JSONObject in risposta come segue:

![Screenshot (205)](https://user-images.githubusercontent.com/114992312/212469871-bd1cd615-0853-4a29-88b2-24fdbc224909.png)

<a name="eccezioni"></a>
## Eccezioni
Le rotte riportate sopra possono generare le seguenti ***eccezioni***:
  * Nel caso in cui l'utente inserisca un countryCode di un paese non europeo oppure non esistente viene generata un'eccezione del tipo ***WrongCountryException*** che restituisce un messaggio di questo tipo:

   ```
    {country} non è un valore ammesso.
   ```
   * Nel caso in cui l'utente inserisca un genere non esistente viene generata un'eccezione del tipo ***WrongGenreException*** che restituisce un messaggio di questo tipo:

   ```
    {genre} non è un valore ammesso.
   ```
  * Nel caso in cui l'utente inserisca un Comparison diverso da Genre/Country/All viene generata un'eccezione del tipo ***WrongComparisonException*** che restituisce un messaggio di questo tipo:

   ```
    {CountryComparison} non è un valore ammesso. Scegliere un valore tra Country o All.

    {GenreComparison} non è un valore ammesso. Scegliere un valore tra Genre o All.   
   ```
<a name="test"></a>
## JUnit Test
<a name="doc"></a>
## Documentazione Javadoc
Ogni package, classe, attributo e metodo che costituisce il software 'Ticketmaster' è interamente e completamente documentato attraverso l'utilizzo della JavaDoc;

In particolare, per accedere alla documentazione tramite pagina HTML, è necessario seguire il percorso:
`ticketmaster > doc > index.html`.

Una volta aperta la pagina `index.html`, è possibile accedere alla documentazione dell'intero codice selezionando:
* la voce `OVERVIEW` che descrive ogni package del progetto
* la voce `TREE` che descrive la gerarchia delle classi del progetto
* la voce `INDEX` che permette di cercare packages, classi, attributi e metodi in base al carattere iniziale selezionato
* la voce `INDEX > All Classes` che descrive ogni classe del progetto
* la voce `INDEX > All Classes > Exception Summary` che descrive la classe di gestione eccezioni del progetto

Ovviamente, cliccando il nome di una qualsiasi classe nella pagina `index.html`, sarà possibile accedere ad informazioni quali metodi, attributi, package di appartenenza, metodo costruttore, autore della classe, ecc...
