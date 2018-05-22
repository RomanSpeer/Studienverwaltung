package server;

import java.awt.List;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

public class StudentAendernServlet extends HttpServlet {

	// Dieses Servlet dient als ein erstes Beispiel

	private static final long serialVersionUID = 1L;
	private int anzahl = 0;
	

//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		resp.getWriter().write("<html><body>Hello <b>World</b></body></html>");
//	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("user");
		anzahl++;
		StringBuilder sb = baueHtmlSeite(name);
		resp.getWriter().write(sb.toString());
	}
	
	private StringBuilder baueHtmlSeite(String name) {
		StringBuilder sb = new StringBuilder();
		sb.append("<!DOCTYPE html>");
		sb.append("<html>");
		sb.append("  <body>");
		
			sb.append("    <form method=\"post\">");
			sb.append("      <label>Benutzername: </label>");
			sb.append("      <input type=\"text\" name=\"user\" length=\"100\" >");
			sb.append("      <br/>");
			sb.append("      <br/>");
			sb.append("      <input type=\"submit\" value=\"Anmelden\">");
			sb.append("    </form>");
			if (StringUtils.isNotEmpty(name)) {
				sb.append("    <p> Hallo ");
				sb.append(name);
				sb.append("!    </p>");
			}
			if(anzahl !=0 )
				sb.append("<p> count: " + anzahl+"</p>");
		sb.append("  </body>");
		sb.append("</html>");
		return sb;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		SimpleDateFormat date=new SimpleDateFormat("HH:mm:ss");
//		String date1=date.format(new Date());
//		
//		Date date2 = java.util.Calendar.getInstance().getTime();
//		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd.MM.yyyy");
//		String dateString = dateFormatter.format(date2);
		
		//resp.getWriter().write("<html><body> Es ist <b>"+date1+"</b> am "+ dateString+" </body></html>");

		doPost(req, resp);
	}

}