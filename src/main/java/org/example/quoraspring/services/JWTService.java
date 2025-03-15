package org.example.quoraspring.services;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.example.quoraspring.models.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

@Service
public class JWTService {

    @Value("${jwt.expiry}")
    private int expiry;

    @Value("${jwt.SECRET}")
    private String SECRET;

    private String createToken(Map<String, Object> claims, String subject) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expiry*1000L);
        SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes());

        return Jwts.builder()
                .claims(claims)
                .subject(subject)
                .expiration(expiryDate)
                .issuedAt(new Date())
                .signWith(key)
                .compact();
    }
}
