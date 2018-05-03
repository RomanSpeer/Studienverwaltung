package application;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

import server.servlet.MainPageServlet;

public class main {

	private static final Logger LOGGER = LogManager.getLogger(main.class);
	
	public static void main(String[] args)  throws Exception {
		
		Server server = new Server(8080);

		ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
		handler.addServlet(MainPageServlet.class, "/mainPage");
		
		server.setHandler(handler);

		server.start();
		LOGGER.info("Server gestartet!");

	}

}
