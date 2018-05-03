package klassen;

import java.util.ArrayList;
import java.util.List;

public class FaecherListe {
	private static FaecherListe instance;
	private List<Fach> fachList;

	private FaecherListe() {
		fachList = new ArrayList<Fach>();
		addDatabaseFach();
	}

	public static FaecherListe getInstance() {

		if (instance == null) {
			instance = new FaecherListe();
		}

		return instance;
	}

	private boolean addDatabaseFach() {

		// Fach aus der Datenbank holen mit entsprechender ID
		/* .... */
		return false;
	}

	public boolean addFach(Fach newFach) {

		// Datenbank
		// Fach mit ID von Datenbank in Liste speichern
		/* ... */

		fachList.add(newFach);

		return false;
	}

	public boolean removeFach(Fach removeFach) {

		// Datenbank
		// Fach aus Datenbank löschen
		/* ... */

		fachList.remove(removeFach);

		return false;
	}

	public boolean updateFach(Fach updateFach) {

		// Datenbank
		// Fach in Datenbank updaten
		/* ... */

		fachList.remove(updateFach);
		fachList.add(updateFach);

		return false;
	}

	public List<Fach> getfachListe() {
		return fachList;
	}

	// Liste nach ID´s sortieren!!
}
