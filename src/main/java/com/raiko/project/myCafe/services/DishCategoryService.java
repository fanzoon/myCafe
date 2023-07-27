package com.raiko.project.myCafe.services;

import com.raiko.project.myCafe.models.Dish;
import com.raiko.project.myCafe.models.DishCategory;

import java.util.List;

public interface DishCategoryService {

    DishCategory addCategory(DishCategory dishCategory);

    DishCategory updateCategory(DishCategory dishCategory);

    DishCategory getDishCategoryById(Long Id);


    List<DishCategory> getAllDishCategory();

    List<Dish> getAllDishesIntoDishCategory(Long id);
}

