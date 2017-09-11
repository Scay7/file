package watcher;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import watcher.logicaBusiness.gestori.Rilevatore;

public class Main {

	private static void inviaRilevazioni(Rilevatore unRilevatore) {	
		String percorsoFile = "";
		try {
			BufferedReader buffer = new BufferedReader(new FileReader(percorsoFile));
			String rilevazione; 
			do {
				rilevazione = buffer.readLine();
				unRilevatore.riceviRilevazione(rilevazione);
				
			}
			while(rilevazione != null);
			buffer.close();
		}
			catch (IOException e) {
				e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		Rilevatore r = Rilevatore.getIstanza();
		
		Thread t = new Thread(r);
		
		t.start();
		
		inviaRilevazioni(r);
		
		
	}	
}
