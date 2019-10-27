import java.util.Date;

public class VitalsData {
    private float temp;
    private float weight;
    private Date vitalsTaken;

	public float getTemp() {
		return temp;
	}

	public void setTemp(float temp) {
		this.temp = temp;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public Date getVitalsTaken() {
		return vitalsTaken;
	}

	public void setVitalsTaken(Date vitalsTaken) {
		this.vitalsTaken = vitalsTaken;
	}
}
