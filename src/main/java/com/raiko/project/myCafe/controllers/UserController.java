package com.raiko.project.myCafe.controllers;

import com.raiko.project.myCafe.models.Contact;
import com.raiko.project.myCafe.models.User;
import com.raiko.project.myCafe.services.ContactTypeService;
import com.raiko.project.myCafe.services.impl.ContactTypeServiceImpl;
import com.raiko.project.myCafe.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private ContactTypeServiceImpl contactTypeService;

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
            return "redirect:/";
        }
        return "registration";
    }

}
