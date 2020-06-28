package it.univpm.TwitterOOP.model;

/**
 * Classe che rappresenta gli utenti menzionati nei tweet
 * @see ID
 * @author Davide Pacioni
 * @author Alex Giaccio
 *
 */
public class UserMentions extends ID {
	
	private String ScreenName;
	private String name;

	public UserMentions() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return ScreenName
	 */
	public String getScreenName() {
		return ScreenName;
	}
	/**
	 * @param screenName 
	 * modifica nome
	 */
	public void setScreenName(String screenName) {
		ScreenName = screenName;
	}
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name
	 * nodifica nome utente
	 */
	public void setName(String name) {
		this.name = name;
	}

}
