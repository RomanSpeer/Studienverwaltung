package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import de.fhdw.awe1.loesungen.jdbc.StudentEntity;
import klassen.BenutzerBuilder;
import klassen.Student;
import klassen.StudentenBuilder;

public class Repository {
	private int id = 0;
	private static final String JDBC_URL = "jdbc:mysql:database;create=true";

	public Connection getConnection() throws SQLException {
		Properties properties = new Properties();
		properties.put("user", "user");
		properties.put("password", "user");

		return DriverManager.getConnection(JDBC_URL, properties);
	}

	public boolean existiertTabelleBereits(Connection connection) throws SQLException {
		try (ResultSet result = connection.getMetaData().getTables("%", "%", "%",
				new String[] { "TABLE", "SYSTEM TABLE" })) {
			while (result.next()) {
				if (result.getString("TABLE_NAME").equalsIgnoreCase("STUDENTEN"))
					return true;
			}
		}
		return false;
	}

	public void erstelleTabelle(Connection connection) throws SQLException {
		try (Statement statement = connection.createStatement()) {
			statement.execute(
					"CREATE TABLE adresse (\n" + 
					"  adressenID int(10),\n" + 
					"  stasse varchar(255),\n" + 
					"  hausnummer varchar(255),\n" + 
					"  plz int(100),\n" + 
					"  ort varchar(255)\n" + 
					");"
					+ "CREATE TABLE dozent (\n" + 
					"  dozentenID int(10),\n" + 
					"  anrede varchar(255) DEFAULT NULL,\n" + 
					"  vorname varchar(255),\n" + 
					"  name varchar(255),\n" + 
					"  gebDatum date,\n" + 
					"  passwort varchar(255) DEFAULT NULL,\n" + 
					"  status varchar(255) DEFAULT NULL,\n" + 
					"  email varchar(255),\n" + 
					"  adressenID int(10)\n" + 
					");"
					+ "CREATE TABLE fach (\n" + 
					"  fachID int(10),\n" + 
					"  name varchar(255),\n" + 
					"  kuerzel varchar(255),\n" + 
					"  dozentenID int(10) DEFAULT NULL,\n" + 
					"  klassenID int(10) DEFAULT NULL\n" + 
					");"
					+ "CREATE TABLE klasse (\n" + 
					"  klassenID int(10),\n" + 
					"  kuerzel varchar(255),\n" + 
					"  kurssprecherID int(10),\n" + 
					"  stellvKursprecherID int(10),\n" + 
					"  dozentenID int(10)\n" + 
					");"
					+ "CREATE TABLE note (\n" + 
					"  notenID int(10),\n" + 
					"  note int(10),\n" + 
					"  semester int(10),\n" + 
					"  art varchar(255),\n" + 
					"  fachID int(10),\n" + 
					"  studierendenID int(10)\n" + 
					");\n" + 
					""
					+ "CREATE TABLE student (\n" + 
					"  studentenID int(10),\n" + 
					"  anrede varchar(255),\n" + 
					"  vorname varchar(255),\n" + 
					"  name varchar(255),\n" + 
					"  gebDatum date,\n" + 
					"  passwort varchar(255),\n" + 
					"  email varchar(255),\n" + 
					"  matrikelnummer varchar(255),\n" + 
					"  status tinyint(4),\n" + 
					"  adressenID int(10),\n" + 
					"  klassenID int(10)\n" + 
					");"
					+ "CREATE TABLE verwaltung (\n" + 
					"  verwaltungID int(10),\n" + 
					"  anrede varchar(255),\n" + 
					"  vorname varchar(255),\n" + 
					"  name varchar(255),\n" + 
					"  gebDatumm date,\n" + 
					"  passwort varchar(255),\n" + 
					"  email varchar(255),\n" + 
					"  adressenID int(11)\n" + 
					");"
					+ "ALTER TABLE fach\n" + 
					"  ADD PRIMARY KEY (fachID);\n" + 
					"ALTER TABLE klasse\n" + 
					"  ADD PRIMARY KEY (klassenID);\n" + 
					"ALTER TABLE note\n" + 
					"  ADD PRIMARY KEY (notenID);\n" + 
					"ALTER TABLE student\n" + 
					"  ADD PRIMARY KEY (studentenID);\n" + 
					"ALTER TABLE verwaltung\n" + 
					"  ADD PRIMARY KEY (verwaltungID);\n" + 
					"ALTER TABLE adresse\n" + 
					"  MODIFY adressenID int(10) AUTO_INCREMENT;\n" + 
					"ALTER TABLE dozent\n" + 
					"  MODIFY dozentenID int(10) AUTO_INCREMENT;\n" + 
					"ALTER TABLE fach\n" + 
					"  MODIFY fachID int(10) AUTO_INCREMENT;\n" + 
					"ALTER TABLE klasse\n" + 
					"  MODIFY klassenID int(10) AUTO_INCREMENT;\n" + 
					"ALTER TABLE note\n" + 
					"  MODIFY notenID int(10) AUTO_INCREMENT;\n" + 
					"ALTER TABLE student\n" + 
					"  MODIFY studentenID int(10) AUTO_INCREMENT;\n" + 
					"ALTER TABLE verwaltung\n" + 
					"  MODIFY verwaltungID int(10) AUTO_INCREMENT;");
			statement.close();
		}
	}

