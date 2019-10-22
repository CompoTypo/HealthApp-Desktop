import static org.junit.Assert.*;

import org.junit.Test;

public class UserTest {
	
	@Test
	public void testDefaults() {
		User usr = new User();
		assertTrue(usr.getAge() == -1);
		assertEquals(usr.getFirstname(),"");
		assertEquals(usr.getLastname(),"");
	}
	
	@Test
	public void testGetSet() {
		User usr = new User();
		usr.setFirstname("Test");
		assertEquals(usr.getFirstname(),"Test");
		usr.setLastname("TestL");
		assertEquals(usr.getLastname(),"TestL");
	}

}
