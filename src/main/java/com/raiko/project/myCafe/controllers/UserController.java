package com.raiko.project.myCafe.controllers;

import com.raiko.project.myCafe.dtos.UserDTO;
import com.raiko.project.myCafe.services.impl.UserServiceImpl;
import com.raiko.project.myCafe.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String formRegistration(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "registration";
    }

    @PostMapping("/registration")
    public String save(@Valid UserDTO userDTO, BindingResult bindingResult, Model model) {
        userValidator.validate(userDTO, bindingResult);
        userDTO.setBirthday(LocalDate.now());
        if (!bindingResult.hasErrors())
        {
            model.addAttribute("noErrors", true);
            userService.create(userDTO);
            return "login";
        }
        model.addAttribute("userDTO", userDTO);
        return "registration";
    }
}
