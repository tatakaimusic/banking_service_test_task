package com.example.banking_service_test_task.service.impl;

import com.example.banking_service_test_task.model.Account;
import com.example.banking_service_test_task.model.User;
import com.example.banking_service_test_task.model.exception.InsufficientFundsException;
import com.example.banking_service_test_task.model.exception.ResourceNotFoundException;
import com.example.banking_service_test_task.model.exception.ResourceTakenException;
import com.example.banking_service_test_task.repository.UserRepository;
import com.example.banking_service_test_task.service.AccountService;
import com.example.banking_service_test_task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AccountService accountService;

    @Autowired
    public UserServiceImpl(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            AccountService accountService
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.accountService = accountService;
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

    @Transactional
    @Override
    public User create(User user, Account account) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new IllegalStateException("User with this username already exist!");
        }
        if (userRepository.getUserByEmail(user.getEmail()).isPresent()) {
            throw new IllegalStateException("User with this email already exist!");
        }
        if (userRepository.getUserByPhoneNumber(user.getPhoneNumber()).isPresent()) {
            throw new IllegalStateException("User with this phone number already exist!");
        }

        account.setInitPayment(account.getAmount());
        account = accountService.create(account);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User createdUser = userRepository.save(user);
        userRepository.assignAccount(createdUser.getId(), account.getId());
        return createdUser;
    }

    @Transactional
    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Transactional
    @Override
    public User updateEmail(Long id, String email) {
        if (emailExisted(email)) {
            throw new ResourceTakenException("This email already exist!");
        }
        User user = getById(id);
        user.setEmail(email);
        return userRepository.save(user);
    }

    @Transactional
    @Override
    public User updatePhoneNumber(Long id, String phoneNumber) {
        if (phoneNumberExisted(phoneNumber)) {
            throw new ResourceTakenException("This phone number already exist!");
        }
        User user = getById(id);
        user.setPhoneNumber(phoneNumber);
        return userRepository.save(user);
    }

    @Override
    public double getBalance(Long userId) {
        return userRepository.getBalanceByUserId(userId);
    }

    @Transactional
    @Override
    public void updateBalance(Long userId, double amount) {
        userRepository.updateBalanceByUserId(userId, amount);
    }

    @Transactional
    @Override
    public void transaction(Long fromId, Long toId, double amount) {
        double balanceFrom = getBalance(fromId);
        double balanceTo = getBalance(toId);
        if ((balanceFrom - amount) < 0) {
            throw new InsufficientFundsException();
        }
        updateBalance(fromId, balanceFrom - amount);
        updateBalance(toId, balanceTo + amount);
    }

    private boolean emailExisted(String email) {
        User user = userRepository.getUserByEmail(email)
                .orElse(null);
        if (user == null) {
            return false;
        }
        return true;
    }

    private boolean phoneNumberExisted(String phoneNumber) {
        User user = userRepository.getUserByPhoneNumber(phoneNumber)
                .orElse(null);
        if (user == null) {
            return false;
        }
        return true;
    }

}
