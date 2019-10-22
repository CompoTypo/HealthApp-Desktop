import static org.junit.Assert.*;

import org.junit.Test;

public class PatientTest {

	@Test
	public void testDefaults() {
		Patient p = new Patient();
		assertTrue(p.getHeight() == -1);
		assertEquals(p.getSex(),"");
		assertEquals(p.getRace(),"");
	}
	
	@Test
	public void testGetSet() {
		Patient p = new Patient("Test", "Tester", "UN", 20, 66, 150, "Male", "Regular");
		assertTrue(p.getHeight() == 66);
		assertTrue(p.getBodyMassIndex() > 24.207 && p.getBodyMassIndex() < 24.208 );
		assertEquals(p.getSex(),"Male");
	}
	
	@Test
	public void testBMI() {
		Patient p = new Patient("Test", "Tester", "UN", 20, 66, 150, "Male", "Regular");
		assertTrue(p.getHeight() == 66);
		assertTrue(p.getBodyMassIndex() > 24.207 && p.getBodyMassIndex() < 24.208 );
		p.setHeight(70);
		assertTrue(p.getBodyMassIndex() > 21.520 && p.getBodyMassIndex() < 24.521 );
		p.setWeight(200);
		assertTrue(p.getBodyMassIndex() > 28.693 && p.getBodyMassIndex() < 28.694 );
	}

}
