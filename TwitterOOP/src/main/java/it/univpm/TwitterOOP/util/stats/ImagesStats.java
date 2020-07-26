package it.univpm.TwitterOOP.util.stats;

import java.util.ArrayList;
import java.util.HashMap;

import it.univpm.TwitterOOP.model.Image;
import it.univpm.TwitterOOP.model.Tweet;

/**
 * Questa classe viene utilizzata per effettuare le statistiche sulle immagini
 * considerando la dimensione, l'altezza e la lunghezza
 * 
 * @author Davide Pacioni
 * @author Alex Giaccio
 *
 */

public class ImagesStats {

	private float heightMin = 0;
	private float heightMax = 0;
	private float heightAvg = 0;
	private float heightVar = 0;
	private float heightDev = 0;
	private float widthMin = 0;
	private float widthMax = 0;
	private float widthAvg = 0;
	private float widthVar = 0;
	private float widthDev = 0;
	private float dimMin = 0;
	private float dimMax = 0;
	private float dimAvg = 0;
	private float dimVar = 0;
	private float dimDev = 0;

	public HashMap<String, Float> imagesStats(ArrayList<Tweet> list) {

		short counter = 0;

		HashMap<String, Float> statMap = new HashMap<String, Float>();

		for (int i = 0; i < list.size(); i++)
			for (int j = 0; j < list.get(i).getEntities().size(); j++)
				for (int k = 0; k < list.get(i).getEntities().get(j).getImages().size(); k++) {
					Image img = list.get(i).getEntities().get(j).getImages().get(k);
					counter++;
					checkMinAndMaxDim(img);
					checkMinAndMaxHeight(img);
					checkMinAndMaxWidth(img);
					dimAvg += img.getSize().get(0).getSize();
					widthAvg += img.getSize().get(0).getWidth();
					heightAvg += img.getSize().get(0).getHeight();

				}

		setAvg(counter);

		for (int i = 0; i < list.size(); i++)
			for (int j = 0; j < list.get(i).getEntities().size(); j++)
				for (int k = 0; k < list.get(i).getEntities().get(j).getImages().size(); k++) {
					Image img = list.get(i).getEntities().get(j).getImages().get(k);
					heightVar += Math.pow(img.getSize().get(0).getHeight() - heightAvg, 2);
					widthVar += Math.pow(img.getSize().get(0).getWidth() - widthAvg, 2);
					dimVar += Math.pow(img.getSize().get(0).getSize() - dimAvg, 2);
				}

		heightVar = heightVar / counter;
		widthVar = widthVar / counter;
		dimVar = dimVar / counter;

		heightDev = (float) Math.sqrt(heightVar);
		widthDev = (float) Math.sqrt(widthVar);
		dimDev = (float) Math.sqrt(dimVar);

		statMap.put("Width Min", widthMin);
		statMap.put("Width Max", widthMax);
		statMap.put("Width Avg", widthAvg);
		statMap.put("Width Dev", widthDev);
		statMap.put("Height Min", heightMin);
		statMap.put("Height Max", heightMax);
		statMap.put("Height Avg", heightAvg);
		statMap.put("Height Dev", heightDev);
		statMap.put("Dimensions Min", dimMin);
		statMap.put("Dimensions Max", dimMax);
		statMap.put("Dimensions Avg", dimAvg);
		statMap.put("Dimensions Dev", dimDev);

		return statMap;
	}

	/**
	 * 
	 * @param img da controllare
	 */
	public void checkMinAndMaxHeight(Image img) {
		if (img.getSize().get(0).getHeight() < heightMin || heightMin == 0)
			heightMin = img.getSize().get(0).getHeight();
		if (img.getSize().get(0).getHeight() > heightMax)
			heightMax = img.getSize().get(0).getHeight();
	}

	/**
	 * 
	 * @param img
	 */
	public void checkMinAndMaxWidth(Image img) {
		if (img.getSize().get(0).getWidth() < widthMin || widthMin == 0)
			widthMin = img.getSize().get(0).getWidth();
		if (img.getSize().get(0).getWidth() > widthMax)
			widthMax = img.getSize().get(0).getWidth();
	}

	/**
	 * 
	 * @param img
	 */
	public void checkMinAndMaxDim(Image img) {
		if (img.getSize().get(0).getSize() < dimMin || dimMin == 0)
			dimMin = img.getSize().get(0).getSize();
		if (img.getSize().get(0).getSize() > dimMax)
			dimMax = img.getSize().get(0).getSize();
	}

	/**
	 * 
	 * @param counter le statistiche relative alle immagini considerando dimensione,
	 *                lunghezza e altezza
	 */

	public void setAvg(short counter) {
		dimAvg = dimAvg / counter;
		widthAvg = widthAvg / counter;
		heightAvg = heightAvg / counter;
	}

}
