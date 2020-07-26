package it.univpm.TwitterOOP.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.univpm.TwitterOOP.exception.FilterIllegalArgumentException;
import it.univpm.TwitterOOP.model.Tweet;

public class FilterCall {

	public static ArrayList<Tweet> callFilter(Object bodyJSON) throws InstantiationException,
			IllegalAccessException, FilterIllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException, ClassNotFoundException {
		System.out.println(bodyJSON);
		ArrayList<Tweet> filteredData = new ArrayList<Tweet>();
		ArrayList<Tweet> fullData = JSONParse.ParseInformazioni();
		String chiave = "";
		Object parametro;
		// thank you stackoverflow <3
		// https://stackoverflow.com/questions/443499/convert-json-to-map
		HashMap<String, Object> mappa = new ObjectMapper().convertValue(bodyJSON, HashMap.class);
		// System.out.println(mappa);
		// System.out.println(mappa.get("Hashtag"));
		Set<String> chiavi = mappa.keySet();
		ArrayList<String> listOfKeys = new ArrayList<String>(chiavi);
		// ora che ho le chiavi posso riprendere la mappa ed estrapolare i valori
		// associati alle chiavi per poi utilizzare la classe reflect
		for (int i = 0; i < listOfKeys.size(); i++) {
			chiave = listOfKeys.get(i);
			HashMap<String, Object> keyMap = new ObjectMapper().convertValue(mappa.get(chiave), HashMap.class);
			Set<String> chiavi2 = keyMap.keySet();
			ArrayList<String> listOfParam = new ArrayList<String>(chiavi2);
			if (listOfParam.size() == 1) { // se è uguale ad uno non c'è il "Type"
				parametro = listOfParam.get(0);
				
				// System.out.println(keyMap.get(parametro)); // <-- questo stampa il VALORE
				// associato al PARAMETRO
				Class<?> scegliClasse = Class.forName("it.univpm.TwitterOOP.util.filter.Filter" + chiave + parametro);
				Object istanzaCostruttore = scegliClasse.getDeclaredConstructor(Object.class)
						.newInstance(keyMap.get(parametro));
				Method metodoDaUsare = scegliClasse.getMethod("filter", Tweet.class);

				// ora devo scorrere l'arrayList dei tweet non filtrato e controllare elemento
				// per elemento che il tweet corrisponda alla condizione posta dal filtro
				// (restituisce un boolean)
				for (int j = 0; j < fullData.size(); j++) {
					if ((boolean) metodoDaUsare.invoke(istanzaCostruttore, fullData.get(j))) {
						filteredData.add(fullData.get(j));
					}
				}
			} else {// altrimenti ho il type e devo controllare se ho un'unione di tipo and/or
				parametro = listOfParam.get(1); // prendo il parametro
				String tipoUnione = keyMap.get(listOfParam.get(0)).toString(); // and o or

				Class<?> scegliClasse = Class.forName("it.univpm.TwitterOOP.util.filter.Filter" + chiave + parametro);
				Object istanzaCostruttore = scegliClasse.getDeclaredConstructor(Object.class)
						.newInstance(keyMap.get(parametro));
				Method metodoDaUsare = scegliClasse.getMethod("filter", Tweet.class);

				// tipo and: scorro i dati per controllare se quelli che già ho corrispondano
				// anche all ulteriore filtro
				if (tipoUnione.equals("and")) {
					for (int j = 0; j < filteredData.size(); j++) {
						if (!(boolean) metodoDaUsare.invoke(istanzaCostruttore, filteredData.get(j))) {
							filteredData.remove(fullData.get(j));
						}
					}
				}
				// scorro l'arraylist originario e aggiungo quelli che corrispondono al filtro
				// all arraylist già filtrato
				else if (tipoUnione.equals("or")) {
					for (int j = 0; j < fullData.size(); j++) {
						if ((boolean) metodoDaUsare.invoke(istanzaCostruttore, fullData.get(j))) {
							filteredData.add(fullData.get(j));
						}
					}
				} else {
					throw new FilterIllegalArgumentException("Type must be 'and'/'or'");
				}
			}

		}

		return filteredData;

	}
	
	
}
