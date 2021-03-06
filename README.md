<h1>Progetto Twitter OOP</h1>
Progetto per il corso "Programmazione ad Oggetti" del corso di laurea in Ingegneria Informatica e dell'Automazione (UNIVPM), A.A. 2019/2020.
<h1>Introduzione</h1>
Questa repository è stata creata per contenere un Web Service che è un sistema software in grado di mettersi al servizio di un Client, comunicando tramite apposito protocollo. Esso consente agli utenti che si collegano di utilizzare le opzioni che mette a disposizione. Questo progetto è finalizzato alla realizzazione di una timeline utente personalizzata contenente i campi relativi ai contenuti multimediali dei tweet e degli hashtag presenti.
La nostra applicazione permette di richiedere mediante API REST (GET o POST) con rotte distinte:
<ul>
 	<li>Restituzione dei dati riguardanti ogni tweet in formato JSON;</li>
 	<li>Restituzione dei dati riguardanti tweet filtrati in formato JSON;</li>
 	<li>Restituzione dei metadati in formato JSON, cioè l’elenco degli attributi;</li>
 	<li>Restituzione delle statistiche sui tweet(con possibilità di filtraggio), sul numero di tweet per giorno, mese ed anno; statistiche sugli hashtag con una top N degli hashtag con N impostato dall’utente; statistiche dei contenuti multimediali: dimensione immagini, larghezza, altezza.</li>
</ul
 <h2><a id="user-content-contenuti" class="anchor" href="https://github.com/alexg99805/ProgettoOOP#contenuti" aria-hidden="true"></a>Contenuti del progetto</h2>
<ul type="circle">
 	<li><a href="https://github.com/alexg99805/ProgettoOOP#-richieste-possibili-">Richieste possibili da effettuare</a></li>
 	<li><a href="https://github.com/alexg99805/ProgettoOOP#-eseguire-richieste-">Tipologie di richieste</a></li>
 	<li><a href="https://github.com/alexg99805/ProgettoOOP#filtri-disponibili">Filtri a disposizione</a></li>
 	<li><a href="https://github.com/alexg99805/ProgettoOOP#-sviluppo-">Struttura del progetto</a></li>
 	<li><a href="https://github.com/alexg99805/ProgettoOOP#packages">Packages</a></li>
 	<li><a href="https://github.com/alexg99805/ProgettoOOP#classi">Classi</a></li>
 	<li><a href="https://github.com/alexg99805/ProgettoOOP#-chiamate-">Chiamate</a></li>
 	<li><a href="https://github.com/alexg99805/ProgettoOOP#software-utilizzati">Software usufruiti</a></li>
 	<li><a href="https://github.com/alexg99805/ProgettoOOP#autori">Autori</a></li>
