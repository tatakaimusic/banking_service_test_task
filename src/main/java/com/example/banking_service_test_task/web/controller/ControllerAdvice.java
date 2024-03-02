package com.example.banking_service_test_task.web.controller;

import com.example.banking_service_test_task.model.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionBody handleResourceNotFound(ResourceNotFoundException e) {
        return new ExceptionBody(e.getMessage());
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ExceptionBody handleAccessDenied(AccessDeniedException e) {
        return new ExceptionBody(e.getMessage());
    }

    @ExceptionHandler(InsufficientFundsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionBody handleInsufficientFunds(InsufficientFundsException e) {
        return new ExceptionBody(e.getMessage());
    }

    @ExceptionHandler(ResourceTakenException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionBody handleResourceTaken(ResourceTakenException e) {
        return new ExceptionBody(e.getMessage());
    }

    @ExceptionHandler(IllegalStateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionBody handleIllegalState(IllegalStateException e) {
        return new ExceptionBody(e.getMessage());
    }

}
