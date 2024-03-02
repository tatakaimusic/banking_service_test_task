package com.example.banking_service_test_task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableScheduling
public class BankingServiceTestTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankingServiceTestTaskApplication.class, args);
    }

}
