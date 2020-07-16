package it.univpm.TwitterOOP.exception;

/**
 * Eccezione specifica del tipo IllegalArgumentException.
 * @author Davide Pacioni
 * @author Alex Giaccio
 * @see IllegalArgumentException
 *
 */
public class FilterIllegalArgumentException extends IllegalArgumentException{


	private static final long serialVersionUID = 1L;

	public FilterIllegalArgumentException() {
		super();
	}

	public FilterIllegalArgumentException(String message) {
		super(message);
	}
}
