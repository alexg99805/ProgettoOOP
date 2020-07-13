package it.univpm.TwitterOOP.model;

/**
 * Classe che rappresenta gli utenti menzionati nei tweet
 * @see ID
 * @author Davide Pacioni
 * @author Alex Giaccio
 *
 */
public class UserMentions extends ID {
	
	private String screennome;
	private String nome;

	public UserMentions() {
		super();
	}

	/**
	 * @return scrennome
	 */
	public String getScreenName() {
		return screennome;
	}
	/**
	 * @param screenName 
	 * modifica nome
	 */
	public void setScreenName(String screenName) {
		screennome = screenName;
	}
	/**
	 * @return nome
	 */
	public String getName() {
		return nome;
	}
	/**
	 * @param name
	 * modifica nome utente
	 */
	public void setName(String name) {
		this.nome = name;
	}

}
