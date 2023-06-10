package com.devmura.security;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

public class TokenJwtConfig {
    
    // public final static String SECRET_KEY = "algun_token_con_alguna_frase_secreta";
    public final static Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    public final static String PREFIX_TOKEN = "Bearer ";
    public final static String HEADER_AUTHORIZATION = "Authorization";

}
