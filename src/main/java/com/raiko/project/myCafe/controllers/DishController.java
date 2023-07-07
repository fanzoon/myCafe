package com.raiko.project.myCafe.controllers;

import com.raiko.project.myCafe.models.Dish;
import com.raiko.project.myCafe.services.impl.DishServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DishController {

    private final DishServiceImpl dishService;

    public DishController(DishServiceImpl dishService) {
        this.dishService = dishService;
    }

    @GetMapping("/")
    public String getAllDishes(Model model) {
        List<Dish> dishes = dishService.getAllDishes();
        model.addAttribute("dishes", dishes);
        return "dish/dish";
    }



}
