import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		
		String tempString;
		
		Patient p1 = new Patient();
		
		Scanner input = new Scanner(System.in);
		
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
		p1.setWeight(Integer.parseInt(tempString));
		
		p1.calculateBodyMassIndex();
		
		System.out.print("Enter in Person's blood pressure: ");
		tempString = input.nextLine();
		p1.setBloodPressure(tempString);
		
		System.out.print("Enter in Person's sex: ");
		tempString = input.nextLine();
		p1.setSex(tempString.toLowerCase());
		
		System.out.print(p1.toString());		
	}

}
