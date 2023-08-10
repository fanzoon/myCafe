package com.raiko.project.myCafe.controllers;

import com.raiko.project.myCafe.dtos.BasketDTO;
import com.raiko.project.myCafe.models.*;
import com.raiko.project.myCafe.services.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
public class DishController {
    @Autowired
    private BasketServiceImpl basketService;

    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private DishCategoryServiceImpl dishCategoryService;

    @Autowired
    private DishServiceImpl dishService;

    @Autowired
    private ImageServiceImpl imageService;

    @Autowired
    private ReviewServiceImpl reviewService;

    @GetMapping("/")
    public String getAllDishCategory(Model model) {
        List<DishCategory> allDishCategory = dishCategoryService.getAllDishCategory();
        List<DishCategory> dishCategories = new ArrayList<>();
        for (DishCategory dishcategory : allDishCategory) {
            if (dishcategory.isActivity() == true)
                dishCategories.add(dishcategory);
        }
        Collections.sort(dishCategories, Comparator.comparingInt(DishCategory::getNumberPriority));
        model.addAttribute("dishCategories", dishCategories);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        List<BasketDTO> basketDTOs = basketService.getAllBasketDTO(user);
        model.addAttribute("listBasketDTO", basketDTOs);
        Double totalAmount = basketService.getTotalAmount(basketDTOs);
        model.addAttribute("totalAmount", totalAmount);
        Order order = orderService.getOrder();
        model.addAttribute("order", order);
        return "user/dish/mainPage";
    }

    @GetMapping("/getAllDishOfCategory/{categoryId}")
    public String showAllDishesIntoDishCategory(@PathVariable("categoryId") Long categoryId, Model model) {
        List<Dish> allDishesIntoDishCategory = dishCategoryService.getAllDishesOfDishCategory(categoryId);
        model.addAttribute("allDishesIntoDishCategory", allDishesIntoDishCategory);
        DishCategory dishCategory = dishCategoryService.getDishCategoryById(categoryId);
        model.addAttribute("dishCategory", dishCategory);
        return "user/dish/getAllDishOfCategory";
    }

    @GetMapping("infoDish/{id}")
    public String infoDish(@PathVariable("id") Long id, Model model) {
        Dish dish = dishService.getDishById(id);
        model.addAttribute("dish", dish);
        Long imageId = imageService.getImageIdFromDish(dish);
        model.addAttribute("imageId", imageId);
        List<Review> reviewList = reviewService.getAllReviewByDish(dish);
        model.addAttribute("reviewList", reviewList);
        return "user/dish/infoDish";
    }
}
