package com.dev.boot.amazonreviewsapp.service.impl;

import com.dev.boot.amazonreviewsapp.entity.model.Role;
import com.dev.boot.amazonreviewsapp.repository.RoleRepository;
import com.dev.boot.amazonreviewsapp.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role getByName(String roleName) {
        return roleRepository.getRoleByRoleName(roleName);
    }
}
