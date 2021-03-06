package healthapp.utilities;
import healthapp.models.UserData;

import java.util.HashMap;
import java.util.Map;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;


/**
 *  Auth Authorizes the User, it is the starting point for the data request
 */
public class Auth {
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
    /**
     * Hashes and sends usernames passwords given a username and password
     * @param u the username
     * @param p the password
     * @return a user as a Map
     */
    public Map<String,String> Authenticate(String u, String p) {
        try {
            String uh = hashPassword(u);
            String ph = hashPassword(p);
            System.out.println(uh + ":" + ph);
            Map<String, Object> params = new HashMap<>();
            params.put("Uname", uh);
            params.put("Hash", ph);
            Map<String, String> user = Requests.send(params, "PUT", "/login");
            if (user == null) { return new HashMap<>(); } 
            else { return user; }
        } catch (NoSuchAlgorithmException e) {
            System.out.println("NoSuchAlgorithmException: check dependencies jdk8+");
        }
        return null;
    }
    /**
     * Resgisters a user given a Userdata and String
     * @param newUser the user data
     * @param p the password
     */
    public void Register(UserData newUser, String p) {
        try {
            Map<String, Object> params = new HashMap<>();
            String u = hashPassword(newUser.getUname());
            String h = hashPassword(p);
            params.put("Fname", newUser.getFirstname());
            params.put("Lname", newUser.getLastname());
            params.put("Uname", u);
            params.put("Email", newUser.getEmail());
            params.put("Hash", h);
            params.put("DOB", newUser.getDob().toString());
            params.put("Sex", newUser.getSex());
            params.put("Race", newUser.getRace());
            params.put("Type", newUser.getAcctType());
            Map<String, String> user = Requests.send(params, "POST", "/register");
        } catch (NoSuchAlgorithmException e) {
            System.out.println("NoSuchAlgorithmException: check dependencies jdk8+");
        }
    }
}