package com.example.MusicApplication.user.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class TokenUtil {

    public String jwt(Long userId) {

        com.auth0.jwt.algorithms.Algorithm algorithm = com.auth0.jwt.algorithms.Algorithm.HMAC512("secret");
        String token = JWT.create()
                .withIssuer("auth0")
                .withSubject(String.valueOf(userId))
                .sign(algorithm);

        return token;
    }

    public Long verifyJwt(String token){

        com.auth0.jwt.algorithms.Algorithm algorithm = Algorithm.HMAC512("secret");

        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("auth0")
                .build();

        DecodedJWT jwt = verifier.verify(token);
        Long subject = Long.valueOf(jwt.getSubject());

        return subject;
    }
}
