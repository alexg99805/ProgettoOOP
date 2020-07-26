package it.univpm.TwitterOOP.util.filter;

import it.univpm.TwitterOOP.model.Tweet;
import it.univpm.TwitterOOP.util.other.Filter;
import it.univpm.TwitterOOP.util.other.IntegerCompare;

/**
 * Questa classe controlla se il tweet che gli viene passato contiene più di tot
 * hashtag
 * 
 * @see Tweet
 * @see IntegerCompare
 * @see Filter
 * 
 * @author Davide Pacioni
 * @author Alex Giaccio
 */

public class FilterHashtagGreater extends IntegerCompare implements Filter {

	public FilterHashtagGreater(Object paramFilter) {
		super(paramFilter);
	}

	public boolean filter(Tweet tweet) {
		for (int i = 0; i < tweet.getEntities().size(); i++) {
			if (tweet.getEntities().get(i).getHashtags().size() > paramFilter) {
				return true;
			}
		}
		return false;
	}

}
