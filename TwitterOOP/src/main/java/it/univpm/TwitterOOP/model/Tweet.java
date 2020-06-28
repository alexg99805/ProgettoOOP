package it.univpm.TwitterOOP.model;

import java.util.ArrayList;

/**
 * Questa classe contiene le principali caratteristiche di un Tweet
 * @author Davide Pacioni
 * @author Alex Giaccio
 *
 */

public class Tweet  extends ID {
	
	private String created_at;
	private String text;
	private ArrayList<Entities> entities = new ArrayList<Entities>();
	private ArrayList<User> user = new ArrayList<User>();
	private long retweet_count;
	private String lang;
	
	
	public Tweet() {
		super();
	}
	
	/**
	 * @return created_at
	 */
	public String getCreated_at() {
		return created_at;
	}

	/**
	 * @param created_at 
	 */
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	/**
	 * @return text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text 
	 */
	public void setText(String text) {
		this.text = text;
	}	

	/**
	 * @return retweet_count
	 */
	public long getRetweet_count() {
		return retweet_count;
	}

	/**
	 * @param retweet_count
	 */
	public void setRetweet_count(long retweet_count) {
		this.retweet_count = retweet_count;
	}
	

	/**
	 * @return le entities
	 */
	public ArrayList<Entities> getEntities() {
		return this.entities;
	}

	/**
	 * @param newEntities 
	 */
	public void setEntities(Entities newEntities) {
		entities.add(newEntities);
	}

	/**
	 * @return user
	 */
	public ArrayList<User> getUsers() {
		return this.user;
	}

	/**
	 * @param newUser
	 */
	public void setUsers(User newUser) {
		user.add(newUser);
	}
	
	/**
	 * @return lang
	 */
	public String getLang() {
		return lang;
	}

	/**
	 * @param lang
	 */
	public void setLang(String lang) {
		this.lang = lang;
	}

}
