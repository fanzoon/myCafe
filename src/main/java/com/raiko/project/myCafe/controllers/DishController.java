package com.raiko.project.myCafe.controllers;

import com.raiko.project.myCafe.dtos.BasketDTO;
import com.raiko.project.myCafe.models.Dish;
import com.raiko.project.myCafe.models.User;
import com.raiko.project.myCafe.services.impl.BasketServiceImpl;
import com.raiko.project.myCafe.services.impl.DishServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;
import java.util.List;

@Controller
public class DishController {
    @Autowired
    private BasketServiceImpl basketService;

    @Autowired
    private DishServiceImpl dishService;

    @GetMapping("/")
    public String getAllDishes(Model model, Principal principal) {
        List<Dish> dishes = dishService.getAllDishes();
        model.addAttribute("dishes", dishes);
        User user = (User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();
        List<BasketDTO> basketDTOs = basketService.getAllBasketDTO(user);
        model.addAttribute("listBasketDTO", basketDTOs);
        Double totalAmount = basketService.getTotalAmount(basketDTOs);
        model.addAttribute("totalAmount", totalAmount);
        return "user/dish/dish";
    }

    @GetMapping("infoDish/{id}")
    public String infoDish(@PathVariable("id") Long id, Model model) {
        Dish dish = dishService.getDishById(id);
        model.addAttribute("dish", dish);
        return "user/dish/infoDish";
    }
}
