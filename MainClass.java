package watcher;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import watcher.logicaBusiness.gestori.Rilevatore;

/**
 * 
 * Classe MainClass per l'esecuzione del Thread che riceve le rilevazione dal rilevatore 
 * 
 * @author Graziano Accogli 
 *
 */
public class MainClass {
	
	/**
	 * Il costruttore della classe
	 */
	private MainClass() {}
	
	private final static Logger LOGGER = Logger.getLogger(MainClass.class.getName());

	
	/**
	 * Metodo per ricevere le rilevazioni dal Rilevatore
	 * @param unRilevatore Il rilevatore da cui prende le rilevazioni
	 */
	private static void inviaRilevazioni(Rilevatore unRilevatore) {	
		String percorsoFile = "";
		try {
			FileReader file = new FileReader(percorsoFile);
			BufferedReader buffer = new BufferedReader(file);
			String rilevazione = null; 
			do {
				rilevazione = buffer.readLine();
				unRilevatore.riceviRilevazione(rilevazione);
				
			}
			while(rilevazione != null);
			buffer.close();
			file.close();
		}
			catch (IOException e) {
				LOGGER.log(Level.SEVERE, "File non trovato");
			}
	}
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		Rilevatore r = Rilevatore.getIstanza();
		
		Thread t = new Thread(r);
		
		t.start();
		
		inviaRilevazioni(r);
		
	}
}
