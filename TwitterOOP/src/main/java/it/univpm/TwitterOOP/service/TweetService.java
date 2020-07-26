package it.univpm.TwitterOOP.service;

import java.util.Collection;

import it.univpm.TwitterOOP.model.Metadata;
import it.univpm.TwitterOOP.model.Tweet;

/**
 * Questa interfaccia che � utilizzata in TweetServiceImpl Viene utilizzata per
 * specificare due metodi che permettono di visualizzare i metadata e la
 * timeline
 * 
 * @see ImplemenTweet
 * @see Tweet
 * @see Metadata
 * @author Davide Pacioni
 * @author Alex Giaccio
 *
 */
public interface TweetService {

	public abstract Collection<Tweet> getTweet();

	public abstract Collection<Metadata> getMetada();
}