</ul>
<h2><a id="user-content--richieste-possibili-da-effettuare" class="anchor" href="https://github.com/alexg99805/ProgettoOOP#-richieste-possibili-da-effettuare" aria-hidden="true"></a>Richieste possibili da effettuare</h2>
<a href="https://github.com/alexg99805/ProgettoOOP/blob/master/UML/user.PNG" target="_blank" rel="noopener noreferrer"><img src="https://github.com/alexg99805/ProgettoOOP/blob/master/UML/user.PNG" alt="diagramma dei casi d'uso" width="600px" height="420px" /></a>
<h2><a id="user-content--tipologie-di-richieste-" class="anchor" href="https://github.com/alexg99805/ProgettoOOP#-richieste-possibili-" aria-hidden="true"></a>Tipologie di richieste</h2>
Per eseguire le richieste GET o POST si può installare un API testing come Postman e, per effettuare queste richieste, l'utente può consultare la tabella di seguito che mostra le istruzioni per visualizzare i dati interessati:
<table>
<thead>
<tr>
<th><strong>TIPO</strong></th>
<th><strong>ROTTA</strong></th>
<th><strong>DESCRIZIONE</strong></th>
</tr>
</thead>
<tbody>
<tr>
<td>GET</td>
<td>/metadata</td>
<td>restituisce gli alias utilizzati</td>
</tr>
<tr>
<td>GET</td>
<td>/data</td>
<td>restituisce l'intero dataset</td>
</tr>
<tr>
<td>GET</td>
<td>/stats</td>
<td>restituisce delle statistiche sul numero di hashtag contenuti in ogni tweet per gli ultimi cento tweet, statistiche sul numero di tweet per giorno mese e anno, statistiche sui contenuti multimediali</td>
</tr>
<tr>
<td>POST</td>
<td>/data</td>
<td>restituisce i tweet che rispettano i filtri specificati nel body della richiesta</td>
</tr>
<tr>
<td>POST</td>
<td>/stats</td>
<td>restituisce statistiche quali il numero di occorrenti degli hashtag contenuti in ogni tweet per gli ultimi cento tweet, statistiche sul numero di tweet per giorno mese e anno, statistiche sui contenuti multimediali</td>
</tr>
<tr>
<td>POST</td>
<td>/stats?field=N</td>
<td>restituisce statistiche quali la top N degli hashtag contenuti in ogni tweet per gli ultimi cento tweet, statistiche sul numero di tweet per giorno mese e anno, statistiche sui contenuti multimediali</td></td>
</tr>
</tbody>
</table>
<h4><a id="user-content-filtri-a-disposizione" class="anchor" href="https://github.com/alexg99805/ProgettoOOP/ProgettoOOP#filtri-a-disposizione" aria-hidden="true"></a>Filtri a disposizione</h4>
<table>
<thead>
<tr>
<th><strong>NOME OPERATORE</strong></th>
<th><strong>ESEMPIO</strong></th>
<th><strong>DESCRIZIONE</strong></th>
</tr>
</thead>
<tbody>
<tr>
<td>Greater</td>
<td>{"Hashtag" : { "Greater" : 6}}</td>
<td>maggiore (valido per campi numerici)</td>
</tr>
<tr>
<td>Less</td>
<td>{"Width" : { "Less" : 1000}}</td>
<td>minore (valido per campi numerici)</td>
</tr>
<tr>
<td>Included</td>
<td>{"Hashtag { "Included" : ["remotesensing"]}}</td>
<td>trova una corrispondenza con i valori dell'array (valido per stringhe)</td>
</tr>
<tr>
<td>NotIncluded</td>
<td>{"Hashtag" : { "NotIncluded" : ["satellite"]}}</td>
<td>non trova una corrispondenza con i valori dell'array (valido per stringhe)</td>
</tr>
<tr>
<td>In</td>
<td>{"Height" : { "In" : [350,800]}}</td>
<td>compreso tra (valido per campi numerici)</td>
</tr>
<tr>
<td>Nin</td>
<td>{"Height" : { "Nin" : [100,620]}}</td>
<td>non compreso tra (valido per campi numerici)</td>
</tr>
<tr>
<td>After</td>
<td>{"Date" : { "After" : ["2020-06-20"]}}</td>
<td>stampa tutti i tweet postati dopo una certa data(formato data: yyyy-mm-dd)</td>
</tr>
<tr>
<td>Before</td>
<td>{"Date" : {  "Before"  : ["2020-12-03"]}}</td>
<td>stampa tutti i tweet postati prima di una certa data(formato data: yyyy-mm-dd)</td>
</tr>
</tbody>
</table>
<th><strong>N.B.</strong></th>
Inoltre, è possibile concatenare più filtri utilizzando il comando "Type" che appunto ci permette di unire anche più di due campi.
{ "Hashtag":{"Greater": 6}, "Date":{"Type":"and","After":["2020-07-14"]},"Width":{"Type":"or","Greater":1000 } }

<h2><a id="user-content--struttura-del-progetto-" class="anchor" href="https://github.com/alexg99805/ProgettoOOP#-struttura-del-progetto-" aria-hidden="true"></a>Struttura del progetto</h2>
<h3><a id="user-content-packages" class="anchor" href="https://github.com/alexg99805/ProgettoOOP#packages" aria-hidden="true"></a>Packages</h3>
<a href="https://github.com/alexg99805/ProgettoOOP/blob/master/UML/package.PNG" target="_blank" rel="noopener noreferrer"><img src="https://github.com/alexg99805/ProgettoOOP/blob/master/UML/package.PNG" alt="diagramma delle classi raffiguranti i packages" width="650px" height="390px" /></a>
<h3><a id="user-content-classi" class="anchor" href="https://github.com/alexg99805/ProgettoOOP#classi" aria-hidden="true"></a>Classi</h3>
<ul>
 	<li><strong>package it.univpm.TwitterOOP.controller;</strong></li>
</ul>
<a href="https://github.com/alexg99805/ProgettoOOP/blob/master/UML/controller.jpeg" target="_blank" rel="noopener noreferrer"><img src="https://github.com/alexg99805/ProgettoOOP/blob/master/UML/controller.jpeg" alt="diagramma delle classi raffigurante il package controller" width="500px" height="500px" /></a>
<ul>
 	<li><strong>package it.univpm.TwitterOOP.db;</strong></li>
</ul>
<a href="https://github.com/alexg99805/ProgettoOOP/blob/master/UML/databasediagram.PNG" target="_blank" rel="noopener noreferrer"><img src="https://github.com/alexg99805/ProgettoOOP/blob/master/UML/databasediagram.PNG" alt="diagramma delle classi raffigurante il package database" width="200px" height="180px" /></a>
<ul>
 	<li><strong>package it.univpm.TwitterOOP.exception;</strong></li>
</ul>
<a href="https://github.com/alexg99805/ProgettoOOP/blob/master/UML/Schermata%20del%202020-07-26%2018-53-27.png" target="_blank" rel="noopener noreferrer"><img src="https://github.com/alexg99805/ProgettoOOP/blob/master/UML/Schermata%20del%202020-07-26%2018-53-27.png" alt="diagramma delle classi raffigurante il package Exception" width="550px" height="300px" /></a>
<ul>
 	<li><strong>package it.univpm.TwitterOOP.model;</strong></li>
</ul>
<a href="https://github.com/alexg99805/ProgettoOOP/blob/master/UML/Schermata%20del%202020-07-26%2018-54-41.png" target="_blank" rel="noopener noreferrer"><img src="https://github.com/alexg99805/ProgettoOOP/blob/master/UML/Schermata%20del%202020-07-26%2018-54-41.png" alt="diagramma delle classi raffigurante il package model" width="1000px" height="900px" /></a>
<ul>
 	<li><strong>package it.univpm.TwitterOOP.service;</strong>

<a href="hhttps://github.com/alexg99805/ProgettoOOP/blob/master/UML/Schermata%20del%202020-07-26%2018-55-23.png" target="_blank" rel="noopener noreferrer"><img src="https://github.com/alexg99805/ProgettoOOP/blob/master/UML/Schermata%20del%202020-07-26%2018-55-23.png" alt="diagramma delle classi raffigurante il package service" width="800px" height="530px" /></a></li>
 	<li><strong>package it.univpm.TwitterOOP.util.other;</strong></li>
</ul>
<a href="https://github.com/alexg99805/ProgettoOOP/blob/master/UML/Schermata%20del%202020-07-26%2018-59-03.png" target="_blank" rel="noopener noreferrer"><img src="https://github.com/alexg99805/ProgettoOOP/blob/master/UML/Schermata%20del%202020-07-26%2018-59-03.png" alt="diagramma delle classi raffigurante il package util" width="900px" height="400px" /></a>
<ul>
 	<li><strong>package it.univpm.TwitterOOP.util.filter;</strong></li>
</ul>
<a href="https://github.com/alexg99805/ProgettoOOP/blob/master/UML/Schermata%20del%202020-07-26%2018-57-42.png" target="_blank" rel="noopener noreferrer"><img src="https://github.com/alexg99805/ProgettoOOP/blob/master/UML/Schermata%20del%202020-07-26%2018-57-42.png" alt="diagramma delle classi raffigurante il package filter" width="890px" height="530px" /></a>
<ul>
 	<li><strong>package it.univpm.TwitterOOP.util.stats;</strong></li>
</ul>

<a href="https://github.com/alexg99805/ProgettoOOP/blob/master/UML/Schermata%20del%202020-07-26%2019-00-02.png" target="_blank" rel="noopener noreferrer"><img src="https://github.com/alexg99805/ProgettoOOP/blob/master/UML/Schermata%20del%202020-07-26%2019-00-02.png" alt="diagramma delle classi raffigurante il package stats" width="800px" height="530px" /></a>
<h2><a id="user-content--chiamate-" class="anchor" href="https://github.com/alexg99805/ProgettoOOP#-chiamate-" aria-hidden="true"></a>Chiamate</h2>
In questo punto esaminiamo nello specifico le chiamate che l'utente può effettuare utilizzando i diagrammi delle sequenze, i quali mostrano come interagiscono tra di loro gli oggetti delle varie classi e forniscono informazioni anche di tipo temporale, poiché le interazioni nel diagramma vengono disposte in ordine cronologico.<ul>
 	<li><strong>Chiamata GET /metadata</strong></li>
</ul>

<a href="https://github.com/alexg99805/ProgettoOOP/blob/master/UML/getmetadata.jpeg" target="_blank" rel="noopener noreferrer"><img src="https://github.com/alexg99805/ProgettoOOP/blob/master/UML/getmetadata.jpeg" alt="Chiamata  GET metadata sequence diagram" width="440px" height="370px" /></a>
<ul>
 	<li><strong>Chiamata GET /data</strong></li>
</ul>
<a href="https://github.com/alexg99805/ProgettoOOP/blob/master/UML/getdata.jpeg" target="_blank" rel="noopener noreferrer"><img src="https://github.com/alexg99805/ProgettoOOP/blob/master/UML/getdata.jpeg" alt="Chiamata GET data sequence diagram" width="440px" height="370px" /></a>
<ul>
 	<li><strong>Chiamata POST /data</strong></li>
</ul>
<a href="https://github.com/alexg99805/ProgettoOOP/blob/master/UML/postdata.PNG" target="_blank" rel="noopener noreferrer"><img src="https://github.com/alexg99805/ProgettoOOP/blob/master/UML/postdata.PNG" alt="Chiamata POST data sequence diagram" width="880px" height="610px" /></a>
<ul>
 	<li><strong>Chiamata GET /stats</strong></li>
</ul>
<a href="https://github.com/alexg99805/ProgettoOOP/blob/master/UML/getstats.jpeg" target="_blank" rel="noopener noreferrer"><img src="https://github.com/alexg99805/ProgettoOOP/blob/master/UML/getmetadata.jpeg" alt="Chiamata GET stats sequence diagram" width="440px" height="370px" /></a>
<ul>
 	<li><strong>Chiamata POST /stats</strong></li>
</ul>
<a href="https://github.com/alexg99805/ProgettoOOP/blob/master/UML/poststats.PNG" target="_blank" rel="noopener noreferrer"><img src="https://github.com/alexg99805/ProgettoOOP/blob/master/UML/poststats.PNG" alt="Chiamata POST stats sequence diagram" width="440px" height="370px" /></a>

<h1><a id="user-content-software-usufruiti" class="anchor" href="https://github.com/alexg99805/ProgettoOOP#software-usufruiti" aria-hidden="true"></a>Software usufruiti</h1>
<ul>
 	<li><a href="https://www.eclipse.org/" rel="nofollow">Eclipse</a> - ambiente di sviluppo integrato</li>
 	<li><a href="https://spring.io/projects/spring-boot" rel="nofollow">Spring Boot</a> - framework per sviluppo di applicazioni in Java</li>
 	<li><a href="https://maven.apache.org/" rel="nofollow">Maven</a> - strumento di gestione di progetti</li>
 	<li><a href="http://www.umldesigner.org/" rel="nofollow">UML Designer</a> - strumento per la realizzazione dei diagrammi UML</li>
  <li><a href="https://www.postman.com/" rel="nofollow">Postman</a> - strumento che ci permette di effettuare richieste di tipo GET e POST
</ul>
<h1><a id="user-content-autori" class="anchor" href="https://github.com/alexg99805/ProgettoOOP#autori" aria-hidden="true"></a>Autori</h1>
<ul type="disc">
 <li><a href="https://github.com/alexg99805/ProgettoOOP">Davide Pacioni</a> Sviluppo progetto determinato più sul codice.</li>
 <li><a href="https://github.com/alexg99805/ProgettoOOP">Alex Giaccio</a> Sviluppo progetto determinato più su Readme, UML, sequence diagrams.</li>
</ul>
