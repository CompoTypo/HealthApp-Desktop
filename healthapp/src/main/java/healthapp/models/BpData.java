package healthapp.models;

import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

public class BpData {
    private int sys;
    private int dia;
    private int pulse;
    private Date bpTaken;

    //public BpData(Map<String, String> u) {
	//	for (Entry<String, String> e : u.entrySet()) {
	//		String k = e.getKey();
	//		String v = e.getValue();
    //    
	//		//String k = Normalizer.normalize(e.getKey(), Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	//		//String v = Normalizer.normalize(e.getValue(), Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	//		System.out.println(k + " " + v);
	//		if (k.matches("Fname")) {
	//			this.firstname = v;
	//		} else if (k.matches("Lname")) {
	//			this.lastname = v;
	//		} else if (k.matches("Uname")) {
	//			this.uname = v;
	//		} else if (k.matches("Email")) {
	//			this.email = v;
	//		} else if (k.matches("DOB")) {
	//			System.out.println(v);
	//			Calendar cal = new GregorianCalendar();
	//			cal.set(Calendar.YEAR, v.indexOf(19, 20));
	//			cal.set(Calendar.MONTH, v.indexOf(3, 5));
	//			cal.set(Calendar.DAY_OF_WEEK, v.indexOf(0, 2));
	//			cal.set(Calendar.DAY_OF_MONTH, v.indexOf(6, 7));
	//			this.dob = cal.getTime();
	//		} else if (k.matches("Sex")) {
	//			this.sex = v;
	//		} else if (k.matches("Race")) {
	//			this.race = v;
	//		} else if (k.matches("Type")) {
	//			this.acctType = v;
	//		} else if (k.matches("Hash")) {
	//			this.hash = v;
	//		} else if (k.matches("UID")) {
	//			continue;
	//		}
	//	}
    //
    //}
    
    BpData(int s, int d, int p) {
        this.sys = s;
        this.dia = d;
        this.pulse = p;
        this.bpTaken = new Date();
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

    public Date getBpTaken() {
        return this.bpTaken;
    }

    public void setBpTaken(Date bpTaken) {
        this.bpTaken = bpTaken;
    }
}
