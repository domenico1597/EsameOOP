<h1 align="center"> Ticketmaster </h1>

<p align="justify"> La nostra applicazione consente all'utente di calcolare statistiche sugli eventi che avranno luogo in Europa. In particolare, permette di filtrare e visualizzare per regione e genere: il numero totale di eventi, il numero di eventi raggruppati per genere, il numero minimo/massimo/medio di eventi mensili. </p>


## **Indice**
* [Introduzione](#intro)
* [Diagrammi UML](#uml)
* [Avvio dell'applicazione](#avvio)
* [Rotte](#rotte)
* [Rotte Aggiuntive](#rotteaggiuntive)
* [Test](#test)
* [Documentazione](#doc)
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

<a name="rotte"></a>
## Rotte
<p align="justify">
L'utente può effettuare le richieste tramite Postman all'indirizzo:
```
localhost:8080
```
Le principali rotte definite sono le seguenti:

N° | Tipo | Rotta | Descrizione
----- | ------------ | -------------------- | ----------------------
[1](#1) | ` POST ` | `/total` | *restituisce un JSONArray contenente il numero totale di eventi, che possono essere filtrati per uno o più stati e/o per uno o più generi*
[2](#2) | ` POST ` | `/genretotal` | *restituisce un JSONArray contenente il numero totale di eventi raggruppati per genere, che possono essere filtrati per uno o più stati*
[3](#3) | ` POST ` | `/stats` | *restituisce un JSONArray contenente le statistiche relative al numero minimo, massimo, medio di eventi mensili, che possono essere filtrati per uno o più stati e/o per uno o più generi*

</p>

### Body della rotta e risposta JSON
Dal momento che tutte le rotte sono di tipo POST, l'utente necessita di un Body per effettuare le richieste.

<a name="1"></a>
## 1.   /total
Richiede un body di questo tipo:
{

     "CountryComparison": "All",
     "CountryElements": [
        {
          "CountryName": "GB"
        },
        {
          "CountryName": "FR"
        }
      ],

     "GenreComparison": "All",
     "GenreElements": [
        {
          "GenreName": "Rock"
        },
        {
          "GenreName": "Pop"
        }
     ]

La prima rotta restituisce un JSONObject contentente a sua volta i JSONObject che riportano le informazioni relative agli eventi del paese selezionato, mentre in fondo sono presenti campi indicanti rispettivamente il numero di eventi mostrati ed il numero totale di eventi esistenti. Possono essere inseriti countryCode solo di paesi europei (la lista dei countryCode ammessi è presente sotto), altrimenti verrà lanciata un'eccezione.

Di seguito vengono mostrati i codici dei paesi europei supportati da Ticketmaster:

<a name="2"></a>
## 2.   /genretotal
Richiede un body di questo tipo:
{

     "CountryComparison": "All",
     "CountryElements": [
        {
          "CountryName": "GB"
        },
        {
          "CountryName": "FR"
        }
      ]
     
     
 <a name="3"></a>
## 3.   /stats
Richiede un body di questo tipo:
{

     "CountryComparison": "All",
     "CountryElements": [
        {
          "CountryName": "GB"
        },
        {
          "CountryName": "FR"
        }
      ],

     "GenreComparison": "All",
     "GenreElements": [
        {
          "GenreName": "Rock"
        },
        {
          "GenreName": "Pop"
        }
     ]
