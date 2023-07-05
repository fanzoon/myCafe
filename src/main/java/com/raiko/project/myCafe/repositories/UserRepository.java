package com.raiko.project.myCafe.repositories;

import com.raiko.project.myCafe.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String login);
}
