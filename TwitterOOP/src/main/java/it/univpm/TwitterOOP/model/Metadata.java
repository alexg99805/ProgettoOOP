package it.univpm.TwitterOOP.model;

/**
 * Questa classe viene utilizzata per descrivere ogni campo contenuto nel tweet
 * @author Davide Pacioni
 * @author Alex Giaccio
 *
 */

public class Metadata {
	
	private String alias;
	private String sourceField;
	private String type;
	
	

	/**
	 * @param alias nome campo
	 * @param sourceField descrizione campo
	 * @param type  tipo campo
	 */
	public Metadata(String alias, String sourceField, String type) {
		super();
		this.alias = alias;
		this.sourceField = sourceField;
		this.type = type;
	}


	public Metadata() {
		super();

	}

	/**
	 * 
	 * @return nome campo
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * @param alias 
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}

	/**
	 * @return sourceField
	 */
	public String getSourceField() {
		return sourceField;
	}

	/**
	 * @param sourceField 
	 */
	public void setSourceField(String sourceField) {
		this.sourceField = sourceField;
	}

	/**
	 * @return type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
}
