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

	public Doctor(String name, int age, String specialist, LinkedList<Patient> patientList, int numPatients) {
		super(name, age);
		this.specialist = specialist;
		this.patientList = patientList;
		this.numPatients = numPatients;
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
		return numPatients;
	}

	public void setNumPatients(int numPatients) {
		this.numPatients = numPatients;
	}
	
	public void addPatient(Patient newPatient)
	{
		patientList.add(newPatient);
		numPatients++;
	}
	
	public void printAllPatients()
	{
		/*
		for (int i = 0; i < numPatients; i++)
		{
			
		}
		*/
		
		System.out.println(patientList);
	}

	@Override
	public String toString() {
		return "Doctor [specialist=" + specialist + ", patientList=" + patientList + ", numPatients=" + numPatients
				+ ", toString()=" + super.toString() + "]\n";
	}
	

}
