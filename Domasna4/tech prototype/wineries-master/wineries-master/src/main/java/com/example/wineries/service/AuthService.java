package com.example.wineries.service;

import com.example.wineries.model.User;

public interface AuthService {
    User login(String email, String password);
    User register(String firstName,String lastName,String email,String password,String repeatedPassword);
}
