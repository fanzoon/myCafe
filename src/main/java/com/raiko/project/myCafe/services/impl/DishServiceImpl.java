package com.raiko.project.myCafe.services.impl;

import com.raiko.project.myCafe.models.Dish;
import com.raiko.project.myCafe.repositories.DishRepository;
import com.raiko.project.myCafe.services.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishServiceImpl implements DishService {

    @Autowired
    private DishRepository dishRepository;


    @Override
    public List<Dish> getAllDishes() {
        return dishRepository.findAll();
    }

    @Override
    public Dish getDishById(Long id) {
        return dishRepository.getById(id);
    }

    @Override
    public Dish addDish(Dish newDish) {
        Dish save = dishRepository.save(newDish);
        return save;
    }
}
