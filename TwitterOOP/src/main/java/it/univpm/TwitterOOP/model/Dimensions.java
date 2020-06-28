package it.univpm.TwitterOOP.model;

/**
 * Classe per rappresentare le dimensioni delle immagini contenute nei tweet
 * @author Davide Pacioni
 * @author Alex Giaccio
 *
 */
public class Dimensions {
	
	private long height;
	private long width;
	private String resize;
	

	public Dimensions() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return l'altezza
	 */
	public long getHeight() {
		return height;
	}

	/**
	 * @param height
	 */
	public void setHeight(long height) {
		this.height = height;
	}

	/**
	 * @return la larghezza
	 */
	public long getWidth() {
		return width;
	}

	/**
	 * @param width
	 */
	public void setWidth(long width) {
		this.width = width;
	}

	/**
	 * @return resize
	 */
	public String getResize() {
		return resize;
	}

	/**
	 * @param resize
	 */
	public void setResize(String resize) {
		this.resize = resize;
	}
	
	
}
