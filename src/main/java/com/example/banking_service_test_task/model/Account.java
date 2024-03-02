package com.example.banking_service_test_task.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Table(name = "accounts")
@Entity
public class Account extends AbstractEntity {

    private double amount;

    public Account() {
    }

    public Account(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
