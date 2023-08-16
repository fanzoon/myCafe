package com.raiko.project.myCafe.services.impl;

import com.raiko.project.myCafe.models.Contact;
import com.raiko.project.myCafe.models.User;
import com.raiko.project.myCafe.repositories.ContactRepository;
import com.raiko.project.myCafe.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Contact addContact(Contact contact) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        contact.setUser(user);
        return contactRepository.save(contact);
    }
}
