package it.univpm.TwitterOOP.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import it.univpm.TwitterOOP.service.JSONParse;
import it.univpm.TwitterOOP.model.Metadata;
import it.univpm.TwitterOOP.model.Tweet;

/**
 * Questa classe ci consente di realizzare due HashMap dove vengono istanziati due ArrayList di tipo Tweet e metadata. 
 * Successivamente vengono creati due metodi di TweetService per visualizzare il
 * pacchetto dove all'interno sono contenuti i relativi tweet e/o metadati
 * 
 * @author Davide Pacioni
 * @author Alex Giaccio
 *
 */
@Service
public class TweetServiceImpl implements TweetService {

	private Map<String, Metadata> metadata = new HashMap<>();
	private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
	
	// riempimento delle HashMap
	public TweetServiceImpl() {
		super();
		try {
			tweets = JSONParse.ParseInformazioni();
			

			ArrayList<Metadata> metadt = ArrayMetadata.getArrayMetadata();
			for (int i = 0; i < metadt.size(); i++) {
				Metadata metadt1 = metadt.get(i);
				metadata.put(metadt1.getField(), metadt1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return ArrayList<Tweet> un ArrayList di Tweet
	 */
	@Override
	public ArrayList<Tweet> getTweet() {
		return tweets;
	}

	/**
	 * @return un pacchetto di Metadata
	 */
	@Override
	public Collection<Metadata> getMetada() {
		return metadata.values();
	}

}
