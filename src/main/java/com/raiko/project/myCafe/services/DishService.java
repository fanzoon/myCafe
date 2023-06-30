package com.raiko.project.myCafe.services;

import com.raiko.project.myCafe.models.Dish;

import java.util.List;

public interface DishService {

    List<Dish> getAllDishes();

    Dish getDishById(Long id);

    Dish addDish(Dish newDish);
}
