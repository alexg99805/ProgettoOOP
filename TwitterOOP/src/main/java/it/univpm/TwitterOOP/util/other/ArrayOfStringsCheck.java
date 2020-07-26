package it.univpm.TwitterOOP.util.other;

import java.util.ArrayList;

/**
 * Superclasse stringhe
 * 
 * @author Davide Pacioni
 * @author Alex Giaccio
 *
 */
public class ArrayOfStringsCheck {

	protected ArrayList<String> param = new ArrayList<String>();

	/**
	 * Costruttore
	 * 
	 * @param parameters ArrayList
	 * @throws IllegalArgumentException il valore inserito non è quello desiderato
	 */
	public ArrayOfStringsCheck(Object parameters) {

		if (parameters instanceof ArrayList<?>) {

			for (Object element : (ArrayList<?>) parameters) {

				if (element instanceof String) {
					param.add((String) element);
				} else {
					throw new IllegalArgumentException("Il tipo deve essere String ");
				}
			}

		} else {
			throw new IllegalArgumentException("Deve essere un array");
		}
	}



}
