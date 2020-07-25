package it.univpm.TwitterOOP.model;

import java.util.ArrayList;

/**
 * Questa classe contiene le caratteristiche principali dell'immagine nel tweet
 * @see Dimensions
 * @author Davide Pacioni
 * @author Alex Giaccio
 *
 */
public class Image {
	
	private String type;
	private ArrayList<Dimensions> size = new ArrayList<Dimensions>();


	public Image() {
		super();
	}
	

	/**
	 * @return type
	 */
	public String getType() {
		return type;
	}


	/**
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}


	/**
	 * @return size
	 */
	public ArrayList<Dimensions> getSize() {
		return size;
	}


	/**
	 * @param newSize
	 */
	public void setSize(Dimensions newSize) {
		size.add(newSize);
	}

	
}
