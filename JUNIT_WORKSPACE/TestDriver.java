import static org.junit.Assert;

public class TestDriver {

    @Test
    public static void testDoctor() {
        Doctor test = new Doctor();

        Assert.assertEquals(0, test.getSpecialist());
    }
}  	