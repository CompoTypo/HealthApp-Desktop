package healthapp.models;

import java.util.Date;

/**
 * VitalsData stores data for vitals
 */
public class VitalsData {
    private float temp;
	private float weight;
	private int sys;
    private int dia;
    private int pulse;
	private long vitalsTaken;
	/**
	 * Construct a VitalsData
	 */
	public VitalsData() {}
	/**
	 * Constructs a VitalsData given data
	 * @param t the temp
	 * @param w the weight
	 * @param s the sys
	 * @param d the dia
	 * @param p the pulse
	 * @param time the vitals
	 */
	public VitalsData(float t, float w, int s, int d, int p, long time) {
		this.temp = t;
		this.weight = w;
		this.sys = s;
        this.dia = d;
		this.pulse = p;
		this.vitalsTaken = time;
	}
	/**
	 * Returns the temperature
	 * @return the temperature
	 */
	public float getTemp() {
		return this.temp;
	}
	/**
	 * Sets the temperature given a temp
	 * @param temp the temp
	 */
	public void setTemp(float temp) {
		this.temp = temp;
	}
	/**
	 * Returns the weight
	 * @return the weight
	 */	
	public float getWeight() {
		return this.weight;
	}
	/**
	 * Returns the system
	 * @return the system
	 */
    public int getSys() {
        return this.sys;
    }
	/**
	 * Sets the system
	 * @param sys the system
	 */
    public void setSys(int sys) {
        this.sys = sys;
    }
	/**
	 * Return the dia
	 * @return the dia
	 */
    public int getDia() {
        return this.dia;
    }
	/**
	 * Sets the dia given a dia
	 * @param the dia
	 */
    public void setDia(int dia) {
        this.dia = dia;
    }
	/**
	 * Returns the pulse
	 * @return the pulse
	 */
    public int getPulse() {
        return this.pulse;
    }
	/**
	 * Sets the pulse given a pulse
	 * @param pulse the pulse
	 */
    public void setPulse(int pulse) {
        this.pulse = pulse;
    }
	/**
	 * Sets the weight given a weight
	 * @param weight the weight
	 */
	public void setWeight(float weight) {
		this.weight = weight;
	}
	/**
	 * Return the vitals
	 * @return the vitals
	 */
	public long getVitalsTaken() {
		return this.vitalsTaken;
	}
}
