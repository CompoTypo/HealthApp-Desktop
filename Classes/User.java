public class User {
	private int uid;
	private String firstname;
	private String lastname;
	private String uname;
	private String email;
	private int age;

	User() {
		this.firstname = "";
		this.lastname = "";
		this.uname = "";
		this.age = -1;
	}


	User(String fn, String ln, String un, int age) {
		this.firstname = fn;
		this.lastname = ln;
		this.uname = un;
		this.age = age;
	}

	public int getAge() { return age; }

	public void setAge(int age) { this.age = age; }

	public int getUID() { return uid; }

	public void setUID(int uID) { uid = uID; }

	public String getUname() { return uname; }

	public void setUname(String uname) { uname = uname; }

	public int getUid() { return uid; }

	public void setUid(int uid) { this.uid = uid; }

	public String getFirstname() { return firstname; }

	public void setFirstname(String firstname) { this.firstname = firstname; }

	public String getLastname() { return lastname; }

	public void setLastname(String lastname) { this.lastname = lastname; }

	public String getEmail() { return email; }

	public void setEmail(String email) { this.email = email; }
}
