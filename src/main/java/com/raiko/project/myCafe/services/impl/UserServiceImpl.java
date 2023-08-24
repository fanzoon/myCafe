package com.raiko.project.myCafe.services.impl;

import com.raiko.project.myCafe.dtos.UserDTO;
import com.raiko.project.myCafe.models.User;
import com.raiko.project.myCafe.models.UserRole;
import com.raiko.project.myCafe.repositories.UserRepository;
import com.raiko.project.myCafe.repositories.UserRoleRepository;
import com.raiko.project.myCafe.services.UserService;
import com.raiko.project.myCafe.transformers.TransformerUserDTOToUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private TransformerUserDTOToUser transformerUserDTOToUser;

    @Override
    public Boolean create(UserDTO userDTO) {
        User user = transformerUserDTOToUser.transform(userDTO);
        if (userRepository.findByLogin(user.getLogin()) != null) {
            return false;
        }
        Optional<UserRole> roleUserFromDB = userRoleRepository.findByRole("ROLE_USER");
        UserRole userRole;
        if (roleUserFromDB.isPresent()) {
            userRole = roleUserFromDB.get();
        } else {
            userRole = userRoleRepository.save(new UserRole(null, "ROLE_USER", null));
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setDateOfCreate(LocalDate.now());
        user.setBan(false);
        user.setUserRole(userRole);
        User save = userRepository.save(user);
        logger.info("Добавлен новый user: " + save.getLogin());
        return true;
    }

    @Override
    public List<User> getUsersByUserRole(String userRole) {
        return null;
    }

    @Override
    public boolean checkConfirmPassword(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }
}