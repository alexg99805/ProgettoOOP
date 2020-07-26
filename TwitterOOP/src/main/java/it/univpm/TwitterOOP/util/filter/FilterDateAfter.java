package it.univpm.TwitterOOP.util.filter;

import it.univpm.TwitterOOP.model.Tweet;
import it.univpm.TwitterOOP.util.other.Filter;
import it.univpm.TwitterOOP.util.other.ArrayOfStringsCheck;

/**
 * Questa classe controlla se il tweet che gli viene passato ha data superiore
 * rispetto a quella inserita
 * 
 * @see Tweet
 * @see ArrayOfStringsCheck
 * @see Filter
 * 
 * @author Davide Pacioni
 * @author Alex Giaccio
 */
public class FilterDateAfter extends ArrayOfStringsCheck implements Filter {

	public FilterDateAfter(Object parameters) {
		super(parameters);
	}

	public boolean filter(Tweet tweet) {
		for (String p : param) {
			if (tweet.getCreated_at().compareTo(p) == 1)
				return true;
		}
		return false;
	}

}
