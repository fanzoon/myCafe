package com.raiko.project.myCafe.controllers;

import com.raiko.project.myCafe.dtos.BasketDTO;
import com.raiko.project.myCafe.models.Dish;
import com.raiko.project.myCafe.models.DishCategory;
import com.raiko.project.myCafe.models.Order;
import com.raiko.project.myCafe.models.User;
import com.raiko.project.myCafe.services.impl.BasketServiceImpl;
import com.raiko.project.myCafe.services.impl.DishCategoryServiceImpl;
import com.raiko.project.myCafe.services.impl.DishServiceImpl;
import com.raiko.project.myCafe.services.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;
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

//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        User user = (User) authentication.getPrincipal();
//        List<BasketDTO> basketDTOs = basketService.getAllBasketDTO(user);
//        model.addAttribute("listBasketDTO", basketDTOs);
//        Double totalAmount = basketService.getTotalAmount(basketDTOs);
//        model.addAttribute("totalAmount", totalAmount);

        return "user/dish/getAllDishOfCategory";
    }

//    @GetMapping("/")
//    public String getAllDishes(Model model, Principal principal) {
////        List<Dish> dishes = dishService.getAllDishes();
////        model.addAttribute("dishes", dishes);
//        User user = (User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();
//        List<BasketDTO> basketDTOs = basketService.getAllBasketDTO(user);
//        model.addAttribute("listBasketDTO", basketDTOs);
//        Double totalAmount = basketService.getTotalAmount(basketDTOs);
//        model.addAttribute("totalAmount", totalAmount);
//        return "user/dish/dish";
//    }
//
//    @GetMapping("infoDish/{id}")
//    public String infoDish(@PathVariable("id") Long id, Model model) {
//        Dish dish = dishService.getDishById(id);
//        model.addAttribute("dish", dish);
//        return "user/dish/infoDish";
//    }
}
