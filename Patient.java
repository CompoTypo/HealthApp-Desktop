
public class Patient extends User {

	private int height;
	private int weight;
	private double bodyMassIndex;
	private String bloodPressure;
	private String sex;

	Patient() 
	{
		super();
		height = 0;
		weight = 0;
		bloodPressure = "";
		bodyMassIndex = 0;
		sex = "";
	}
	
	Patient(String name, int age, int height, int weight, String bloodPressure, String sex) 
	{
		super(name, age);
		this.height = height;
		this.bloodPressure = bloodPressure;
		this.weight = weight;
		this.sex = sex;
	}

	public int getHeight() 
	{
		return height;
	}

	public void setHeight(int height) 
	{
		this.height = height;
	}

	public int getWeight() 
	{
		return weight;
	}

	public void setWeight(int weight) 
	{
		this.weight = weight;
	}

	public double getBodyMassIndex() 
	{
		return bodyMassIndex;
	}

	public void calculateBodyMassIndex() 
	{
		bodyMassIndex = ((weight)*(703))/((height)*(height));
	}
	
	public String getBloodPressure() 
	{
		return bloodPressure;
	}

	public void setBloodPressure(String bloodPressure) 
	{
		this.bloodPressure = bloodPressure;
	}

	public String getSex() 
	{
		return sex;
	}

	public void setSex(String sex) 
	{
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Patient [height=" + height + ", weight=" + weight + ", bloodPressure=" + bloodPressure
				+ ", bodyMassIndex=" + bodyMassIndex + ", sex=" + sex + ", toString()=" + super.toString() + "]";
	}


}
