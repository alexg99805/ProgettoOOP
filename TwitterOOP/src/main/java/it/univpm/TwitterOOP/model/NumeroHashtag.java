package it.univpm.TwitterOOP.model;

/**
 * Xlasse che salva il numero di hashtag per ogni tweet con il relativo 
 * hashtag utilizzato un numero di volte da un utente
 * @author Davide Pacioni
 * @author Alex Giaccio
 *
 */

public class NumeroHashtag {
	
	private int nHashtag;
	private String hash;

	
	public NumeroHashtag(int nHashtag,String hash) {
		super();
		this.nHashtag = nHashtag;
		this.hash = hash;
	}

	public NumeroHashtag() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return nHashtag
	 */
	public int getnHashtag() {
		return nHashtag;
	}

	/**
	 * @param nHashtag
	 */
	public void setnHashtag(int nHashtag) {
		this.nHashtag = nHashtag;
	}

	/**
	 * @return l'hashtag
	 */
	public String getHashtag() {
		return hash;
	}

	/**
	 * @param newHash
	 */
	public void setHashtag(String newHash) {
		this.hash = newHash;
	}
	
}

