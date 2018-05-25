package klassen;

import java.util.Date;
import java.util.List;

public class Dozent extends Benutzer {

	private List<Fach> fachListe;

//	public Dozent(BenutzerBuilder builder, List<Fach> fachListe) {
//		super(builder);
//		this.fachListe = fachListe;
//	}
	
	public Dozent(String anrede, String vorname, String name, Date gebJahr, String straße, String hausnummer, int plz, String ort, String passwort, String status, String kuerzel, String email, List<Fach> fachliste)
	{
		super(anrede, vorname, name, gebJahr, straße, hausnummer, plz, ort, passwort, status, kuerzel, email);
		this.fachListe = fachliste;
	}

	public List<Fach> getFachListe() {
		return fachListe;
	}

	public void setFachListe(List<Fach> fachListe) {
		this.fachListe = fachListe;
	}

	public void addNote() {

	}

	public void addStudentToKurs() {

	}

	public void deleteStudentFromKurs() {

	}

}
