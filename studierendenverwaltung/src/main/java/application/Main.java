package application;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

import server.EinstellungenServlet;
import server.FachErfassenServlet;
import server.LoginServlet;
import server.MainPageServlet;
import server.StudentAendernServlet;
import server.StudentErfassenServlet;
import server.FachServlet;
import server.KlasseErfassenServlet;
import server.KlassenServlet;
import server.StudentenuebersichtServlet;

public class Main {

	private static final Logger LOGGER = LogManager.getLogger(Main.class);

	public static void main(String[] args) throws Exception {
		Server server = new Server(8080);

		ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
		handler.addServlet(MainPageServlet.class, "/mainPage");
		handler.addServlet(StudentenuebersichtServlet.class, "/studentenUebersicht");
		handler.addServlet(StudentErfassenServlet.class, "/studentErfassen");
		handler.addServlet(StudentAendernServlet.class, "/studentAendern");
		handler.addServlet(FachServlet.class, "/faecher");
		handler.addServlet(KlassenServlet.class, "/klassen");
		handler.addServlet(FachErfassenServlet.class, "/fachErfassen");
		handler.addServlet(KlasseErfassenServlet.class, "/klasseErfassen");
		handler.addServlet(EinstellungenServlet.class, "/einstellungen");
		handler.addServlet(LoginServlet.class, "/login");


		server.setHandler(handler);

		server.start();
		LOGGER.info("Server gestartet!");
	}

}
