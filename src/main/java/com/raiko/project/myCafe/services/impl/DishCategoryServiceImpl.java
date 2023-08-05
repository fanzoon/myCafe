package com.raiko.project.myCafe.services.impl;

import com.raiko.project.myCafe.models.Dish;
import com.raiko.project.myCafe.models.DishCategory;
import com.raiko.project.myCafe.repositories.DishCategoryRepository;
import com.raiko.project.myCafe.repositories.DishRepository;
import com.raiko.project.myCafe.services.DishCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        List<DishCategory> dishCategoryList = dishCategoryRepository.findAll();
//        List<DishCategory> dishCategories = new ArrayList<>();
//        for (DishCategory dishcategory: dishCategoryList) {
//            if (dishcategory.isActivity() == true)
//                dishCategories.add(dishcategory);
//        }
        return dishCategoryList;
    }

    @Override
    public List<Dish> getAllDishesOfDishCategory(Long id) {
        DishCategory dishCategory = dishCategoryRepository.findById(id).get();
        return dishRepository.findAllByDishCategory(dishCategory);
    }

    @Override
    public void changeStatusDishCategory(Long id) {
        DishCategory dishCategory = dishCategoryRepository.findById(id).get();
        boolean activity = dishCategory.isActivity();
        if (activity) {
            activity = false;
        } else {
            activity = true;
        }
        dishCategory.setActivity(activity);
        dishCategoryRepository.save(dishCategory);
    }
}
