package klassen;

public class Note {

	public int notenID;
	public int studentenID;
	public int note;
	public int fachID;
	public int semester;
	public String art;

//	public Note(NotenBuilder builder) {
//		this.notenID = builder.getNotenID();
//		this.studentenID = builder.getStudentenID();
//		this.note = builder.getNote();
//		this.fachID = builder.getFachID();
//		this.semester = builder.getSemester();
//		this.art = builder.getArt();
//	}
	
	public Note(int notenID, int studentenID, int note, int fachID, int semester, String art) 
	{
		this.notenID = notenID;
		this.studentenID = studentenID;
		this.note = note;
		this.fachID = fachID;
		this.semester = semester;
		this.art = art;
	}

	public int getNotenID() {
		return notenID;
	}

	public void setNotenID(int notenID) {
		this.notenID = notenID;
	}

	public int getStudentenID() {
		return studentenID;
	}

	public void setStudentenID(int studentenID) {
		this.studentenID = studentenID;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public int getFachID() {
		return fachID;
	}

	public void setFachID(int fachID) {
		this.fachID = fachID;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public String getArt() {
		return art;
	}

	public void setArt(String art) {
		this.art = art;
	}
}
