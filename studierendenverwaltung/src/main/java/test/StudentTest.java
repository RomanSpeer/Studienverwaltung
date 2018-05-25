package test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import klassen.Benutzer;
import klassen.BenutzerBuilder;
import klassen.Fach;
import klassen.FachBuilder;
import klassen.Note;
import klassen.NotenBuilder;
import klassen.Student;
import klassen.StudentenBuilder;

public class StudentTest {

	// Exkurs: TDD (Test driven Development und hamcrest) -> red, green, refactor...
	// Referenz bzw. Cheat-Sheet:
	// https://www.marcphilipp.de/downloads/posts/2013-01-02-hamcrest-quick-reference/Hamcrest-1.3.pdf

	// Definition Wikipedia:
	// https://de.wikipedia.org/wiki/Testgetriebene_Entwicklung

	// Literatur:
	// Kent Beck, Test-Driven Development by Example, Addison-Wesley Verlag


	@Test
	public void vergleichMitNullwertSollteFalseLiefern() throws Exception {

		// given (oder gegeben sein)
		List<Fach> faecher = new ArrayList<Fach>();
		Fach fach = new Fach(FachBuilder.neuesFach().setDozentenID(1)
				.setFachID(1)
				.setKlassenID(1)
				.setName("Mathe"));
		
		faecher.add(fach);
		
		List<Note> noten = new ArrayList<Note>();
		Note note = new Note(NotenBuilder.neueNote().setArt("String")
				.setFachID(1)
				.setNote(3)
				.setNotenID(2)
				.setSemester(4)
				.setStudentenID(1));
		
		noten.add(note);
		
		
		BenutzerBuilder benutzer = new BenutzerBuilder().setAnrede("Herr")
				.setBenutzerID(1)
				.setGebJahr(new Date(1220227200L * 1000))
				.setHausnummer("22")
				.setkuerzel("sp")
				.setName("Alster")
				.setPasswort("12345")
				.setStatus("Blokckiert")
				.setStraße("Federathweg")
				.setVorname("Erni");
		
		Student student = new Student(benutzer, StudentenBuilder.neuerStudent().setFaecherListe(faecher)
				.setKlassenID(1)
				.setMatrikelnummer("ASFNIAJGPSASGNÖ787FA")
				.setNotenListe(noten));

		// when (wenn)
		boolean expected = student.equals(null);

		// then (dann)
		assertThat(expected, is(false));
	}

	// reflexive
	@Test
	public void vergleichMitSichSelbstSollteTrueLiefern() throws Exception {

		List<Fach> faecher = new ArrayList<Fach>();
		Fach fach = new Fach(FachBuilder.neuesFach().setDozentenID(1)
				.setFachID(1)
				.setKlassenID(1)
				.setName("Mathe"));
		
		faecher.add(fach);
		
		List<Note> noten = new ArrayList<Note>();
		Note note = new Note(NotenBuilder.neueNote().setArt("String")
				.setFachID(1)
				.setNote(3)
				.setNotenID(2)
				.setSemester(4)
				.setStudentenID(1));
		
		noten.add(note);
		
		
		BenutzerBuilder benutzer = new BenutzerBuilder().setAnrede("Herr")
				.setBenutzerID(1)
				.setGebJahr(new Date(1220227200L * 1000))
				.setHausnummer("22")
				.setkuerzel("sp")
				.setName("Alster")
				.setPasswort("12345")
				.setStatus("Blokckiert")
				.setStraße("Federathweg")
				.setVorname("Erni");
		
		Student student = new Student(benutzer, StudentenBuilder.neuerStudent().setFaecherListe(faecher)
				.setKlassenID(1)
				.setMatrikelnummer("ASFNIAJGPSASGNÖ787FA")
				.setNotenListe(noten));

		// when
		boolean expected = student.equals(student);

		// then
		assertThat(expected, is(true));
	}

