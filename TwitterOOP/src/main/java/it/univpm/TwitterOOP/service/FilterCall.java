package it.univpm.TwitterOOP.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.univpm.TwitterOOP.model.Tweet;

public class FilterCall {
	
	
	
	public static ArrayList<Tweet> callFilter(Object bodyJSON){
		System.out.println(bodyJSON);
		ArrayList<Tweet> filteredData = new ArrayList<Tweet>();
		ArrayList<Tweet> fullData = JSONParse.ParseInformazioni();
		String chiave="";
		String parametro="";
		
		
		//thank you stackoverflow <3 https://stackoverflow.com/questions/443499/convert-json-to-map
		HashMap<String,Object> mappa = new ObjectMapper().convertValue(bodyJSON, HashMap.class);
		//System.out.println(mappa);
		//System.out.println(mappa.get("Hashtag"));
		Set<String> chiavi = mappa.keySet();
		ArrayList<String> listOfKeys = new ArrayList<String>(chiavi);
		//ora che ho le chiavi posso riprendere la mappa ed estrapolare i valori associati alle chiavi per poi utilizzare la classe reflect
		for(int i=0; i<listOfKeys.size(); i++) {
			chiave=listOfKeys.get(i);
			HashMap<String,Object> keyMap = new ObjectMapper().convertValue(mappa.get(chiave), HashMap.class);
			Set<String> chiavi2 = keyMap.keySet();
			ArrayList<String> listOfParam = new ArrayList<String>(chiavi2);
			if(listOfParam.size()==1) { //se è uguale ad uno non c'è il "Type"
				parametro=listOfParam.get(0);
				System.out.println(keyMap.get(parametro)); // <-- questo stampa il valore associato alla chiave
			}
			else parametro = listOfParam.get(1);
			//adesso ho sia la chiave sia il parametro. mi rimane da controllare se è presente il type e prendere il valore associato
			//System.out.println(chiave + " : " +parametro);
			
		}
		
		
		return filteredData;
		
	}
	
	
}

