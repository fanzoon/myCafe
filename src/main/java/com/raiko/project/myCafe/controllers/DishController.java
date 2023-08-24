package com.raiko.project.myCafe.controllers;

import com.raiko.project.myCafe.dtos.BasketDTO;
import com.raiko.project.myCafe.dtos.GetAllDishOfCategoryDTO;
import com.raiko.project.myCafe.models.*;
import com.raiko.project.myCafe.services.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

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
    public String getAllDishCategoryIsActive(Model model) {
        List<DishCategory> dishCategories = dishCategoryService.getAllDishCategoryIsActive();
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

    @GetMapping("/getAllDishOfCategoryIsActive/{categoryId}")
    public String showAllDishesIntoDishCategory(@PathVariable("categoryId") Long categoryId, Model model) {
        List<GetAllDishOfCategoryDTO> getAllDishOfCategoryDTOList = dishCategoryService.getAllDishesOfDishCategoryDTOIsActive(categoryId);
        model.addAttribute("getAllDishOfCategoryDTOList", getAllDishOfCategoryDTOList);
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

    @GetMapping("/menuDish")
    public String menuDish(Model model) {
        List<DishCategory> dishCategories = dishCategoryService.getAllDishCategoryIsActive();
        model.addAttribute("dishCategories", dishCategories);
        return "user/dish/menuDish";
    }

    @ModelAttribute("user")
    public User  detUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        return user;
    }
}
