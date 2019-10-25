import static org.junit.Assert.*;

import org.junit.Test;

public class DoctorTest {

	@Test
	public void testDefaults() {
		Doctor d = new Doctor();
		assertTrue(d.getNumPatients() == 0);
		assertEquals(d.getSpecialist(), "");
	}
	
	@Test
	public void testGetSet() {
		Doctor d = new Doctor();
		Patient p = new Patient();
		assertTrue(d.getNumPatients() == 0);
		d.addPatient(p);
		assertTrue(d.getNumPatients() == 1);
	}
	
	@Test
	public void testPatients() {
		Doctor d = new Doctor();
		Patient p = new Patient();
		d.addPatient(p);
		assertTrue(d.getPatientList().get(0).getAge() == -1);
	}
	

}
