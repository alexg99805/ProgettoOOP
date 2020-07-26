package it.univpm.TwitterOOP.util.stats;

import java.util.ArrayList;
import java.util.HashMap;

import it.univpm.TwitterOOP.model.Tweet;
import it.univpm.TwitterOOP.service.JSONParse;

/**
 * Questa classe viene utilizzata per il ritorno di tutte le statistiche in
 * formato HashMap, relative ai dati passati tramite ArrayList
 * 
 * @author Davide Pacioni
 * @author Alex Giaccio
 *
 */

public class Statistiche {
	/**
	 * Funzione che permette alla classe di raccogliere e restituire come risultato
	 * le statistiche sotto forma di ArrayList di HashMap
	 * 
	 * @param tw
	 * @param paramN
	 * @return lista
	 */
	public ArrayList<HashMap> stats(ArrayList<Tweet> tw, int paramN) {
		ArrayList<HashMap> lista = new ArrayList<HashMap>();

		HashMap<String, Integer> topHashtag;

		// ritorno prima statistica su hashtag
		TopHashtag retInfo = new TopHashtag();
		if (paramN == 0)
			topHashtag = retInfo.retTopMap(tw);
		else
			topHashtag = retInfo.retTopMap(tw, paramN);
		lista.add(topHashtag);

		// ritorno seconda statistica (min max media ecc...)
		HashMap<String, Float> imgMap;
		ImagesStats imgStats = new ImagesStats();
		imgMap = imgStats.imagesStats(tw);
		lista.add(imgMap);

		// ritorno terza statistica (numero di tweet per giorno mese e anno)
		YearStats yearStats = new YearStats(tw);
		lista.add(yearStats.getYearStats());
		return lista;
	}

}
