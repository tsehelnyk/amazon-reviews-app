package com.dev.boot.amazonreviewsapp.controller;

import com.dev.boot.amazonreviewsapp.entity.model.Role;
import com.dev.boot.amazonreviewsapp.entity.model.User;
import com.dev.boot.amazonreviewsapp.service.RoleService;
import com.dev.boot.amazonreviewsapp.service.UserService;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class InitController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Value("${spring.application.admin_login}")
    private String login;
    @Value("${spring.application.admin_password}")
    private String password;

    @PostConstruct
    private void postConstruct() {
        Role roleAdmin = new Role();
        roleAdmin.setRoleName("ADMIN");
        roleAdmin = roleService.save(roleAdmin);

        User admin = new User();
        admin.setLogin("admin");
        admin.setPassword(passwordEncoder.encode(password));
        admin.getRoles().add(roleAdmin);
        userService.save(admin);
    }
}
