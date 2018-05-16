package server;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;

public class MainPageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String name = req.getParameter("user");
//		anzahl++;
		StringBuilder sb = baueHtmlSeite();
		resp.getWriter().write(sb.toString());
	}
	
	private StringBuilder baueHtmlSeite() {
		StringBuilder sb = new StringBuilder();
		sb.append("<!DOCTYPE html>");
		sb.append("<html>");
		sb.append("  <head>");
			sb.append("  <style>");
			/* Navbar container */
			sb.append(".navbar {");
		    sb.append(" overflow: hidden;");
			sb.append("background-color: #333;");
			sb.append("	  font-family: Arial;");
			sb.append("	}");

			/* Links inside the navbar */
			sb.append("	.navbar a {");
			sb.append("  float: left;");
		    sb.append(" font-size: 16px;");
			sb.append("  color: white;");
			sb.append("  text-align: center;");
			sb.append("  padding: 14px 16px;");
			sb.append("  text-decoration: none;");
			sb.append("}");

			/* The dropdown container */
			sb.append(".dropdown {");
			sb.append("  float: left;");
			sb.append("  overflow: hidden;");
			sb.append("}");

			/* Dropdown button */
			sb.append(".dropdown .dropbtn {");
			sb.append("  font-size: 16px; ");
			sb.append("  border: none;");
			sb.append("  outline: none;");
			sb.append(" color: white;");
		    sb.append(" padding: 14px 16px;");
			sb.append(" background-color: inherit;");
			sb.append(" font-family: inherit;");
			sb.append("  margin: 0; ");
			sb.append("}");

			/* Add a red background color to navbar links on hover */
			sb.append(".navbar a:hover, .dropdown:hover .dropbtn {");
			sb.append("  background-color: red;");
			sb.append("}");

			/* Dropdown content (hidden by default) */
			sb.append(".dropdown-content {");
			sb.append(" display: none;");
			sb.append(" position: absolute;");
			sb.append("background-color: #f9f9f9;");
		    sb.append(" min-width: 160px;");
			sb.append(" box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2)");
			sb.append(" z-index: 1;");
			sb.append("}");

			/* Links inside the dropdown */
			sb.append(".dropdown-content a {");
			sb.append("  float: none;");
			sb.append("  color: black;");
			sb.append("  padding: 12px 16px;");
			sb.append("  text-decoration: none;");
			sb.append("  display: block;");
			sb.append("  text-align: left;");
			sb.append("	}");

			/* Add a grey background color to dropdown links on hover */
			sb.append(".dropdown-content a:hover {");
			sb.append("background-color: #ddd;");
			sb.append("}");

			/* Show the dropdown menu on hover */
			sb.append(".dropdown:hover .dropdown-content {");
			sb.append("  display: block;");
			sb.append("}");
			
			sb.append("  </style>");
		sb.append("  </head>");
		sb.append("  <body>");
		
		sb.append("<div class=\"navbar\">\\");
			sb.append("<a class=\"active\" href=\"#home\">Startseite</a>");
			sb.append("<a href=\"#news\">Notenübersicht</a>");
			sb.append("<div class=\"dropdown\">");
			sb.append("<button class=\"dropbtn\">Klasse ");
			sb.append("<i class=\"fa fa-caret-down\"></i>");
			sb.append(" </button>");
			sb.append("<div class=\"dropdown-content\">");
			sb.append("<a href=\"#\">Fächer</a>");
			sb.append(" <a href=\"#\">Studierende</a>");
			sb.append(" </div>");
			sb.append(" </div> ");
			
		    sb.append("<a href=\"#about\">Einstellungen</a>");
		    sb.append("<a href=\"#news\">Abmelden</a>");
			sb.append("</div>");
		
//			sb.append("    <form method=\"post\">");
//			sb.append("      <label>Benutzername: </label>");
//			sb.append("      <input type=\"text\" name=\"user\" length=\"100\" >");
//			sb.append("      <br/>");
//			sb.append("      <br/>");
//			sb.append("      <input type=\"submit\" value=\"Anmelden\">");
//			sb.append("    </form>");
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
	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		resp.getWriter().write("<html><body>Willkommen in der Studentenverwaltung!</body></html>");
//	}

}