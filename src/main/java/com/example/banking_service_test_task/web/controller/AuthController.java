package com.example.banking_service_test_task.web.controller;

import com.example.banking_service_test_task.model.Account;
import com.example.banking_service_test_task.model.User;
import com.example.banking_service_test_task.service.AuthService;
import com.example.banking_service_test_task.service.UserService;
import com.example.banking_service_test_task.web.dto.UserDTO;
import com.example.banking_service_test_task.web.dto.auth.JwtRequest;
import com.example.banking_service_test_task.web.dto.auth.JwtResponse;
import com.example.banking_service_test_task.web.dto.validation.OnCreate;
import com.example.banking_service_test_task.web.mapper.AccountMapper;
import com.example.banking_service_test_task.web.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/auth")
@Validated
public class AuthController {

    private final AuthService authService;
    private final UserService userService;
    private final UserMapper userMapper;
    private final AccountMapper accountMapper;

    @Autowired
    public AuthController(
            AuthService authService,
            UserService userService,
            UserMapper userMapper,
            AccountMapper accountMapper
    ) {
        this.authService = authService;
        this.userService = userService;
        this.userMapper = userMapper;
        this.accountMapper = accountMapper;
    }

    @PostMapping("/login")
    public JwtResponse login(@Validated @RequestBody JwtRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @PostMapping("/register")
    public UserDTO register(
            @Validated(OnCreate.class) @RequestBody UserDTO dto
    ) {
        User user = userMapper.toEntity(dto);
        Account account = new Account(dto.getAmount());
        User createdUser = userService.create(user, account);
        UserDTO userDTO = userMapper.toDto(createdUser);
        userDTO.setAmount(dto.getAmount());
        return userDTO;
    }

    @PostMapping("/refresh")
    public JwtResponse refresh(String refreshToken) {
        return authService.refresh(refreshToken);
    }
}
