package healthapp.models;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.Map.Entry;
// import java.text.Normalizer;
// import java.text.Normalizer.Form;

/**
 * UserData stores the data for a user
 */
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

	/**
	 * Constructs a UserData given a raw user
	 * @param u the user
	 */
	public UserData(Map<String, String> u) {
		for (Entry<String, String> e : u.entrySet()) {
			String k = e.getKey();
			String v = e.getValue();
			//String k = Normalizer.normalize(e.getKey(), Form.NFD).replaceAll("[^\\p{ASCII}]", "");
			//String v = Normalizer.normalize(e.getValue(), Form.NFD).replaceAll("[^\\p{ASCII}]", "");
			System.out.println(k + " " + v);
			if (k.matches("Fname")) {
				this.firstname = v;
			} else if (k.matches("Lname")) {
				this.lastname = v;
			} else if (k.matches("Uname")) {
				this.uname = v;
			} else if (k.matches("Email")) {
				this.email = v;
			} else if (k.matches("DOB")) {
				System.out.println(v);
				Calendar cal = new GregorianCalendar();
				cal.set(Calendar.YEAR, v.indexOf(19, 20));
				cal.set(Calendar.MONTH, v.indexOf(3, 5));
				cal.set(Calendar.DAY_OF_WEEK, v.indexOf(0, 2));
				cal.set(Calendar.DAY_OF_MONTH, v.indexOf(6, 7));
				this.dob = cal.getTime();
			} else if (k.matches("Sex")) {
				this.sex = v;
			} else if (k.matches("Race")) {
				this.race = v;
			} else if (k.matches("Type")) {
				this.acctType = v;
			} else if (k.matches("Hash")) {
				this.hash = v;
			} else if (k.matches("UID")) {
				continue;
			}
		}
	}
	/**
	 * Constructs a UserData given first, last, username, email, dob, sex, race, type
	 * @param fn the first name
	 * @param ln the last name
	 * @param un the username
	 * @param em the email
	 * @param dob the date of birth
	 * @param s the sex
	 * @param r the race
	 * @param acctType the type
	 */
	public UserData(String fn, String ln, String un, String em, Date dob, String s, String r, String acctType) {
		this.firstname = fn;
		this.lastname = ln;
		this.uname = un;
		this.email = em;
		this.dob = dob;
		this.sex = s;
		this.race = r;
		this.acctType = acctType;
	}
	/**
	 * Returns the first name
	 * @return the first name
	 */
	public String getFirstname() {
		return this.firstname;
	}
	/**
	 * Sets the first name given a name
	 * @param firstname
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/**
	 * Returns the last name
	 * @return the last name
	 */
	public String getLastname() {
		return this.lastname;
	}
	/**
	 * Sets the last name given a name
	 * @param lastname the last name
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	/**
	 * Returns the username
	 * @return the username
	 */
	public String getUname() {
		return this.uname;
	}
	/**
	 * Sets the username given a username
	 * @param the username
	 */
	public void setUname(String uname) {
		this.uname = uname;
	}
	/**
	 * Returns the email
	 * @return the email
	 */
	public String getEmail() {
		return this.email;
	}
	/**
	 * Sets the email given an email
	 * @param email the email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * Returns the date of birth
	 * @return the date of birth
	 */
	public Date getDob() {
		return this.dob;
	}
	/**
	 * Sets the date of birth given a date of birth
	 * @param dob the date of birth
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}
	/**
	 * Returns the sex
	 * @return the sex
	 */
	public String getSex() {
		return this.sex;
	}
	/**
	 * Sets the sex given a sex
	 * @param sex the sex
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * Returns the race
	 * @return the race
	 */
	public String getRace() {
		return this.race;
	}
	/**
	 * Sets the race given a race
	 * @param race the race
	 */
	public void setRace(String race) {
		this.race = race;
	}
	/**
	 * Returns the hash
	 * @return the hash
	 */
	public String getHash() {
		return this.hash;
	}
	/**
	 * Sets the hash given a hash
	 * @param hash the hash
	 */
	public void setHash(String hash) {
		this.hash = hash;
	}
	/**
	 * Returns the patient data as a PatientData
	 * @return the patient data
	 */
	public PatientData getPd() {
		return this.pd;
	}
	/**
	 * sets the patient data given a PatientData
	 * @param pd the patient data
	 */
	public void setPd(PatientData pd) {
		this.pd = pd;
	}
	/**
	 * Returns the doctor data
	 * @return the doctor data
	 */
	public DoctorData getMd() {
		return this.md;
	}
	/**
	 * Sets the doctor data given a DoctorData
	 * @param md the doctor data
	 */
	public void setMd(DoctorData md) {
		this.md = md;
	}
	/**
	 * Returns the account type
	 * @return the account type
	 */
	public String getAcctType() {
		return this.acctType;
	}
	/**
	 * Sets the account type given an account type
	 * @param acctType the account type
	 */
	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}
	/**
	 * Prints the data
	 */
	public void enumerate() {
		System.out.println(this.firstname + " " + this.lastname);
		System.out.println(this.uname);
		System.out.println(this.email);
		System.out.println(this.race);
		System.out.println(this.sex);
		System.out.println(this.acctType);
	}
}
