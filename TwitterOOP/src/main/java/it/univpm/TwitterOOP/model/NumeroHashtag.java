package it.univpm.TwitterOOP.model;

/**
 * Classe che salva il numero di hashtag per ogni tweet con il relativo 
 * hashtag utilizzato un numero di volte da un utente
 * @author Davide Pacioni
 * @author Alex Giaccio
 *
 */

public class NumeroHashtag {
	
	private int numHashtag;
	private String hashtag;

	
	public NumeroHashtag(int numHashtag,String hashtag) {
		super();
		this.numHashtag = numHashtag;
		this.hashtag = hashtag;
	}

	public NumeroHashtag() {
		super();

	}

	/**
	 * @return numHashtag
	 */
	public int getnumHashtag() {
		return numHashtag;
	}

	/**
	 * @param numHashtag
	 */
	public void setnumHashtag(int numHashtag) {
		this.numHashtag = numHashtag;
	}

	/**
	 * @return l'hashtag
	 */
	public String getHashtag() {
		return hashtag;
	}

	/**
	 * @param newHash
	 */
	public void setHashtag(String newHash) {
		this.hashtag = newHash;
	}
	
}

