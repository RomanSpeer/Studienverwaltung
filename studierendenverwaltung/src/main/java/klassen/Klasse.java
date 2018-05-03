package klassen;

public class Klasse {

	public int klassenID;
	public String kuerzel;
	public int kurssprecher;
	public int stellvKursprecher;

	public Klasse(KlassenBuilder builder) {
		super();
		this.klassenID = builder.getKlassenID();
		this.kuerzel = builder.getKuerzel();
		this.kurssprecher = builder.getKurssprecher();
		this.stellvKursprecher = builder.getStellvKursprecher();
	}

	public int getKlassenID() {
		return klassenID;
	}

	public void setKlassenID(int klassenID) {
		this.klassenID = klassenID;
	}

	public String getKuerzel() {
		return kuerzel;
	}

	public void setKuerzel(String kuerzel) {
		this.kuerzel = kuerzel;
	}

	public int getKurssprecher() {
		return kurssprecher;
	}

	public void setKurssprecher(int kurssprecher) {
		this.kurssprecher = kurssprecher;
	}

	public int getStellvKursprecher() {
		return stellvKursprecher;
	}

	public void setStellvKursprecher(int stellvKursprecher) {
		this.stellvKursprecher = stellvKursprecher;
	}

	public void changeKurssprecher() {

	}

	public void changeStellvKursprecher() {

	}
}
