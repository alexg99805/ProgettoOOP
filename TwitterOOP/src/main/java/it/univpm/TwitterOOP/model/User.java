package it.univpm.TwitterOOP.model;


/**
 * Questa classe ci permette di visualizzare le caratteristiche principali dell'utente autore del tweet
 * @see ID
 * @author Davide Pacioni
 */
public class User extends ID {
	
	private String name;
	private String ScreenName;
	private String description;
	private long FollowerCount;
	
	public User() {
		super();
	}


	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 * modifica nome completo
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return screenName
	 */
	public String getScreenName() {
		return ScreenName;
	}

	/**
	 * @param screenName
	 * modifica il nome utente
	 */
	public void setScreenName(String screenName) {
		ScreenName = screenName;
	}

	/**
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description 
	 * modifica la descrizione dell'utente
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return followerCount
	 */
	public long getFollowerCount() {
		return FollowerCount;
	}

	/**
	 * @param followerCount 
	 * modifica il numero di seguaci
	 */
	public void setFollowerCount(long followerCount) {
		FollowerCount = followerCount;
	}
	
}
