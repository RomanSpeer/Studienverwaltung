package klassen;

import java.util.List;

public class StudentenBuilder {

	public String matrikelnummer;
	public int klassenID;
	public List<Note> notenListe;
	public List <Fach> faecherListe;
	
	public static StudentenBuilder neuerStudent() {
		StudentenBuilder sb = new StudentenBuilder();
		return sb;
	}

	public String getMatrikelnummer() {
		return matrikelnummer;
	}

	public StudentenBuilder setMatrikelnummer(String matrikelnummer) {
		this.matrikelnummer = matrikelnummer;
		return this;
	}

	public int getKlassenID() {
		return klassenID;
	}

	public StudentenBuilder setKlassenID(int klassenID) {
		this.klassenID = klassenID;
		return this;
	}

	public List<Note> getNotenListe() {
		return notenListe;
	}

	public StudentenBuilder setNotenListe(List<Note> notenListe) {
		this.notenListe = notenListe;
		return this;
	}

	public List<Fach> getFaecherListe() {
		return faecherListe;
	}

	public StudentenBuilder setFaecherListe(List<Fach> faecherListe) {
		this.faecherListe = faecherListe;
		return this;
		
	}
	
	
}
