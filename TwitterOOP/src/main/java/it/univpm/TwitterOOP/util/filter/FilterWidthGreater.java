package it.univpm.TwitterOOP.util.filter;

import it.univpm.TwitterOOP.model.Tweet;
import it.univpm.TwitterOOP.util.other.Filter;
import it.univpm.TwitterOOP.util.other.Filter1Compare;
import it.univpm.TwitterOOP.util.other.FilterArrayString;

/**
 * Questa classe controlla se l'immagine contenuta nel tweet che gli viene
 * passato ha larghezza maggiore rispetto al parametro fornito
 * 
 * @see Tweet
 * @see Filter1Compare
 * @see Filter
 * 
 * @author Davide Pacioni
 * @author Alex Giaccio
 */
public class FilterWidthGreater extends Filter1Compare implements Filter {

	public FilterWidthGreater(Object paramFilter) {
		super(paramFilter);
	}

	@Override
	public boolean filter(Tweet tweet) {
		for (int i = 0; i < tweet.getEntities().size(); i++)
			for (int j = 0; j < tweet.getEntities().get(i).getImages().size(); j++)
				for (int k = 0; k < tweet.getEntities().get(i).getImages().get(j).getSize().size(); k++) {
					if (tweet.getEntities().get(i).getImages().get(j).getSize().get(k).getWidth() > paramFilter)
						return true;
				}
		return false;

	}

}
