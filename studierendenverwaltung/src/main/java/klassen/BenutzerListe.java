package klassen;

import java.util.ArrayList;
import java.util.List;

public class BenutzerListe {

	private static BenutzerListe instance;
	private List<Student> studentenList;
	private List<Verwaltung> verwaltungList;
	private List<Dozent> dozentenList;

	private BenutzerListe() {
		studentenList = new ArrayList<Student>();
		verwaltungList = new ArrayList<Verwaltung>();
		dozentenList = new ArrayList<Dozent>();
		addDatabaseUser();
	}

	public static BenutzerListe getInstance() {

		if (instance == null) {
			instance = new BenutzerListe();
		}

		return instance;
	}

	private void addDatabaseUser() {
		// Benutzer aus der Datenbank holen und der entsprechenden Liste hiinzufügen

		// Studenten
		/* ... */

		// Verwaltung
		/* ... */

		// Dozenten
		/* ... */
	}

	public boolean addStudent(Student newStudent) {

		// Datenbank
		// Student mit ID von Datenbank in Liste speichern
		/* ... */

		return false;
	}

	public boolean addVerwaltung(Verwaltung newVerwaltung) {

		// Datenbank
		// Verwaltung mit ID von Datenbank in Liste speichern
		/* ... */

		return false;
	}

	public boolean addDozent(Dozent newDozent) {

		// Datenbank
		// Dozent mit ID von Datenbank in Liste speichern
		/* ... */

		return false;
	}

	public boolean removeStudent(Student removeStudent) {

		// Datenbank
		// Student aus Datenbank löschen
		/* ... */

		studentenList.remove(removeStudent);

		return false;
	}

	public boolean removeVerwaltung(Verwaltung removeVerwaltung) {

		// Datenbank
		// Verwaltung aus Datenbank löschen
		/* ... */

		verwaltungList.remove(removeVerwaltung);

		return false;
	}

	public boolean removeDozent(Dozent removeDozent) {

		// Datenbank
		// Dozent aus Datenbank löschen
		/* ... */

		dozentenList.remove(removeDozent);

		return false;
	}

	public boolean updateStudent(Student updateStudent) {

		// Datenbank
		// Student in Datenbank updaten
		/* ... */

		studentenList.remove(updateStudent);
		studentenList.add(updateStudent);

		return false;
	}

	public boolean updateVerwaltung(Verwaltung updateVerwaltung) {

		// Datenbank
		// Verwaltung in Datenbank updaten
		/* ... */

		verwaltungList.remove(updateVerwaltung);
		verwaltungList.add(updateVerwaltung);

		return false;
	}

	public boolean updateDozent(Dozent updateDozent) {

		// Datenbank
		// Dozent in Datenbank updaten
		/* ... */

		dozentenList.remove(updateDozent);
		dozentenList.add(updateDozent);

		return false;
	}

	public List<Student> getStudentenListe() {
		return studentenList;
	}

	public List<Verwaltung> getVerwaltungListe() {
		return verwaltungList;
	}

	public List<Dozent> getDozentenListe() {
		return dozentenList;
	}

	public List<Object> searchBenutzer(String toSearch) {
		toSearch = toSearch.toLowerCase();
		List<Object> found = new ArrayList<Object>();
		for (Student tmpStudent : studentenList) {
			if (tmpStudent.vorname.toLowerCase().equals(toSearch)) {
				found.add(tmpStudent);
				break;
			} else if (tmpStudent.name.toLowerCase().equals(toSearch)) {
				found.add(tmpStudent);
				break;
			} else if (tmpStudent.kuerzel.toLowerCase().equals(toSearch)) {
				found.add(tmpStudent);
				break;
			} else if (tmpStudent.kuerzel.toLowerCase().equals(toSearch)) {
				found.add(tmpStudent);
				break;
			} else {
				// falls es eine Klasse ist dann die klassenID herausfinden da im Student nur
				// die ID hinterlegt wird
				break;
			}
		}

		for (Dozent tmpDozent : dozentenList) {
			if (tmpDozent.vorname.toLowerCase().equals(toSearch)) {
				found.add(tmpDozent);
				break;
			} else if (tmpDozent.name.toLowerCase().equals(toSearch)) {
				found.add(tmpDozent);
				break;
			} else if (tmpDozent.kuerzel.toLowerCase().equals(toSearch)) {
				found.add(tmpDozent);
				break;
			} else if (tmpDozent.kuerzel.toLowerCase().equals(toSearch)) {
				found.add(tmpDozent);
				break;
			}
		}

		for (Verwaltung tmpVerwaltung : verwaltungList) {
			if (tmpVerwaltung.vorname.toLowerCase().equals(toSearch)) {
				found.add(tmpVerwaltung);
				break;
			} else if (tmpVerwaltung.name.toLowerCase().equals(toSearch)) {
				found.add(tmpVerwaltung);
				break;
			} else if (tmpVerwaltung.kuerzel.toLowerCase().equals(toSearch)) {
				found.add(tmpVerwaltung);
				break;
			} else if (tmpVerwaltung.kuerzel.toLowerCase().equals(toSearch)) {
				found.add(tmpVerwaltung);
				break;
			}
		}

		return found;
	}
}
