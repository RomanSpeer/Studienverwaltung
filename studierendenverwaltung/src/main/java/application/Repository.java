package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import klassen.Benutzer;
import klassen.BenutzerBuilder;
import klassen.Fach;
import klassen.Note;
import klassen.Student;
import klassen.StudentenBuilder;

public class Repository {
	private static final String JDBC_URL = "jdbc:derby:database;create=true";
	public Repository db;

	public Connection getConnection() throws SQLException {
		Properties properties = new Properties();
		properties.put("user", "user");
		properties.put("password", "user");

		return DriverManager.getConnection(JDBC_URL, properties);
	}
	
	public Repository getDbCon() {
        if ( db == null ) {
            db = new Repository();
        }
        return db;
 
    }
	

	public boolean existiertTabelleBereits(Connection connection) throws SQLException {
		try (ResultSet result = connection.getMetaData().getTables("%", "%", "%",
				new String[] { "TABLE", "SYSTEM TABLE" })) {
			while (result.next()) {
				if (result.getString("TABLE_NAME").equalsIgnoreCase("addresse"))
					return true;
			}
		}
		return false;
	}

	public void erstelleTabelle(Connection connection) throws SQLException {
		try (Statement statement = connection.createStatement()) {
			
			statement.execute(
					"CREATE TABLE addresse (\n" + 
					"  addressenID int NOT NULL,\n" + 
					"  strasse varchar(255),\n" + 
					"  hausnummer varchar(255),\n" + 
					"  plz int,\n" + 
					"  ort varchar(255)\n" + 
					")");
			statement.execute(
					"CREATE TABLE dozent (\n" + 
					"  dozentenID int NOT NULL,\n" + 
					"  anrede varchar(255) DEFAULT NULL,\n" + 
					"  vorname varchar(255),\n" + 
					"  name varchar(255),\n" + 
					"  gebDatum date,\n" + 
					"  passwort varchar(255) DEFAULT NULL,\n" + 
					"  status varchar(255) DEFAULT NULL,\n" + 
					"  email varchar(255),\n" + 
					"  addressenID int\n" + 
					")");
			
			statement.execute(
					"CREATE TABLE fach (\n" + 
					"  fachID int NOT NULL,\n" + 
					"  name varchar(255),\n" + 
					"  kuerzel varchar(255),\n" + 
					"  dozentenID int DEFAULT NULL,\n" + 
					"  klassenID int DEFAULT NULL\n" + 
					")");
			
			statement.execute(
					"CREATE TABLE klasse (\n" + 
					"  klassenID int NOT NULL,\n" + 
					"  kuerzel varchar(255),\n" + 
					"  kurssprecherID int,\n" + 
					"  stellvKursprecherID int,\n" + 
					"  dozentenID int\n" + 
					")");
			statement.execute(
					"CREATE TABLE note (\n" + 
					"  notenID int NOT NULL,\n" + 
					"  note int,\n" + 
					"  semester int,\n" + 
					"  art varchar(255),\n" + 
					"  fachID int,\n" + 
					"  studentenID int\n" + 
					")");  
					
			statement.execute(
					"CREATE TABLE student (\n" + 
					"  studentenID int NOT NULL,\n" +
					"  kuerzel varchar(255),\n" + 
					"  anrede varchar(255),\n" + 
					"  vorname varchar(255),\n" + 
					"  name varchar(255),\n" + 
					"  gebDatum date,\n" + 
					"  passwort varchar(255),\n" + 
					"  email varchar(255),\n" + 
					"  matrikelnummer varchar(255),\n" + 
					"  status varchar(255),\n" + 
					"  addressenID int,\n" + 
					"  klassenID int\n" + 
					")");
			
			statement.execute(
					"CREATE TABLE verwaltung (\n" + 
					"  verwaltungID int NOT NULL,\n" + 
					"  anrede varchar(255),\n" + 
					"  vorname varchar(255),\n" + 
					"  name varchar(255),\n" + 
					"  gebDatumm date,\n" + 
					"  passwort varchar(255),\n" + 
					"  email varchar(255),\n" + 
					"  addressenID int\n" + 
					")");
			
		
			
			statement.execute(
					"ALTER TABLE fach\n" + 
					"  ADD PRIMARY KEY (fachID)");
			statement.execute(
					"ALTER TABLE klasse\n" + 
					"  ADD PRIMARY KEY (klassenID)"); 
							
			statement.execute(
					"ALTER TABLE note\n" + 
					"  ADD PRIMARY KEY (notenID)"); 
							
			statement.execute(
					"ALTER TABLE student\n" + 
					"  ADD PRIMARY KEY (studentenID)");
							
			statement.execute(
					"ALTER TABLE verwaltung\n" + 
					"  ADD PRIMARY KEY (verwaltungID)");  						
//			statement.execute(
//					"ALTER TABLE addresse\n" + 
//					"  MODIFY COLUMN addressenID int AUTO_INCREMENT PRIMARY KEY");
//							
//			statement.execute(
//					"ALTER TABLE dozent\n" + 
//					"  MODIFY COLUMN dozentenID int AUTO_INCREMENT PRIMARY KEY");
//							
//			statement.execute(
//					"ALTER TABLE fach\n" + 
//					"  MODIFY COLUMN fachID int AUTO_INCREMENT PRIMARY KEY");
//							
//			statement.execute(
//					"ALTER TABLE klasse\n" + 
//					"  MODIFY COLUMN klassenID int AUTO_INCREMENT PRIMARY KEY");
//							
//			statement.execute(
//					"ALTER TABLE note\n" + 
//					"  MODIFY COLUMN notenID int AUTO_INCREMENT PRIMARY KEY");
//						
//			statement.execute(
//					"ALTER TABLE student\n" + 
//					"  MODIFY COLUMN studentenID int AUTO_INCREMENT PRIMARY KEY");
//							
//			statement.execute(
//					"ALTER TABLE verwaltung\n" + 
//					"  MODIFY COLUMN verwaltungID int AUTO_INCREMENT PRIMARY KEY");
			statement.close();
		}
	}

