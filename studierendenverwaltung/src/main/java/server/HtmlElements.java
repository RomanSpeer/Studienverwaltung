package server;

import java.util.List;

import klassen.Benutzer;
import klassen.Student;

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
				+ "		<button class=\"dropbtn\">Verwaltung"
				+ "			<i class=\"fa fa-caret-down\"></i>"
				+ " 	</button>"
				+ "		<div class=\"dropdown-content\">"
				+ "			<a href=\"http://localhost:8080/studentErfassen\">Student erfassen</a>"
				+ "			<a href=\"http://localhost:8080/studentAendern\">Student ändern/löschen</a>"
				+ "			<a href=\"http://localhost:8080/studentAendern\">Note vergeben</a>"
				+ "			<a href=\"http://localhost:8080/klassen\">Klassen Liste</a>"
				+ "			<a href=\"http://localhost:8080/faecher\">Fächer Liste</a>"
				+ "			<a href=\"http://localhost:8080/klasseErfassen\">Klasse erfassen</a>"
				+ "			<a href=\"http://localhost:8080/fachErfassen\">Fach erfassen</a>"
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
				+ "	<label>Benutzername: </label>"
				+ "	<input type=\"text\" name=\"user\" length=\"100\""
				+ "	<br/><br/><br/>"
				+ "	<label>Passwort: </label>"
				+ "	<input type=\"password\" name=\"password\" length=\"100\""
				+ "	<br/><br/><br/>"
				+ fehlerMeldung
				+ "	<input type=\"submit\" value=\"Anmelden\">"
				+ "</form>";
	}	
	
	public static String getUserTable(List<Object> givenUserList, boolean change) {
		
		//if(!givenUserList.isEmpty()) {
		if(givenUserList==null) {
			String tableHead ="<div class=”tbl-content”>"  
					+"<table id=\"userTable\">"
					+ "<thead>"
					+ "	<th>Vorname</th>"
					+ "	<th>Name</th>"
				    + "	<th>Kuerzel</th>"
				    + "	<th>Email</th>";
			
			if(change==true)
				tableHead+= "<th></th>";
			
			tableHead+= "<\thead>";
			
			String tableBody = "<tbody>";

//			for(Object tmpObject : givenUserList)
//			{
//				Benutzer tmpBenuter = (Benutzer) tmpObject;
//				tableBody +="<tr>"
//							+"	<td>"+tmpBenuter.getVorname()+"</td>" 
//							+"	<td>"+tmpBenuter.getName()+"</td>"
//							+"	<td>"+tmpBenuter.getKuerzel()+"</td>"
//							+"	<td>"+tmpBenuter.getPasswort()+"</td>"
//							+if(change==true)
//			tableBody+="  <td class=\"last\"><Button>bearbeitn</Button>&emsp;<Button onclick=\"myFunction("+i+")\">löschen</Button></td>";
//			
//			tableBody+="</tr>";
//			}
			
			for(int i = 0; i< 100;i++)
			{
		
				tableBody +="<tr>"
							+"	<td>test</td>" 
							+"	<td>test</td>"
							+"	<td>test</td>"
							+"	<td>test</td>";
				
				if(change==true)
					tableBody+="  <td class=\"last\">"
								+ "	<Button onclick=\"document.getElementById('id01').style.display='block'\" style=\"width:auto;\" class=\"changebtn\">bearbeitn</Button>"
								+ "	&emsp;"
								+ "	<Button class=\"deletebtn\">löschen</Button><br>"
								+ " <Button class=\"changebtn\">Fächer</Button>"
								+ "	&emsp;"
								+ "	<Button class=\"changebtn\">Noten</Button>"
								+ "</td>";
							
							tableBody+="</tr>";
			}
			
			tableBody += "</tbody>";
			
			String tableEnd= "</table></div>";
						
			String changeString ="";
			if(change==true)
				changeString = getChangeUser();
			
			return tableHead+tableBody+tableEnd+getChangeUser();
		}	
		
		return "Keine Benutzer vorhanden";
	}
	