	@Test
	public void vergleichMitGleichemObjektSollteTrueLiefern() throws Exception {

		// given
		List<Fach> faecher = new ArrayList<Fach>();
		Fach fach = new Fach(FachBuilder.neuesFach().setDozentenID(1)
				.setFachID(1)
				.setKlassenID(1)
				.setName("Mathe"));
		
		faecher.add(fach);
		
		List<Note> noten = new ArrayList<Note>();
		Note note = new Note(NotenBuilder.neueNote().setArt("String")
				.setFachID(1)
				.setNote(3)
				.setNotenID(2)
				.setSemester(4)
				.setStudentenID(1));
		
		noten.add(note);
		
		
		BenutzerBuilder benutzer = new BenutzerBuilder().setAnrede("Herr")
				.setBenutzerID(1)
				.setGebJahr(new Date(1220227200L * 1000))
				.setHausnummer("22")
				.setkuerzel("sp")
				.setName("Alster")
				.setPasswort("12345")
				.setStatus("Blokckiert")
				.setStraße("Federathweg")
				.setVorname("Erni");
		
		Student student1 = new Student(benutzer, StudentenBuilder.neuerStudent().setFaecherListe(faecher)
				.setKlassenID(1)
				.setMatrikelnummer("ASFNIAJGPSASGNÖ787FA")
				.setNotenListe(noten));
		
		Student student2 = new Student(benutzer, StudentenBuilder.neuerStudent().setFaecherListe(faecher)
				.setKlassenID(1)
				.setMatrikelnummer("ASFNIAJGPSASGNÖ787FA")
				.setNotenListe(noten));
		

		// when

		// then
		assertThat(student1.equals(student2), is(true));
	}

	@Test
	public void vergleichMitUngleichemObjektSollteFalseLiefern() throws Exception {

		// given
		List<Fach> faecher = new ArrayList<Fach>();
		Fach fach = new Fach(FachBuilder.neuesFach().setDozentenID(1)
				.setFachID(1)
				.setKlassenID(1)
				.setName("Mathe"));
		
		faecher.add(fach);
		
		List<Note> noten = new ArrayList<Note>();
		Note note = new Note(NotenBuilder.neueNote().setArt("String")
				.setFachID(1)
				.setNote(3)
				.setNotenID(2)
				.setSemester(4)
				.setStudentenID(1));
		
		noten.add(note);
		
		
		BenutzerBuilder benutzer = new BenutzerBuilder().setAnrede("Herr")
				.setBenutzerID(1)
				.setGebJahr(new Date(1220227200L * 1000))
				.setHausnummer("22")
				.setkuerzel("sp")
				.setName("Alster")
				.setPasswort("12345")
				.setStatus("Blokckiert")
				.setStraße("Federathweg")
				.setVorname("Erni");
		
		Student student1 = new Student(benutzer, StudentenBuilder.neuerStudent().setFaecherListe(faecher)
				.setKlassenID(1)
				.setMatrikelnummer("ASFNIAJGPSASGNÖ787FA")
				.setNotenListe(noten));
		
		BenutzerBuilder benutzer2 = new BenutzerBuilder().setAnrede("Herr")
				.setBenutzerID(1)
				.setGebJahr(new Date(1220227200L * 1000))
				.setHausnummer("22")
				.setkuerzel("rt")
				.setName("Heras")
				.setPasswort("12315125")
				.setStatus("Blokckiert")
				.setStraße("Ludwief")
				.setVorname("Rocko");
		
		Student student2 = new Student(benutzer, StudentenBuilder.neuerStudent().setFaecherListe(faecher)
				.setKlassenID(2)
				.setMatrikelnummer("JBKAGßß08ßAGAG")
				.setNotenListe(noten));

		// when

		// then
		assertThat(student1.equals(student2), is(false));
	}

	// symmetric
	@Ignore
	@Test
	public void equalsImplementierungSollteSymetrischSein() throws Exception {

		// given
		//Student student1 = new Student("4711", "Mustermann", "Max", LocalDate.of(1985, 10, 10));
		//Student student2 = new Student("4711", "Mustermann", "Max", LocalDate.of(1985, 10, 10));

		// when

		// then
		//assertThat(student1.equals(student2), is(true));
		//assertThat(student2.equals(student1), is(true));
	}

	// transitive
	@Ignore
	@Test
	public void equalsImplementierungSollteTransitivSein() throws Exception {

		// given
		//Student student1 = new Student("4711", "Mustermann", "Max", LocalDate.of(1985, 10, 10));
		//Student student2 = new Student("4711", "Mustermann", "Max", LocalDate.of(1985, 10, 10));
		//Student student3 = new Student("4711", "Mustermann", "Max", LocalDate.of(1985, 10, 10));

		// when

		// then
		//assertThat(student1.equals(student2), is(true));
		//assertThat(student3.equals(student2), is(true));
		//assertThat(student3.equals(student1), is(true));

	}

	// consistent
	@Ignore
	@Test
	public void equalsImplementierungSollteKonsistentSein() throws Exception {

		// given
		//Student student1 = new Student("4711", "Mustermann", "Max", LocalDate.of(1985, 10, 10));

		// when

		// then
		for (int i = 0; i < 50_000; i++) {
		//	assertThat(student1.equals(student1), is(true));
		}
	}
}
