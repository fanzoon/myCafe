package com.raiko.project.myCafe.services.impl;

import com.raiko.project.myCafe.dtos.GetAllDishOfCategoryDTO;
import com.raiko.project.myCafe.models.Dish;
import com.raiko.project.myCafe.models.DishCategory;
import com.raiko.project.myCafe.repositories.DishCategoryRepository;
import com.raiko.project.myCafe.repositories.DishRepository;
import com.raiko.project.myCafe.services.DishCategoryService;
import com.raiko.project.myCafe.transformers.TransformerDishToGetAllDishesOfDishCategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DishCategoryServiceImpl implements DishCategoryService {
    @Autowired
    private DishCategoryRepository dishCategoryRepository;

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private TransformerDishToGetAllDishesOfDishCategoryDTO transformerDishToGetAllDishesOfDishCategoryDTO;


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
        return dishCategoryList;
    }

    @Override
    public List<DishCategory> getAllDishCategoryIsActive() {
        List<DishCategory> allDishCategory = getAllDishCategory();
        List<DishCategory> allDishCategoryIsActive = new ArrayList<>();
        for (DishCategory dishcategory : allDishCategory) {
            if (dishcategory.isActivity() == true)
                allDishCategoryIsActive.add(dishcategory);
        }
        Collections.sort(allDishCategoryIsActive, Comparator.comparingInt(DishCategory::getNumberPriority));
        return allDishCategoryIsActive;
    }

    @Override
    public List<Dish> getAllDishesOfDishCategory(Long id) {
        DishCategory dishCategory = dishCategoryRepository.findById(id).get();
        return dishRepository.findAllByDishCategory(dishCategory);
    }

    @Override
    public List<GetAllDishOfCategoryDTO> getAllDishesOfDishCategoryDTO(Long id) {
        List<Dish> allDishesOfDishCategory = getAllDishesOfDishCategory(id);
        return allDishesOfDishCategory.stream().map(dish -> transformerDishToGetAllDishesOfDishCategoryDTO.transformer(dish)).collect(Collectors.toList());
    }

    @Override
    public List<GetAllDishOfCategoryDTO> getAllDishesOfDishCategoryDTOIsActive(Long id) {
        List<Dish> allDishesOfDishCategory = getAllDishesOfDishCategory(id);
        return allDishesOfDishCategory.stream()
                .filter(dish -> dish.isActivity())
                .map(dish -> transformerDishToGetAllDishesOfDishCategoryDTO.transformer(dish))
                .collect(Collectors.toList());
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
