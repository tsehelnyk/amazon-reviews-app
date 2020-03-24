package com.dev.boot.amazonreviewsapp.service;

import com.dev.boot.amazonreviewsapp.entity.model.User;

public interface AuthenticationService {

    User login(String login, String password);

}
