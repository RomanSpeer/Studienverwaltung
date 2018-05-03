package server.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainPageServlet extends HttpServlet {

	// Dieses Servlet dient als ein erstes Beispiel

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().write("<html><body>Willkommen in der Studierendenverwaltung!</body></html>");
	}

}