package it.univpm.TwitterOOP.util.other;

import java.util.ArrayList;

/**
 * Superclasse stringhe
 * 
 * @author Davide Pacioni
 * @author Alex Giaccio
 *
 */
public class FilterArrayString {

	protected ArrayList<String> param = new ArrayList<String>();

	/**
	 * Costruttore
	 * 
	 * @param parameters ArrayList
	 * @throws IllegalArgumentException il valore inserito non è quello desiderato
	 */
	public FilterArrayString(Object parameters) {

		if (parameters instanceof ArrayList<?>) {

			for (Object element : (ArrayList<?>) parameters) {

				if (element instanceof String) {
					param.add((String) element);
				} else {
					throw new IllegalArgumentException("Type: String ");
				}
			}

		} else {
			throw new IllegalArgumentException("Type: Array ");
		}
	}

	/**
	 * Set
	 * 
	 * @param parameters ArrayList
	 * @throws IllegalArgumentException il valore inserito non è quello desiderato
	 */
	public void SetFilterParameters(Object parameters) {

		if (parameters instanceof ArrayList<?>) {

			for (Object element : (ArrayList<?>) parameters) {

				if (element instanceof String) {
					param.add((String) element);
				} else {
					throw new IllegalArgumentException("Type: String ");
				}
			}

		} else {
			throw new IllegalArgumentException("Type: Array ");
		}
	}

}
