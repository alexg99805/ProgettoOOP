Progetto TwitterOOP
Progetto per il corso "Programmazione ad Oggetti" del corso di laurea in Ingegneria Informatica e dell'Automazione (UNIVPM), A.A. 2019/2020.
Introduzione
Questa repository è stata creta per contenere un Web Service che è un sistema software in grado di mettersi al servizio di un Client, comunicando tramite apposito protocollo. Esso consente agli utenti che si collegano di utilizzare le opzioni che mette a disposizione.  Questo progetto è finalizzato alla realizzazione di una timeline utente personalizzata contenente i campi relativi ai contenuti multimediali dei tweet e degli hashtag presenti.
La nostra applicazione permette di richiedere mediante API REST (GET o POST) con rotte distinte:
•	Restituzione dei dati riguardanti ogni tweet in formato JSON;
•	Restituzione dei dati riguardanti tweet filtrati in formato JSON;
•	Restituzione dei metadati in formato JSON, cioè l’elenco degli attributi;
•	Restituzione delle statistiche sul numero di tweet per giorno, mese ed anno; statistiche sugli hashtag con una top N degli hashtag con N impostato dall’utente; statistiche dei contenuti multimediali: dimensione immagini, larghezza, altezza.
•	Restituzione delle statistiche, formato JSON, sul numero hashtag contenuto in ogni post per un determinato utente.
