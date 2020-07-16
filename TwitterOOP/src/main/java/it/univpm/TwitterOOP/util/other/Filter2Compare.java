package it.univpm.TwitterOOP.util.other;

import java.util.ArrayList;

/**
 * Rappresenta la superclasse che fa passare due oggetti interi come parametri
 * 
 * @author Davide Pacioni
 * @author Alex Giaccio
 *
 */
public class Filter2Compare {

	protected int param1;
	protected int param2;
	
		
	/** Costruttore 
	 * @param param è un ArrayList di interi che deve avere lunghezza due
	 * @throws IllegalArgumentException il valore passato non è quello desiderato
	*/
	public Filter2Compare(Object param){

		if(param instanceof ArrayList<?>) {
				
			if( ((ArrayList<?>) param).size() != 2) {
				throw new IndexOutOfBoundsException("2 Integer ") ;
			}
												
			if(((ArrayList<?>) param).get(0) instanceof Integer) {
				param1 = (int) ((ArrayList<?>) param).get(0) ;
			}else {throw new IllegalArgumentException("Type: Integer ");}
					
			if(((ArrayList<?>) param).get(1) instanceof Integer) {
				param2 = (int) ((ArrayList<?>) param).get(1) ;
			}else{throw new IllegalArgumentException("Type: Integer ");}			
					
					
		}else {
			throw new IllegalArgumentException("Type: Array of 2 Integer ");
		}
		
		if(param2 < param1) {
			throw new IllegalArgumentException("Integer two must be greater than Integer one ");
		}
	}


	
	/** Set
	 * @param param  è un ArrayList di interi che deve avere lunghezza due
	 * @throws IllegalArgumentException il valore passato non è quello desiderato
	*/
	
	public void setParameters(Object param) {
		
		if(param instanceof ArrayList<?>) {
			
			if( ((ArrayList<?>) param).size() != 2) {
				throw new IndexOutOfBoundsException("2 Integer ") ;
			}
											
			if(((ArrayList<?>) param).get(0) instanceof Integer) {
				param1 = (int) ((ArrayList<?>) param).get(0) ;
			}else {throw new IllegalArgumentException("Type: Integer ");}
					
			if(((ArrayList<?>) param).get(1) instanceof Integer) {
				param2 = (int) ((ArrayList<?>) param).get(1) ;
			}else{throw new IllegalArgumentException("Type: Integer ");}			
					
			
		}else {
			throw new IllegalArgumentException("Type: Array of 2 Integer ");
		}
		
		if(param2 < param1) {
			throw new IllegalArgumentException("Integer two must be greater than Integer one ");
		}
	}

	/**
	 * @return first paramet
	 */
	public int getParam1() {
		return param1;
	}

	/**
	 * @param parameter
	 * il primo parametro ha un nuovo valore
	 */
	public void setParam1(int param1) {
		this.param1 = param1;
	}

	/**
	 * @return second parameter
	 */
	public int getParam2() {
		return param2;
	}

	/**
	 * @param param2 
	 * il secondo parametro ha un nuovo valore
	 */
	public void setParam2(int param2) {
		this.param2 = param2;
	}
}


