package com.example.wineries.model.exception;

public class EmailAlreadyExistsException extends RuntimeException{
    public EmailAlreadyExistsException(String username) {
        super(String.format("User with username: %s already exists", username));
    }
}