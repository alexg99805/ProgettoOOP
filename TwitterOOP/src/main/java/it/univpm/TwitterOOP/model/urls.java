package it.univpm.TwitterOOP.model;

/**
 * Questa classe indica gli url del tweet
 * @author Davide Pacioni
 * @author Alex Giaccio
 *
 */
public class urls {
	
	private String url;
	private String espansioneU;

	public urls() {
		super();
	}

	/**
	 * @return url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param Url 
	 * modifica url
	 */
	public void setUrl(String Url) {
		this.url = Url;
	}

	/**
	 * @return espansioneU
	 */
	public String getExpandedUrl() {
		return espansioneU;
	}

	/**
	 * @param expandedUrl 
	 * modifica l'url esteso
	 */
	public void setExpandedUrl(String expandedUrl) {
		espansioneU = expandedUrl;
	}
	
}
