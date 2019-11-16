package group.project.teamhungerforce;

import java.util.regex.Pattern;

public class InputValidation {
	public InputValidation() {
	}

	public boolean isValidUN(String input) {
		if (!Pattern.matches("[a-zA-Z0-9]{8,20}", input)) {
			System.out.println("Invalid UserName");
			return false;
		} else {
			return true;
		}
	}

	public boolean isValidPW(String input) {
		if (!Pattern.matches("[a-zA-Z0-9]{2,20}", input)) {
			System.out.println("Invalid Password");
			return false;
		} else {
			return true;
		}
	}

	public boolean isValidName(String input) {
		if (!Pattern.matches("[a-zA-Z]{2,20}", input)) {
			System.out.println("Invalid Name");
			return false;
		} else {
			return true;
		}
	}

	public boolean isValidEmail(String input) {
		if (!Pattern.matches("(^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$)", input)) {
			System.out.println("Invalid Email");
			return false;
		} else {
			return true;
		}
	}

	public boolean isValidYear(String input) {
		if (!(Pattern.matches("[0-9]{4}", input) && Integer.parseInt(input) <= 2020)) {
			System.out.println("Invalid Year");
			return false;
		} else {
			return true;
		}
	}

	public boolean isValidMonth(String input) {
		if (!(Integer.parseInt(input) > 0 && Integer.parseInt(input) < 13)) {
			System.out.println("Invalid Month");
			return false;
		} else {
			return true;
		}
	}

	public boolean isValidDay(String input) {
		if (!(Integer.parseInt(input) > 0 && Integer.parseInt(input) < 32)) {
			System.out.println("Invalid Day");
			return false;
		} else {
			return true;
		}
	}

	public boolean isValidSex(String input) {
		if (!Pattern.matches("[a-zA-Z]{0,10}", input)) {
			System.out.println("Invalid Sex");
			return false;
		} else {
			return true;
		}
	}

	public boolean isValidRace(String input) {
		if (!Pattern.matches("[a-zA-Z]{0,10}", input)) {
			System.out.println("Invalid Race");
			return false;
		} else {
			return true;
		}
	}

}
