package group.project.teamhungerforce;

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

	UserData(Map<String, String> u) {
		for (Entry<String, String> e : u.entrySet()) {
			String k = e.getKey();
			String v = e.getValue();
			System.out.println(k + " " + v);
			if (k.matches("Fname")) {
				System.out.println(v);
				this.firstname = v;
			} else if (k.matches("Lname")) {
				System.out.println(v);
				this.lastname = v;
			} else if (k.matches("Uname")) {
				System.out.println(v);
				this.uname = v;
			} else if (k.matches("Email")) {
				System.out.println(v);
				this.email = v;
			} else if (k.matches("DOB")) {
				Calendar cal = new GregorianCalendar();
				cal.set(Calendar.YEAR, v.indexOf(19, 20));
				cal.set(Calendar.MONTH, v.indexOf(3, 5));
				cal.set(Calendar.DAY_OF_WEEK, v.indexOf(0, 2));
				cal.set(Calendar.DAY_OF_MONTH, v.indexOf(6, 7));
				this.dob = cal.getTime();
			} else if (k.matches("Sex")) {
				System.out.println(v);
				this.sex = v;
			} else if (k.matches("Race")) {
				System.out.println(v);
				this.race = v;
			} else if (k.matches("Type")) {
				System.out.println(v);
				this.acctType = v;
			}
		}
	}

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

	public void enumerate() {
		System.out.println(this.firstname + " " + this.lastname);
		System.out.println(this.uname);
		System.out.println(this.email);
		System.out.println(this.race);
		System.out.println(this.sex);
		System.out.println(this.acctType);
	}
}
