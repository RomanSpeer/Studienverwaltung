package klassen;

import java.util.Date;

public class Benutzer {

	public int benutzerID;
	public String anrede;
	public String vorname;
	public String name;
	public Date gebJahr;
	public String straße;
	public int hausnummer;
	public String passwort;
	public String status;

	public Benutzer(BenutzerBuilder builder) {
		super();
		this.benutzerID = builder.getBenutzerID();
		this.anrede = builder.getAnrede();
		this.vorname = builder.getVorname();
		this.name = builder.getName();
		this.gebJahr = builder.getGebJahr();
		this.straße = builder.getStraße();
		this.hausnummer = builder.getHausnummer();
		this.passwort = builder.getPasswort();
		this.status = builder.getStatus();
	}

	public void setBenutzerID(int benutzerID) {
		this.benutzerID = benutzerID;
	}

	public void setAnrede(String anrede) {
		this.anrede = anrede;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGebJahr(Date gebJahr) {
		this.gebJahr = gebJahr;
	}

	public void setStraße(String straße) {
		this.straße = straße;
	}

	public void setHausnummer(int hausnummer) {
		this.hausnummer = hausnummer;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getBenutzerID() {
		return benutzerID;
	}

	public String getAnrede() {
		return anrede;
	}

	public String getVorname() {
		return vorname;
	}

	public String getName() {
		return name;
	}

	public Date getGebJahr() {
		return gebJahr;
	}

	public String getStraße() {
		return straße;
	}

	public int getHausnummer() {
		return hausnummer;
	}

	public String getPasswort() {
		return passwort;
	}

	public String getStatus() {
		return status;
	}

	public void login() {

	}

	public void logout() {

	}

	public void search() {

	}

	public void generatePDF() {

	}

}
