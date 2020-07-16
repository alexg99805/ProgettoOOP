package it.univpm.TwitterOOP.util.filter;

import it.univpm.TwitterOOP.model.Tweet;
import it.univpm.TwitterOOP.util.other.Filter;
import it.univpm.TwitterOOP.util.other.Filter1Compare;

/** Questa classe controlla se il tweet che gli viene passato
 *  ha meno di tot hashtag dove tot è passato tramite param
 *  
 *  @see Tweet
 *  @see Filter1Compare
 *  @see Filter
 *  
 *  @author Davide Pacioni
 *  @author Alex Giaccio
*/

public class FilterHashtagLess extends Filter1Compare implements Filter{
	
	public FilterHashtagLess(Object paramFilter) {                                  
		super(paramFilter);
	}
	
	public boolean filter (Tweet tweet) {
		for(int i=0; i<tweet.getEntities().size(); i++) {
			if( tweet.getEntities().get(i).getHashtags().size()< paramFilter) {
				return true;
			}
		}
		return false;
	}
}
