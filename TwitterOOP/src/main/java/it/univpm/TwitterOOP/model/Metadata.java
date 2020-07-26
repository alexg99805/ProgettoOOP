package it.univpm.TwitterOOP.model;

/**
 * Questa classe � utilizzata per descrivere ogni campo contenuto nel tweet
 * 
 * @author Davide Pacioni
 * @author Alex Giaccio
 *
 */

public class Metadata {

	private String field;
	private String description;
	private String var_type;

	/**
	 * @param field       nome campo
	 * @param description descrizione campo
	 * @param var_type    tipo campo
	 */
	public Metadata(String field, String description, String var_type) {
		super();
		this.field = field;
		this.description = description;
		this.var_type = var_type;
	}

	public Metadata() {
		super();

	}

	/**
	 * 
	 * @return nome campo
	 */
	public String getField() {
		return field;
	}

	/**
	 * @param field
	 */
	public void setField(String field) {
		this.field = field;
	}

	/**
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return var_type
	 */
	public String getVar_type() {
		return var_type;
	}

	/**
	 * @param type
	 */
	public void setVar_type(String var_type) {
		this.var_type = var_type;
	}
}
