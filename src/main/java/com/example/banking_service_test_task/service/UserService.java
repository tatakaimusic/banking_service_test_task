package com.example.banking_service_test_task.service;

import com.example.banking_service_test_task.model.Account;
import com.example.banking_service_test_task.model.User;

public interface UserService {

    User getByUsername(String username);

    User getById(Long id);

    User create(User user, Account account);

    User update(User user);

    User updateEmail(Long id, String email);

    User updatePhoneNumber(Long id, String phoneNumber);

    void transaction(Long fromId, Long toId, double amount);

    double getBalance(Long userId);

    void updateBalance(Long userId, double amount);

}
