package klassen;

import java.util.List;

public class Student extends Benutzer {

	public String matrikelnummer;
	public int klassenID;
	public List<Note> notenListe;
	public List<Fach> faecherListe;

	public Student(BenutzerBuilder benutzerBuilder, StudentenBuilder studentenBuilder) {
		super(benutzerBuilder);
		this.matrikelnummer = studentenBuilder.getMatrikelnummer();
		this.klassenID = studentenBuilder.getKlassenID();
		this.notenListe = studentenBuilder.getNotenListe();
		this.faecherListe = studentenBuilder.getFaecherListe();
	}

	public List<Note> getNotenListe() {
		return notenListe;
	}

	public void setNotenListe(List<Note> notenListe) {
		this.notenListe = notenListe;
	}

	public List<Fach> getFaecherListe() {
		return faecherListe;
	}

	public void setFaecherListe(List<Fach> faecherListe) {
		this.faecherListe = faecherListe;
	}

	public String getMatrikelnummer() {
		return matrikelnummer;
	}

	public void setMatrikelnummer(String matrikelnummer) {
		this.matrikelnummer = matrikelnummer;
	}

	public int getKlassenID() {
		return klassenID;
	}

	public void setKlassenID(int klassenID) {
		this.klassenID = klassenID;
	}

}
