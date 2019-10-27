

public class DoctorData {
    private String degree;
    private ArrayList<String> credentials;
    private String specialty;
    private ArrayList<PatientData> patients;

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public ArrayList<String> getCredentials() {
		return credentials;
	}

	public void setCredentials(ArrayList<String> credentials) {
		this.credentials = credentials;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public ArrayList<PatientData> getPatients() {
		return patients;
	}

	public void setPatients(ArrayList<PatientData> patients) {
		this.patients = patients;
	}
}
