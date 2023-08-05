package com.raiko.project.myCafe.repositories;

import com.raiko.project.myCafe.models.ContactType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactTypeRepository extends JpaRepository<ContactType, Long> {
}
