package klassen;

public class NotenBuilder {

	public int notenID;
	public int studentenID;
	public int note;
	public int fachID;
	public int semester;
	public String art;

	public static NotenBuilder neueNote() {
		NotenBuilder nb = new NotenBuilder();
		return nb;
	}

	public int getNotenID() {
		return notenID;
	}

	public NotenBuilder setNotenID(int notenID) {
		this.notenID = notenID;
		return this;
	}

	public int getStudentenID() {
		return studentenID;
	}

	public NotenBuilder setStudentenID(int studentenID) {
		this.studentenID = studentenID;
		return this;
	}

	public int getNote() {
		return note;
	}

	public NotenBuilder setNote(int note) {
		this.note = note;
		return this;
	}

	public int getFachID() {
		return fachID;
	}

	public NotenBuilder setFachID(int fachID) {
		this.fachID = fachID;
		return this;
	}

	public int getSemester() {
		return semester;
	}

	public NotenBuilder setSemester(int semester) {
		this.semester = semester;
		return this;
	}

	public String getArt() {
		return art;
	}

	public NotenBuilder setArt(String art) {
		this.art = art;
		return this;
	}

}
