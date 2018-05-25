package server;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import klassen.Student;

public class StudentenuebersichtServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	String anrede = "";
	String vorname = "";
	String nachname = "";
	String gebDate = "";
	String strasse = "";
	String hausnummer = "";
	String ort = "";
	String plz = "";
	String passwort ="";
	String status = "";
	String kuerzel = "";
	String email = "";
	
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String name = req.getParameter("user");
//		anzahl++;	
		anrede = req.getParameter("gender");
		vorname = req.getParameter("vorname");
		nachname = req.getParameter("nachname");
		nachname = req.getParameter("nachname");
		gebDate = req.getParameter("Datum");
		strasse = req.getParameter("strasse");
		hausnummer = req.getParameter("hnr");
		plz = req.getParameter("plz");
		ort = req.getParameter("ort");
		passwort = req.getParameter("psw");
		status = req.getParameter("block");
		kuerzel = req.getParameter("kuerzel");
		email = req.getParameter("Email");
		
		//repository.getUsers
		
		StringBuilder sb = baueHtmlSeite();
		resp.getWriter().write(sb.toString());
	}
	
	private StringBuilder baueHtmlSeite(/*List <Student> givenStudentList*/) {
				
		StringBuilder sb = new StringBuilder();
		sb.append("<!DOCTYPE html>");
		sb.append("<html>");
		sb.append("  <head>");
			sb.append("  <style>");			
			sb.append(HtmlElements.getNavBarCSS());
			sb.append(HtmlElements.getUserTableCSS());
			sb.append("  </style>");
		sb.append("  </head>");
		sb.append("  <body>");
		
		sb.append(HtmlElements.getNavBar());
		sb.append(HtmlElements.getStudentTable(null,false));
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