public static String getStudentTable(List<Student> givenStudentList, boolean change) {
		
		//if(!givenUserList.isEmpty()) {
		if(givenStudentList!=null) {
			String tableHead ="<div class=”tbl-content”>"  
					+"<table id=\"userTable\">"
					+ "<thead>"
					+ "	<th>Vorname</th>"
					+ "	<th>Name</th>"
				    + "	<th>Kuerzel</th>"
				    + "	<th>Email</th>";
			
			if(change==true)
				tableHead+= "<th></th>";
			
			tableHead+= "<\thead>";
			
			String tableBody = "<tbody>";

//			for(Object tmpObject : givenUserList)
//			{
//				Benutzer tmpBenuter = (Benutzer) tmpObject;
//				tableBody +="<tr>"
//							+"	<td>"+tmpBenuter.getVorname()+"</td>" 
//							+"	<td>"+tmpBenuter.getName()+"</td>"
//							+"	<td>"+tmpBenuter.getKuerzel()+"</td>"
//							+"	<td>"+tmpBenuter.getPasswort()+"</td>"
//							+if(change==true)
//			tableBody+="  <td class=\"last\"><Button>bearbeitn</Button>&emsp;<Button onclick=\"myFunction("+i+")\">löschen</Button></td>";
//			
//			tableBody+="</tr>";
//			}
			
			for(int i = 0; i< 100;i++)
			{
		
				tableBody +="<tr>"
							+"	<td>test</td>" 
							+"	<td>test</td>"
							+"	<td>test</td>"
							+"	<td>test</td>";
				
				if(change==true)
					tableBody+="  <td class=\"last\">"
								+ "	<Button onclick=\"document.getElementById('id01').style.display='block'\" style=\"width:auto;\" class=\"changebtn\">bearbeitn</Button>"
								+ "	&emsp;"
								+ "	<Button class=\"deletebtn\">löschen</Button><br>"
								+ " <Button class=\"changebtn\">Fächer</Button>"
								+ "	&emsp;"
								+ "	<Button class=\"changebtn\">Noten</Button>"
								+ "</td>";
							
							tableBody+="</tr>";
			}
			
			tableBody += "</tbody>";
			
			String tableEnd= "</table></div>";
						
			String changeString ="";
			if(change==true)
				changeString = getChangeUser();
			
			return tableHead+tableBody+tableEnd+getChangeUser();
		}	
		
		return "Keine Benutzer vorhanden";
	}

	public static String getUserTableCSS() {
		return "body {font-family: Arial, Helvetica, sans-serif;}" + 
				"form {border: 3px solid #f1f1f1;}"
				+ "table{"  
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
				+"td.last {" + 
				"    width: 1px;" + 
				"    white-space: nowrap;" + 
				"}"
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
				+"}"
				+".deletebtn {"  
				+"    width: auto;"  
				+"    padding: 10px 18px;"  
				+"    background-color: #f44336;"  
				+"}"
				+".changebtn {"  
				+"    width: auto;"  
				+"    padding: 10px 18px;"  
				+"    background-color: #4CAF50;"  
				+"}";
		
	}
	
	public static String getLoginCSS() {
		return "form {" 
				+ "    border: 3px solid #f1f1f1;" 
				+ "}"
				+ ""
				+ "input[type=text], input[type=password] {"
				+ "    width: 100%;" 
				+ "    padding: 12px 20px;"  
				+ "    margin: 8px 0;" 
				+ "    display: inline-block;" 
				+ "    border: 1px solid #ccc;" 
				+ "    box-sizing: border-box;" 
				+ "}" 
				+ ""
				+ "button {"
				+ "    background-color: #4CAF50;"
				+ "    color: white;" 
				+ "    padding: 14px 20px;" 
				+ "    margin: 8px 0;" 
				+ "    border: none;" 
				+ "    cursor: pointer;" 
				+ "    width: 100%;" 
				+ "}"
				+ ""
				+ "button:hover {" 
				+ "    opacity: 0.8;" 
				+ "}" 
				+ ""
				+ ".cancelbtn {" 
				+ "    width: auto;" 
				+ "    padding: 10px 18px;"
				+ "    background-color: #f44336;"
				+ "}" 
				+ "" 
				+ ".imgcontainer {"
				+ "    text-align: center;"
				+ "    margin: 24px 0 12px 0;"
				+ "}" 
				+ ""
				+ "img.avatar {" 
				+ "    width: 40%;" 
				+ "    border-radius: 50%;"
				+ "}"
				+ ""
				+ ".container {"
				+ "    padding: 16px;" 
				+ "}" 
				+ "" 
				+ "span.psw {"
				+ "    float: right;" 
				+ "    padding-top: 16px;"
				+ "}" 
				+ ""
				+ ".login{"
				+ "width: 30%;"
				+ "margin: auto;"
				+ "}";
	}

	public static String getLogin() {
		return " <form class=\"login\">" + 
				"  <div class=\"imgcontainer\">" + 
				"    <img src=\"../images/head.png\" alt=\"Avatar\" class=\"avatar\">" + 
				"  </div>" + 
				"" + 
				"  <div class=\"container\">" + 
				"    <label for=\"uname\"><b>Username</b></label>" + 
				"    <input type=\"text\" placeholder=\"Enter Username\" name=\"uname\" required>" + 
				"" + 
				"    <label for=\"psw\"><b>Password</b></label>" + 
				"    <input type=\"password\" placeholder=\"Enter Password\" name=\"psw\" required>" + 
				"" + 
				"    <button type=\"submit\">Login</button>" +   
				"  </div>" + 
				"" + 
				"  <div class=\"container\" style=\"background-color:#f1f1f1\">" + 
				"  hier kommt fehlermeldung  " + 
				"  </div>" + 
				"</form> ";
	}

	public static String getChangeUser() {
		return "<div id=\"id01\" class=\"modal\">"  
				+"  "  
				+"  <form class=\"modal-content animate\">"  
				+"    <div class=\"imgcontainer\">"  
				+"      <span onclick=\"document.getElementById('id01').style.display='none'\" class=\"close\" title=\"Close Modal\">&times;</span>"
				+"    </div>"  
				+""  
				+"    <div class=\"container\">"
				+ "		<label for=\"anrede\"><b>Anrede</b></label><br>"
				+ "		<input type=\"radio\" name=\"gender\" value=\"male\" required> Herr"
				+"  	<input type=\"radio\" name=\"gender\" value=\"female\" required> Frau<br><br>"  
				+"      <label for=\"vornmae\"><b>Vorname</b></label>"  
				+"      <input type=\"text\" placeholder=\"Enter Vorname\" name=\"vorname\" required>"  
				+"      <label for=\"name\"><b>Name</b></label>"  
				+"      <input type=\"text\" placeholder=\"Enter Name\" name=\"name\" required>" 
				+"      <label for=\"gebDatum\"><b>Geburtsdatum</b></label><br>"
				+"      <input type=\"date\" name=\"Datum\" value=\"07.12.2012\" required><br><br>"   
				+"      <label for=\"stasse\"><b>Starße</b></label>"  
				+"      <input type=\"text\" placeholder=\"Enter Staße\" name=\"strasse\" required>"  
				+"      <label for=\"hnr\"><b>Hausnummer</b></label>"  
				+"      <input type=\"text\" placeholder=\"Enter hausnummer\" name=\"hnr\" required>"  
				+"      <label for=\"psw\"><b>Passwort</b></label>"  
				+"      <input type=\"password\" placeholder=\"Enter Passwort\" name=\"psw\" required>"  
				+"      <label for=\"status\"><b>Status</b></label><br>"  
				+"		<input type=\"radio\" name=\"block\" value=\"block\" required> blockiert"
				+"  	<input type=\"radio\" name=\"block\" value=\"notblock\" required> nicht blockiert<br><br>"
				+"      <label for=\"kuerzel\"><b>Kürzel</b></label>"  
				+"      <input type=\"text\" placeholder=\"Enter Kürzel\" name=\"kuerzel\" required>"  
				+"      <label for=\"email\"><b>Email</b></label>"  
				+"      <input type=\"text\" placeholder=\"Enter Email\" name=\"Email\" required>"  
				+"        "  
				+"      <button>speichern</button>"   
				+"    </div>"  
				+""  
				+"    <div class=\"container\" style=\"background-color:#f1f1f1\">"  
				+"      <button type=\"button\" onclick=\"document.getElementById('id01').style.display='none'\" class=\"cancelbtn\" >Cancel</button>"  
				+"    </div>"  
				+"  </form>"  
				+"</div>"  
				+""  
				+"<script>"  
				+"// Get the modal"  
				+"var modal = document.getElementById('id01');"  
				+""  
				+"// When the user clicks anywhere outside of the modal, close it"  
				+"window.onclick = function(event) {"  
				+"    if (event.target == modal) {"  
				+"        modal.style.display = \"none\";"  
				+"    }"  
				+"}"  
				+"</script>";
	}

	
	public static String getChangeCSS() {
		return "/* Full-width input fields */"  
				+"input[type=text], input[type=password] {"  
				+"    width: 100%;"  
				+"    padding: 12px 20px;"  
				+"    margin: 8px 0;"  
				+"    display: inline-block;"  
				+"    border: 1px solid #ccc;"  
				+"    box-sizing: border-box;"  
				+"}"  
				+""  
				+"/* Set a style for all buttons */"  
				+"button{"  
				+"    background-color: #4CAF50;"  
				+"    color: white;"  
				+"    padding: 14px 20px;"  
				+"    margin: 8px 0;"  
				+"    border: none;"  
				+"    cursor: pointer;"  
				+"    width: 100%;"  
				+"}"  
				+""  
				+"button.modal:hover {"  
				+"    opacity: 0.8;"  
				+"}"  
				+""  
				+"/* Extra styles for the cancel button */"  
				+".cancelbtn {"  
				+"    width: auto;"  
				+"    padding: 10px 18px;"  
				+"    background-color: #f44336;"  
				+"}"  
				+""  
				+"/* Center the image and position the close button */"  
				+".imgcontainer {"  
				+"    text-align: center;"  
				+"    margin: 24px 0 12px 0;"  
				+"    position: relative;"  
				+"}"   
				+""  
				+".container {"  
				+"    padding: 16px;"  
				+"}"  
				+""  
				+"span.psw {"  
				+"    float: right;"  
				+"    padding-top: 16px;"  
				+"}"  
				+""  
				+"/* The Modal (background) */"  
				+".modal {"  
				+"    display: none; /* Hidden by default */"  
				+"    position: fixed; /* Stay in place */"  
				+"    z-index: 1; /* Sit on top */"  
				+"    left: 0;"  
				+"    top: 0;"  
				+"    width: 100%; /* Full width */"  
				+"    height: 100%; /* Full height */"  
				+"    overflow: auto; /* Enable scroll if needed */"  
				+"    background-color: rgb(0,0,0); /* Fallback color */"  
				+"    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */"  
				+"    padding-top: 60px;"  
				+"}"  
				+""  
				+"/* Modal Content/Box */"  
				+".modal-content {"  
				+"    background-color: #fefefe;"  
				+"    margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */"  
				+"    border: 1px solid #888;"  
				+"    width: 80%; /* Could be more or less, depending on screen size */"  
				+"}"  
				+""  
				+"/* The Close Button (x) */"  
				+".close {"  
				+"    position: absolute;"  
				+"    right: 25px;"  
				+"    top: 0;"  
				+"    color: #000;"  
				+"    font-size: 35px;"  
				+"    font-weight: bold;"  
				+"}"  
				+""  
				+".close:hover,"  
				+".close:focus {"  
				+"    color: red;"  
				+"    cursor: pointer;"  
				+"}"  
				+""  
				+"/* Add Zoom Animation */"  
				+".animate {"  
				+"    -webkit-animation: animatezoom 0.6s;"  
				+"    animation: animatezoom 0.6s"  
				+"}"  
				+""  
				+"@-webkit-keyframes animatezoom {"  
				+"    from {-webkit-transform: scale(0)} "  
				+"    to {-webkit-transform: scale(1)}"  
				+"}"  
				+"    "  
				+"@keyframes animatezoom {"  
				+"    from {transform: scale(0)} "  
				+"    to {transform: scale(1)}"  
				+"}"  
				+""  
				+"/* Change styles for span and cancel button on extra small screens */"  
				+"@media screen and (max-width: 300px) {"  
				+"    span.psw {"  
				+"       display: block;"  
				+"       float: none;"  
				+"    }"  
				+"    .cancelbtn {"  
				+"       width: 100%;"  
				+"    }"  
				+"}";
	}

	public static String getAddUser() {
		return "<div>"  
				+"  <form method=\"post\" action=\"/studentenUebersicht\">"  
				+"    <div class=\"container\">"
				+ "		<label for=\"anrede\"><b>Anrede</b></label><br>"
				+ "		<input type=\"radio\" name=\"gender\" value=\"male\" required> Herr"
				+"  	<input type=\"radio\" name=\"gender\" value=\"female\" required> Frau<br><br>"  
				+"      <label for=\"vornmae\"><b>Vorname</b></label>"  
				+"      <input type=\"text\" placeholder=\"Enter Vorname\" name=\"vorname\" required>"  
				+"      <label for=\"name\"><b>Name</b></label>"  
				+"      <input type=\"text\" placeholder=\"Enter Name\" name=\"name\" required>" 
				+"      <label for=\"gebDatum\"><b>Geburtsdatum</b></label><br>"
				+"      <input type=\"date\" name=\"Datum\" value=\"07.12.2012\" required><br><br>"   
				+"      <label for=\"stasse\"><b>Starße</b></label>"  
				+"      <input type=\"text\" placeholder=\"Enter Staße\" name=\"strasse\" required>"  
				+"      <label for=\"hnr\"><b>Hausnummer</b></label>"  
				+"      <input type=\"text\" placeholder=\"Enter hausnummer\" name=\"hnr\" required>"  
				+"      <label for=\"hnr\"><b>PLZ</b></label>"  
				+"      <input type=\"text\" placeholder=\"Enter PLZ\" name=\"plz\" required>"  
				+"      <label for=\"hnr\"><b>Ort</b></label>"  
				+"      <input type=\"text\" placeholder=\"Enter Ort\" name=\"ort\" required>"  
				+"      <label for=\"psw\"><b>Passwort</b></label>"  
				+"      <input type=\"password\" placeholder=\"Enter Passwort\" name=\"psw\" required>"  
				+"      <label for=\"status\"><b>Status</b></label><br>"  
				+"		<input type=\"radio\" name=\"block\" value=\"block\" required> blockiert"
				+"  	<input type=\"radio\" name=\"block\" value=\"notblock\" required> nicht blockiert<br><br>"
				+"      <label for=\"kuerzel\"><b>Kürzel</b></label>"  
				+"      <input type=\"text\" placeholder=\"Enter Kürzel\" name=\"kuerzel\" required>"  
				+"      <label for=\"email\"><b>Email</b></label>"  
				+"      <input type=\"text\" placeholder=\"Enter Email\" name=\"Email\" required>"  
				+"        "  
				+"      <button>speichern</button>"   
				+"    </div>"  
				+""   
				+"  </form>"  
				+"</div>";
	}

	public static String getAddFach() {
		
		String dozenten="<select>";
		//Dozentenliste durchgehen
		for(int i = 0; i< 10; i++)
		{
			dozenten += "<option value=\""+i+"\">"+i+"</option>";
		}
		dozenten += "</select>";
		return "<div>"  
				+"  <form >"  
				+"    <div class=\"container\">"
				+"      <label for=\"fachname\"><b>Fach</b></label>"  
				+"      <input type=\"text\" placeholder=\"Enter Fachname\" name=\"fachname\" required>"  
				+"      <label for=\"name\"><b>Dozent</b></label>"
				+       dozenten
				+"      <button>speichern</button>"   
				+"    </div>"  
				+""   
				+"  </form>"  
				+"</div>";
	}
	
	public static String getFachListe() {
		
		//if(!givenUserList.isEmpty()) {
		if(true) {
			String tableHead ="<div class=”tbl-content”>"  
					+"<table id=\"userTable\">"
					+ "<thead>"
					+ "	<th>Fach</th>"
					+ "	<th>Name</th>"
				    + "	<th>Dozent</th>"
				    + "	<th>Klasse</th>"
					+ "<th></th>"
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
//							+if(change==true)
//			tableBody+="  <td class=\"last\"><Button>bearbeitn</Button>&emsp;<Button onclick=\"myFunction("+i+")\">löschen</Button></td>";
//			
//			tableBody+="</tr>";
//			}
			
			for(int i = 0; i< 100;i++)
			{
		
				tableBody +="<tr>"
							+ "	<td>test</td>" 
							+ "	<td>test</td>"
							+ "	<td>test</td>"
							+ "	<td>test</td>"
							+ "  <td class=\"last\">"
							+ "	<Button onclick=\"document.getElementById('id02').style.display='block'\" style=\"width:auto;\" class=\"changebtn\">bearbeitn</Button>"
							+ "	&emsp;"
							+ "	<Button class=\"deletebtn\">löschen</Button>"
							+ "</td>"
							+ "</tr>";
			}
			
			tableBody += "</tbody>";
			
			String tableEnd= "</table></div>";
			
			return tableHead+tableBody+tableEnd+getChangeFach();
		}	
		
		return "Keine Benutzer vorhanden"; 
	}

	public static String getChangeFach() {
		String dozenten="<select required>";
		//Dozentenliste durchgehen
		for(int i = 0; i< 10; i++)
		{
			dozenten += "<option value=\""+i+"\">"+i+"</option>";
		}
		dozenten += "</select>";
		
		String klassen="<select>";
		//Klassen durchgehen
		for(int i = 0; i< 10; i++)
		{
			klassen += "<option value=\""+i+"\">"+i+"</option>";
		}
		klassen += "</select>";
		
		return "<div id=\"id02\" class=\"modal\">"  
				+"  "  
				+"  <form class=\"modal-content animate\">"  
				+"    <div class=\"imgcontainer\">"
				+ "<b>Fach ändern<b>"  
				+"      <span onclick=\"document.getElementById('id02').style.display='none'\" class=\"close\" title=\"Close Modal\">&times;</span>"
				+"    </div>"  
				+""  
				+"    <div class=\"container\">"
				+"		<label for=\"fachname\"><b>Fach</b></label>"  
				+"      <input type=\"text\" placeholder=\"Enter Fachname\" name=\"fachname\" required>"  
				+"      <label for=\"name\"><b>Dozent</b></label><br>"
				+       dozenten
				+"		<br><label for=\"Klasse\"><b>Fach</b></label><br>"  
				+		klassen
				+"      <button>speichern</button>"   
				+"    </div>"  
				+""  
				+"    <div class=\"container\" style=\"background-color:#f1f1f1\">"  
				+"      <button type=\"button\" onclick=\"document.getElementById('id02').style.display='none'\" class=\"cancelbtn\" >Cancel</button>"  
				+"    </div>"  
				+"  </form>"  
				+"</div>"  
				+""  
				+"<script>"  
				+"// Get the modal"  
				+"var modal = document.getElementById('id02');"  
				+""  
				+"// When the user clicks anywhere outside of the modal, close it"  
				+"window.onclick = function(event) {"  
				+"    if (event.target == modal) {"  
				+"        modal.style.display = \"none\";"  
				+"    }"  
				+"}"  
				+"</script>";

	}
	
	public static String getKlassenListe() {
		//if(!givenUserList.isEmpty()) {
				if(true) {
					String tableHead ="<div class=”tbl-content”>"  
							+"<table id=\"userTable\">"
							+ "<thead>"
							+ "	<th>Kuerzel/Name</th>"
							+ "	<th>KlassenSprecher</th>"
						    + "	<th>Stellvertretender Klassensprecher</th>"
							+ "<th></th>"
						    + "<\thead>";
					
					String tableBody = "<tbody>";

//					for(Object tmpObject : givenUserList)
//					{
//						Benutzer tmpBenuter = (Benutzer) tmpObject;
//						tableBody +="<tr>"
//									+"	<td>"+tmpBenuter.getVorname()+"</td>" 
//									+"	<td>"+tmpBenuter.getName()+"</td>"
//									+"	<td>"+tmpBenuter.getKuerzel()+"</td>"
//									+"	<td>"+tmpBenuter.getPasswort()+"</td>"
//									+if(change==true)
//					tableBody+="  <td class=\"last\"><Button>bearbeitn</Button>&emsp;<Button onclick=\"myFunction("+i+")\">löschen</Button></td>";
//					
//					tableBody+="</tr>";
//					}
					
					for(int i = 0; i< 100;i++)
					{
				
						tableBody +="<tr>"
									+ "	<td>test</td>" 
									+ "	<td>test</td>"
									+ "	<td>test</td>"
									+ "  <td class=\"last\">"
									+ "	<Button onclick=\"document.getElementById('id03').style.display='block'\" style=\"width:auto;\" class=\"changebtn\">bearbeitn</Button>"
									+ "	&emsp;"
									+ "	<Button class=\"deletebtn\">löschen</Button>"
									+ "</td>"
									+ "</tr>";
					}
					
					tableBody += "</tbody>";
					
					String tableEnd= "</table></div>";
					
					return tableHead+tableBody+tableEnd+getChangeKlasse();
				}	
				
				return "Keine Klasse vorhanden"; 
	}
	
	public static String getAddKlasse() {
				
		return "<div>"  
				+"  <form >"  
				+"    <div class=\"container\">"
				+"      <label for=\"klasse\"><b>Klassenkürzel</b></label>"  
				+"      <input type=\"text\" placeholder=\"Enter Klassenkürzel\" name=\"kuerzel\" required>"
				+"      <button>speichern</button>"   
				+"    </div>"  
				+""   
				+"  </form>"  
				+"</div>";
	}
	
	public static String getChangeKlasse() {
		
		String studenten="<select>";
		//Klassen durchgehen
		for(int i = 0; i< 10; i++)
		{
			studenten += "<option value=\""+i+"\">"+i+"</option>";
		}
		studenten += "</select>";
		
		return "<div id=\"id03\" class=\"modal\">"  
				+"  "  
				+"  <form class=\"modal-content animate\">"  
				+"    <div class=\"imgcontainer\">"
				+ "<b>Fach ändern<b>"  
				+"      <span onclick=\"document.getElementById('id03').style.display='none'\" class=\"close\" title=\"Close Modal\">&times;</span>"
				+"    </div>"  
				+""  
				+"    <div class=\"container\">"
				+" 		<label for=\"klasse\"><b>Klassenkürzel</b></label>"  
				+"      <input type=\"text\" placeholder=\"Enter Klassenkürzel\" name=\"kuerzel\" required>"
				+"      <label for=\"name\"><b>Klassensprecher</b></label><br>"
				+       studenten
				+"		<br><label for=\"Klasse\"><b>Stellvertrendender Klassnesprecher</b></label><br>"  
				+		studenten
				+"      <button>speichern</button>"   
				+"    </div>"  
				+""  
				+"    <div class=\"container\" style=\"background-color:#f1f1f1\">"  
				+"      <button type=\"button\" onclick=\"document.getElementById('id02').style.display='none'\" class=\"cancelbtn\" >Cancel</button>"  
				+"    </div>"  
				+"  </form>"  
				+"</div>"  
				+""  
				+"<script>"  
				+"// Get the modal"  
				+"var modal = document.getElementById('id03');"  
				+""  
				+"// When the user clicks anywhere outside of the modal, close it"  
				+"window.onclick = function(event) {"  
				+"    if (event.target == modal) {"  
				+"        modal.style.display = \"none\";"  
				+"    }"  
				+"}"  
				+"</script>";

	}
}
