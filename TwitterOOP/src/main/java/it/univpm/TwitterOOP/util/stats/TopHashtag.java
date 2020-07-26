package it.univpm.TwitterOOP.util.stats;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import it.univpm.TwitterOOP.model.Tweet;

/**
 * Questa classe viene utilizzata per effettuare le statistiche sugli hashtag e
 * per la formazione della creazione di una top N degli hashtag
 * 
 * @author Davide Pacioni
 * @author Alex Giaccio
 *
 */

public class TopHashtag {

	public HashMap<String, Integer> retMap(ArrayList<Tweet> tw) {
		HashMap<String, Integer> hashtagMap = new HashMap<String, Integer>();
		// costruisco hashMap di tutti gli hastag presenti in tutti i tweet
		for (Tweet t : tw) {
			for (int i = 0; i < t.getEntities().size(); i++) { // prende entità
				for (int j = 0; j < t.getEntities().get(i).getHashtags().size(); j++) { // prende gli hashtag
					String hashtag = t.getEntities().get(i).getHashtags().get(j).getText();
					if (!hashtagMap.containsKey(hashtag)) {
						hashtagMap.put(hashtag, 1);
					} else {
						int app = hashtagMap.get(hashtag);
						hashtagMap.replace(hashtag, ++app);
					}

				}
			}
		}
		return hashtagMap;
	}

	public HashMap<String, Integer> retTopMap(ArrayList<Tweet> tw) {
		HashMap<String, Integer> HashtagMap = retMap(tw);
		HashMap<String, Integer> TopHashtag = new HashMap<String, Integer>();
		// costruisco hashMap di tutti gli hastag presenti in tutti i tweet
		LinkedHashMap<String, Integer> linkedMap = sortHashMapByValues(HashtagMap);

		TopHashtag = linkedMap;
		System.out.println(TopHashtag);
		return TopHashtag;
	}

	// overload per stats con filtro N inseribile dall'utente
	public HashMap<String, Integer> retTopMap(ArrayList<Tweet> tw, int Numero) {
		HashMap<String, Integer> HashtagMap = retMap(tw);
		HashMap<String, Integer> TopHashtag = new HashMap<String, Integer>();
		// costruisco hashMap di tutti gli hastag presenti in tutti i tweet
		LinkedHashMap<String, Integer> linkedMap = sortHashMapByValues(HashtagMap, Numero);

		// TopHashtag = linkedMap;
		TopHashtag = linkedMap;
		return TopHashtag;
	}

	// ritorna una hashmap ordinata per valore (occorrenze hashtag)
	public LinkedHashMap<String, Integer> sortHashMapByValues(HashMap<String, Integer> passedMap) {
		List<String> mapKeys = new ArrayList<>(passedMap.keySet());
		List<Integer> mapValues = new ArrayList<>(passedMap.values());
		Collections.sort(mapValues);
		Collections.sort(mapKeys);
		Collections.reverse(mapValues);
		Collections.reverse(mapKeys);

		LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();

		Iterator<Integer> valueIt = mapValues.iterator();
		while (valueIt.hasNext()) {
			int val = valueIt.next();
			Iterator<String> keyIt = mapKeys.iterator();

			while (keyIt.hasNext()) {
				String key = keyIt.next();
				int comp1 = passedMap.get(key);
				int comp2 = val;

				if (comp1 == comp2) {
					keyIt.remove();
					sortedMap.put(key, val);
					break;
				}
			}
		}
		return sortedMap;
	}

	// overload per top N
	public LinkedHashMap<String, Integer> sortHashMapByValues(HashMap<String, Integer> passedMap, int N) {
		List<String> mapKeys = new ArrayList<>(passedMap.keySet());
		List<Integer> mapValues = new ArrayList<>(passedMap.values());
		Collections.sort(mapValues);
		Collections.sort(mapKeys);
		Collections.reverse(mapValues);
		Collections.reverse(mapKeys);
		int numero = N;

		LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();

		Iterator<Integer> valueIt = mapValues.iterator();
		while (valueIt.hasNext()) {
			if (numero == 0)
				return sortedMap;
			numero--;
			int val = valueIt.next();
			Iterator<String> keyIt = mapKeys.iterator();

			while (keyIt.hasNext()) {
				String key = keyIt.next();
				int comp1 = passedMap.get(key);
				int comp2 = val;

				if (comp1 == comp2) {
					keyIt.remove();
					sortedMap.put(key, val);
					break;
				}
			}
		}
		return sortedMap;
	}
}
