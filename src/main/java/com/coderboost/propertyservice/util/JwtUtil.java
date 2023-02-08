package com.coderboost.propertyservice.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Component
public class JwtUtil {

    //TODO: make the secret centralized for all services
    private final String secret = "coderBoost++"; //similar used in identity-service

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token);
            return true;
        } catch (SignatureException | MalformedJwtException | ExpiredJwtException | IllegalArgumentException |
                 UnsupportedJwtException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public String getEmailFromToken(String token) {
        String result = null;
        try {
            result = getAllClaimsFromToken(token)
                    .getSubject();
        } catch (ExpiredJwtException e) {
            System.out.println(e.getMessage());
            throw e;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public Collection<? extends GrantedAuthority> getAuthoritiesFromToken(String token) {
        Collection<? extends GrantedAuthority> authorities = Collections.emptyList();
        try {
            Claims claims = getAllClaimsFromToken(token);
            List<String> roles = (List<String>) claims.get("roles");
            authorities = roles.stream()
                    .map(SimpleGrantedAuthority::new).toList();
        } catch (ExpiredJwtException e) {
            System.out.println(e.getMessage());
            throw e;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return authorities;
    }
}
