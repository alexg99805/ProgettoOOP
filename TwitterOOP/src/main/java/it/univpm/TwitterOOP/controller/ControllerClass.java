package it.univpm.TwitterOOP.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.InternalParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.TwitterOOP.service.FilterCall;
import it.univpm.TwitterOOP.service.JSONParse;

import it.univpm.TwitterOOP.exception.FilterIllegalArgumentException;
import it.univpm.TwitterOOP.exception.FilterNotFoundException;
import it.univpm.TwitterOOP.exception.InternalGeneralException;
import it.univpm.TwitterOOP.model.Tweet;
import it.univpm.TwitterOOP.service.TweetService;
import it.univpm.TwitterOOP.util.stats.Statistiche;

/**
 * Classe che specifica le diverse rotte possibili per il server.
 * 
 * @author Davide Pacioni
 * @author Alex Giaccio
 * @see TweetService
 * @see JsonParser
 * @see Statistiche
 * 
 */
@RestController
public class ControllerClass {
	/*
	 * Autowired consente la creazione di un'istanza del nostro servizio che sarà
	 * possibile utilizzare per ogni operazione
	 */
	@Autowired
	TweetService tweetService;

	/**
	 * Richiesta GET /data
	 * 
	 * @return ArrayList di Tweet
	 */
	@RequestMapping(value = "/data", method = RequestMethod.GET)
	public ResponseEntity<Object> getTweets() {
		return new ResponseEntity<>(tweetService.getTweet(), HttpStatus.OK);
	}

	/**
	 * Risponde alla richiesta GET /metadata
	 * 
	 * @return ArrayList di informazioni riguardanti i vari campi
	 */
	@RequestMapping(value = "/metadata", method = RequestMethod.GET)
	public ResponseEntity<Object> getMetadatas() {
		return new ResponseEntity<>(tweetService.getMetada(), HttpStatus.OK);
	}

	/**
	 * Risponde alla richiesta POST /data
	 * 
	 * @param filter filtro o filtri che devono essere inseriti nel corpo
	 * @return un ArrayList di tweet filtrato
	 * @throws InternalParseException
	 * @throws InternalGeneralException
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 * 
	 */

	@RequestMapping(value = "/data", method = RequestMethod.POST)
	public ResponseEntity<Object> getFilteredTweets(@RequestBody Object filter) throws InternalParseException,
			InternalGeneralException, ClassNotFoundException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		return new ResponseEntity<>(FilterCall.callFilter(filter), HttpStatus.CREATED);
	}

	/**
	 * 
	 * @return ArrayList con al suo interno la frequenza per utente di hashtag
	 * @throws InternalGeneralException
	 * @throws StatsNotFoundException
	 * @throws FilterNotFoundException
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	@RequestMapping(value = "/stats", method = RequestMethod.POST)
	public ResponseEntity<Object> getStatsFilteredWithParam(
			@RequestParam(name = "field", required = false, defaultValue = "0") int paramN, @RequestBody Object filter)
			throws InternalGeneralException, FilterNotFoundException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		ArrayList<HashMap> stats;
		ArrayList<Tweet> filtered = FilterCall.callFilter(filter);
		Statistiche st = new Statistiche();
		stats = st.stats(filtered, paramN);
		// hash = st.HashtagTweet(filtered);
		return new ResponseEntity<>(stats, HttpStatus.CREATED);
	}

	/**
	 * 
	 * @return un array che contiene il num di hashtag per ogni posts
	 * @throws InternalGeneralException
	 * @throws StatsNotFoundException
	 * @throws FilterNotFoundException
	 * @throws FilterIllegalArgumentException
	 */
	@RequestMapping(value = "/stats", method = RequestMethod.GET)
	public ResponseEntity<Object> getStats(
			@RequestParam(name = "field", required = false, defaultValue = "0") int paramN)
			throws InternalGeneralException, FilterNotFoundException, FilterIllegalArgumentException {
		ArrayList<HashMap> stats;
		Statistiche st = new Statistiche();
		ArrayList<Tweet> tw = JSONParse.ParseInformazioni();
		stats = st.stats(tw, paramN);
		return new ResponseEntity<>(stats, HttpStatus.OK);
	}

}
