package it.univpm.TwitterOOP.model;

/**
 * Questa classe viene utilizzata come classe madre dato che ha un'unica variabile
 * che rappresenta l'id e che è comune alla maggiorparte delle classi nel package model.
 * @author Davide Pacioni
 * @author Alex Giaccio
 *
 */
public class ID {
	
	private long id;


	public ID() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @return  id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id 
	 */
	public void setId(long id) {
		this.id = id;
	}
	
}
