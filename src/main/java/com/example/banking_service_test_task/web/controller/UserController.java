package com.example.banking_service_test_task.web.controller;

import com.example.banking_service_test_task.model.User;
import com.example.banking_service_test_task.service.UserService;
import com.example.banking_service_test_task.web.dto.UserDTO;
import com.example.banking_service_test_task.web.mapper.UserMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app")
@Validated
@Tag(name = "User controller")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PreAuthorize("@customSecurityExpression.canAccessUser(#id)")
    @PutMapping("/{id}/update/email")
    public UserDTO updateEmailByUserId(
            @PathVariable Long id,
            @RequestParam(value = "email") @Email String email
    ) {
        User user = userService.updateEmail(id, email);
        return userMapper.toDto(user);
    }

    @PreAuthorize("@customSecurityExpression.canAccessUser(#id)")
    @PutMapping("/{id}/update/phone")
    public UserDTO updatePhoneNumberByUserId(
            @PathVariable Long id,
            @RequestParam(value = "phone")
            @Pattern(
                    regexp = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$"
            ) String phoneNumber
    ) {
        User user = userService.updatePhoneNumber(id, phoneNumber);
        return userMapper.toDto(user);
    }

    @PreAuthorize("@customSecurityExpression.canAccessUser(#fromId)")
    @PostMapping("/{fromId}/{toId}/transaction")
    public void transaction(
            @PathVariable Long fromId,
            @PathVariable Long toId,
            @RequestParam(value = "amount") double amount
    ) {
        userService.transaction(fromId, toId, amount);
    }

    @PreAuthorize("@customSecurityExpression.canAccessUser(#id)")
    @GetMapping("/{id}/balance")
    public double getBalance(@PathVariable Long id) {
        return userService.getBalance(id);
    }

}
