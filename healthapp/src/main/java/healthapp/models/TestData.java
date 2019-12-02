package healthapp.models;

import java.util.Date;
import java.util.Map;

/**
 * TestData stores the data for a test
 */
public class TestData {
    Map<String, String> results;
    private Date testTaken;
    /**
     * Constructs a TestData given results and test
     * @param r the results
     * @param d the test
     */
    public TestData(Map<String, String> r, Date d) {
        this.results = r;
        this.testTaken = d;
    }
    /**
     * Returns the results
     * @return the results
     */
    public Map<String, String> getResults() {
        return this.results;
    }
    /**
     * Sets the results given results
     * @param results the results
     */
    public void setResults(Map<String, String> results) {
        this.results = results;
    }
    /**
     * Returns the blood pressure
     * @return the blood pressure
     */
    public Date getBpTaken() {
        return this.testTaken;
    }
}
