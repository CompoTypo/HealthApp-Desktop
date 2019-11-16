package group.project.teamhungerforce;

import java.util.ArrayList;

public class DoctorData {
    private String degree;
    private ArrayList<String> credentials;
    private String specialty;
    private ArrayList<PatientData> patients;

	public String getDegree() {
		return this.degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public ArrayList<String> getCredentials() {
		return this.credentials;
	}

	public void setCredentials(ArrayList<String> credentials) {
		this.credentials = credentials;
	}

	public String getSpecialty() {
		return this.specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public ArrayList<PatientData> getPatients() {
		return this.patients;
	}

	public void setPatients(ArrayList<PatientData> patients) {
		this.patients = patients;
	}
}
