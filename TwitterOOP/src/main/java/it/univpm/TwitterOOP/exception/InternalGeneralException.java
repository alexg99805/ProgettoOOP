package it.univpm.TwitterOOP.exception;

/**
 * Eccezione specifica di tipo Exception.
 * 
 * @author Davide Pacioni
 * @author Alex Giaccio
 * @see Exception
 *
 */

public class InternalGeneralException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;

	public InternalGeneralException() {
		super();
	}

	public InternalGeneralException(String message) {
		super(message);
	}
}
