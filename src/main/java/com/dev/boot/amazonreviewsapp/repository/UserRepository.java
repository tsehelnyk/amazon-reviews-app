package com.dev.boot.amazonreviewsapp.repository;

import com.dev.boot.amazonreviewsapp.entity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User getUserByLogin(String login);

}
