package com.example.banking_service_test_task.service.impl;

import com.example.banking_service_test_task.model.User;
import com.example.banking_service_test_task.model.exception.ResourceNotFoundException;
import com.example.banking_service_test_task.repository.UserRepository;
import com.example.banking_service_test_task.service.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class SearchServiceImpl implements SearchService {

    private final UserRepository userRepository;

    @Autowired
    public SearchServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> filterByBirth(Date birth) {
        log.info("Filter users by birth: " + birth);
        return userRepository.filterUsersByBirth(birth);
    }

    @Override
    public User filterByPhoneNumber(String phoneNumber) {
        log.info("Filter users by phone number: " + phoneNumber);
        return userRepository.getUserByPhoneNumber(phoneNumber)
                .orElseThrow(
                        () -> new ResourceNotFoundException(
                                "User with this phone number doesnt exist!"
                        )
                );
    }

    @Override
    public List<User> filterByName(String name) {
        log.info("Filter users by name: " + name);
        return userRepository.filterByUserName(name + "%");
    }

    @Override
    public User filterByEmail(String email) {
        log.info("Filter users by email: " + email);
        return userRepository.getUserByEmail(email)
                .orElseThrow(
                        () -> new ResourceNotFoundException(
                                "User with this email doesnt exist!"
                        )
                );
    }

}
