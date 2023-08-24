package com.raiko.project.myCafe.repositories;

import com.raiko.project.myCafe.models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    Optional<UserRole> findByRole(String role);
}
