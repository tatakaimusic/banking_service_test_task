package com.example.banking_service_test_task.service;

import com.example.banking_service_test_task.model.User;

import java.util.Date;
import java.util.List;

public interface SearchService {

    List<User> filterByBirth(Date birth);

    User filterByPhoneNumber(String phoneNumber);

    List<User> filterByName(String name);

    User filterByEmail(String email);

}
