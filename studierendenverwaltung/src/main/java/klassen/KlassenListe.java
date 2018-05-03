package klassen;

import java.util.ArrayList;
import java.util.List;

public class KlassenListe {

	private static KlassenListe instance;
	private List<Klasse> klassenList;

	private KlassenListe() {
		klassenList = new ArrayList<Klasse>();
		addDatabaseKlasse();
	}

	public static KlassenListe getInstance() {

		if (instance == null) {
			instance = new KlassenListe();
		}

		return instance;
	}

	private boolean addDatabaseKlasse() {

		// Klasse aus der Datenbank holen mit entsprechender ID
		/* .... */
		return false;
	}

	public boolean addKlasse(Klasse newKlasse) {

		// Datenbank
		// Klasse mit ID von Datenbank in Liste speichern
		/* ... */

		klassenList.add(newKlasse);

		return false;
	}

	public boolean removeKlasse(Klasse removeKlasse) {

		// Datenbank
		// Klasse aus Datenbank löschen
		/* ... */

		klassenList.remove(removeKlasse);

		return false;
	}

	public boolean updateKlasse(Klasse updateKlasse) {

		// Datenbank
		// Klasse in Datenbank updaten
		/* ... */

		klassenList.remove(updateKlasse);
		klassenList.add(updateKlasse);

		return false;
	}

	public List<Klasse> getklassenListe() {
		return klassenList;
	}

	// Liste nach ID´s sortieren!!
}
