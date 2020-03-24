package com.dev.boot.amazonreviewsapp.service;

import com.dev.boot.amazonreviewsapp.entity.model.Role;

public interface RoleService {
    Role save(Role role);

    Role getByName(String roleName);
}
