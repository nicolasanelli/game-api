package br.com.nicolasanelli.game.config.jwt;

import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

import javax.crypto.SecretKey;

@Configuration
public class JwtConfig {

    @Value("${security.jwt.secretKey}")
    private String secretKey;
    @Value("${security.jwt.tokenPrefix}")
    private String tokenPrefix;
    @Value("${security.jwt.expirationAfterDays}")
    private Integer expirationAfterDays;

    public SecretKey secretKey() {
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    public String getTokenPrefix() {
        return tokenPrefix;
    }

    public Integer getExpirationAfterDays() {
        return expirationAfterDays;
    }

    public String getAuthorizationHeader() {
        return HttpHeaders.AUTHORIZATION;
    }
}
