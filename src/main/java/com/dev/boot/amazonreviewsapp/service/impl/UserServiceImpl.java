package com.dev.boot.amazonreviewsapp.service.impl;

import com.dev.boot.amazonreviewsapp.entity.model.User;
import com.dev.boot.amazonreviewsapp.repository.UserRepository;
import com.dev.boot.amazonreviewsapp.service.AuthenticationService;
import com.dev.boot.amazonreviewsapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthenticationService authenticationService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getByLogin(String login) {
        return userRepository.getUserByLogin(login);
    }
}
