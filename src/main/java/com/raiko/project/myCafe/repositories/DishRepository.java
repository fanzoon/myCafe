package com.raiko.project.myCafe.repositories;

import com.raiko.project.myCafe.models.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish, Long> {


}
