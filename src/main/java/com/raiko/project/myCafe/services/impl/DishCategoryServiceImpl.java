package com.raiko.project.myCafe.services.impl;

import com.raiko.project.myCafe.models.Dish;
import com.raiko.project.myCafe.models.DishCategory;
import com.raiko.project.myCafe.repositories.DishCategoryRepository;
import com.raiko.project.myCafe.repositories.DishRepository;
import com.raiko.project.myCafe.services.DishCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishCategoryServiceImpl implements DishCategoryService {

    @Autowired
    private DishCategoryRepository dishCategoryRepository;

    @Autowired
    private DishRepository dishRepository;

    @Override
    public DishCategory addCategory(DishCategory dishCategory) {
        DishCategory saveDishCategory = dishCategoryRepository.save(dishCategory);
        return saveDishCategory;
    }

    @Override
    public DishCategory updateCategory(DishCategory dishCategory) {
        DishCategory updateDishCategory = dishCategoryRepository.save(dishCategory);
        return updateDishCategory;
    }

    @Override
    public DishCategory getDishCategoryById(Long id) {
        return dishCategoryRepository.getById(id);
    }

    @Override
    public List<DishCategory> getAllDishCategory() {
        return dishCategoryRepository.findAll();
    }

    @Override
    public List<Dish> getAllDishesIntoDishCategory(Long id) {
        return null;
    }
}
