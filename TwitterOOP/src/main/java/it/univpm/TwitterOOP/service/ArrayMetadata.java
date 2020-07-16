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
		metadata.add(new Metadata("created_at", "data e ora in cui il tweet è stato pubblicato", "CreationDate"));
		metadata.add(new Metadata("text","corpo del tweet","String"));
		metadata.add(new Metadata("entities","ulteriori array in riferimento agli hashtag, alle menzioni, agli url e alle immagini","ArrayList"));
		metadata.add(new Metadata("hashtags","hashtag presenti nel tweet","ArrayList"));
		metadata.add(new Metadata("text","corpo dell'hashtag","String"));
		metadata.add(new Metadata("mentions","contiene le informazioni di quegli account che sono menzionati nel tweet","ArrayList"));
		metadata.add(new Metadata("id","identificatore dell'utente che viene menzionato nel tweet","Long"));
		metadata.add(new Metadata("name","nome dell'utente menzionato","String"));
		metadata.add(new Metadata("screenName","nome user unico per ogni account","String"));
		metadata.add(new Metadata("url","contiene gli url presenti nel corpo del tweet","ArrayList"));
		metadata.add(new Metadata("Url","url presente nel tweet","String"));
		metadata.add(new Metadata("expandedUrl","url completo","String"));
		metadata.add(new Metadata("image","contiene le informazioni relative all'immagine presente nel tweet","ArrayList"));
		metadata.add(new Metadata("id","id entificatore immagine","Long"));
		metadata.add(new Metadata("media_url","url dell'immagine","String"));
		metadata.add(new Metadata("type","tipologia dell'immagine","String"));
		metadata.add(new Metadata("size","misure riguardanti l'immagine","ArrayList"));
		metadata.add(new Metadata("height","altezza immagine","Long"));
		metadata.add(new Metadata("bytes","dimensione in byte riguardante l'immagine","Long"));
		metadata.add(new Metadata("width","larghezza dell'immagine","Long"));
		metadata.add(new Metadata("resize","ridimensionamento immagini senza modificarle","String"));
		metadata.add(new Metadata("retweet_count","num volte in cui il tweet è stato repostato dagli altri utenti","Long"));
		metadata.add(new Metadata("lang","lingua in cui il tweet è stato twittato","String"));
		metadata.add(new Metadata("users","array che contiene le informazioni sull'utente che ha postato il tweet","ArrayList"));
		metadata.add(new Metadata("id","identificatore dell'utente che ha postato il tweet","Long"));
		metadata.add(new Metadata("name","nome completo dell'utente che ha postato il tweet","String"));
		metadata.add(new Metadata("description","informazioni relative alle info del profilo","String"));
		metadata.add(new Metadata("screenName","unico nome dell'account twitter","String"));
		metadata.add(new Metadata("followerCount","numero di seguaci che ha l'utente sul proprio profilo","Long"));
		return metadata;
	}
}
