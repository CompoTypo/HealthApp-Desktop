package healthapp.models;

import java.util.Date;
import java.util.Map;

public class TestData {
    Map<String, String> results;
    private Date testTaken;

    public TestData(Map<String, String> r, Date d) {
        this.results = r;
        this.testTaken = d;
    }

    public Map<String, String> getResults() {
        return this.results;
    }

    public void setResults(Map<String, String> results) {
        this.results = results;
    }

    public Date getBpTaken() {
        return this.testTaken;
    }
}
