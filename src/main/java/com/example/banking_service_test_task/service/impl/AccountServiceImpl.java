package com.example.banking_service_test_task.service.impl;

import com.example.banking_service_test_task.model.Account;
import com.example.banking_service_test_task.repository.AccountRepository;
import com.example.banking_service_test_task.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account create(Account account) {
        return accountRepository.save(account);
    }

}
