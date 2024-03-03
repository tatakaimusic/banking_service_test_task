package com.example.banking_service_test_task.web.security.expression;

import com.example.banking_service_test_task.service.UserService;
import com.example.banking_service_test_task.web.security.JwtEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service("customSecurityExpression")
public class CustomSecurityExpression {

    private final UserService userService;

    @Autowired
    public CustomSecurityExpression(UserService userService) {
        this.userService = userService;
    }

    public boolean canAccessUser(Long id) {
        Authentication authentication = SecurityContextHolder
                .getContext().getAuthentication();
        JwtEntity user = (JwtEntity) authentication.getPrincipal();
        Long userId = user.getId();

        return userId.equals(id);
    }

}
