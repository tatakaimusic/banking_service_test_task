package com.example.banking_service_test_task.service;

import com.example.banking_service_test_task.model.User;

public interface UserService {

    User getByUsername(String username);

    User getById(Long id);

}
