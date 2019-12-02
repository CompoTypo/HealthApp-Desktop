package healthapp;

import healthapp.models.VitalsData;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
/*
    private float temp;
	private float weight;
	private int sys;
    private int dia;
    private int pulse;
	private long vitalsTaken;
 */
public class VitalsDataTest {
    private VitalsData d;

    public VitalsDataTest() {
        this.d = new VitalsData(0,0,0,0,0,0);
    }

    @Test
    public void getTemp() {
        this.d.setTemp(98.71f);
        assertEquals(98.71f,this.d.getTemp(),0.01f);
    }

    @Test
    public void getWeight() {
        this.d.setWeight(100.2f);
        assertEquals(100.2f,this.d.getWeight(),0.01f);
    }

    @Test
    public void getSys() {
        this.d.setSys(8);
        assertEquals(8,this.d.getSys());
    }

    @Test
    public void getDia() {
        this.d.setDia(6);
        assertEquals(6,this.d.getDia());
    }
    @Test
    public void getPulse() {
        this.d.setPulse(6);
        assertEquals(6,this.d.getPulse());
    }
    @Test
    public void getVitalsTaken() {
        assertEquals(0,this.d.getVitalsTaken());
    }
}
