package healthapp.utilities;

import java.util.regex.Pattern;

/**
 * InputValidation stores pattern functions
 */
public class InputValidation {
	/**
	 * Constructs a default InputValidation
	 */
	public InputValidation() {
	}

	/**
	 * Returns whether or not a username is valid using a pattern
	 * @param input the username
	 * @return true if its valid, false otherwise
	 */
	public boolean isValidUN(String input) {
		if (!Pattern.matches("[a-zA-Z0-9]{8,20}", input)) {
			System.out.println("Invalid UserName");
			return false;
		} else {
			return true;
		}
	}
	/**
	 * Returns whether or not a password is valid using a pattern
	 * @param input the password
	 * @return true if its valid, false otherwise
	 */
	public boolean isValidPW(String input) {
		if (!Pattern.matches("[a-zA-Z0-9]{2,20}", input)) {
			System.out.println("Invalid Password");
			return false;
		} else {
			return true;
		}
	}
	/**
	 * Returns whether or not a name is valid using a pattern
	 * @param input the name
	 * @return true if its valid, false otherwise
	 */
	public boolean isValidName(String input) {
		if (!Pattern.matches("[a-zA-Z]{2,20}", input)) {
			System.out.println("Invalid Name");
			return false;
		} else {
			return true;
		}
	}
	/**
	 * Returns whether or not an email is valid using a pattern
	 * @param input the email
	 * @return true if its valid, false otherwise
	 */
	public boolean isValidEmail(String input) {
		if (!Pattern.matches("(^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$)", input)) {
			System.out.println("Invalid Email");
			return false;
		} else {
			return true;
		}
	}
	/**
	 * Returns whether or not a year is valid using a pattern
	 * @param input the year
	 * @return true if its valid, false otherwise
	 */
	public boolean isValidYear(String input) {
		if (!(Pattern.matches("[0-9]{4}", input) && Integer.parseInt(input) <= 2020)) {
			System.out.println("Invalid Year");
			return false;
		} else {
			return true;
		}
	}
	/**
	 * Returns whether or not a month is valid using a pattern
	 * @param input the month
	 * @return true if its valid, false otherwise
	 */
	public boolean isValidMonth(String input) {
		if (!(Integer.parseInt(input) > 0 && Integer.parseInt(input) < 13)) {
			System.out.println("Invalid Month");
			return false;
		} else {
			return true;
		}
	}
	/**
	 * Returns whether or not a day is valid using a pattern
	 * @param input the day
	 * @return true if its valid, false otherwise
	 */
	public boolean isValidDay(String input) {
		if (!(Integer.parseInt(input) > 0 && Integer.parseInt(input) < 32)) {
			System.out.println("Invalid Day");
			return false;
		} else {
			return true;
		}
	}
	/**
	 * Returns whether or not a sex is valid using a pattern
	 * @param input the sex
	 * @return true if its valid, false otherwise
	 */
	public boolean isValidSex(String input) {
		if (!Pattern.matches("[a-zA-Z]{0,10}", input)) {
			System.out.println("Invalid Sex");
			return false;
		} else {
			return true;
		}
	}
	/**
	 * Returns whether or not a race is valid using a pattern
	 * @param input the race
	 * @return true if its valid, false otherwise
	 */
	public boolean isValidRace(String input) {
		if (!Pattern.matches("[a-zA-Z]{0,10}", input)) {
			System.out.println("Invalid Race");
			return false;
		} else {
			return true;
		}
	}
    /**
	 * Returns whether or not an hour is valid using a pattern
	 * @param input the hour
	 * @return true if its valid, false otherwise
	 */ 
    public boolean isValidHour(String input){
        if (!(Pattern.matches("[0-9]{2}", input) && Integer.parseInt(input) <= 24)) {
			System.out.println("Invalid Time");
		return false;
		} else {
			return true;
		}
    }
    /**
	 * Returns whether or not a minute is valid using a pattern
	 * @param input the minute
	 * @return true if its valid, false otherwise
	 */
    public boolean isValidMinute(String input){
        if (!(Pattern.matches("[0-9]{2}", input) && Integer.parseInt(input) <= 59)) {
			System.out.println("Invalid Time");
			return false;
		} else {
			return true;
		}
    }
    /**
	 * Returns whether or not a number is valid using a pattern
	 * @param input the number
	 * @return true if its valid, false otherwise
	 */
    public boolean isValidNumber(String input){
        if (!(Pattern.matches("[0-9]{2,4}", input))) {
			System.out.println("Invalid number");
			return false;
		} else {
			return true;
		}
	}

}
