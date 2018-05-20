package test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import java.time.LocalDate;

import org.junit.Ignore;
import org.junit.Test;

import klassen.Note;
import klassen.NotenBuilder;

public class NoteTest {

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
		Note note = new Note(NotenBuilder.neueNote()
				.setArt("OK")
				.setFachID(1)
				.setNote(3)
				.setNotenID(1)
				.setSemester(4)
				.setStudentenID(8));

		// when (wenn)
		boolean expected = note.equals(null);

		// then (dann)
		assertThat(expected, is(false));
	}

	// reflexive
	@Test
	public void vergleichMitSichSelbstSollteTrueLiefern() throws Exception {

		// given
		Note note = new Note(NotenBuilder.neueNote()
				.setArt("OK")
				.setFachID(1)
				.setNote(3)
				.setNotenID(1)
				.setSemester(4)
				.setStudentenID(8));

		// when
		boolean expected = note.equals(note);

		// then
		assertThat(expected, is(true));
	}

	@Test
	public void vergleichMitGleichemObjektSollteTrueLiefern() throws Exception {

		// given
		Note note1 = new Note(NotenBuilder.neueNote()
				.setArt("OK")
				.setFachID(1)
				.setNote(3)
				.setNotenID(1)
				.setSemester(4)
				.setStudentenID(8));
		
		Note note2 = new Note(NotenBuilder.neueNote()
				.setArt("OK")
				.setFachID(1)
				.setNote(3)
				.setNotenID(1)
				.setSemester(4)
				.setStudentenID(8));

		// when

		// then
		assertThat(note1.equals(note2), is(true));
	}

	@Test
	public void vergleichMitUngleichemObjektSollteFalseLiefern() throws Exception {

		// given
		Note note1 = new Note(NotenBuilder.neueNote()
				.setArt("OK")
				.setFachID(1)
				.setNote(3)
				.setNotenID(1)
				.setSemester(4)
				.setStudentenID(8));
		
		Note note2 = new Note(NotenBuilder.neueNote()
				.setArt("NOT")
				.setFachID(4)
				.setNote(6)
				.setNotenID(2)
				.setSemester(3)
				.setStudentenID(7));
		// when

		// then
		assertThat(note1.equals(note2), is(false));
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
