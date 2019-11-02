import java.util.HashMap;
import java.util.Map;
import java.util.regex.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.nio.charset.StandardCharsets;



public class Auth {
    private Requests req = new Requests();

    private boolean checkForSemi(String w) { 
        Matcher m = Pattern.compile(";").matcher(w);
        return m.matches();
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
        try {
            String uh = hashPassword(u);
            String ph = hashPassword(p);
            Map<String, String> params = new HashMap<>();
            params.put("Uname", uh);
            params.put("Hash", ph);
            Map<String, String> user = req.put(params);
            if (user == null) { return new HashMap<>(); } 
            else { return user; }
        } catch (NoSuchAlgorithmException e) {
            System.out.println("NoSuchAlgorithmException: check dependencies jdk8+");
        }
        return null;
    }

    public void Register(UserData newUser, String p) {
        try {
            System.out.println("butts");
            String u = hashPassword(newUser.getUname());
            String h = hashPassword(p);
            Map<String, String> params = new HashMap<>();
            params.put("Fname", newUser.getFirstname());
            params.put("Lname", newUser.getLastname());
            params.put("Uname", u);
            params.put("Email", newUser.getEmail());
            params.put("Hash", h);
            params.put("DOB", newUser.getDob().toString());
            params.put("Sex", newUser.getSex());
            params.put("Race", newUser.getRace());
            params.put("Type", newUser.getAcctType());
            System.out.println("butts");

            Map<String, String> user = req.post(params);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("NoSuchAlgorithmException: check dependencies jdk8+");
        }
    }
}