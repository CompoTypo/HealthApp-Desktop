public class Vitals extends Bp {
	private float temp;
	private float weight;

	Vitals() {
		super();
		this.temp = 0;
		this.weight = 0;
	}

	Vitals(int s, int d, int p, float t, float w) {
		super(s, d, p);
		this.temp = t;
		this.weight = w;
	}
 
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
	
}
