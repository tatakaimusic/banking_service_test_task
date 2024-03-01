package com.example.banking_service_test_task.service.impl;

import com.example.banking_service_test_task.model.User;
import com.example.banking_service_test_task.model.exception.ResourceNotFoundException;
import com.example.banking_service_test_task.repository.UserRepository;
import com.example.banking_service_test_task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(
                        () -> new ResourceNotFoundException(
                                "User with this username was not found!"
                        )
                );
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException(
                                "User with this id was not found!"
                        )
                );
    }

}
