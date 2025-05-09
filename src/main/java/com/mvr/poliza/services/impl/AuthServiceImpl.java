package com.mvr.poliza.services.impl;

import java.util.UUID;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mvr.poliza.dtos.request.LoginRequest;
import com.mvr.poliza.dtos.request.RegisterRequest;
import com.mvr.poliza.dtos.response.AuthResponse;
import com.mvr.poliza.dtos.response.Meta;
import com.mvr.poliza.entitys.UserEntity;
import com.mvr.poliza.repositorys.UserRepository;
import com.mvr.poliza.services.AuthService;
import com.mvr.poliza.utils.ResponseMessage;
import com.mvr.poliza.utils.Role;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    final UserRepository userRepository;
    final JwtServiceImpl jwtServiceImpl;
    final PasswordEncoder passwordEncoder;
    final AuthenticationManager authenticationManager;

    UUID id = UUID.randomUUID();
    Meta meta = new Meta(id.toString(), ResponseMessage.MESSAGE_OK.getMsgInformativo());

    @Override
    public AuthResponse login(LoginRequest loginRequest) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getKey())
        );
        UserEntity userEntity = userRepository.findByUsername(loginRequest.getUsername()).orElseThrow();
        String token = jwtServiceImpl.getToken(userEntity);
        return new AuthResponse(token, meta);
    }

    @Override
    public AuthResponse register(RegisterRequest registerRequest) {
        var role = (registerRequest.isRole()) ? Role.ADMIN : Role.USER;
        UserEntity userEntity = UserEntity.builder()
            .username(registerRequest.getUsername())
            .password(passwordEncoder.encode(registerRequest.getKey()))
            .role(role)
            .build();
        userRepository.save(userEntity);
        return new AuthResponse(jwtServiceImpl.getToken(userEntity), meta);
    }

}
