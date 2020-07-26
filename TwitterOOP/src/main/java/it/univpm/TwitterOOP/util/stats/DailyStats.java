package it.univpm.TwitterOOP.util.stats;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

import it.univpm.TwitterOOP.model.Tweet;

/**
 * Questa classe viene utilizzata per effettuare le statistiche realtive ai
 * giorni dei tweet
 * 
 * @author Davide Pacioni
 * @author Alex Giaccio
 *
 */

public class DailyStats {

	private HashMap<String, Float> dailyStats;

	public HashMap<String, Float> getDailyStats() {
		return dailyStats;
	}

	/**
	 * Calcola le statistiche mensili scorrendo l'arraylist di tweet, che conterrà
	 * solo i tweet relativi ad un determinato mese
	 * 
	 * @param list
	 */
	public DailyStats(ArrayList<Tweet> list) {
		// calcolare le statistiche sull'array come min media max e deviazione standard
		dailyStats = new HashMap<>();
		calculateStats(list);
	}

	/**
	 * 
	 * @param list contenente solo i tweet relativi ad un determinato mese
	 */
	private void calculateStats(ArrayList<Tweet> list) {
		Integer[] nGiorni = new Integer[31];

		// scorro l'arraylist contenente solo i tweet di un determinato mese
		int numeroMese = list.get(0).getCreated_at().getMonth();
		int numeroGiorni = 0;
		if (numeroMese == 4 || numeroMese == 6 || numeroMese == 9 || numeroMese == 11)
			numeroGiorni = 31;
		else if (numeroMese == 2)
			numeroGiorni = 28;
		else
			numeroGiorni = 31;
		System.out.println(numeroGiorni);

		// inizializzo l'array con degli zeri
		for (int i = 0; i < nGiorni.length; i++)
			nGiorni[i] = 0;

		// occorrenze di tweet per giorno
		for (int i = 0; i < list.size(); i++) {
			int giorno = list.get(i).getCreated_at().getDay();
			// System.out.println("Giorno: "+ giorno);
			nGiorni[giorno - 1]++;
		}

		Arrays.sort(nGiorni, Collections.reverseOrder());

		// for(int i=0; i<numeroGiorni; i++) {
		// System.out.println(nGiorni[i]);
		// }

		float average = list.size() / numeroGiorni;
		int varianza = 0;
		// calcolo varianza
		for (int i = 0; i < numeroGiorni; i++) {
			varianza += Math.pow(nGiorni[i] - average, 2);
		}

		varianza = varianza / numeroGiorni;
		float stdDev = (float) Math.sqrt(varianza);

		// System.out.println("\n\n\n"+nGiorni[0]);
		// int max = nGiorni[0];

		dailyStats.put("Min", (float) nGiorni[numeroGiorni - 1]);
		dailyStats.put("Max", (float) nGiorni[0]);
		dailyStats.put("Avg", average);
		dailyStats.put("StdDev", stdDev);

	}

}
