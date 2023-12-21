package com.example.wineries.model.exception;

public class WineryAlreadyExistsException extends RuntimeException{
    public WineryAlreadyExistsException(Long id){
        super(String.format("Winery with id: %f already exists", id));
    }
}

