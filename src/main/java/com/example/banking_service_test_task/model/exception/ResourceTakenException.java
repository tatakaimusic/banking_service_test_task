package com.example.banking_service_test_task.model.exception;

public class ResourceTakenException extends RuntimeException {

    public ResourceTakenException(String message) {
        super(message);
    }
}
