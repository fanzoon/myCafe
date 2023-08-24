package com.raiko.project.myCafe.controllers;

import com.raiko.project.myCafe.dtos.ContactDTO;
import com.raiko.project.myCafe.models.*;
import com.raiko.project.myCafe.repositories.UserRoleRepository;
import com.raiko.project.myCafe.services.impl.ContactServiceImpl;
import com.raiko.project.myCafe.services.impl.ContactTypeServiceImpl;
import com.raiko.project.myCafe.validators.ContactValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ContactController {
    @Autowired
    private ContactTypeServiceImpl contactTypeService;

    @Autowired
    private ContactServiceImpl contactService;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private ContactValidator contactValidator;

    @GetMapping("/addContact")
    public String addContact(Model model) {
        List<ContactType> contactTypes = contactTypeService.getAllContactTypes();
        model.addAttribute("contactTypes", contactTypes);
        model.addAttribute("contactDTO", new ContactDTO());
        return "addContact";
    }

    @PostMapping("/addContact")
    public String saveContact(@Valid ContactDTO contactDTO, BindingResult bindingResult, Model model) {
        contactValidator.validate(contactDTO, bindingResult);
        if (!bindingResult.hasErrors())
        {
            model.addAttribute("noErrors", true);
            contactService.addContact(contactDTO);
            return "redirect:/userSetting";
        }
        List<ContactType> contactTypes = contactTypeService.getAllContactTypes();
        model.addAttribute("contactTypes", contactTypes);
        model.addAttribute("contactDTO",  contactDTO);
        return "/addContact";
    }

    @GetMapping("/userSetting")
    public String showUserInformation(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        user.setPassword("1");
        List<Contact> contacts;
        contacts = contactService.getAllContactOfUser(user);
        model.addAttribute("contacts", contacts);
        List<UserRole> userRoleList = userRoleRepository.findAll();
        model.addAttribute("userRoleList", userRoleList);
        return "userInfo";
    }

    @ModelAttribute("user")
    public User  detUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        return user;
    }
}
