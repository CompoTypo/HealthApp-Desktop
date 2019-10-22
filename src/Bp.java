public class Bp {
	private int sys;
	private int dia;
    private int pulse;
    
    Bp() {
        this.sys = 0;
        this.dia = 0;
        this.pulse = 0;
    }

    Bp(int s, int d, int p) {
        this.sys = s;
        this.dia = d;
        this.pulse = p;        
    }

    public int getSys() {
        return sys;
    }

    public void setSys(int sys) {
        this.sys = sys;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getPulse() {
        return pulse;
    }

    public void setPulse(int pulse) {
        this.pulse = pulse;
    }
}