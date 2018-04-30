package klassen;

import java.util.List;

public class Dozent extends Benutzer{
	
	private List<Fach> fachListe;

	public Dozent(BenutzerBuilder builder, List<Fach> fachListe) {
		super(builder);
		this.fachListe = fachListe;
		// TODO Auto-generated constructor stub
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
