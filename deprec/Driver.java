import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {

		String tempString;

		Doctor testDoctor = new Doctor();
		Patient p1 = new Patient();
		boolean confirm = true;
		Scanner input = new Scanner(System.in);

		System.out.print("Enter in Doctor's name: ");
		tempString = input.nextLine();
		testDoctor.setName(tempString);

		System.out.print("Enter in Doctor's age: ");
		tempString = input.nextLine();
		testDoctor.setAge(Integer.parseInt(tempString));

		System.out.print("Enter in Doctor's specialty: ");
		tempString = input.nextLine();
		testDoctor.setSpecialist(tempString);

		/*
		 * System.out.print("Enter in the amount of Doctor's patients: "); tempString =
		 * input.nextLine(); testDoctor.setNumPatients(Integer.parseInt(tempString));
		 */

		do {
			System.out.println("Do you want to add patient?");
			tempString = input.nextLine();
			if (tempString.toLowerCase().contains("yes")) {
				System.out.print("Enter in Person's name: ");
				tempString = input.nextLine();
				p1.setName(tempString);

				System.out.print("Enter in Person's age: ");
				tempString = input.nextLine();
				p1.setAge(Integer.parseInt(tempString));

				System.out.print("Enter in Person's height(in.): ");
				tempString = input.nextLine();
				p1.setHeight(Integer.parseInt(tempString));

				System.out.print("Enter in Person's weight(lbs): ");
				tempString = input.nextLine();
				p1.setWeight(Double.parseDouble(tempString));

				p1.calculateBodyMassIndex();

				System.out.print("Enter in Person's blood pressure: ");
				tempString = input.nextLine();
				p1.setBloodPressure(tempString);

				System.out.print("Enter in Person's sex: ");
				tempString = input.nextLine();
				p1.setSex(tempString.toLowerCase());

				System.out.print("Enter in Person's race: ");
				tempString = input.nextLine();
				p1.setRace(tempString.toLowerCase());

				testDoctor.addPatient(p1);
			} else {
				confirm = false;
			}
		} while (confirm);

		/*
		 * for (int i = 0; i < testDoctor.getNumPatients(); i++) {
		 * System.out.print("Enter in Person's name: "); tempString = input.nextLine();
		 * p1.setName(tempString);
		 * 
		 * System.out.print("Enter in Person's age: "); tempString = input.nextLine();
		 * p1.setAge(Integer.parseInt(tempString));
		 * 
		 * System.out.print("Enter in Person's height(in.): "); tempString =
		 * input.nextLine(); p1.setHeight(Integer.parseInt(tempString));
		 * 
		 * System.out.print("Enter in Person's weight(lbs): "); tempString =
		 * input.nextLine(); p1.setWeight(Double.parseDouble(tempString));
		 * 
		 * p1.calculateBodyMassIndex();
		 * 
		 * System.out.print("Enter in Person's blood pressure: "); tempString =
		 * input.nextLine(); p1.setBloodPressure(tempString);
		 * 
		 * System.out.print("Enter in Person's sex: "); tempString = input.nextLine();
		 * p1.setSex(tempString.toLowerCase());
		 * 
		 * System.out.print("Enter in Person's race: "); tempString = input.nextLine();
		 * p1.setRace(tempString.toLowerCase());
		 * 
		 * testDoctor.addPatient(p1); }
		 */

		System.out.println(testDoctor.toString());

		testDoctor.printAllPatients();
	}

}
