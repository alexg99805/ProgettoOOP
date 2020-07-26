package it.univpm.TwitterOOP.util.stats;

import java.util.ArrayList;
import java.util.HashMap;

import it.univpm.TwitterOOP.model.Tweet;

/**
 * classe che calcola le statistiche relative alle date dei tweet prende
 * l'arraylist completo dei tweet e ne estrapola i relativi anni crea un
 * arraylist di tweet che corrispondono ai diversi anni e li passa a MonthStats
 * per i relativi calcoli
 * 
 * @author Davide Pacioni
 * @author Alex Giaccio
 *
 */
public class YearStats {

	private HashMap<Integer, MonthStats> yearStats;

	public YearStats(ArrayList<Tweet> list) {
		yearStats = new HashMap<>();
		calculateStats(list);
	}

	private void calculateStats(ArrayList<Tweet> list) {
		// creo l'array list che conterrà solo gli anni dei tweet
		ArrayList<Integer> years = new ArrayList<Integer>();
		// scorro l'arraylist originario per vedere quali anni sono presenti
		for (int i = 0; i < list.size(); i++) {
			int anno = list.get(i).getCreated_at().getYear();
			if (!years.contains(anno))
				years.add(anno);
		}

		ArrayList<Tweet> tweetByYears = new ArrayList<Tweet>();
		// scorro l'arraylist contentente solo gli anni, e per ogni elemento creo un
		// arraylist
		// che contiene i tweet relativi a quell'anno e lo passo alla classe MonthStats
		// per i relativi calcoli
		for (int i = 0; i < years.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j).getCreated_at().getYear() == years.get(i)) {
					// se l'anno corrisponde lo aggiungo alla lista da inviare a MonthStats
					tweetByYears.add(list.get(j));
				}
			} // finisco a scorrere i tweet originari
				// passo l'array list contenente solo i tweet relativi ad un particolare anno a
				// MonthStats per i calcoli
			MonthStats monthStats = new MonthStats(tweetByYears);
			// yearStats.add(years.get(i), monthStats.getMonthStats());
			this.yearStats.put(years.get(i), monthStats);
		}

	}

	public HashMap<Integer, MonthStats> getYearStats() {
		return yearStats;
	}

}
