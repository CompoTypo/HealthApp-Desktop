import java.util.Date;

public class UserData {
    private String uid;
    private String firstname;
    private String lastname;
    private String uname;
    private String email;
    private Date dob;
    private String sex;
    private String race;
    private boolean isDoctor;
    private PatientData pd; // !!  optional, constructs safe invalid object by default
    private MdData md; // !!  optional, constructs safe invalid object by default   

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public boolean isDoctor() {
		return isDoctor;
	}

	public void setDoctor(boolean isDoctor) {
		this.isDoctor = isDoctor;
	}

	public PatientData getPd() {
		return pd;
	}

	public void setPd(PatientData pd) {
		this.pd = pd;
	}

	public MdData getMd() {
		return md;
	}

	public void setMd(MdData md) {
		this.md = md;
	}
}
