import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class DoctorDataTest {

    @Test
    void getDegree() {
        DoctorData d = new DoctorData();
        d.setDegree("Degree");
        assertEquals("Degree",d.getDegree());
    }

    @Test
    void getCredentials() {
        DoctorData d = new DoctorData();
        ArrayList<String> a = new ArrayList<>();
        a.add("A");
        a.add("B");
        d.setCredentials(a);
        assertEquals(a,d.getCredentials());
    }

    @Test
    void getSpecialty() {
        DoctorData d = new DoctorData();
        d.setSpecialty("Being a Doctor");
        assertEquals("Being a Doctor",d.getSpecialty());
    }

    @Test
    void getPatients() {
        DoctorData d = new DoctorData();
        ArrayList<PatientData> a = new ArrayList<>();
        a.add(new PatientData());
        a.add(new PatientData());
        d.setPatients(a);
        assertEquals(a,d.getPatients());
    }
}