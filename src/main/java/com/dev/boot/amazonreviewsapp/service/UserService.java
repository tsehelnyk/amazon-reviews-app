package com.dev.boot.amazonreviewsapp.service;


import com.dev.boot.amazonreviewsapp.entity.model.User;

public interface UserService {

    User save(User user);

    User getByLogin(String login);

}
