package it.univpm.TwitterOOP.service;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import it.univpm.TwitterOOP.db.Database;
import it.univpm.TwitterOOP.model.*;

/**
 * Questa classe ci permette di fare il parsing dei dati del file JSON che
 * vengono scaricati nella classe Database
 * 
 * @see Database
 * @see Tweet
 * @author Davide Pacioni
 * @author Alex Giaccio
 *
 */

public class JSONParse {

	/**
	 * Questo metodo permette di far avere un ArrayList che contiene tutte le
	 * informazioni che riguardano la classe
	 * 
	 * @see Tweet
	 * @return Timeline
	 * @throws ParseException
	 */
	public static ArrayList<Tweet> ParseInformazioni() {

		JSONArray raw_data = Database.downloadJSON();
		ArrayList<Tweet> Timeline = new ArrayList<Tweet>();
		for (int i = 0; i < raw_data.size(); i++) {
			Tweet single_tweet = new Tweet();
			JSONObject created_obj = (JSONObject) raw_data.get(i);
			try {
				single_tweet.setCreated_at((String) created_obj.get("created_at"));
			} catch (ParseException e) {

				e.printStackTrace();
			}
			Hashtag single_hashtag;
			Entities en = new Entities();
			JSONObject entities_obj = (JSONObject) created_obj.get("entities");
			JSONArray hashtagArray = (JSONArray) entities_obj.get("hashtags");

			for (int j = 0; j < hashtagArray.size(); j++) {
				single_hashtag = new Hashtag();
				JSONObject hashtag_obj = (JSONObject) hashtagArray.get(j);
				single_hashtag.setText((String) hashtag_obj.get("text"));
				en.setHashtags(single_hashtag);
			}
			Image single_image;
			if (entities_obj.containsKey("media")) {
				JSONArray media = (JSONArray) entities_obj.get("media");
				for (int j = 0; j < media.size(); j++) {
					single_image = new Image();
					JSONObject media_obj = (JSONObject) media.get(j);
					Dimensions dimensions;
					JSONObject Size = (JSONObject) media_obj.get("sizes");
					JSONObject dim = (JSONObject) Size.get("medium");
					dimensions = new Dimensions();
					dimensions.setWidth((long) dim.get("w"));
					dimensions.setHeight((long) dim.get("h"));
					dimensions.setSize(dimensions.calcDim((long) dim.get("w"), (long) dim.get("h")));
					single_image.setSize(dimensions);
					en.setImages(single_image);
				}
			}
			single_tweet.setEntities(en);
			Timeline.add(single_tweet);
		}
		return Timeline;
	}
}
