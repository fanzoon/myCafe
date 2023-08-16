package com.raiko.project.myCafe.repositories;

import com.raiko.project.myCafe.models.Dish;
import com.raiko.project.myCafe.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image, Long> {
    Optional<Image> findByDish(Dish dish);

}
