package com.example.banking_service_test_task.web.dto;


import com.example.banking_service_test_task.web.dto.validation.OnCreate;
import com.example.banking_service_test_task.web.dto.validation.OnUpdate;
import jakarta.validation.constraints.NotNull;

public class AccountDTO extends AbstractEntityDTO {

    @NotNull(
            message = "Amount must be not null!",
            groups = {OnCreate.class, OnUpdate.class}
    )
    private double amount;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
