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
		
		//ora che ho le chiavi posso riprendere la mappa ed estrapolare i valori associati alle chiavi per poi utilizzare la classe reflect
		for(int i=0; i<chiavi.size(); i++) {
		}
		
		
		return filteredData;
		
	}
	
	
}

