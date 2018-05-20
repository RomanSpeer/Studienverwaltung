package test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;

import klassen.Benutzer;
import klassen.BenutzerBuilder;

public class BenutzerTest {

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
		Benutzer benutzer = new Benutzer(BenutzerBuilder.neuerBenutzer().setAnrede("Herr")
				.setBenutzerID(1)
				.setGebJahr(new Date(1220227200L * 1000))
				.setHausnummer(22)
				.setkuerzel("sp")
				.setName("Alster")
				.setPasswort("12345")
				.setStatus("Blokckiert")
				.setStraße("Federathweg")
				.setVorname("Erni"));

		// when (wenn)
		boolean expected = benutzer.equals(null);

		// then (dann)
		assertThat(expected, is(false));
	}

	// reflexive
	@Test
	public void vergleichMitSichSelbstSollteTrueLiefern() throws Exception {

		// given
		Benutzer benutzer = new Benutzer(BenutzerBuilder.neuerBenutzer().setAnrede("Herr")
				.setBenutzerID(1)
				.setGebJahr(new Date(1220227200L * 1000))
				.setHausnummer(22)
				.setkuerzel("sp")
				.setName("Alster")
				.setPasswort("12345")
				.setStatus("Blokckiert")
				.setStraße("Federathweg")
				.setVorname("Erni"));

		// when
		boolean expected = benutzer.equals(benutzer);

		// then
		assertThat(expected, is(true));
	}

	@Test
	public void vergleichMitGleichemObjektSollteTrueLiefern() throws Exception {

		// given
		Benutzer benutzer1 = new Benutzer(BenutzerBuilder.neuerBenutzer().setAnrede("Herr")
				.setBenutzerID(1)
				.setGebJahr(new Date(1220227200L * 1000))
				.setHausnummer(22)
				.setkuerzel("sp")
				.setName("Alster")
				.setPasswort("12345")
				.setStatus("Blokckiert")
				.setStraße("Federathweg")
				.setVorname("Erni"));
		
		Benutzer benutzer2 = new Benutzer(BenutzerBuilder.neuerBenutzer().setAnrede("Herr")
				.setBenutzerID(1)
				.setGebJahr(new Date(1220227200L * 1000))
				.setHausnummer(22)
				.setkuerzel("sp")
				.setName("Alster")
				.setPasswort("12345")
				.setStatus("Blokckiert")
				.setStraße("Federathweg")
				.setVorname("Erni"));

		// when

		// then
		assertThat(benutzer1.equals(benutzer2), is(true));
	}

	@Test
	public void vergleichMitUngleichemObjektSollteFalseLiefern() throws Exception {

		// given
		Benutzer benutzer1 = new Benutzer(BenutzerBuilder.neuerBenutzer().setAnrede("Herr")
				.setBenutzerID(1)
				.setGebJahr(new Date(1220227200L * 1000))
				.setHausnummer(22)
				.setkuerzel("sp")
				.setName("Alster")
				.setPasswort("12345")
				.setStatus("Blokckiert")
				.setStraße("Federathweg")
				.setVorname("Erni"));
		
		Benutzer benutzer2 = new Benutzer(BenutzerBuilder.neuerBenutzer().setAnrede("Frau")
				.setBenutzerID(4)
				.setGebJahr(new Date(1320227200L * 1000))
				.setHausnummer(22)
				.setkuerzel("ho")
				.setName("Genau")
				.setPasswort("1234567")
				.setStatus("Nicht Blockiert")
				.setStraße("Ludwigweg")
				.setVorname("Anna"));
	

		// when

		// then
		assertThat(benutzer1.equals(benutzer2), is(false));
	}

	@Ignore
	// symmetric
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
