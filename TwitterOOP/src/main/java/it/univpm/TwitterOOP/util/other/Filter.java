package it.univpm.TwitterOOP.util.other;

import it.univpm.TwitterOOP.model.Tweet;

/**
 * Rappresenta l'interfaccia per i filtri
 * 
 * @author Davide Pacioni
 * @author Alex Giaccio
 *
 */
public interface Filter {

	/**
	 * Questo metodo restituisce Vero se il filtro rispetta le caratteristiche
	 * richieste
	 * 
	 * @param tweet che si vuole modificare
	 * @return risposta
	 */
	public boolean filter(Tweet tweet);

}
