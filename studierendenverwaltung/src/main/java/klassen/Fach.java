package klassen;

public class Fach {

	public int fachID;
	public String name;
	public int dozentenID;
	public int klassenID;

	public Fach(FachBuilder builder) {
		this.fachID = builder.getFachID();
		this.name = builder.getName();
		this.dozentenID = builder.getDozentenID();
		this.klassenID = builder.getKlassenID();
	}

	public int getFachID() {
		return fachID;
	}

	public void setFachID(int fachID) {
		this.fachID = fachID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDozentenID() {
		return dozentenID;
	}

	public void setDozentenID(int dozentenID) {
		this.dozentenID = dozentenID;
	}

	public int getKlassenID() {
		return klassenID;
	}

	public void setKlassenID(int klassenID) {
		this.klassenID = klassenID;
	}

}
