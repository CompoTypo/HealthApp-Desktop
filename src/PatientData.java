public class PatientData {
    private double height; // In Inches
    private double weight; // In Pounds
    private ArrayList<DoctorData> doctors;
    // private ArrayList<Message> msgs;
    private ArrayList<VitalsData> vitalsReadings;
    private ArrayList<BpData> bpReadings;
    private ArrayList<TestData> tests;

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public ArrayList<DoctorData> getDoctors() {
		return doctors;
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
		return vitalsReadings;
	}

	public void setVitalsReadings(ArrayList<VitalsData> vitalsReadings) {
		this.vitalsReadings = vitalsReadings;
	}

	public ArrayList<BpData> getBpReadings() {
		return bpReadings;
	}

	public void setBpReadings(ArrayList<BpData> bpReadings) {
		this.bpReadings = bpReadings;
	}

	public Private getArrayList() {
		return ArrayList;
	}

	public void setArrayList(Private arrayList) {
		ArrayList = arrayList;
	}
}
