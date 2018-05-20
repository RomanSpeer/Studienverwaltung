package server;

import java.util.List;

import klassen.Benutzer;

public class HtmlElements {

	public static String getNavBarCSS() {
		return 	/* Navbar container */
				".navbar {" 
				+ "	overflow: hidden;" 
				+ "	background-color: #333;" 
				+ "	font-family: Arial;"
				+ "}"
				/* Links inside the navbar */
				+ ".navbar a {"
				+ "	float: left;"
				+ "	font-size: 16px;"
				+ "	color: white;"
				+ "	text-align: center;"
				+ "	padding: 14px 16px;"
				+ "	text-decoration: none;"
				+ "}"
				/* The dropdown container */
				+ ".dropdown {"
				+ "	float: left;"
				+ "	overflow: hidden;"
				+ "}"
				/* Dropdown button */
				+ ".dropdown .dropbtn {"
				+ "	font-size: 16px;"
				+ "	border: none;"
				+ "	outline: none;"
				+ "	color: white;"
				+ "	padding: 14px 16px;"
				+ "	background-color: inherit;"
				+ "	font-family: inherit;"
				+ "	margin: 0;"
				+ "}"
				/* Add a red background color to navbar links on hover */
				+ ".navbar a:hover, .dropdown:hover .dropbtn {"
				+ "	background-color: red;"
				+ "}"
				/* Dropdown content (hidden by default) */
				+ ".dropdown-content {"
				+ "	display: none;"
				+ "	position: absolute;"
				+ "	background-color: #f9f9f9;"
				+ "	min-width: 160px;"
				+ "	box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2)"
				+ "	z-index: 1;"
				+ "}"
				/* Links inside the dropdown */
				+ ".dropdown-content a {"
				+ "	float: none;"
				+ "	color: black;"
				+ "	padding: 12px 16px;"
				+ "	text-decoration: none;"
				+ "	display: block;"
				+ " text-align: left;"
				+ "}"
				/* Add a grey background color to dropdown links on hover */
				+ ".dropdown-content a:hover {"
				+ "	background-color: #ddd;"
				+ "}"
				/* Show the dropdown menu on hover */
				+ ".dropdown:hover .dropdown-content {"
				+ "	display: block;"
				+ "}";
	}

	public static String getNavBar() {
		return "<div class=\"navbar\">"
				+ "	<a class=\"active\" href=\"#home\">Startseite</a>"
				+ "	<a href=\"http://localhost:8080/studentenUebersicht\">Studentenübersicht</a>"
				+ "	<div class=\"dropdown\">"
				+ "		<button class=\"dropbtn\">Studentenverwaltung"
				+ "			<i class=\"fa fa-caret-down\"></i>"
				+ " 	</button>"
				+ "		<div class=\"dropdown-content\">"
				+ "			<a href=\"http://localhost:8080/studentErfassen\">Student erfassen</a>"
				+ "			<a href=\"http://localhost:8080/studentAendern\">Student ändern</a>"
				+ "			<a href=\"http://localhost:8080/studentLoeschen\">Student löschen</a>"
				+ "		</div>"
				+ "	</div>"
				+ "	<a href=\"#about\">Einstellungen</a>"
				+ "	<a href=\"#news\">Abmelden</a>"
				+ "</div>";
	}
	
	public static String getLogin(boolean loginStatus) {
		String fehlerMeldung = "";
		
		if(loginStatus==false)
			fehlerMeldung = "<lable>Benutzername oder Passwort ist falsch</label><br/><br/>";
			
		return "<form method=\"post\">"
				+ "<label>Benutzername: </label>"
				+ "<input type=\"text\" name=\"user\" length=\"100\""
				+ "<br/><br/><br/>"
				+ "<label>Passwort: </label>"
				+ "<input type=\"password\" name=\"password\" length=\"100\""
				+ "<br/><br/><br/>"
				+ fehlerMeldung
				+ "<input type=\"submit\" value=\"Anmelden\">"
				+ "</form>";
	}	
	
	public static String getUserTable(List<Object> givenUserList) {
		
		//if(!givenUserList.isEmpty()) {
		if(givenUserList==null) {
			String tableHead ="<div class=”tbl-content”>"  
					+"<table id=\"userTable\">"
					+ "<thead>"
					+ "	<th>Vorname</th>"
					+ "	<th>Name</th>"
				    + "	<th>Kuerzel</th>"
				    + "	<th>Email</th>"
				    +""
				    + "<\thead>";
			
			String tableBody = "<tbody>";

//			for(Object tmpObject : givenUserList)
//			{
//				Benutzer tmpBenuter = (Benutzer) tmpObject;
//				tableBody +="<tr>"
//							+"	<td>"+tmpBenuter.getVorname()+"</td>" 
//							+"	<td>"+tmpBenuter.getName()+"</td>"
//							+"	<td>"+tmpBenuter.getKuerzel()+"</td>"
//							+"	<td>"+tmpBenuter.getPasswort()+"</td>"
//							+""
//							+"<\tr>";
//			}
			
			for(int i = 0; i< 100;i++)
			{
		
				tableBody +="<tr>"
							+"	<td>test</td>" 
							+"	<td>test</td>"
							+"	<td>test</td>"
							+"	<td>test</td>"
							+""
							+"</tr>";
			}
			
			tableBody += "</tbody>";
			
			String tableEnd= "</table></div>";
			
			return tableHead+tableBody+tableEnd;
		}	
		
		return "Keine Benutzer vorhanden";
	}

	public static String getUserTableCSS() {
		return "table{"  
				+"	width:100%;"
				+" 	cellpadding=”0″;"
				+"	cellspacing=”0″;"
				+"	border=”0″;"
				+"}" 
				+"th{"  
				+"	padding: 15px;"  
				+"	text-align: left;"  
				+"	vertical-align:middle;"  
				+"	font-weight: 1000;"  
				+"	border-bottom: solid 2px rgba(0,0,0,0.5);"  
				+"	text-transform: uppercase;"  
				+"}"
				+"td{"  
				+"	padding: 15px;"  
				+"	text-align: left;"  
				+"	vertical-align:middle;"  
				+"	font-weight: 300;"  
				+"	border-bottom: solid 1px rgba(0,0,0,0.2);"  
				+"	text-transform: uppercase;"  
				+"}"
				+".tbl-content{"    
				+"	height:auto;"  
				+"	overflow-x:auto;"  
				+"	margin-top: 0px;"  
				+"	border: 1px solid rgba(255,255,255,0.9);"  
				+"	background-color: white;"  
				+"	border-radius: 5px;"
				+"	box-shadow: 0px 1px 5px 4px;"
				+"	rgba(0,0,0,0.2);"  
				+"}"
				+".tableHr{"
				+"	padding: 0px;"
				+"}";
		
	}
}
