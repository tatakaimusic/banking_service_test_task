package com.example.banking_service_test_task.service.impl;

import com.example.banking_service_test_task.model.User;
import com.example.banking_service_test_task.model.exception.ResourceNotFoundException;
import com.example.banking_service_test_task.repository.UserRepository;
import com.example.banking_service_test_task.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    private final UserRepository userRepository;

    @Autowired
    public SearchServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> filterByBirth(Date birth) {
        return userRepository.filterUsersByBirth(birth);
    }

    @Override
    public User filterByPhoneNumber(String phoneNumber) {
        return userRepository.getUserByPhoneNumber(phoneNumber)
                .orElseThrow(
                        () -> new ResourceNotFoundException(
                                "User with this phone number doesnt exist!"
                        )
                );
    }

    @Override
    public List<User> filterByName(String name) {
        return userRepository.filterByUserName(name + "%");
    }

    @Override
    public User filterByEmail(String email) {
        return userRepository.getUserByEmail(email)
                .orElseThrow(
                        () -> new ResourceNotFoundException(
                                "User with this email doesnt exist!"
                        )
                );
    }

}
