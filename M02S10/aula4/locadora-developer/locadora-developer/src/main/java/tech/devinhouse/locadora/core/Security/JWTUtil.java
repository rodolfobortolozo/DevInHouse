package tech.devinhouse.locadora.core.Security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtil {

  @Value("${jwt_secret}")
  private String secret;

  public String generateToken(String email) throws IllegalArgumentException, JWTCreationException {
    return JWT.create()
            .withIssuer("Rodolfo R Bortolozo")
            .withSubject("User Details")
            .withIssuedAt(new Date())
            .withClaim("email", email)
            .sign(Algorithm.HMAC256(secret));
  }

  public String validateTokenAndRetrieveSubject(String token)throws JWTVerificationException {
    JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret))
            .withIssuer("Rodolfo R Bortolozo")
            .withSubject("User Details")
            .build();
    DecodedJWT jwt = verifier.verify(token);
    return jwt.getClaim("email").asString();
  }
}
