package klassen;


import org.jpatterns.gof.BuilderPattern;
import org.jpatterns.gof.BuilderPattern.ConcreteBuilder;

@BuilderPattern
@ConcreteBuilder(participants = Klasse.class)
public class KlassenBuilder {

	public int klassenID;
	public String kuerzel;
	public int kurssprecher;
	public int stellvKursprecher;

	public static KlassenBuilder neueKlasse() {
		KlassenBuilder kb = new KlassenBuilder();
		return kb;
	}

	public Klasse klasse() {
		return new Klasse(this);
	}

	public int getKlassenID() {
		return klassenID;
	}

	public KlassenBuilder setKlassenID(int klassenID) {
		this.klassenID = klassenID;
		return this;
	}

	public String getKuerzel() {
		return kuerzel;
	}

	public KlassenBuilder setKuerzel(String kuerzel) {
		this.kuerzel = kuerzel;
		return this;
	}

	public int getKurssprecher() {
		return kurssprecher;
	}

	public KlassenBuilder setKurssprecher(int kurssprecher) {
		this.kurssprecher = kurssprecher;
		return this;
	}

	public int getStellvKursprecher() {
		return stellvKursprecher;
	}

	public KlassenBuilder setStellvKursprecher(int stellvKursprecher) {
		this.stellvKursprecher = stellvKursprecher;
		return this;
	}

}
