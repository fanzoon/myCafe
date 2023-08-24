package com.raiko.project.myCafe.transformers;


import com.raiko.project.myCafe.dtos.ContactDTO;
import com.raiko.project.myCafe.models.Contact;
import com.raiko.project.myCafe.models.ContactType;
import com.raiko.project.myCafe.models.User;
import com.raiko.project.myCafe.repositories.ContactTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class TransformerContactDTOToContact {
    @Autowired
    private ContactTypeRepository contactTypeRepository;

    public Contact transformerContact(ContactDTO contactDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        Contact contact = new Contact();
        String contactTypeFromContactDTO = contactDTO.getContactType();
        ContactType contactType = contactTypeRepository.findContactTypesByName(contactTypeFromContactDTO).get();
        contact.setContactType(contactType);
        contact.setName(contactDTO.getName());
        contact.setUser(user);
        return contact;
    }
}
