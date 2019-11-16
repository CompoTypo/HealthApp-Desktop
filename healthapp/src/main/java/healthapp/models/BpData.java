package group.project.teamhungerforce;

import java.util.Date;

public class BpData {
    private int sys;
    private int dia;
    private int pulse;
    private Date bpTaken;

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
