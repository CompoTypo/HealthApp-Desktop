package healthapp.models;

import java.util.ArrayList;

/**
 * Stores a doctor
 */
public class DoctorData {
    private String degree;
    private ArrayList<String> credentials;
    private String specialty;
    private ArrayList<PatientData> patients;

	/**
	 * Returns the degree
	 * @return the degree
	 */
	public String getDegree() {
		return this.degree;
	}
	/**
	 * Sets the degree given a string
	 * @param degree the degree
	 */
	public void setDegree(String degree) {
		this.degree = degree;
	}
	/**
	 * Returns the credentials list
	 * @return the credentials list
	 */
	public ArrayList<String> getCredentials() {
		return this.credentials;
	}
	/**
	 * Sets the credentials list given a list
	 * @param credentials the list
	 */
	public void setCredentials(ArrayList<String> credentials) {
		this.credentials = credentials;
	}
	/**
	 * Returns the specialty as a String
	 * @return the specialty
	 */
	public String getSpecialty() {
		return this.specialty;
	}
	/**
	 * Sets the specialty 
	 * @param the specialty
	 */
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	/**
	 * Returns the list of patients
	 * @return the list of patients
	 */
	public ArrayList<PatientData> getPatients() {
		return this.patients;
	}
	/**
	 * Sets the patients list
	 * @param patients the list of patients
	 */
	public void setPatients(ArrayList<PatientData> patients) {
		this.patients = patients;
	}
}
