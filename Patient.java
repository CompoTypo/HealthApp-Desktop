import java.util.LinkedList;

public class Patient extends User {

	private int height;
	private double weight;
	private double bodyMassIndex;
	private String bloodPressure;
	private String sex;
	private String race;
	private LinkedList<Doctor> doctorList = new LinkedList<Doctor>();

	Patient() 
	{
		super();
		height = 0;
		weight = 0;
		bloodPressure = "";
		bodyMassIndex = 0;
		sex = "";
		race = "";
	}
	
	Patient(String name, int age, int height, double weight, String bloodPressure, String sex, String race) 
	{
		super(name, age);
		this.height = height;
		this.weight = weight;
		this.sex = sex;
		this.race = race;
	}

	public int getHeight() 
	{
		return height;
	}

	public void setHeight(int height) 
	{
		this.height = height;
	}

	public double getWeight() 
	{
		return weight;
	}

	public void setWeight(double weight) 
	{
		this.weight = weight;
	}

	public double getBodyMassIndex() 
	{
		return bodyMassIndex;
	}

	public void calculateBodyMassIndex() 
	{
		bodyMassIndex = ((weight)*(703))/((height)*(height));
	}
	
	public String getBloodPressure() 
	{
		return bloodPressure;
	}

	public void setBloodPressure(String bloodPressure) 
	{
		this.bloodPressure = bloodPressure;
	}

	public String getSex() 
	{
		return sex;
	}

	public void setSex(String sex) 
	{
		this.sex = sex;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public LinkedList<Doctor> getPatientList() {
		return doctorList;
	}

	public void setPatientList(LinkedList<Doctor> doctorList) {
		this.doctorList = doctorList;
	}
	
	@Override
	public String toString() {
		return "Patient [height=" + height + ", weight=" + weight + ", bodyMassIndex=" + bodyMassIndex
				+ ", bloodPressure=" + bloodPressure + ", sex=" + sex + ", race=" + race + ", toString()="
				+ super.toString() + "]\n";
	}




}
