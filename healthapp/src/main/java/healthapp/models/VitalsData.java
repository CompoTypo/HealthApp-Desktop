package healthapp.models;

import java.util.Date;

public class VitalsData {
    private float temp;
    private float weight;
	private Date vitalsTaken;
	
	public VitalsData() {}

	public VitalsData(float t, float w) {
		this.temp = t;
		this.weight = w;
	}

	public float getTemp() {
		return this.temp;
	}

	public void setTemp(float temp) {
		this.temp = temp;
	}

	public float getWeight() {
		return this.weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public Date getVitalsTaken() {
		return this.vitalsTaken;
	}
}