	private void insertStudent(Student entity, Connection connection) throws SQLException, ParseException {
		//Convert java.date to mysql.date
		while(holeStudentZurID(entity.getBenutzerID(), connection) != null)
		{
			entity.generateBenutzerID();
		}
		
		int addresseUUID = generateID();
//		System.out.println("TEST!!!");
//		System.out.println(addresseUUID);
		try (PreparedStatement preparedStatement = connection
				.prepareStatement("INSERT INTO addresse (addressenID, strasse, hausnummer, plz, ort)"+ 
					"VALUES ("+addresseUUID+", '"+entity.getStraße()+"','"+entity.getHausnummer()+"',"+entity.getPlz()+",'"+entity.getOrt()+"')")) {
			preparedStatement.executeUpdate();
			preparedStatement.close();
				
		}
		

		
		
		
		String pattern = "yyyy-MM-dd";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String mysqlDateString = formatter.format(entity.gebJahr);
		try (PreparedStatement preparedStatement = connection
				.prepareStatement("INSERT INTO student (studentenID, kuerzel, anrede, vorname, name, gebDatum, passwort, email, matrikelnummer, status," + 
						"  addressenID, klassenID )"+ 
					"VALUES ("+entity.getBenutzerID()+", '"+entity.getKuerzel()+"','"+entity.getAnrede()+"','"+entity.getVorname()+"','"+entity.getName()+"','"+mysqlDateString+"','"
						+entity.getPasswort()+"','"+entity.getEmail()+"','"+entity.getMatrikelnummer()+"','"+entity.getStatus()+"',"+addresseUUID+","+entity.getKlassenID()+")")) {
			preparedStatement.executeUpdate();
			preparedStatement.close();
				
		}
	}
	
	public void speichereStudenten(Student entity, Connection connection) throws SQLException, ParseException {
		
		insertStudent(entity, connection);
	}

	private void updateStudent(Student entity, Connection connection) throws SQLException {
		try (PreparedStatement preparedStatement = connection
				.prepareStatement("UPDATE STUDENTEN SET name = ? WHERE id = ?")) {
			preparedStatement.setString(1, entity.getName());
			preparedStatement.setInt(2, entity.getBenutzerID());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		}
	}

