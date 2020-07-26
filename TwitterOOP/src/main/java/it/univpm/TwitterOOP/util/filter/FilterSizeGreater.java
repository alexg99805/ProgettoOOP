package it.univpm.TwitterOOP.util.filter;

import it.univpm.TwitterOOP.model.Tweet;
import it.univpm.TwitterOOP.util.other.Filter;
import it.univpm.TwitterOOP.util.other.IntegerCheck;

/**
 * Questa classe controlla se l'immagine contenuta nel tweet che gli viene
 * passato ha una dimensione maggiore rispetto al parametro fornito
 * 
 * @see Tweet
 * @see IntegerCheck
 * @see Filter
 * 
 * @author Davide Pacioni
 * @author Alex Giaccio
 */
public class FilterSizeGreater extends IntegerCheck implements Filter {

	public FilterSizeGreater(Object paramFilter) {
		super(paramFilter);
	}

	@Override
	public boolean filter(Tweet tweet) {
		for (int i = 0; i < tweet.getEntities().size(); i++)
			for (int j = 0; j < tweet.getEntities().get(i).getImages().size(); j++)
				for (int k = 0; k < tweet.getEntities().get(i).getImages().get(j).getSize().size(); k++) {
					if (tweet.getEntities().get(i).getImages().get(j).getSize().get(k).getSize() > paramFilter)
						return true;
				}
		return false;

	}

}