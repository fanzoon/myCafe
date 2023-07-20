package com.raiko.project.myCafe.services.impl;

import com.raiko.project.myCafe.enums.UserRole;
import com.raiko.project.myCafe.models.User;
import com.raiko.project.myCafe.repositories.UserRepository;
import com.raiko.project.myCafe.services.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public Boolean create(User user) {
        if (userRepository.findByLogin(user.getLogin()) != null) {
            return false;
        }
        user.getRoles().add(UserRole.ROLE_USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setDateOfCreate(LocalDate.now());
        user.setBan(false);
        User save = userRepository.save(user);
        logger.info("Добавлен новый user: " + save.getLogin());
        return true;
    }
}