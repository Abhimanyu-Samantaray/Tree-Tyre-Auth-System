package com.Three_Tyre_Auth_System.User.Service;

import com.Three_Tyre_Auth_System.User.DTO.UserResponse;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.print.DocFlavor;
import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }

    public String generateToken(long userId, String username, String userRole) {
        return Jwts.builder()
                .subject(username)
                .claim("id", userId)
                .claim("role", userRole)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSigningKey())
                .compact();
    }

     private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith((SecretKey) getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public String extractUsername(String token) {

        return extractAllClaims(token).getSubject();

    }

    public Long extractUserId(String token) {

        return extractAllClaims(token).get("id", Long.class);

    }

    public String extractUserRole(String token) {

        return extractAllClaims(token).get("role", String.class);

    }

    public boolean isTokenValid(String token, UserResponse userResponse) {
        final String username = extractUsername(token);

        return username.equals(userResponse.getEmail()) && !checkTokenExpiry(token);
    }

    private boolean checkTokenExpiry(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
}
