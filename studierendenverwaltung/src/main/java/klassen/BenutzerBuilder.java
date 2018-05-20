package klassen;

import java.util.Date;
import org.jpatterns.gof.BuilderPattern;
import org.jpatterns.gof.BuilderPattern.ConcreteBuilder;

@BuilderPattern
@ConcreteBuilder(participants = Benutzer.class)
public class BenutzerBuilder {

	public int benutzerID;
	public String anrede;
	public String vorname;
	public String name;
	public Date gebJahr;
	public String straße;
	public int hausnummer;
	public String passwort;
	public String status;
	public String kuerzel;
	public String email;

	public String getKuerzel() {
		return kuerzel;
	}

	public void setKuerzel(String kuerzel) {
		this.kuerzel = kuerzel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static BenutzerBuilder neuerBenutzer() {
		BenutzerBuilder bb = new BenutzerBuilder();
		return bb;
	}

	public Benutzer benutzer() {
		return new Benutzer(this);
	}

	public int getBenutzerID() {
		return benutzerID;
	}

	public BenutzerBuilder setBenutzerID(int benutzerID) {
		this.benutzerID = benutzerID;
		return this;
	}

	public String getAnrede() {
		return anrede;
	}

	public BenutzerBuilder setAnrede(String anrede) {
		this.anrede = anrede;
		return this;
	}

	public String getVorname() {
		return vorname;
	}

	public BenutzerBuilder setVorname(String vorname) {
		this.vorname = vorname;
		return this;
	}

	public String getName() {
		return name;
	}

	public BenutzerBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public Date getGebJahr() {
		return gebJahr;
	}

	public BenutzerBuilder setGebJahr(Date gebJahr) {
		this.gebJahr = gebJahr;
		return this;
	}

	public String getStraße() {
		return straße;
	}

	public BenutzerBuilder setStraße(String straße) {
		this.straße = straße;
		return this;
	}

	public int getHausnummer() {
		return hausnummer;
	}

	public BenutzerBuilder setHausnummer(int hausnummer) {
		this.hausnummer = hausnummer;
		return this;
	}

	public String getPasswort() {
		return passwort;
	}

	public BenutzerBuilder setPasswort(String passwort) {
		this.passwort = passwort;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public BenutzerBuilder setStatus(String status) {
		this.status = status;
		return this;
	}
	
	public String getkuerzel() {
		return kuerzel;
	}

	public BenutzerBuilder setkuerzel(String kuerzel) {
		this.kuerzel = kuerzel;
		return this;
	}

}
