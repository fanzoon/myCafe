package com.raiko.project.myCafe.services.impl;

import com.raiko.project.myCafe.models.ContactType;
import com.raiko.project.myCafe.repositories.ContactTypeRepository;
import com.raiko.project.myCafe.services.ContactTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactTypeServiceImpl implements ContactTypeService {

    @Autowired
    private ContactTypeRepository contactTypeRepository;

    @Override
    public List<ContactType> getAllContactTypes() {
        return contactTypeRepository.findAll();
    }
}
