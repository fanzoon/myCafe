package com.raiko.project.myCafe.controllers;


import com.raiko.project.myCafe.models.Dish;
import com.raiko.project.myCafe.services.impl.DishServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@RequestMapping("/admin/dish")
public class AdminDishController {

    @Autowired
    private DishServiceImpl dishService;


    @GetMapping("/add")
    public String addDish() {
        return "admin/addDish";
    }

    @PostMapping("/add")
    public  String save(@ModelAttribute("dish") Dish dish) {
        dishService.addDish(dish);
        return "redirect:/";
    }


}
