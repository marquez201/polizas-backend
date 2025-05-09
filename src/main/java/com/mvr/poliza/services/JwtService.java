package com.mvr.poliza.services;

import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;

import com.mvr.poliza.entitys.UserEntity;

import io.jsonwebtoken.Claims;

public interface JwtService {

    public String getToken(UserEntity userEntity);
    public String getUsernameFromToken(String token);
    public boolean isTokenValid(String token, UserDetails userDetails);
    public <T> T getClaim(String token, Function<Claims, T> claimsResolver);
    
}
