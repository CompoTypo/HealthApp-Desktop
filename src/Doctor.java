import java.util.LinkedList;

public class Doctor extends User {

	private String specialist;
	private LinkedList<Patient> patientList = new LinkedList<Patient>();
	private int numPatients;

	public Doctor() {
		super();
		specialist = "";
		numPatients = 0;
	}

	public Doctor(String fn, String ln, String un, int age, String specialist) {
		super(fn, ln, un, age);
		this.specialist = specialist;
		numPatients = 0;
	}

	public String getSpecialist() {
		return specialist;
	}

	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}

	public LinkedList<Patient> getPatientList() {
		return patientList;
	}

	public void setPatientList(LinkedList<Patient> patientList) {
		this.patientList = patientList;
	}

	public int getNumPatients() {
		return patientList.size();
	}

	public void setNumPatients(int numPatients) {
		this.numPatients = patientList.size();
	}

	public void addPatient(Patient newPatient) {
		patientList.add(newPatient);
		numPatients++;
	}

	public void printAllPatients() {
		System.out.println(patientList);
	}

}