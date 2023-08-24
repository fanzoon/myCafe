package com.raiko.project.myCafe.services;

import com.raiko.project.myCafe.dtos.UserDTO;
import com.raiko.project.myCafe.models.User;

import java.util.List;

public interface UserService {
    Boolean create(UserDTO userDTO);

    List<User> getUsersByUserRole(String userRole);

    boolean checkConfirmPassword(String password, String confirmPassword);
}

