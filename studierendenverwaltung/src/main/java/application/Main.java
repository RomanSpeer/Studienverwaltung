package application;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

import klassen.Fach;
import klassen.Note;
import klassen.Student;
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
		
		Repository repository = new Repository().getDbCon();
		Connection connection = repository.getConnection();

		//repository.deleteTable(connection, "addresse");
		//repository.deleteAllTables(connection);
		
		
		if (!repository.existiertTabelleBereits(connection)) {
			repository.erstelleTabelle(connection);
		}
		
//		Fach fach = new Fach(1, "Mathe", 2, 3);
//		List<Fach> faecherListe = new ArrayList<Fach>();
//		faecherListe.add(fach);
//		
//		Note note = new Note(4, 1, 3, 1, 5, "Cool");
//		List<Note> notenListe = new ArrayList<Note>();
//		notenListe.add(note);
//		
//		
//		Student std1 = new Student("Herr","Roman","Speer", new Date(1241251251l),"Ludwigweg","18",33184,"Altenbeken","abc123","Genehmigt","pbs2h15asp","romanspeer@web.de","123abaswgwe",3, notenListe, faecherListe);
//
//		repository.speichereStudenten(std1, connection);
		
//		List <Student> liste = repository.holeAlleStudenten(connection);
//		
//		for(int i = 0; i<liste.size();i++)
//		{
//			System.out.println(liste.get(i).getBenutzerID());
//		}
		
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
