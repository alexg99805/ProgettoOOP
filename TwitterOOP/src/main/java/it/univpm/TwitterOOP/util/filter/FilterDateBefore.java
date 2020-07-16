package it.univpm.TwitterOOP.util.filter;

import it.univpm.TwitterOOP.model.Tweet;
import it.univpm.TwitterOOP.util.other.Filter;
import it.univpm.TwitterOOP.util.other.FilterArrayString;

/** Questa classe controlla se il tweet che gli viene passato
 *  ha data inferiore rispetto a quella inserita
 *  @see Tweet
 *  @see FilterArrayString
 *  @see Filter
 *  
 *  @author Davide Pacioni
 *  @author Alex Giaccio
*/
public class FilterDateBefore extends FilterArrayString implements Filter {
	
	public FilterDateBefore (Object parameters) {
		super(parameters);
	}
	
	public boolean filter (Tweet tweet) {
		for(String p:param) {
			if( tweet.getCreated_at().compareTo(p) == -1)
					return true;
			}
		return false;
	}

}
