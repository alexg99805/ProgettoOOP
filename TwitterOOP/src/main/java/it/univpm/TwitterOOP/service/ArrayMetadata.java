package it.univpm.TwitterOOP.service;

import java.util.ArrayList;

import it.univpm.TwitterOOP.model.Metadata;

/**
 * Questa classe permette di visualizzare un intero array contenente tutti i dettagli
 * riguardanti tutti i campi del tweet analizzato
 * @author Davide Pacioni
 * @author Alex Giaccio
 *
 */
public class ArrayMetadata {
	
	private static ArrayList<Metadata> metadata = new ArrayList<Metadata>();
	
	/**
	 * 
	 * @return un array che contenente tutti i metadata necessari
	 */
	public static ArrayList<Metadata> getArrayMetadata() {
		
		metadata.add(new Metadata("id","identificatore del tweet","Long"));
		metadata.add(new Metadata("created_at", "data e ora in cui il tweet � stato pubblicato", "CreationDate"));
		metadata.add(new Metadata("text","corpo del tweet","String"));
		metadata.add(new Metadata("entities","ulteriori array in riferimento agli hashtag e alle immagini","ArrayList"));
		metadata.add(new Metadata("hashtags","hashtag presenti nel tweet","ArrayList"));
		metadata.add(new Metadata("text","corpo dell'hashtag","String"));
		metadata.add(new Metadata("image","contiene le informazioni relative all'immagine presente nel tweet","ArrayList"));
		metadata.add(new Metadata("type","tipologia dell'immagine","String"));
		metadata.add(new Metadata("size","misure riguardanti l'immagine","ArrayList"));
		metadata.add(new Metadata("height","altezza immagine","Long"));
		metadata.add(new Metadata("bytes","dimensione in byte riguardante l'immagine","Long"));
		metadata.add(new Metadata("width","larghezza dell'immagine","Long"));
		metadata.add(new Metadata("resize","ridimensionamento immagini senza modificarle","String"));
		metadata.add(new Metadata("contaretw","num volte in cui il tweet è stato repostato dagli altri utenti","Long"));
		metadata.add(new Metadata("lang","lingua in cui il tweet è stato twittato","String"));
		return metadata;
	}
}
