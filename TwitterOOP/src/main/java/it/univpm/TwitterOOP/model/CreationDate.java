package it.univpm.TwitterOOP.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.json.simple.parser.ParseException;

/**
 * Classe per effettuare il parsing delle date e mette in istruzione i metodi
 * per confrontare le date
 * 
 * @author Davide Pacioni
 * @author Alex Giaccio
 *
 */
public class CreationDate {

	private LocalDate creation_date;

	public CreationDate() {
		this.creation_date = null;
	}

	LocalDate getCreation_date() {
		return creation_date;
	}

	/**
	 * 
	 * metodo setter dell'attributo creation_date Viene effettuato anche il parsing
	 * del parametro formale
	 * 
	 * @param date
	 * @throws ParseException
	 */
	public void setCreation_date(String date) throws ParseException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss Z yyyy", Locale.ENGLISH);
		LocalDateTime creation = LocalDateTime.parse(date, formatter);
		this.creation_date = creation.toLocalDate();

	}

	/**
	 * 
	 * @return day
	 */

	public int getDay() {
		return this.creation_date.getDayOfMonth();
	}

	/**
	 * 
	 * @return month
	 */
	public int getMonth() {
		return this.creation_date.getMonthValue();
	}

	/**
	 * 
	 * @return year
	 */
	public int getYear() {
		return this.creation_date.getYear();
	}

	/**
	 * Questo metodo serve a comparare la data passata come parametro con quella
	 * presente nel post
	 * 
	 * @param dateToParse
	 * @return
	 */
	public int compareTo(String dateToParse) {
		DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
		// System.out.println(dateToParse);
		LocalDate dateToCompare = LocalDate.parse(dateToParse, formatter);
		// LocalDate dateToCompare = creation.toLocalDate();

		if (this.creation_date.getDayOfMonth() == dateToCompare.getDayOfMonth()
				&& this.creation_date.getMonthValue() == dateToCompare.getMonthValue()
				&& this.creation_date.getYear() == dateToCompare.getYear())
			return 0;
		else if (this.creation_date.isBefore(dateToCompare))
			return -1;
		return 1;
	}

}
