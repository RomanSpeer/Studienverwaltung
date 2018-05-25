package klassen;

public class Klasse {

	public int klassenID;
	public String kuerzel;
	public int kurssprecher;
	public int stellvKurssprecher;

//	public Klasse(KlassenBuilder builder) {
//		super();
//		this.klassenID = builder.getKlassenID();
//		this.kuerzel = builder.getKuerzel();
//		this.kurssprecher = builder.getKurssprecher();
//		this.stellvKurssprecher = builder.getstellvKurssprecher();
//	}
	
	public Klasse( int klassenID, String kuerzel, int kurssprecher, int stellvKurssprecher)
	{
		this.klassenID = klassenID;
		this.kuerzel = kuerzel;
		this.kurssprecher = kurssprecher;
		this.stellvKurssprecher = stellvKurssprecher;
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

	public int getstellvKurssprecher() {
		return stellvKurssprecher;
	}

	public void setstellvKurssprecher(int stellvKurssprecher) {
		this.stellvKurssprecher = stellvKurssprecher;
	}

	public void changeKurssprecher() {

	}

	public void changestellvKurssprecher() {

	}
}
