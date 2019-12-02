package healthapp;

import healthapp.models.DoctorData;
import healthapp.models.PatientData;

import org.junit.*;
import static org.junit.Assert.*;
//import org.junit.jupiter.api.Test;
import java.util.ArrayList;
//import static org.junit.jupiter.api.Assertions.*;

public class DoctorDataTest {
    private DoctorData d;

    public DoctorDataTest() {
        this.d = new DoctorData();
    }

    @Test
    public void getDegree() {
        this.d.setDegree("Degree");
        assertEquals("Degree",this.d.getDegree());
    }

    @Test
    public void getCredentials() {
        ArrayList<String> a = new ArrayList<>();
        a.add("A");
        a.add("B");
        this.d.setCredentials(a);
        assertEquals(a,this.d.getCredentials());
    }

    @Test
    public void getSpecialty() {
        this.d.setSpecialty("Being a Doctor");
        assertEquals("Being a Doctor",this.d.getSpecialty());
    }

    @Test
    public void getPatients() {
        ArrayList<PatientData> a = new ArrayList<>();
        a.add(new PatientData());
        a.add(new PatientData());
        this.d.setPatients(a);
        assertEquals(a,this.d.getPatients());
    }
}