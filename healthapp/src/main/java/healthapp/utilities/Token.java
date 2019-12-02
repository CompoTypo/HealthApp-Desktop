package healthapp.utilities;

import java.io.UnsupportedEncodingException;
import java.time.Instant;
import java.util.Date;
import java.util.Map;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

/**
 * token
 */
public class Token {
    private static String savedToken;
    private static final String secret = "secret";

    public static String createJWT(String subject, Map<String, Object> body) {
        String token = "";
        try {
            Algorithm alg = Algorithm.HMAC256(secret);
            token = JWT.create()
                .withIssuer("DesktopAppUse")
                .withExpiresAt(Date.from(Instant.now().plusMillis((30 * 60000))))
                .withClaim("info", body.toString())
                .withSubject(subject)
                .sign(alg);
            return token;

        } catch (JWTCreationException e) {
            System.out.println("Invalid Signing configuration / Couldn't convert Claims.");
        } catch (UnsupportedEncodingException e) {
            System.out.println(e);
        }
        return token;
    }


    public static String checkJWT(String t) {
        try {
            Algorithm alg = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(alg)
                .withIssuer("server")
                .build();
            DecodedJWT tok = verifier.verify(t);
            savedToken = t;
            return tok.getClaim("info").asString();

        } catch (UnsupportedEncodingException e) {
            System.out.println(e);
        } catch (JWTVerificationException e) {
            System.out.println("Butts" + e);
        }
        return "";
    }
}