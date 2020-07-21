package it.univpm.TwitterOOP.service;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import it.univpm.TwitterOOP.exception.FilterIllegalArgumentException;
import it.univpm.TwitterOOP.exception.FilterNotFoundException;
import it.univpm.TwitterOOP.exception.InternalGeneralException;
import it.univpm.TwitterOOP.model.Tweet;
import it.univpm.TwitterOOP.service.JSONParse;
import it.univpm.TwitterOOP.util.other.Filter;
/**
 * rappresenta una classe che gestisce i filtraggi della timeline
 * @author Davide Pacioni
 * @author Alex Giaccio
 *
 */
 public class FilterService {
	
	/** pacchetto che contiene le classi che mette in atto l'interfaccia Filter 
	*/
	private final static String path = "it.univpm.TwitterOOP.util.filter.";
	
	
    private static ArrayList<Tweet> tweets = JSONParse.ParseInformazioni();
    
    /*
     * Permette di stabilire un oggetto di tipo Filter indicando i parametri di filtraggio che si desiderano
	 * @param     column campo dove si vuol eseguire il filtraggio
	 * @param     operator tipo selezionato del filtraggio
	 * @param     param parametro ingresso necessario per il filtro scelto
	 * @return    un oggetto che implementa il filtro desiderato
	 * @throws    FilterNotFoundException il filtro richiesto è assente
	 * @throws    FilterIllegalArgumentException il parametro d'ingresso per il filtro risulta non valido
	 * @throws    InternalGeneralException errori interni
     */
	public static Filter instanceFilter(String column,String operator,Object param) 
		   throws FilterNotFoundException, FilterIllegalArgumentException,InternalGeneralException{
		
		Filter filtro;
		String filterName = new String("Filter"+column+operator);
		String ClassFilterName = path.concat(filterName);
	    
		try {
			
			Class<?> cls = Class.forName(ClassFilterName); //seleziono la classe
		
			Constructor<?> ct = cls.getDeclaredConstructor(Object.class); //seleziono il costruttore
	    
			filtro =(Filter)ct.newInstance(param);  //istanzo oggetto filtro
		}
		
	    //viene inserito qui il nome filtro non è corretto 
	    catch(ClassNotFoundException e){
	    	throw new FilterNotFoundException("The filter in field: '"+column+"' with operator: '"+
	                                            operator +"' does not exist");
	    }
		
		//viene inserito qui se sbagliate le lettere maiuscole o minuscole
	    catch(NoClassDefFoundError e){
	    	throw new FilterNotFoundException(
	    			"Error typing: '"+filterName+"' uppercase and lowercase error");
	    }

	    //viene inserito qui se il costruttore voluto da newInstance lancia un eccezione 
	   	catch (InvocationTargetException e) {  
	   		//genero una nuova eccezione 
	   		 throw new FilterIllegalArgumentException(e.getTargetException().getMessage()
	   				+ " Expected in '"+column+"'");
	   	}

	    catch (LinkageError | NoSuchMethodException | SecurityException 
	    		| InstantiationException | IllegalAccessException e ) {
		       e.printStackTrace();
		    	throw new InternalGeneralException("try later");
		    }

		
	    return filtro;
	    
	}
		
	/**
	 * Questo metodo scorre un ArrayList di Tweet e ne restitusce uno nuovo con Tweet composti
	 * da soli tweet che risultano validi per il filtro
	 * @param filtro desiderato
	 * @param previousArray ArrayList su cui si vuol eseguire l'operazione
	 * @return ArrayList di Tweet risultato dell'operazione
	 */
	public static ArrayList<Tweet> runFilterAND(Filter filtro, ArrayList<Tweet> previousArray){

		ArrayList<Tweet> filteredArray = new ArrayList<Tweet>();
		
		for(Tweet tweet :  previousArray) {

			if(filtro.filter(tweet))
				filteredArray.add(tweet);
		}				

		return filteredArray;
	}

	/**
	 * Questo metodo ci restituisce un ArrayList di Tweet contenenti tutti i tweet che 
	 * rispettano o l'uno o l'altro filtro desiderato
	 * @param filtro che si vuol far partre
	 * @param previousArray ArrayList di Tweet su cui si vuol eseguire l'operazione 
	 * @return ArrayList di Tweet frutto dell'operazione di filtraggio.
	 */
	public static  ArrayList<Tweet> runFilterOR(Filter filtro, ArrayList<Tweet> previousArray){

		ArrayList<Tweet> filteredArray = new ArrayList<Tweet>();
		
		for(Tweet tweet : tweets) {

			if(filtro.filter(tweet))
				filteredArray.add(tweet);
		}	
		
		previousArray.removeAll(filteredArray);
		previousArray.addAll(filteredArray);
		return previousArray;
	}
	
}