	public void speichereStudenten(Student entity, Connection connection) throws SQLException {
		// Es ist durchaus üblich INSERT und UPDATE in einer Methode zu verbinden
		if (existiertStudentBereits(entity.getName(), connection)) {
			updateStudent(entity, connection);
		} else {
			insertStudent(entity, connection);
		}
	}

	private void insertStudent(Student entity, Connection connection) throws SQLException {
		//Convert java.date to mysql.date
		String pattern = "yyyy-MM-dd";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String mysqlDateString = formatter.format(entity.gebJahr);
		try (PreparedStatement preparedStatement = connection
				.prepareStatement("INSERT INTO users (studentenID, anrede, vorname, name, gebDatum, passwort, mail, matrikelnummer, status," + 
						"  adressenID, klassenID )"+ 
					"VALUES ("+id+", '"+entity.getAnrede()+"','"+entity.getVorname()+"','"+entity.getName()+"','"+mysqlDateString+"','"
						+entity.getPasswort()+"','"+entity.getEmail()+"','"+entity.getMatrikelnummer()+"',"+entity.getStatus()+"")) {
			preparedStatement.executeUpdate();
			preparedStatement.close();
				id++;
		}
	}

	private void updateStudent(Student entity, Connection connection) throws SQLException {
		try (PreparedStatement preparedStatement = connection
				.prepareStatement("UPDATE STUDENTEN SET name = ? WHERE id = ?")) {
			preparedStatement.setString(1, entity.getName());
			preparedStatement.setInt(2, entity.getId());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		}
	}

	public List<Student> holeAlleStudenten(Connection connection) throws SQLException {
		List<Student> studenten = new ArrayList<>();
		try (Statement statement = connection.createStatement()) {
			ResultSet result = statement.executeQuery("SELECT * FROM STUDENT");

			while (result.next()) {
				BenutzerBuilder benutzer = new BenutzerBuilder()
						.setBenutzerID(result.getInt(1))
						.setAnrede(result.getString(2))
						.setVorname(result.getString(3))
						.setName(result.getString(4))
						.setGebJahr(result.getDate(5))
						.setPasswort(result.getString(6))
						.setStatus(result.getString(9))
						.set);
				
				Student student = new Student(benutzer, StudentenBuilder.neuerStudent().setFaecherListe(faecher)
						.setKlassenID(1)
						.setMatrikelnummer(result.getString(8))
						.setNotenListe(noten));
				
				
				Student student = new Student();

				student.setId(result.getInt(1));
				student.setName(result.getString(2));

				studenten.add(student);
			}
			result.close();

		}
		return studenten;
	}

	public boolean existiertStudentBereits(int id, Connection connection) throws SQLException {
		return holeStudentZumNamen(id, connection) != null;
	}

	private Student holeStudentZumNamen(int id, Connection connection) throws SQLException {
		try (PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT * FROM STUDENT WHERE studentenID LIKE ?")) {
			preparedStatement.setInt(1, id);
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
		return student;
	}

}
