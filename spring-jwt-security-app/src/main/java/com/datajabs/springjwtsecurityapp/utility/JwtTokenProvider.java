package com.datajabs.springjwtsecurityapp.utility;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.datajabs.springjwtsecurityapp.constant.SecurityConstant;
import com.datajabs.springjwtsecurityapp.domain.UserPrincipal;
import org.springframework.beans.factory.annotation.Value;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;
import static com.datajabs.springjwtsecurityapp.constant.SecurityConstant.*;

import java.util.Date;

public class JwtTokenProvider {

    @Value("${jwt.secret}")
    private String secret;

    public String generateJwtToken(UserPrincipal userPrincipal) {
        String[] claims = getClaimsFromUser(userPrincipal);
        return JWT.create().withIssuer(DATAJABS_LLC).withAudience(DATAJABS_ADMINISTRATION)
                .withIssuedAt(new Date()).withSubject(userPrincipal.getUsername()).withArrayClaim(AUTHORITIES, claims)
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME)).sign(HMAC512(secret.getBytes()));

    }

    private String[] getClaimsFromUser(UserPrincipal userPrincipal) {
    }

}
