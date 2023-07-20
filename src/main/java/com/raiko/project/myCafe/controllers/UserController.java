package com.raiko.project.myCafe.controllers;

import com.raiko.project.myCafe.models.User;
import com.raiko.project.myCafe.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class UserController {
    @Autowired
    private UserServiceImpl userService;

//    @GetMapping("/")
//    public String hello(Principal principal) {
//        if (principal == null) {
//            return "registration";
//        }
//        if (((UsernamePasswordAuthenticationToken) principal).getAuthorities().contains(UserRole.ROLE_USER)){
//            return "hello";
//        } if (((UsernamePasswordAuthenticationToken) principal).getAuthorities().contains(UserRole.ROLE_ADMIN)){
//            return "goodbye";
//        } return null;
//    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String formRegistration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String save(User user, @RequestParam(name = "day") String day)  {
        user.setBirthday(LocalDate.parse(day));
        if(userService.create(user)) {
            return "hello";
        }
        return "registration";

    }




}
