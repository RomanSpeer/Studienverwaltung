package server;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import application.Repository;
import klassen.Fach;
import klassen.Note;
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
		Repository repository = new Repository().getDbCon();
		Connection connection = null;
		try {
			 connection = repository.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
//		Student std2 = new Student("Herr","Roman","Speer", new Date(1241251251l),"Ludwigweg","18",33184,"Altenbeken","abc123","Genehmigt","pbs2h15asp","romanspeer@web.de","123abaswgwe",3, notenListe, faecherListe);
		List<Student> studentList = null;
		try {
			studentList = repository.holeAlleStudenten(connection);
			System.out.println("IM TRY");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		StringBuilder sb = baueHtmlSeite(studentList);
		resp.getWriter().write(sb.toString());
	}
	
	private StringBuilder baueHtmlSeite(List <Student> givenStudentList) {
				
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
		sb.append(HtmlElements.getStudentTable(givenStudentList,false));
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