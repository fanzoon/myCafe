package com.raiko.project.myCafe.services;

import com.raiko.project.myCafe.models.User;
import com.raiko.project.myCafe.models.UserRole;

import java.util.List;

public interface UserService {
    Boolean create(User user);

    List<User> getUsersByUserRole(String userRole);
}

