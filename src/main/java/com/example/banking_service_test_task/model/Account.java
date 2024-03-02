package com.example.banking_service_test_task.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Table(name = "accounts")
@Entity
public class Account extends AbstractEntity {

    private double amount;
    private double initPayment;

    public Account() {
    }

    public Account(double amount) {
        this.amount = amount;
    }

    public double getInitPayment() {
        return initPayment;
    }

    public void setInitPayment(double initPayment) {
        this.initPayment = initPayment;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
