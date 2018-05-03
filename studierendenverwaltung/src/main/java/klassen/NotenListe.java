package klassen;

import java.util.ArrayList;
import java.util.List;

public class NotenListe {

	private static NotenListe instance;
	private List<Note> notenList;
	private int userID;
	private String position;

	private NotenListe(int userID, String position) {
		notenList = new ArrayList<Note>();
		this.userID = userID;
		this.position = position;
		addDatabaseNote();
	}

	public static NotenListe getInstance(int user, String positsion) {

		if (instance == null) {
			instance = new NotenListe(user, positsion);
		}

		return instance;
	}

	private void addDatabaseNote() {

		// Noten aus der Datenbank holen mit entsprechender ID
		// bei Lehrer oder Verwaltung alle noten
		/* .... */
		notenList.add(null);
	}

	public boolean addNote(Note newNote) {

		// Datenbank
		// Note mit ID von Datenbank in Liste speichern
		/* ... */

		notenList.add(newNote);

		return false;
	}

	public boolean removeNote(Note removeNote) {

		// Datenbank
		// Note aus Datenbank löschen
		/* ... */

		notenList.remove(removeNote);

		return false;
	}

	public boolean updateNote(Note updateNote) {

		// Datenbank
		// Note in Datenbank updaten
		/* ... */

		notenList.remove(updateNote);
		notenList.add(updateNote);

		return false;
	}

	public List<Note> getNotenListe() {
		return notenList;
	}

	// Liste nach ID´s sortieren!!
}
