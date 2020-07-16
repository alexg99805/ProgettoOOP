package it.univpm.TwitterOOP.exception;

/**
 * Eccezione specifica di tipo ClassNotFoundException.
 * @author Davide Pacioni
 * @author Alex Giaccio
 * @see ClassNotFoundException
 *
 */

public class StatsNotFoundException extends ClassNotFoundException{


	private static final long serialVersionUID = 4L;

	public StatsNotFoundException() {
		super();
	}

	public StatsNotFoundException(String message) {
		super(message);
	}
}
