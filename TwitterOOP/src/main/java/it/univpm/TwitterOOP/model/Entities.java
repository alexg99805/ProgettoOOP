package it.univpm.TwitterOOP.model;

import java.util.ArrayList;

/**
 * Classe contenente arraylist relativi ad hashtag, userMentions, url e immagini
 * @see Hashtag
 * @see UserMentions
 * @see urls
 * @see Image
 * @author Davide Pacioni
 * @author Alex Giaccio
 *
 */
public class Entities {
	
	private ArrayList<Hashtag> hashtg = new ArrayList<Hashtag>();
	private ArrayList<UserMentions> menzioni = new ArrayList<UserMentions>();
	private ArrayList<urls> url = new ArrayList<urls>();
	private ArrayList<Image> immagini = new ArrayList<Image>();

	
	public Entities() {
	}

	/**
	 * @return hashtg
	 */
	public ArrayList<Hashtag> getHashtags() {
		return this.hashtg;
	}

	/**
	 * @param newHashtag
	 */
	public void setHashtags(Hashtag newHashtag) {
		hashtg.add(newHashtag);
	}

	/**
	 * @return menzioni
	 */
	public ArrayList<UserMentions> getMentions() {
		return this.menzioni;
	}

	/**
	 * @param newMention
	 */
	public void setMentions(UserMentions newMention) {
		menzioni.add(newMention);
	}

	/**
	 * @return url
	 */
	public ArrayList<urls> getUrl() {
		return this.url;
	}

	/**
	 * @param newUrl 
	 */
	public void setUrl(urls newUrl) {
		url.add(newUrl);
	}

	/**
	 * @return immagini
	 */
	public ArrayList<Image> getImages() {
		return this.immagini;
	}

	/**
	 * @param newImage
	 */
	public void setImages(Image newImage) {
		
		immagini.add(newImage);
	}
	
}
