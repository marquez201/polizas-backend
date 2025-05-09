package com.mvr.poliza.services;

import com.mvr.poliza.dtos.request.LoginRequest;
import com.mvr.poliza.dtos.request.RegisterRequest;
import com.mvr.poliza.dtos.response.AuthResponse;

public interface AuthService {
    public AuthResponse login(LoginRequest loginRequest);
    public AuthResponse register(RegisterRequest registerRequest);
}
