package com.raiko.project.myCafe.repositories;

import com.raiko.project.myCafe.models.Contact;
import com.raiko.project.myCafe.models.ContactType;
import com.raiko.project.myCafe.models.Dish;
import com.raiko.project.myCafe.models.DishCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ContactTypeRepository extends JpaRepository<ContactType, Long> {
    Optional<ContactType> findContactTypesByName(String name);

}
