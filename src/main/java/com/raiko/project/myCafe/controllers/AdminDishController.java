package com.raiko.project.myCafe.controllers;


import com.raiko.project.myCafe.models.Dish;
import com.raiko.project.myCafe.services.impl.DishServiceImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@PreAuthorize("hasAuthority('ADMIN_ROLE')")
@RequestMapping("/admin/dish")
public class AdminDishController {


    private final DishServiceImpl dishService;

    public AdminDishController(DishServiceImpl dishService) {
        this.dishService = dishService;
    }

    @GetMapping("/add")
    public String addDish(@ModelAttribute("dish") Dish dish) {
        return "dish/addDish";
    }

    @PostMapping("/add")
    public  String save(@ModelAttribute("dish") Dish dish) {

        return "hello";
    }


}
