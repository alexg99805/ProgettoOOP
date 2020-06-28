package it.univpm.TwitterOOP.model;

import java.util.ArrayList;

/**
 * Questa classe contiene le caratteristiche principali dell'immagine nel tweet
 * @see Dimensions
 * @author Davide Pacioni
 * @author Alex Giaccio
 *
 */
public class Image extends ID {
	
	private String media_url;
	private String type;
	private ArrayList<Dimensions> size = new ArrayList<Dimensions>();


	public Image() {
		super();
	}
	
	/**
	 * @return media_url
	 */
	public String getMedia_url() {
		return media_url;
	}

	/**
	 * @param media_url 
	 */
	public void setMedia_url(String media_url) {
		this.media_url = media_url;
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
