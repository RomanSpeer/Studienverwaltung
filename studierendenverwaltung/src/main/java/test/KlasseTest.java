package test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import java.time.LocalDate;

import org.junit.Ignore;
import org.junit.Test;

import klassen.Klasse;
import klassen.KlassenBuilder;

public class KlasseTest {

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
		Klasse klasse = new Klasse(KlassenBuilder.neueKlasse()
				.setKlassenID(1)
				.setKuerzel("pbs2h15a")
				.setKurssprecher(3)
				.setStellvKursprecher(2));

		// when (wenn)
		boolean expected = klasse.equals(null);

		// then (dann)
		assertThat(expected, is(false));
	}

	// reflexive
	@Test
	public void vergleichMitSichSelbstSollteTrueLiefern() throws Exception {

		// given
		Klasse klasse = new Klasse(KlassenBuilder.neueKlasse()
				.setKlassenID(1)
				.setKuerzel("pbs2h15a")
				.setKurssprecher(3)
				.setStellvKursprecher(2));

		// when
		boolean expected = klasse.equals(klasse);

		// then
		assertThat(expected, is(true));
	}

	@Test
	public void vergleichMitGleichemObjektSollteTrueLiefern() throws Exception {

		// given
		Klasse klasse1 = new Klasse(KlassenBuilder.neueKlasse()
				.setKlassenID(1)
				.setKuerzel("pbs2h15a")
				.setKurssprecher(3)
				.setStellvKursprecher(2));
		Klasse klasse2 = new Klasse(KlassenBuilder.neueKlasse()
				.setKlassenID(1)
				.setKuerzel("pbs2h15a")
				.setKurssprecher(3)
				.setStellvKursprecher(2));

		// when

		// then
		assertThat(klasse1.equals(klasse2), is(true));
	}

	@Test
	public void vergleichMitUngleichemObjektSollteFalseLiefern() throws Exception {

		// given
		Klasse klasse1 = new Klasse(KlassenBuilder.neueKlasse()
				.setKlassenID(1)
				.setKuerzel("pbs2h15a")
				.setKurssprecher(3)
				.setStellvKursprecher(2));
		Klasse klasse2 = new Klasse(KlassenBuilder.neueKlasse()
				.setKlassenID(4)
				.setKuerzel("pbs2h16a")
				.setKurssprecher(4)
				.setStellvKursprecher(6));

		// when

		// then
		assertThat(klasse1.equals(klasse2), is(false));
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
