package klassen;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Funktionen {

	public void Functionen() {

	}

	//Email
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	public static boolean validateEmail(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.find();
	}

	//Password
	// https://www.mkyong.com/regular-expressions/how-to-validate-password-with-regular-expression/
	public static final Pattern VALID_PASSWORD_REFEX = Pattern
			.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})");

	public static boolean validatePassword(String passwordStr) {
		Matcher matcher = VALID_PASSWORD_REFEX.matcher(passwordStr);
		return matcher.find();
	}

	public String hashPassword(String password) {

		String newPassword = "";

		return newPassword;
	}
	
	public boolean checkPassword(String checkPassword) {
		return false;
	}
}
