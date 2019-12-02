package healthapp.models;

import java.util.Date;

public class VitalsData {
    private float temp;
	private float weight;
	private int sys;
    private int dia;
    private int pulse;
	private long vitalsTaken;
	
	public VitalsData() {}

	public VitalsData(float t, float w, int s, int d, int p, long time) {
		this.temp = t;
		this.weight = w;
		this.sys = s;
        this.dia = d;
		this.pulse = p;
		this.vitalsTaken = time;
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

    public int getSys() {
        return this.sys;
    }

    public void setSys(int sys) {
        this.sys = sys;
    }

    public int getDia() {
        return this.dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getPulse() {
        return this.pulse;
    }

    public void setPulse(int pulse) {
        this.pulse = pulse;
    }

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public long getVitalsTaken() {
		return this.vitalsTaken;
	}
}
