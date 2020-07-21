package it.univpm.TwitterOOP.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.univpm.TwitterOOP.exception.FilterIllegalArgumentException;
import it.univpm.TwitterOOP.exception.FilterNotFoundException;
import it.univpm.TwitterOOP.exception.InternalGeneralException;
import it.univpm.TwitterOOP.model.Tweet;
import it.univpm.TwitterOOP.service.FilterService;
import it.univpm.TwitterOOP.util.other.Filter;
 
/**
 * Rappresenta la classe che effettua il parsing ricorsivo su un oggetto di tipo JSON
 * @author Davide Pacioni
 * @author Alex Giaccio
 * @see Tweet
 *
 */

public class JsonParser {
	
	/**
	 * Effettua il parsing più lontano, selezionando column
	 * e un oggetto, che contiene il filtro da applicare al dataset
	 * @param filter contiene il JSON con le informazioni per il filtraggio
	 * @return Arraylist di Tweet filtrato
	 * @throws InternalGeneralException se vengono registrare anomalie interne al server
	 * @throws FilterNotFoundException se vengono fuori errori legati al filtro not found
	 * @throws FilterIllegalArgumentException  se vengono registrati errori di parametro non valido al filtro
	 */
	public static ArrayList<Tweet> JsonParserColumn(Object filter)
			throws InternalGeneralException, FilterNotFoundException, FilterIllegalArgumentException{ 
				ArrayList<Tweet> previousArray= new ArrayList<Tweet>();
				ArrayList<Tweet> filteredArray= new ArrayList<Tweet>();
				HashMap<String,Object> result= new ObjectMapper().convertValue(filter, HashMap.class);

			//fa un'iterazione con gli elementi dell'ArrayList
				for(Map.Entry<String, Object> entry: result.entrySet()) {
					//ad ogni ciclo ripulisce l'array filtered
					filteredArray= new ArrayList<Tweet>();
					String column=entry.getKey();
					Object filterParam=entry.getValue();
					try {
							filteredArray=jsonParserOperator(column, filterParam, previousArray);
					}catch (SecurityException e) {
						throw new InternalGeneralException ("Error in I/O parsing information");
					}
					//pulisce previous prima di riempirlo con filtered
					previousArray=new ArrayList<Tweet>();
					previousArray.addAll(filteredArray);
				}
				return filteredArray;
			}
	
	/**
	 * Effettua il parsing più vicino selezionando operatore e parametro
	 * e fa inizializzare il filtro che corrisponde a quel che viene richiesto
	 * @param column è il campo su cui si vuole effettuare il filtraggio.
	 * @param filterParam contiene i parametri di filtraggio.
	 * @param previousArray ArrayList ottenuto dai filtraggi effettuati prima
	 * @return arraylist di tweet filtrato
	 * @throws InternalGeneralException se vengono registrate anomalie iternamente al server
	 * @throws FilterNotFoundException se vengono fuori errori legati al filtro not found
	 * @throws FilterIllegalArgumentException se vengono registrati errori di parametro non valido al filtro
	 */
	public static  ArrayList<Tweet> jsonParserOperator (String column,Object filterParam,
			                                          ArrayList<Tweet> previousArray)
			throws InternalGeneralException, FilterNotFoundException, FilterIllegalArgumentException {
		String type="";
		Filter filter;
		ArrayList<Tweet> filteredArray= new ArrayList <Tweet>();
		HashMap<String, Object> result= new ObjectMapper().convertValue(filterParam,HashMap.class);
		for(Map.Entry<String, Object> entry: result.entrySet()) {
			String operator= entry.getKey();
			Object value=entry.getValue();
		    // Se l'operatore è Type allora guarda se il valore è 'and' o 'or'
		    // lancia il metodo runfilter corrispondente
			if(operator.equals("type") || operator.equals("Type")) {
				if(operator.equals("type")) {

					throw new FilterIllegalArgumentException(" Type must be 'T' caps ");

				}
				type=(String) value;
				if(!(value.equals("and"))&&!(value.equals("or"))) {
					throw new FilterIllegalArgumentException("'and' o 'or' expected after 'type'");
		    	}
		    	continue;
		    } 
			filter= FilterService.instanceFilter(column, operator, value);
			if (type.equals("and"))
				filteredArray = FilterService.runFilterAND(filter, previousArray);
			else 
				filteredArray = FilterService.runFilterOR(filter, previousArray);
		}
		return filteredArray;
	}			
}


