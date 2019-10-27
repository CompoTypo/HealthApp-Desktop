import java.util.Date;
import java.util.Map;

public class TestData {
    Map<String, String> results;
    private Date bpTaken;

    public Map<String, String> getResults() {
        return results;
    }

    public void setResults(Map<String, String> results) {
        this.results = results;
    }

    public Date getBpTaken() {
        return bpTaken;
    }

    public void setBpTaken(Date bpTaken) {
        this.bpTaken = bpTaken;
    }
}
