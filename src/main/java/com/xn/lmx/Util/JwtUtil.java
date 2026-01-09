package com.xn.lmx.Util;

import io.jsonwebtoken.*;
import java.util.Date;

public class JwtUtil {

    private static final String SECRET_KEY = "LMXSecretKey123456";
    private static final long EXPIRATION = 1000 * 60 * 60 * 24; // 24小时

    public static String generateToken(Long userId) {
        return Jwts.builder()
                .setSubject(userId.toString())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public static Long parseToken(String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token)
                    .getBody();
            return Long.parseLong(claims.getSubject());
        } catch (Exception e) {
            throw new RuntimeException("Invalid token");
        }
    }
}
