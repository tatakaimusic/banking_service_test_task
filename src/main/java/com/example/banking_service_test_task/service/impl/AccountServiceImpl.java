package com.example.banking_service_test_task.service.impl;

import com.example.banking_service_test_task.model.Account;
import com.example.banking_service_test_task.repository.AccountRepository;
import com.example.banking_service_test_task.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account create(Account account) {
        log.info("Create account with amount" + account.getAmount());
        return accountRepository.save(account);
    }

    @Override
    public List<Account> getAll() {
        log.info("Get all accounts");
        return accountRepository.findAll();
    }

    @Override
    public Account update(Account account) {
        log.info("Update account with id: " + account.getId());
        return accountRepository.save(account);
    }

}
