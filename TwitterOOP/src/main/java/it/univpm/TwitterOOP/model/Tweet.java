package it.univpm.TwitterOOP.model;

import java.util.ArrayList;

import org.json.simple.parser.ParseException;

/**
 * Questa classe contiene le principali caratteristiche di un Tweet
 * @author Davide Pacioni
 * @author Alex Giaccio
 *
 */

public class Tweet {
	
	private CreationDate created_at;
	private ArrayList<Entities> entities = new ArrayList<Entities>();

	
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

}
