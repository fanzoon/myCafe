package com.raiko.project.myCafe.services.impl;

import com.raiko.project.myCafe.dtos.ContactDTO;
import com.raiko.project.myCafe.models.Contact;
import com.raiko.project.myCafe.models.Dish;
import com.raiko.project.myCafe.models.DishCategory;
import com.raiko.project.myCafe.models.User;
import com.raiko.project.myCafe.repositories.ContactRepository;
import com.raiko.project.myCafe.services.ContactService;
import com.raiko.project.myCafe.transformers.TransformerContactDTOToContact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private TransformerContactDTOToContact transformerContactDTOToContact;

    @Override
    public List<Contact> getAllContact() {
        return contactRepository.findAll();
    }

    @Override
    public Contact addContact(ContactDTO contactDTO) {
        Contact contact = transformerContactDTOToContact.transformerContact(contactDTO);
        return contactRepository.save(contact);
    }

    @Override
    public List<Contact> getAllContactOfUser(User user) {
        return contactRepository.findAllByUser(user);
    }
}
