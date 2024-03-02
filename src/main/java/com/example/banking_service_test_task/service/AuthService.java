package com.example.banking_service_test_task.service;

import com.example.banking_service_test_task.web.dto.auth.JwtRequest;
import com.example.banking_service_test_task.web.dto.auth.JwtResponse;

public interface AuthService {

    JwtResponse login(JwtRequest jwtRequest);

    JwtResponse refresh(String refreshToken);

}
