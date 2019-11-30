package healthapp.utilities;

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

import com.auth0.jwt.JWT;


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
            if (pair.length == 2) {
                pairs.put(pair[0], pair[1]);
            }
        }
        return pairs;
    }

    private Map<String, String> _transact(String t) {
        try {
            http.setDoOutput(true);
            http.setDoInput(true);
            OutputStream os = http.getOutputStream();
            OutputStreamWriter out = new OutputStreamWriter(os);
            out.write(t); 
            out.flush();
            out.close();
            os.close();
            System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
            InputStream is = http.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(is));

            String line = in.readLine();
            String newTok = Token.checkJWT(line);
            String newInfo = newTok.replaceAll("[\\[\\]}{\"]", "");
            Map<String, String> pairs = !newInfo.equals("") ? splitToMap(newInfo) : splitToMap("account:created");
            return pairs;
        } catch (IOException e) {
            System.out.println(e);
            return null;
        }
    }

    public Map<String,String> send(Map<String, Object> p, String type, String ext) {
        try {
            String t = Token.createJWT(ext, p);
            url = new URL(apiURL + apiPort + ext);
            http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod(type);
            http.setRequestProperty("Content-Length", Integer.toString(t.length()));    
            System.out.println(t);
            Map<String, String> feedback = _transact(t);
            http.disconnect();
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