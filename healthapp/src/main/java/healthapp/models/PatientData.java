package group.project.teamhungerforce;

import java.util.ArrayList;

public class PatientData {
    private double height; // In Inches
    private double weight; // In Pounds
    private ArrayList<DoctorData> doctors;
    // private ArrayList<Message> msgs;
    private ArrayList<VitalsData> vitalsReadings;
    private ArrayList<BpData> bpReadings;
	private ArrayList<TestData> tests;
	
	PatientData() {
		this.height = -1.0;
		this.weight = -1.0;
		this.doctors = new ArrayList<DoctorData>();
		this.vitalsReadings = new ArrayList<VitalsData>();
		this.bpReadings = new ArrayList<BpData>();
		this.tests = new ArrayList<TestData>();
	}

	PatientData(double h, double w) {
		this.height = -1.0;
		this.weight = -1.0;
		this.doctors = new ArrayList<DoctorData>();
		this.vitalsReadings = new ArrayList<VitalsData>();
		this.bpReadings = new ArrayList<BpData>();
		this.tests = new ArrayList<TestData>();
	}

	public double getHeight() {
		return this.height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return this.weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public ArrayList<DoctorData> getDoctors() {
		return this.doctors;
	}

	public void setDoctors(ArrayList<DoctorData> doctors) {
		this.doctors = doctors;
	}
/*
	public ArrayList<Message> getMsgs() {
		return msgs;
	}

	public void setMsgs(ArrayList<Message> msgs) {
		this.msgs = msgs;
	}
*/
	public ArrayList<VitalsData> getVitalsReadings() {
		return this.vitalsReadings;
	}

	public void setVitalsReadings(ArrayList<VitalsData> vitalsReadings) {
		this.vitalsReadings = vitalsReadings;
	}

	public ArrayList<BpData> getBpReadings() {
		return this.bpReadings;
	}

	public void setBpReadings(ArrayList<BpData> bpReadings) {
		this.bpReadings = bpReadings;
	}

	public ArrayList<TestData> getTests() {
		return this.tests;
	}

	public void setTests(ArrayList<TestData> tests) {
		this.tests = tests;
	}

}
