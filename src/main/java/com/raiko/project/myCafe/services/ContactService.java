package com.raiko.project.myCafe.services;

import com.raiko.project.myCafe.dtos.ContactDTO;
import com.raiko.project.myCafe.models.Contact;
import com.raiko.project.myCafe.models.User;

import java.util.List;

public interface ContactService {

    List<Contact> getAllContact();

    List<Contact> getAllContactOfUser(User user);

    Contact addContact(ContactDTO contactDTO);
}
