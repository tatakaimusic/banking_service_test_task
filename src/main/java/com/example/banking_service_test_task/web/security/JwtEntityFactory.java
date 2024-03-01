package com.example.banking_service_test_task.web.security;

import com.example.banking_service_test_task.model.User;

public class JwtEntityFactory {

    public static JwtEntity create(User user) {
        return new JwtEntity(user.getId(), user.getUsername(), user.getPassword());
    }

}
