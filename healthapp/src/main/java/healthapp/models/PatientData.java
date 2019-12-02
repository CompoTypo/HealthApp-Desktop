package healthapp.models;

import java.util.ArrayList;

/**
 * PatientData stores the data for a single patient
 */
public class PatientData {
    private double height; // In Inches
    private double weight; // In Pounds
    private ArrayList<DoctorData> doctors;
    // private ArrayList<Message> msgs;
    private ArrayList<VitalsData> vitalsReadings;
	private ArrayList<TestData> tests;
	
	/**
	 * Constructs a default PatientData
	 */
	public PatientData() {
		this.height = -1.0;
		this.weight = -1.0;
		this.doctors = new ArrayList<DoctorData>();
		this.vitalsReadings = new ArrayList<VitalsData>();
		this.tests = new ArrayList<TestData>();
	}
	/**
	 * Constructs a patient data given a height and width
	 * @param h the height
	 * @param w the width
	 */
	public PatientData(double h, double w) {
		this.height = -1.0;
		this.weight = -1.0;
		this.doctors = new ArrayList<DoctorData>();
		this.vitalsReadings = new ArrayList<VitalsData>();
		this.tests = new ArrayList<TestData>();
	}
	/**
	 * Returns the height
	 * @return the height
	 */
	public double getHeight() {
		return this.height;
	}
	/**
	 * Sets the height given a height
	 * @param height the height
	 */
	public void setHeight(double height) {
		this.height = height;
	}
	/**
	 * Returns the weight
	 * @return the weight
	 */
	public double getWeight() {
		return this.weight;
	}
	/**
	 * Sets the weight given a weight
	 * @param weight the weight
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}
	/**
	 * Returns the list of doctors
	 * @return the doctors
	 */
	public ArrayList<DoctorData> getDoctors() {
		return this.doctors;
	}
	/**
	 * Sets the list of doctors given a list of doctors
	 * @param doctors the list
	 */
	public void setDoctors(ArrayList<DoctorData> doctors) {
		this.doctors = doctors;
	}
	/**
	 * Returns the vitals readings
	 * @return the vitals readings
	 */
	public ArrayList<VitalsData> getVitalsReadings() {
		return this.vitalsReadings;
	}
	/**
	 * Sets the vitals readings given the readings
	 * @param vitalsReadings the readings
	 */
	public void setVitalsReadings(ArrayList<VitalsData> vitalsReadings) {
		this.vitalsReadings = vitalsReadings;
	}
	/**
	 * Returns the tests
	 * @return the tests
	 */
	public ArrayList<TestData> getTests() {
		return this.tests;
	}
	/**
	 * Sets the tests given the tests
	 * @param tests the tests
	 */
	public void setTests(ArrayList<TestData> tests) {
		this.tests = tests;
	}
}
