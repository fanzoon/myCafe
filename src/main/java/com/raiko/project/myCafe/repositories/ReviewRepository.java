package com.raiko.project.myCafe.repositories;

import com.raiko.project.myCafe.models.Dish;
import com.raiko.project.myCafe.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByDish(Dish dish);
}
