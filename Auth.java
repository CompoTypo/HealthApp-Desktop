import java.util.HashMap;
import java.util.Map;
import java.util.regex.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

public class Auth {
    private static final String apiURL = "http://127.0.0.1";
    private static final String apiPort = ":8000";

    private boolean checkForSemi(String w) {
        Pattern p = Pattern.compile(";");
        Matcher m = p.matcher(w);
        return m.matches();
    }

    private Map<String,String> splitToMap(String l) {
        Map<String, String> pairs = new HashMap<>();
        String[] rawPairs = l.split(",");
        for (String rawPair : rawPairs)  {
            String[] pair = rawPair.split(":");
            pairs.put(pair[0], pair[1]);
        }
        return pairs;
    }

    private Map<String,String> verifyUser(Map<String, String> p) {
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

    private String hashPassword(String w) throws NoSuchAlgorithmException {
        final MessageDigest digest = MessageDigest.getInstance("SHA-256");
        final byte[] hashbytes = digest.digest(w.getBytes(StandardCharsets.UTF_8));
        return bytesToHex(hashbytes);
    }

    private String bytesToHex(byte[] hash) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public Map<String,String> Authenticate(String u, String p) {
        if (checkForSemi(u) && checkForSemi(p)) {
            System.out.println("Semicolon found. deny access!");
            return null;
        }

        try {
            String h = hashPassword(p);
            Map<String, String> params = new HashMap<>();
            params.put("Uname", u);
            params.put("Hash", h);
            Map<String, String> user = verifyUser(params);
            return user;
        } catch (NoSuchAlgorithmException e) {
            System.out.println("NoSuchAlgorithmException: check dependencies jdk8+");
        }
        return null;
    }
}