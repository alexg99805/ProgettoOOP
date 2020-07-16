<h1>Progetto Twitter OOP</h1>
Progetto per il corso "Programmazione ad Oggetti" del corso di laurea in Ingegneria Informatica e dell'Automazione (UNIVPM), A.A. 2019/2020.
<h1>Introduzione</h1>
Questa repository è stata creta per contenere un Web Service che è un sistema software in grado di mettersi al servizio di un Client, comunicando tramite apposito protocollo. Esso consente agli utenti che si collegano di utilizzare le opzioni che mette a disposizione.  Questo progetto è finalizzato alla realizzazione di una timeline utente personalizzata contenente i campi relativi ai contenuti multimediali dei tweet e degli hashtag presenti.
La nostra applicazione permette di richiedere mediante API REST (GET o POST) con rotte distinte:
<ul>
 	<li>Restituzione dei dati riguardanti ogni tweet in formato JSON;</li>
 	<li>Restituzione dei dati riguardanti tweet filtrati in formato JSON;</li>
 	<li>Restituzione dei metadati in formato JSON, cioè l’elenco degli attributi;</li>
 	<li>Restituzione delle statistiche sul numero di tweet per giorno, mese ed anno; statistiche sugli hashtag con una top N degli hashtag con N impostato dall’utente; statistiche dei contenuti multimediali: dimensione immagini, larghezza, altezza.</li>
</ul
 <h2><a id="user-content-contenuti" class="anchor" href="https://github.com/alexg99805/ProgettoOOP#contenuti" aria-hidden="true"></a>Contenuti del progetto</h2>
<ul type="circle">
 	<li><a href="https://github.com/alexg99805/ProgettoOOP#-richieste-possibili-">Richieste possibili da effettuare</a></li>
 	<li><a href="https://github.com/alexg99805/ProgettoOOP#-eseguire-richieste-">Richieste possibili</a></li>
 	<li><a href="https://github.com/alexg99805/ProgettoOOP#filtri-disponibili">Filtri a disposizione</a></li>
 	<li><a href="https://github.com/alexg99805/ProgettoOOP#-sviluppo-">Struttura del progetto</a></li>
 	<li><a href="https://github.com/alexg99805/ProgettoOOP#diagramma-delle-classi">Diagramma delle classi</a></li>
 	<li><a href="https://github.com/alexg99805/ProgettoOOP#packages">Packages</a></li>
 	<li><a href="https://github.com/alexg99805/ProgettoOOP#classi">Classi</a></li>
 	<li><a href="https://github.com/alexg99805/ProgettoOOP#-chiamate-">Chiamate</a></li>
 	<li><a href="https://github.com/alexg99805/ProgettoOOP#software-utilizzati">Software usufruiti</a></li>
 	<li><a href="https://github.com/alexg99805/ProgettoOOP#autori">Autori</a></li>
