package it.univpm.TwitterOOP.util.other;

import java.util.ArrayList;

/**
 * Rappresenta la superclasse che fa passare due oggetti interi come parametri
 * 
 * @author Davide Pacioni
 * @author Alex Giaccio
 *
 */
public class IntegersCompare {

	protected int param1;
	protected int param2;

	/**
	 * Costruttore
	 * 
	 * @param param è un ArrayList di interi che deve avere lunghezza due
	 * @throws IllegalArgumentException il valore passato non è quello desiderato
	 */
	public IntegersCompare(Object param) {
		if (param instanceof ArrayList<?>) {

			if (((ArrayList<?>) param).size() != 2) {
				throw new IndexOutOfBoundsException("Solo 2 interi!");
			}

			if (((ArrayList<?>) param).get(0) instanceof Integer) {
				param1 = (int) ((ArrayList<?>) param).get(0);
			} else {
				throw new IllegalArgumentException("Il tipo deve essere un intero ");
			}

			if (((ArrayList<?>) param).get(1) instanceof Integer) {
				param2 = (int) ((ArrayList<?>) param).get(1);
			} else {
				throw new IllegalArgumentException("Il tipo deve essere un intero");
			}

		} else {
			throw new IllegalArgumentException("Il tipo deve essere un array di 2 interi");
		}

		if (param2 < param1) {
			throw new IllegalArgumentException("Il secondo intero deve essere > del primo intero");
		}
	}



}
