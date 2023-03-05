package com.example.demoSecurityWeb.config.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {

    @Value("${jwt_secret}")
    private String secret;


    public String generateToken(String username) {

        return JWT.create().withSubject("User Details").withClaim("username", username).withIssuedAt(new Date()).withIssuer("Event Scheduler").sign(Algorithm.HMAC256(secret));


    }

    public String validateTokenAndRetieveSubject(String token) {
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(secret)).withSubject("User Details").withIssuer("Event Scheduler").build();

        DecodedJWT jwt = jwtVerifier.verify(token);
        return jwt.getClaim("username").asString();
    }

}

