package com.example.wineries.service.impl;


import com.example.wineries.model.User;
import com.example.wineries.model.exception.EmailAlreadyExistsException;
import com.example.wineries.model.exception.InvalidArgumentsException;
import com.example.wineries.model.exception.InvalidUserCredentialsException;
import com.example.wineries.model.exception.PasswordsDoNotMatchException;
import com.example.wineries.repository.UserRepository;
import com.example.wineries.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String email, String password) {
        if (email==null || email.isEmpty() || password==null || password.isEmpty()) {
            throw new InvalidArgumentsException();
        }
        return userRepository.findByEmailAndPassword(email,
                password).orElseThrow(InvalidUserCredentialsException::new);
    }

    @Override
    public User register(String firstName, String lastName, String email, String password, String repeatedPassword) {
        if (email==null || email.isEmpty()  || password==null || password.isEmpty())
            throw new InvalidArgumentsException();
        if (!password.equals(repeatedPassword))
            throw new PasswordsDoNotMatchException();
        if(this.userRepository.findByEmail(email).isPresent()
        )
            throw new EmailAlreadyExistsException(email);

        User user = new User(email,firstName,lastName,password);
        return userRepository.save(user);
    }
}

