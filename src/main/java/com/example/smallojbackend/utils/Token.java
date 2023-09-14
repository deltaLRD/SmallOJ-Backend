package com.example.smallojbackend.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.security.interfaces.RSAKey;
import java.util.Date;

@Service
public class Token {
    private final String key = "SomeRandomChars";
    private final long ExpireTime = 15 * 60 * 1000;
    public String createToken(String userId) {
        try {
            Date date = new Date(System.currentTimeMillis() + ExpireTime);
            Algorithm algorithm = Algorithm.HMAC256(key);
            return JWT.create()
                    .withClaim("uid", userId)
                    .withExpiresAt(date)
                    .sign(algorithm);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
