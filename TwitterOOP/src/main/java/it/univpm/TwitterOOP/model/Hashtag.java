package it.univpm.TwitterOOP.model;

/**
 * Questa classe permette di visualizzare gli hashtag presenti nel testo del tweet.
 * @author Davide Pacioni
 * @author Alex Giaccio
 *
 */
public class Hashtag {
	
	private String text;

	public Hashtag() {
		super();
	}
	
	/**
	 * @return testo
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
	
}
