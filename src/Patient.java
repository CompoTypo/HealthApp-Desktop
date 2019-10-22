import java.util.LinkedList;

public class Patient extends User {

	private double height; // In Inches
	private double weight; // In Pounds
	private double bmi;
	private String sex;
	private String race;
	private LinkedList<Doctor> doctorList = new LinkedList<Doctor>();
	private LinkedList<Vitals> vitalsList = new LinkedList<Vitals>();

	Patient() {
		super();
		this.height = -1;
		this.weight = -1;
		this.bmi = -1.0;
		this.sex = "";
		this.race = "";
	}

	Patient(String fn, String ln, String un, int age, int height, double weight, String sex, String race) {
		super(fn, ln, un, age);
		this.height = height;
		this.weight = weight;
		this.calculateBodyMassIndex();
		this.sex = sex;
		this.race = race;
	}

	public double getHeight() {
		return this.height;
	}

	public void setHeight(double height) {
		this.height = height;
		calculateBodyMassIndex();
	}

	public double getWeight() {
		return this.weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
		calculateBodyMassIndex();
	}

	public double getBodyMassIndex() {
		return this.bmi;
	}

	private void calculateBodyMassIndex() {
		this.bmi = (this.weight * 703.0) / (this.height * this.height);
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getRace() {
		return this.race;
	}

	public void setRace(String race) {
		this.race = race;
	}

}
