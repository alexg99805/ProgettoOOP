package it.univpm.TwitterOOP.model;

/**
 * Questa classe indica gli url del tweet
 * @author Davide Pacioni
 * @author Alex Giaccio
 *
 */
public class urls {
	
	private String Url;
	private String ExpandedUrl;

	public urls() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return url
	 */
	public String getUrl() {
		return Url;
	}

	/**
	 * @param Url 
	 * modifica url
	 */
	public void setUrl(String Url) {
		this.Url = Url;
	}

	/**
	 * @return expandedUrl
	 */
	public String getExpandedUrl() {
		return ExpandedUrl;
	}

	/**
	 * @param expandedUrl 
	 * modifica l'url esteso
	 */
	public void setExpandedUrl(String expandedUrl) {
		ExpandedUrl = expandedUrl;
	}
	
}
