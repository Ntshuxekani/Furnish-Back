package com.jwtwtf.jwtapp.repository;

import com.jwtwtf.jwtapp.models.ERole;
import com.jwtwtf.jwtapp.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
