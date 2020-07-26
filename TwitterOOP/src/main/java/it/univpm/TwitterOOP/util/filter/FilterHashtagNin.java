package it.univpm.TwitterOOP.util.filter;

import it.univpm.TwitterOOP.model.Tweet;
import it.univpm.TwitterOOP.util.other.Filter;
import it.univpm.TwitterOOP.util.other.IntegersCompare;

/**
 * Questa classe controlla se il tweet che gli viene passato NON contiene un
 * numero tot di hashtag compreso tra 2 parametri(param)
 * 
 * @see Tweet
 * @see IntegersCompare
 * @see Filter
 * 
 * @author Davide Pacioni
 * @author Alex Giaccio
 */

public class FilterHashtagNin extends IntegersCompare implements Filter {

	public FilterHashtagNin(Object param) {
		super(param);
	}

	public boolean filter(Tweet tweet) {
		for (int i = 0; i < tweet.getEntities().size(); i++) {
			if (tweet.getEntities().get(i).getHashtags().size() >= param1
					& tweet.getEntities().get(i).getHashtags().size() <= param2)
				return false;
		}
		return true;
	}
}
