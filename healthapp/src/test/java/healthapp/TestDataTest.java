package healthapp;

import healthapp.models.TestData;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import org.junit.*;
import static org.junit.Assert.*;
//import org.junit.jupiter.api.Test;
import java.util.ArrayList;
//import static org.junit.jupiter.api.Assertions.*;

public class TestDataTest {
    private TestData d;
    private Date date;
    public TestDataTest() {
        Map<String,String> m = new HashMap<>();
        date = new Date();
        this.d = new TestData(m,date);
    }

    @Test
    public void getResults() {
        Map<String,String> m = new HashMap<>();
        this.d.setResults(m);
        assertEquals(m,this.d.getResults());
    }
    @Test
    public void getBpTaken() {
        assertEquals(date,this.d.getBpTaken());
    }

}
