import java.util.HashMap;
import java.util.Map;
import java.nio.charset.StandardCharsets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class Requests {
    private static final String apiURL = "http://127.0.0.1";
    private static final String apiPort = ":8000";
    private URL url;
    private HttpURLConnection http;


    private Map<String,String> splitToMap(String l) {
        Map<String, String> pairs = new HashMap<>();
        String[] rawPairs = l.split(",");
        for (String rawPair : rawPairs)  {
            String[] pair = rawPair.split(":");
            pairs.put(pair[0], pair[1]);
        }
        return pairs;
    }

    private Map<String, String> _transact(String parms) {
        try {
            http.setDoOutput(true);
            OutputStream os = http.getOutputStream();
            OutputStreamWriter out = new OutputStreamWriter(os);
            out.write(parms); 
            out.flush();
            out.close();
            os.close();
            System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
            this.http.setDoInput(true);
            InputStream is = http.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(is));
            String line = in.readLine().replaceAll("[}{]", "");
            Map<String, String> pairs = splitToMap(line);
            return pairs;
        } catch (IOException e) {
            System.out.println(e);
            return null;
        }
    }

    public Map<String,String> send(Map<String, String> p, String type, String ext) {

        byte[] params = p.toString().getBytes(StandardCharsets.UTF_8);
        try {
            url = new URL(apiURL + apiPort + ext);
            this.http = (HttpURLConnection) url.openConnection();
            this.http.setRequestMethod(type);
            this.http.setRequestProperty("Content-Length", Integer.toString(params.length));    
            Map<String, String> feedback = _transact(p.toString());
            return feedback;
        } catch (MalformedURLException e) {
            System.out.println(e);
            return null;
        } catch (ProtocolException e) {
            System.out.println(e);
            return null;
        } catch (IOException e) {
            System.out.println(e);
            return null;
        }
    }
    
}