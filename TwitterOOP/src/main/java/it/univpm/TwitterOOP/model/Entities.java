package it.univpm.TwitterOOP.model;

import java.util.ArrayList;

/**
 * Classe contenente arraylist relativi ad hashtag, userMentions e url
 * @see Hashtag
 * @see UserMentions
 * @see urls
 * @see Image
 * @author Davide Pacioni
 * @author Alex Giaccio
 *
 */
public class Entities {
	
	private ArrayList<Hashtag> hashtags = new ArrayList<Hashtag>();
	private ArrayList<UserMentions> mentions = new ArrayList<UserMentions>();
	private ArrayList<urls> Url = new ArrayList<urls>();
	private ArrayList<Image> image = new ArrayList<Image>();

	
	public Entities() {
	}

	/**
	 * @return hashtags
	 */
	public ArrayList<Hashtag> getHashtags() {
		return this.hashtags;
	}

	/**
	 * @param newHashtag
	 */
	public void setHashtags(Hashtag newHashtag) {
		hashtags.add(newHashtag);
	}

	/**
	 * @return mentions
	 */
	public ArrayList<UserMentions> getMentions() {
		return this.mentions;
	}

	/**
	 * @param newMention
	 */
	public void setMentions(UserMentions newMention) {
		mentions.add(newMention);
	}

	/**
	 * @return url
	 */
	public ArrayList<urls> getUrl() {
		return this.Url;
	}

	/**
	 * @param newUrl 
	 */
	public void setUrl(urls newUrl) {
		Url.add(newUrl);
	}

	/**
	 * @return l'immagine
	 */
	public ArrayList<Image> getImages() {
		return this.image;
	}

	/**
	 * @param newImage
	 */
	public void setImages(Image newImage) {
		
		image.add(newImage);
	}
	
}
