package application;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

import server.EinstellungenServlet;
import server.MainPageServlet;
import server.StudentAendernServlet;
import server.StudentErfassenServlet;
import server.StudentLoeschenServlet;
import server.StudentenuebersichtServlet;

public class Main {

	// @formatter:off
	/*
	 * Übungsaufgabe 1 (Skipt Folie 174) Schreiben Sie ein weiteres Servlet, welches
	 * das aktuelle Datum sowie die Uhrzeit formatiert ausgibt.
	 * 
	 * Übungsaufgabe 2 (Skript Folie 176) Schreiben Sie noch ein weiteres Servlet,
	 * welches über ein HTML-Formular einen Namen annimmt und um eine Begrüßung
	 * erweitert ausgibt.
	 * 
	 * Übungsaufgabe 3 (Skript Folie 177) Schreiben Sie ein drittes Servlet, dass es
	 * erlaubt, über ein Formular Studenten zu immatrikulieren. Erstellen Sie ein
	 * viertes Servlet, dass eine Liste mit allen bisher immatrikulierten Studenten
	 * ausgibt.
	 * 
	 * (Für die Speicherung kann z.B. das StudentenServlet aus vorherigen Übungen
	 * genutzt werden.)
	 */
	// @formatter:on

	private static final Logger LOGGER = LogManager.getLogger(Main.class);

	public static void main(String[] args) throws Exception {
		Server server = new Server(8080);

		ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
		handler.addServlet(MainPageServlet.class, "/mainPage");
		handler.addServlet(StudentenuebersichtServlet.class, "/studentenUebersicht");
		handler.addServlet(StudentErfassenServlet.class, "/studentErfassen");
		handler.addServlet(StudentAendernServlet.class, "/studentAendern");
		handler.addServlet(StudentLoeschenServlet.class, "/studentLoeschen");
		handler.addServlet(EinstellungenServlet.class, "/einstellungen");


		server.setHandler(handler);

		server.start();
		LOGGER.info("Server gestartet!");
	}

}
