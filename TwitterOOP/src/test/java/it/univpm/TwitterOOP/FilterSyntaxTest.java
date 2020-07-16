package it.univpm.TwitterOOP;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.univpm.TwitterOOP.exception.FilterIllegalArgumentException;
import it.univpm.TwitterOOP.exception.FilterNotFoundException;
import it.univpm.TwitterOOP.service.FilterService;

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
		
		assertThrows(FilterNotFoundException.class, ()-> FilterService.instanceFilter("Hashtags", "Greater" , 6));		
		assertThrows(FilterNotFoundException.class, ()-> FilterService.instanceFilter("hashtag", "In", "Remote"));
		assertThrows(FilterNotFoundException.class, ()-> FilterService.instanceFilter("Height", "Greeater", 600));
		assertThrows(FilterIllegalArgumentException.class, ()-> FilterService.instanceFilter("Date", "After", "2011 12 03"));
		assertThrows(FilterIllegalArgumentException.class, ()-> FilterService.instanceFilter("Hashtag", "Greater", "g"));
	}
	
}
