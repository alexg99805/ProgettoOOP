package it.univpm.TwitterOOP.model;

/**
 * Classe per rappresentare le dimensioni delle immagini contenute nei tweet
 * @author Davide Pacioni
 * @author Alex Giaccio
 *
 */
public class Dimensions {
	
	private long height=0;
	private long width=0;
	private long bytes=0;
	private String resize = null;
	

	public Dimensions() {
		super();
	}

	/**
	 * @return altezza
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
	 * @return larghezza
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

	public long getSize() {
		return bytes;
	}

	public void setSize(long size) {
		this.bytes = size;
	}
	
	public long calcDim(long w, long h) {
		return (w*h)*3;
	}
	
	
}
