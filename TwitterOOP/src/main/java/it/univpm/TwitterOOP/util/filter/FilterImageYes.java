package it.univpm.TwitterOOP.util.filter;

import it.univpm.TwitterOOP.model.Tweet;
import it.univpm.TwitterOOP.util.other.Filter;
import it.univpm.TwitterOOP.util.other.FilterArrayString;

/** Questa classe controlla il tweet che gli viene passato
 *  contiene immagine.
 *  
 *  @see Tweet
 *  @see FilterArrayString
 *  @see Filter
 *  
 *  @author Davide Pacioni
 *  @author Alex Giaccio
*/

public class FilterImageYes extends FilterArrayString implements Filter{
	
	public FilterImageYes(Object parameters) {
		super(parameters);
	}
	
	public boolean filter(Tweet tweet) {
		for(int i=0;i<tweet.getEntities().size();i++) {
			for(int j=0; j<tweet.getEntities().get(i).getImages().size(); j++)
				if(!(tweet.getEntities().get(i).getImages().get(j).equals(null)))
					return true;
		}
	return false;
	}
}
