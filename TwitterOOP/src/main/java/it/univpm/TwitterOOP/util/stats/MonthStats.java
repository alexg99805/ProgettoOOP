package it.univpm.TwitterOOP.util.stats;

import java.util.ArrayList;
import java.util.HashMap;

import it.univpm.TwitterOOP.model.Tweet;

/**
 * Questa classe viene utilizzata per effettuare le statistiche relative ai mesi
 * dei tweet
 * 
 * @author Davide Pacioni
 * @author Alex Giaccio
 *
 */
public class MonthStats {

	private HashMap<Integer, DailyStats> monthStats; // string nome del mese, hashmap delle statistiche

	/**
	 * Calcola le statistiche mensili scorrendo l'arraylist di tweet, che conterrà
	 * solo i tweet relativi ad un determinato anno
	 * 
	 * @param list
	 */
	public MonthStats(ArrayList<Tweet> list) {
		monthStats = new HashMap<>();
		calculateStats(list);

	}

	/**
	 * 
	 * @param list contenente i tweet relativi ad un determinato mese
	 */
	private void calculateStats(ArrayList<Tweet> list) {
		// creo l'array list che conterrà solo i mesi dei tweet
		ArrayList<Integer> months = new ArrayList<Integer>();
		// scorro l'arraylist originario per vedere quali mesi sono presenti
		for (int i = 0; i < list.size(); i++) {
			int mese = list.get(i).getCreated_at().getMonth();
			if (!months.contains(mese))
				months.add(mese);
		}

		ArrayList<Tweet> tweetByMonths = new ArrayList<Tweet>();
		// scorro l'arraylist contentente solo i mesi, e per ogni elemento creo un
		// arraylist
		// che contiene i tweet relativi a quel mese e lo passo alla classe DailyStats
		// per i relativi calcoli
		for (int i = 0; i < months.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j).getCreated_at().getMonth() == months.get(i)) {
					// se l'anno corrisponde lo aggiungo alla lista da inviare a MonthStats
					tweetByMonths.add(list.get(j));
				}

			} // finisco a scorrere i tweet originari
				// passo l'array list contenente solo i tweet relativi ad un particolare mese a
				// DailyStats per i calcoli
			DailyStats dailyStats = new DailyStats(tweetByMonths);
			this.monthStats.put(months.get(i), dailyStats);
		}
	}

	public HashMap<Integer, DailyStats> getMonthStats() {

		return monthStats;
	}
}