</ul>
<h2><a id="user-content--richieste-possibili-da-effettuare" class="anchor" href="https://github.com/alexg99805/ProgettoOOP#-richieste-possibili-da-effettuare" aria-hidden="true"></a>Richieste possibili da effettuare</h2>
<a href="https://github.com/alexg99805/ProgettoOOP/blob/master/UMLDiagram/OOP%20Use%20Case%20user.jpg" target="_blank" rel="noopener noreferrer"><img src="https://github.com/alexg99805/ProgettoOOP/raw/master/UMLDiagram/OOP%20Use%20Case%20user.jpg" alt="diagramma dei casi d'uso" width="600px" height="420px" /></a>
<h2><a id="user-content--richieste-possibili-" class="anchor" href="https://github.com/alexg99805/ProgettoOOP#-richieste-possibili-" aria-hidden="true"></a>Richieste possibili</h2>
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
<td>restituisce gli ultimi cento tweet</td>
</tr>
<tr>
<td>GET</td>
<td>/stats</td>
<td>restituisce una statistica sul numero di hashtag contenuti in ogni tweet per gli ultimi cento tweet</td>
</tr>
<tr>
<td>POST</td>
<td>/data</td>
<td>restituisce i tweet che rispettano i filtri specificati nel body della richiesta</td>
</tr>
<tr>
<td>POST</td>
<td>/stats</td>
<td>restituisce una statistica sul numero di hashtag utilizzati da un utente(da inserire tramite body) e permette di visualizzare anche gli hashtag utilizzati dall'utente</td>
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
<td>{"RetweetCount" : { "Less" : 30}}</td>
<td>minore (valido per campi numerici)</td>
</tr>
<tr>
<td>Included</td>
<td>{"Mentions" : { "Included" : ["equipeprivacy"]}}</td>
<td>trova una corrispondenza con i valori dell'array (valido per stringhe)</td>
</tr>
<tr>
<td>NotIncluded</td>
<td>{"Lang" : { "NotIncluded" : ["en"]}}</td>
<td>non trova una corrispondenza con i valori dell'array (valido per stringhe)</td>
</tr>
<tr>
<td>In</td>
<td>{"Hashtag" : { "In" : [2,7]}}</td>
<td>compreso tra (valido per campi numerici)</td>
</tr>
<tr>
<td>Nin</td>
<td>{"Hashtag" : { "Nin" : [2,5]}}</td>
<td>non compreso tra (valido per campi numerici)</td>
</tr>
<tr>
<td>Created</td>
<td>{"User" : { "Created" : ["cybersec_feeds"]}}</td>
<td>stampa tutti i tweet creati da un utente (valido per stringhe)</td>
</tr>
<tr>
<td>NotCreated</td>
<td>{"User" : { "NotCreated" : ["cybersec_feeds"]}}</td>
<td>stampa tutti i tweet non creati da un utente (valido per stringhe)</td>
</tr>
<tr>
<td>Yes</td>
<td>{"Mentions" : { "Yes" : []}}</td>
<td>viene utilizzato per filtrare tutti quei tweet in cui sono presenti un'immagine o delle menzioni</td>
</tr>
<tr>
<td>Not</td>
<td>{"Image" : { "Not" : []}}</td>
<td>viene utilizzato per filtrare tutti quei tweet in cui sono non presenti un'immagine o delle menzioni</td>
</tr>
</tbody>
</table>

<h2><a id="user-content--struttura-del-progetto-" class="anchor" href="https://github.com/alexg99805/ProgettoOOP#-struttura-del-progetto-" aria-hidden="true"></a>Struttura del progetto</h2>
<a href="https://github.com/alexg99805/ProgettoOOP/blob/master/UMLDiagram/OOP%20Class%20Diagram.jpg" target="_blank" rel="noopener noreferrer"><img src="https://github.com/alexg99805/ProgettoOOP/raw/master/UMLDiagram/OOP%20Class%20Diagram.jpg" alt="diagramma delle classi raffigurante tutti i package con tutte le classi" width="1000px" height="700px" /></a>
<h3><a id="user-content-packages" class="anchor" href="https://github.com/alexg99805/ProgettoOOP#packages" aria-hidden="true"></a>Packages</h3>

<h3><a id="user-content-classi" class="anchor" href="https://github.com/alexg99805/ProgettoOOP#classi" aria-hidden="true"></a>Classi</h3>
<ul>
 	<li><strong>package it.univpm.TwitterOOP.controller;</strong></li>
</ul>
<a href="https://github.com/alexg99805/ProgettoOOP/blob/master/UMLDiagram/OOP%20Class%20Diagram%20controllerdiagrams.jpg" target="_blank" rel="noopener noreferrer"><img src="https://github.com/alexg99805/ProgettoOOP/raw/master/UMLDiagram/OOP%20Class%20Diagram%20controllerdiagrams.jpg" alt="diagramma delle classi raffigurante il package controller" width="280px" height="200px" /></a>
<ul>
 	<li><strong>package it.univpm.TwitterOOP.db;</strong></li>
