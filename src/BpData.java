import java.util.Date;

public class BpData {
    private int sys;
    private int dia;
    private int pulse;
    private Date bpTaken;

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

    public Date getBpTaken() {
        return bpTaken;
    }

    public void setBpTaken(Date bpTaken) {
        this.bpTaken = bpTaken;
    }
}
