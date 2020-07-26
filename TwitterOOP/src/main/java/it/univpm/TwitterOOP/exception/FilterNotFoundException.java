package it.univpm.TwitterOOP.exception;

/**
 * Eccezione specifica di tipo ClassNotFoundException.
 * 
 * @author Davide Pacioni
 * @author Alex Giaccio
 * @see ClassNotFoundException
 *
 */

public class FilterNotFoundException extends ClassNotFoundException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	public FilterNotFoundException() {
		super();
	}

	public FilterNotFoundException(String message) {
		super(message);
	}

}
