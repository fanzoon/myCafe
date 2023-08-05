package com.raiko.project.myCafe.services;

import com.raiko.project.myCafe.controllers.ContactController;
import com.raiko.project.myCafe.models.Contact;
import com.raiko.project.myCafe.models.User;

public interface ContactService {
    Contact addContact(Contact contact);
}
