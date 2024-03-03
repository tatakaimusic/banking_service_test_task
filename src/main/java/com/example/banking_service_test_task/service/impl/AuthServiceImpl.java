package com.example.banking_service_test_task.service.impl;

import com.example.banking_service_test_task.model.User;
import com.example.banking_service_test_task.service.AuthService;
import com.example.banking_service_test_task.service.UserService;
import com.example.banking_service_test_task.web.dto.auth.JwtRequest;
import com.example.banking_service_test_task.web.dto.auth.JwtResponse;
import com.example.banking_service_test_task.web.security.JwtTokenProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public AuthServiceImpl(
            AuthenticationManager authenticationManager,
            UserService userService,
            JwtTokenProvider jwtTokenProvider
    ) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public JwtResponse login(JwtRequest loginRequest) {
        log.info("Login user with username: " + loginRequest.getUsername());
        JwtResponse jwtResponse = new JwtResponse();
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
        User user = userService.getByUsername(loginRequest.getUsername());
        jwtResponse.setId(user.getId());
        jwtResponse.setUsername(user.getUsername());
        jwtResponse.setAccessToken(
                jwtTokenProvider.createAccessToken(
                        user.getId(), user.getUsername()
                )
        );
        jwtResponse.setRefreshToken(
                jwtTokenProvider.createRefreshToken(
                        user.getId(), user.getUsername()
                )
        );
        return jwtResponse;
    }

    @Override
    public JwtResponse refresh(String refreshToken) {
        log.info("Refresh tokens by refresh token: " + refreshToken);
        return jwtTokenProvider.refreshUserTokens(refreshToken);
    }

}
