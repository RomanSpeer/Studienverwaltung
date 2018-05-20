package klassen;

import org.jpatterns.gof.BuilderPattern;
import org.jpatterns.gof.BuilderPattern.ConcreteBuilder;

@BuilderPattern
@ConcreteBuilder(participants = Fach.class)

public class FachBuilder {

	public int fachID;
	public String name;
	public int dozentenID;
	public int klassenID;

	public static FachBuilder neuesFach() {
		FachBuilder fb = new FachBuilder();
		return fb;
	}

	public int getFachID() {
		return fachID;
	}

	public FachBuilder setFachID(int fachID) {
		this.fachID = fachID;
		return this;
	}

	public String getName() {
		return name;
	}

	public FachBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public int getDozentenID() {
		return dozentenID;
	}

	public FachBuilder setDozentenID(int dozentenID) {
		this.dozentenID = dozentenID;
		return this;
	}

	public int getKlassenID() {
		return klassenID;
	}

	public FachBuilder setKlassenID(int klassenID) {
		this.klassenID = klassenID;
		return this;
	}

}
