package com.raiko.project.myCafe.repositories;

import com.raiko.project.myCafe.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
