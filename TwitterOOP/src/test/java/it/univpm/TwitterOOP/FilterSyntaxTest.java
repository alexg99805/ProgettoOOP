package it.univpm.TwitterOOP;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.univpm.TwitterOOP.exception.FilterIllegalArgumentException;
import it.univpm.TwitterOOP.service.FilterCall;

/**
 * Classe che effettua test sul funzionamento delle eccezioni 
 * @author Davide Pacioni
 * @author Alex Giaccio
 *
 */
public class FilterSyntaxTest {
	
	@BeforeEach
	void setUp() throws Exception {

	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	
	@Test
	public void testFilterService() {
		String bodyJSON =  "{Hashtag={Less=3}, Date={Type=and, HHHHH=[2020-07-14]}, Width={Type=or, Greater=1000}}"; 
		
		assertThrows(FilterIllegalArgumentException.class, ()-> FilterCall.callFilter(bodyJSON));		
	}
	
}
