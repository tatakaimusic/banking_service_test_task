package com.example.banking_service_test_task.service.impl;

import com.example.banking_service_test_task.model.Account;
import com.example.banking_service_test_task.service.AccountService;
import com.example.banking_service_test_task.service.ScheduleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final AccountService accountService;

    @Autowired
    public ScheduleServiceImpl(AccountService accountService) {
        this.accountService = accountService;
    }

    @Scheduled(cron = "0 * * * * *")
    @Override
    public void increase() {
        log.info("Increase all user balance");
        List<Account> accounts = accountService.getAll();
        for (Account account : accounts) {
            double amount = Math.floor(account.getAmount() * 1.05);
            if (amount < account.getInitPayment() * 2.07) {
                Math.floor(amount);
                account.setAmount(amount);
                accountService.update(account);
            }
        }
    }

}
