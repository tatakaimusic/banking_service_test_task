package com.example.banking_service_test_task.service;

import com.example.banking_service_test_task.model.Account;

import java.util.List;

public interface AccountService {

    Account create(Account account);

    List<Account> getAll();

    Account update(Account account);

}
