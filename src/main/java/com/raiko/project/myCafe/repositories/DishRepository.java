package com.raiko.project.myCafe.repositories;

import com.raiko.project.myCafe.models.Dish;
import com.raiko.project.myCafe.models.DishCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DishRepository extends JpaRepository<Dish, Long> {

    List<Dish> findAllByName(String name);

    List<Dish> findAllByDishCategory(DishCategory dishCategory);

}
