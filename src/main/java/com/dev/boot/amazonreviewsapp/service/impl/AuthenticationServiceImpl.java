package com.dev.boot.amazonreviewsapp.service.impl;

import com.dev.boot.amazonreviewsapp.entity.model.User;
import com.dev.boot.amazonreviewsapp.service.AuthenticationService;
import com.dev.boot.amazonreviewsapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User login(String login, String password) {
        User user = userService.getByLogin(login);
        if (user == null
                || ! passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Wrong login or password");
        }
        return user;
    }
}