	public List<Student> holeAlleStudenten(Connection connection) throws SQLException, ParseException {
		List<Student> studenten = new ArrayList<>();
		try (Statement statement = connection.createStatement()) {
				ResultSet result = statement.executeQuery("SELECT * FROM STUDENT");
				
				while (result.next()) {
					
					List<Note> notenListe = new ArrayList<Note>();
					List<Fach> faecherListe = new ArrayList<Fach>();
					String straße = "";
					String hausnummer = "";
					int plz = 0;
					String ort = "";
				
					try (Statement noteStatement = connection.createStatement()) {
						
						ResultSet noteResult = noteStatement.executeQuery("Select * from note WHERE studentenID =  " + result.getInt(1) + "");
						
						while(noteResult.next())
						{
							Note note = new Note(noteResult.getInt(1), noteResult.getInt(6), noteResult.getInt(2), noteResult.getInt(5), noteResult.getInt(3), noteResult.getString(4));
							notenListe.add(note);
						}
						
						noteResult.close();
					}
					
					try (Statement fachStatement = connection.createStatement()) {
						
						ResultSet fachResult = fachStatement.executeQuery("Select * from fach WHERE klassenID =  " + result.getInt(12) + "");
						
						while(fachResult.next())
						{
							Fach fach = new Fach(fachResult.getInt(1), fachResult.getString(2), fachResult.getInt(4), fachResult.getInt(5));
							faecherListe.add(fach);
						}
						
						fachResult.close();
					}	
					
					try (PreparedStatement preparedAddrStatement = connection
							.prepareStatement("Select * from addresse WHERE addressenID = " + result.getInt(11) + "")) {
						ResultSet addrResult = preparedAddrStatement.executeQuery();

						if (addrResult.next()) {
							straße = addrResult.getString(2);
							hausnummer =  addrResult.getString(3);
							plz =  addrResult.getInt(4);
							ort =  addrResult.getString(5);
						}
						addrResult.close();

					}	a
					
					SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			        Date tmpDate = format.parse(result.getString(6));
			        
					Student student =  new Student(result.getString(3), result.getString(4), result.getString(5), tmpDate, straße, hausnummer, plz, ort, result.getString(7), result.getString(10), result.getString(2), result.getString(8), result.getString(9), result.getInt(12), notenListe, faecherListe);
					
					studenten.add(student);
				}
				result.close();

		}
		return studenten;
	}
	
	private Student holeStudentZurID(int id, Connection connection) throws SQLException, ParseException {
		try (PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT * FROM STUDENT WHERE studentenID = "+id+"")) {
			ResultSet result = preparedStatement.executeQuery();

			if (result.next()) {
				for(Student st : holeAlleStudenten(connection))
				{
					if(st.getBenutzerID() == st.getBenutzerID())
					{
						return st;
					}
				}
			}
			result.close();

		}
		return null;
	}
	

	public boolean existiertStudentBereits(int id, Connection connection) throws SQLException, ParseException {
		return holeStudentZurID(id, connection) != null;
	}
	
	public String generateUUID()
	{
		UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
        
        return randomUUIDString;
	}
	
	public void deleteAllTables(Connection connection) throws SQLException
	{
		try (Statement statement = connection.createStatement()) {
		statement.execute("DROP TABLE verwaltung");
		statement.execute("DROP TABLE student");
		statement.execute("DROP TABLE note");
		statement.execute("DROP TABLE klasse");
		statement.execute("DROP TABLE fach");
		statement.execute("DROP TABLE dozent");
		statement.execute("DROP TABLE addresse");
		statement.close();
		}
	}
	
	public void deleteTable(Connection connection, String tableName) throws SQLException
	{
		try (Statement statement = connection.createStatement()) {
		statement.execute("DROP TABLE "+tableName+"");
		statement.close();
		}
	}
	
	private int generateID()
	{
		int zufallszahl; 
	    zufallszahl = (int)(Math.random() * 10000000) + 1;
	    return zufallszahl;
	}
	

}
