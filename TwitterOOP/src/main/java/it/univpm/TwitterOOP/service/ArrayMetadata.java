package it.univpm.TwitterOOP.service;

import java.util.ArrayList;

import it.univpm.TwitterOOP.model.Metadata;
import it.univpm.TwitterOOP.model.Metadata;

import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
        JSONParser jsonParser = new JSONParser();
         
        try(FileReader reader = new FileReader("metadata"))
        {
            Object obj = jsonParser.parse(reader);
            JSONArray file_metadata = (JSONArray) obj;
           
            //Iterate over employee array
            file_metadata.forEach(single_metadata -> addMetadata((JSONObject) single_metadata));
            return metadata;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

 
    private static void addMetadata(JSONObject single_metadata) 
    {
        Metadata x = new Metadata(single_metadata.get("field"), single_metadata.get("description"), single_metadata.get("var_type"));
        metadata.add(x);
	}
}