package it.univpm.TwitterOOP.util.filter;

import it.univpm.TwitterOOP.model.Tweet;
import it.univpm.TwitterOOP.util.other.Filter;
import it.univpm.TwitterOOP.util.other.IntegerCompare;

/**
 * Questa classe controlla se l'immagine contenuta nel tweet che gli viene
 * passato ha larghezza minore rispetto al parametro fornito
 * 
 * @see Tweet
 * @see IntegerCompare
 * @see Filter
 * 
 * @author Davide Pacioni
 * @author Alex Giaccio
 */
public class FilterWidthLess extends IntegerCompare implements Filter {

	public FilterWidthLess(Object paramFilter) {
		super(paramFilter);
	}

	@Override
	public boolean filter(Tweet tweet) {
		for (int i = 0; i < tweet.getEntities().size(); i++)
			for (int j = 0; j < tweet.getEntities().get(i).getImages().size(); j++)
				for (int k = 0; k < tweet.getEntities().get(i).getImages().get(j).getSize().size(); k++) {
					if (tweet.getEntities().get(i).getImages().get(j).getSize().get(k).getWidth() < paramFilter)
						return true;
				}
		return false;

	}

}
