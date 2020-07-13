package it.univpm.TwitterOOP.model;

import java.util.ArrayList;

import org.json.simple.parser.ParseException;

/**
 * Questa classe contiene le principali caratteristiche di un Tweet
 * @author Davide Pacioni
 * @author Alex Giaccio
 *
 */

public class Tweet  extends ID {
	
	private CreationDate created_at;
	private String testo;
	private ArrayList<Entities> entities = new ArrayList<Entities>();
	private ArrayList<User> user = new ArrayList<User>();
	private long contaretw;
	private String language;
	
	
	public Tweet() {
		super();
	}
	
	/**
	 * @return created_at
	 */
	public CreationDate getCreated_at() {
		return created_at;
	}

	/**
	 * @param created_at 
	 * @throws ParseException 
	 */
	public void setCreated_at(String created_at) throws ParseException {
		this.created_at= new CreationDate();
		this.created_at.setCreation_date(created_at);
		
	}

	/**
	 * @return testo
	 */
	public String getText() {
		return testo;
	}

	/**
	 * @param text 
	 */
	public void setText(String text) {
		this.testo = text;
	}	

	/**
	 * @return contaretw
	 */
	public long getRetweet_count() {
		return contaretw;
	}

	/**
	 * @param retweet_count
	 */
	public void setRetweet_count(long retweet_count) {
		this.contaretw = retweet_count;
	}
	

	/**
	 * @return entities
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
	 * @return language
	 */
	public String getLang() {
		return language;
	}

	/**
	 * @param lang
	 */
	public void setLang(String lang) {
		this.language = lang;
	}

}
