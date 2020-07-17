package it.univpm.TwitterOOP.util.filter;

import it.univpm.TwitterOOP.model.Tweet;
import it.univpm.TwitterOOP.util.other.Filter;
import it.univpm.TwitterOOP.util.other.Filter2Compare;
import it.univpm.TwitterOOP.util.other.FilterArrayString;

/** Questa classe controlla se l'immagine contenuta nel tweet che gli viene passato
 *  ha un'altezza ben precisa che gli viene fornito tramite due parametri
 *  
 *  @see Tweet
 *  @see Filter2Compare
 *  @see Filter
 *  
 *  @author Davide Pacioni
 *  @author Alex Giaccio
*/
public class FilterHeightIn extends Filter2Compare implements Filter {


	public FilterHeightIn(Object param) {                                  
		super(param);
	}
	
	
	@Override
	public boolean filter(Tweet tweet) {
		for(int i=0; i<tweet.getEntities().size(); i++) 
			for(int j=0; j<tweet.getEntities().get(i).getImages().size(); j++)
				for(int k=0;k<tweet.getEntities().get(i).getImages().get(j).getSize().size(); k++) {
					boolean cond1 =tweet.getEntities().get(i).getImages().get(j).getSize().get(k).getHeight() > param1;
					boolean cond2 =tweet.getEntities().get(i).getImages().get(j).getSize().get(k).getHeight() < param2;
					if(cond1 && cond2)
						return true;
				}
	return false;
	
	}
				
				

}