import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.Map.Entry;

public class UserData {
	private String firstname;
	private String lastname;
	private String uname;
	private String email;
	private Date dob;
	private String sex;
	private String race;
	private String acctType;
	private PatientData pd; // !! optional, constructs safe invalid object by default
	private DoctorData md; // !! optional, constructs safe invalid object by default
	private String hash;

	//UserData(Map<String, String> u) {
	//	for (Entry<String, String> e: u.entrySet()) {
	//		if (e.getKey().equals("Fname")) { firstname = e.getValue(); }
	//		if (e.getKey().equals("Lname")) { lastname = e.getValue(); }
	//		if (e.getKey().equals("Uname")) { uname = e.getValue(); }
	//		if (e.getKey().equals("Email")) { email = e.getValue(); }
	//		if (e.getKey().equals("DOB")) {
	//			Calendar cal = new GregorianCalendar();
	//			dob
	//		}
	//		if (e.getKey().equals("Sex")) { sex = e.getValue(); }
	//		if (e.getKey().equals("Race")) { race = e.getValue(); }
	//		if (e.getKey().equals("Type")) { acctType = e.getValue(); }
//
	//	}
	//}

	UserData(String fn, String ln, String un, String em, Date dob, String s, String r, String acctType) {
		this.firstname = fn;
		this.lastname = ln;
		this.uname = un;
		this.email = em;
		this.dob = dob;
		this.sex = s;
		this.race = r;
		this.acctType = acctType;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getRace() {
		return this.race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public PatientData getPd() {
		return this.pd;
	}

	public void setPd(PatientData pd) {
		this.pd = pd;
	}

	public DoctorData getDoctor() {
		return this.md;
	}

	public void setDoctor(DoctorData md) {
		this.md = md;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getAcctType() {
		return acctType;
	}

	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}
}
