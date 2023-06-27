package com.raiko.project.myCafe.controllers;

import com.raiko.project.myCafe.enums.UserRole;
import com.raiko.project.myCafe.models.User;
import com.raiko.project.myCafe.services.UserService;
import com.raiko.project.myCafe.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/")
    public String hello(Principal principal) {
        if (principal == null) {
            return "registration";
        }
        if (((UsernamePasswordAuthenticationToken) principal).getAuthorities().contains(UserRole.USER_ROLE)){
            return "hello";
        } if (((UsernamePasswordAuthenticationToken) principal).getAuthorities().contains(UserRole.ADMIN_ROLE)){
            return "goodbye";
        } return null;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String formRegistration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String save(User user, Model model) {
        if(userService.create(user)) {
            return "hello";
        }
        return "registration";

    }


}
