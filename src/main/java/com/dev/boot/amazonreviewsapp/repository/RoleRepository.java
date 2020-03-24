package com.dev.boot.amazonreviewsapp.repository;

import com.dev.boot.amazonreviewsapp.entity.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role getRoleByRoleName(String roleName);

}