</ul>
<a href="https://github.com/alexg99805/ProgettoOOP/blob/master/UMLDiagram/OOP%20Class%20Diagram%20databasediagram.jpg" target="_blank" rel="noopener noreferrer"><img src="https://github.com/alexg99805/ProgettoOOP/raw/master/UMLDiagram/OOP%20Class%20Diagram%20databasediagram.jpg" alt="diagramma delle classi raffigurante il package database" width="200px" height="180px" /></a>
<ul>
 	<li><strong>package it.univpm.TwitterOOP.exception;</strong></li>
</ul>
<a href="https://github.com/alexg99805/ProgettoOOP/blob/master/UMLDiagram/OOP%20Class%20Diagram%20exceptionsdiagrams.jpg" target="_blank" rel="noopener noreferrer"><img src="https://github.com/alexg99805/ProgettoOOP/raw/master/UMLDiagram/OOP%20Class%20Diagram%20exceptionsdiagrams.jpg" alt="diagramma delle classi raffigurante il package Exception" width="550px" height="400px" /></a>
<ul>
 	<li><strong>package it.univpm.TwitterOOP.model;</strong></li>
</ul>
<a href="https://github.com/alexg99805/ProgettoOOP/blob/master/UMLDiagram/OOP%20Class%20Diagram%20modelsdiagrams.jpg" target="_blank" rel="noopener noreferrer"><img src="https://github.com/alexg99805/ProgettoOOP/raw/master/UMLDiagram/OOP%20Class%20Diagram%20modelsdiagrams.jpg" alt="diagramma delle classi raffigurante il package model" width="1000px" height="650px" /></a>
<ul>
 	<li><strong>package it.univpm.TwitterOOP.service;</strong>

<a href="https://github.com/alexg99805/ProgettoOOP/blob/master/UMLDiagram/OOP%20Class%20Diagram%20servicediagrams.jpg" target="_blank" rel="noopener noreferrer"><img src="https://github.com/alexg99805/ProgettoOOP/raw/master/UMLDiagram/OOP%20Class%20Diagram%20servicediagrams.jpg" alt="diagramma delle classi raffigurante il package service" width="500px" height="530px" /></a></li>
 	<li><strong>package it.univpm.TwitterOOP.util.other;</strong></li>
</ul>
<a href="https://github.com/alexg99805/ProgettoOOP/blob/master/UMLDiagram/OOP%20Class%20Diagram%20otherdiagrams.jpg" target="_blank" rel="noopener noreferrer"><img src="https://github.com/alexg99805/ProgettoOOP/raw/master/UMLDiagram/OOP%20Class%20Diagram%20otherdiagrams.jpg" alt="diagramma delle classi raffigurante il package util" width="900px" height="530px" /></a>
<ul>
 	<li><strong>package it.univpm.TwitterOOP.util.filter;</strong></li>
</ul>
<a href="https://github.com/alexg99805/ProgettoOOP/blob/master/UMLDiagram/OOP%20Class%20Diagram%20filterdiagrams.jpg" target="_blank" rel="noopener noreferrer"><img src="https://github.com/alexg99805/ProgettoOOP/raw/master/UMLDiagram/OOP%20Class%20Diagram%20filterdiagrams.jpg" alt="diagramma delle classi raffigurante il package filter" width="890px" height="530px" /></a>
<ul>
 	<li><strong>package it.univpm.TwitterOOP.util.stats;</strong></li>
</ul>

<a href="https://github.com/alexg99805/ProgettoOOP/blob/master/UMLDiagram/OOP%20Class%20Diagram%20statsdiagram.jpg" target="_blank" rel="noopener noreferrer"><img src="https://github.com/alexg99805/ProgettoOOP/raw/master/UMLDiagram/OOP%20Class%20Diagram%20statsdiagram.jpg" alt="diagramma delle classi raffigurante il package stats" width="220px" height="180px" /></a>




<h1><a id="user-content-autori" class="anchor" href="https://github.com/alexg99805/ProgettoOOP#autori" aria-hidden="true"></a>Autori</h1>
<ul type="disc">
 	<li><a href="https://github.com/alexg99805/ProgettoOOP">Davide Pacioni</a></li>
 	<li><a href="https://github.com/alexg99805/ProgettoOOP">Alex Giaccio</a></li>
</ul>
