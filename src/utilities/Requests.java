import java.util.HashMap;
import java.util.Map;
import java.nio.charset.StandardCharsets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Requests {
    private static final String apiURL = "http://127.0.0.1";
    private static final String apiPort = ":8000";

    private Map<String,String> splitToMap(String l) {
        Map<String, String> pairs = new HashMap<>();
        String[] rawPairs = l.split(",");
        for (String rawPair : rawPairs)  {
            String[] pair = rawPair.split(":");
            pairs.put(pair[0], pair[1]);
        }
        return pairs;
    }

    public Map<String,String> put(Map<String, String> p) {
        byte[] params = p.toString().getBytes(StandardCharsets.UTF_8);
        try {
            URL url = new URL(apiURL + apiPort + "/login");
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setDoInput(true);
            http.setDoOutput(true);
            http.setRequestMethod("PUT");
            http.setRequestProperty("Content-Length", Integer.toString(params.length));
            OutputStream os = http.getOutputStream();
            OutputStreamWriter out = new OutputStreamWriter(os);
            out.write(p.toString());
            out.flush();
            out.close();
            os.close();
            System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
            InputStream is = http.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(is));
            String line = in.readLine().replaceAll("[}{]", "");
            Map<String, String> pairs = splitToMap(line);
            return pairs;
        } catch (MalformedURLException e) {
            System.out.println(e);
            return null;
        } catch (IOException e) {
            System.out.println(e);
            return null;
        }
    }

    public Map<String,String> post(Map<String, String> p) {
        byte[] params = p.toString().getBytes(StandardCharsets.UTF_8);
        try {
            URL url = new URL(apiURL + apiPort + "/register");
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setDoInput(true);
            http.setDoOutput(true);
            http.setRequestMethod("POST");
            http.setRequestProperty("Content-Length", Integer.toString(params.length));
            OutputStream os = http.getOutputStream();
            OutputStreamWriter out = new OutputStreamWriter(os);
            out.write(p.toString());
            out.flush();
            out.close();
            os.close();
            System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
            InputStream is = http.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(is));
            String line = in.readLine().replaceAll("[}{]", "");
            Map<String, String> pairs = splitToMap(line);
            return pairs;
        } catch (MalformedURLException e) {
            System.out.println(e);
            return null;
        } catch (IOException e) {
            System.out.println(e);
            return null;
        }
    }
    
}