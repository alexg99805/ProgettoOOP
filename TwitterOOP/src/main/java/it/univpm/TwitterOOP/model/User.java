package it.univpm.TwitterOOP.model;


/**
 * Questa classe ci permette di vedere le caratteristiche principali dell'utente autore del tweet
 * @see ID
 * @author Davide Pacioni
 * @author Alex Giaccio
 */
public class User extends ID {
	
	private String nome;
	private String nomescr;
	private String descrizione;
	private long contafollow;
	
	public User() {
		super();
	}


	/**
	 * @return nome
	 */
	public String getName() {
		return nome;
	}

	/**
	 * @param name
	 * modifica nome completo
	 */
	public void setName(String name) {
		this.nome = name;
	}

	/**
	 * @return nomescr
	 */
	public String getScreenName() {
		return nomescr;
	}

	/**
	 * @param screenName
	 * modifica il nome dell'user
	 */
	public void setScreenName(String screenName) {
		nomescr = screenName;
	}

	/**
	 * @return descrizione
	 */
	public String getDescription() {
		return descrizione;
	}

	/**
	 * @param description 
	 * modifica la descrizione dell'utente
	 */
	public void setDescription(String description) {
		this.descrizione = description;
	}

	/**
	 * @return contafollow
	 */
	public long getFollowerCount() {
		return contafollow;
	}

	/**
	 * @param followerCount 
	 * modifica il numero di follower
	 */
	public void setFollowerCount(long followerCount) {
		contafollow = followerCount;
	}
	
}
