package com.raiko.project.myCafe.controllers;

import com.raiko.project.myCafe.models.Contact;
import com.raiko.project.myCafe.models.ContactType;
import com.raiko.project.myCafe.models.User;
import com.raiko.project.myCafe.services.impl.ContactServiceImpl;
import com.raiko.project.myCafe.services.impl.ContactTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ContactController {


    @Autowired
    private ContactTypeServiceImpl contactTypeService;

    @Autowired
    private ContactServiceImpl contactService;

    @GetMapping("/addContact")
    public String addContact(Model model) {
        List<ContactType> contactTypes = contactTypeService.getAllContactTypes();
        model.addAttribute("contactTypes", contactTypes);
        return "addContact";
    }

    @PostMapping("/addContact")
    public String saveContact(@ModelAttribute("contact") Contact contact) {
        contactService.addContact(contact);

        return "redirect:/userSetting";
    }

    @GetMapping("/userSetting")
    public String showUserInformation(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        user.setPassword("1");
        model.addAttribute("user", user);
        List<Contact> contacts = new ArrayList<>();
        contacts = user.getContacts();
        model.addAttribute("contacts", contacts);
        return "userInfo";
    }
}
