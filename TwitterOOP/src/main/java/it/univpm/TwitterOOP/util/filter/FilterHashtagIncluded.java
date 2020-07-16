package it.univpm.TwitterOOP.util.filter;

import it.univpm.TwitterOOP.model.Tweet;
import it.univpm.TwitterOOP.util.other.Filter;
import it.univpm.TwitterOOP.util.other.FilterArrayString;

/** Questa classe controlla se il tweet che gli viene passato
 *  contiene Hashtag ben preciso
 *  
 *  @see Tweet
 *  @see FilterArrayString
 *  @see Filter
 *  
 *  @author Davide Pacioni
 *  @author Alex Giaccio
*/

public class FilterHashtagIncluded extends FilterArrayString implements Filter{
	
	public FilterHashtagIncluded(Object paramFilter) {
		super(paramFilter);
	}
	 
	public boolean filter(Tweet tweet) {

		for(String p : param) {
			for(int i=0; i<tweet.getEntities().size(); i++) {
				for(int j=0; j<tweet.getEntities().get(i).getHashtags().size(); j++) {
					if(tweet.getEntities().get(i).getHashtags().get(j).getText().equals(p))
						return true;
				}
			}
		}
		return false;
	}
}
//