package com.raiko.project.myCafe.controllers;


import com.raiko.project.myCafe.dtos.GetAllDishOfCategoryDTO;
import com.raiko.project.myCafe.models.Dish;
import com.raiko.project.myCafe.models.DishCategory;
import com.raiko.project.myCafe.services.impl.DishCategoryServiceImpl;
import com.raiko.project.myCafe.services.impl.DishServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@RequestMapping("/admin/dish")
public class AdminDishController {

    @Autowired
    private DishServiceImpl dishService;

    @Autowired
    private DishCategoryServiceImpl dishCategoryService;


    @GetMapping("/add")
    public String addDish(Model model) {
        List<DishCategory> categories = dishCategoryService.getAllDishCategory();
        model.addAttribute("categories", categories);
        return "admin/addDish";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute("dish") Dish dish,
                       @RequestParam(name = "dishCategory") Long dishCategoryId,
                       @RequestParam("file") MultipartFile file) throws IOException {
        DishCategory dishCategoryById = dishCategoryService.getDishCategoryById(dishCategoryId);
        dish.setDishCategory(dishCategoryById);
        dishService.addOrUpdateDish(dish, file);
        return "redirect:/admin/dish/getAllDishOfCategory/" + dishCategoryId;
    }


    @GetMapping("/updateDish/{dishId}")
    public String updateDish(@PathVariable Long dishId, Model model) {
        Dish dish = dishService.getDishById(dishId);
        model.addAttribute("dish", dish);
        List<DishCategory> categories = dishCategoryService.getAllDishCategory();
        model.addAttribute("categories", categories);
        return "admin/updateDish";
    }

    @PostMapping("/updateDish")
    public String saveUpdateDish(@ModelAttribute("dish") Dish dish,
                                 @RequestParam(name = "dishCategory") Long dishCategoryId,
                                 @RequestParam("file") MultipartFile file) throws IOException {
        DishCategory dishCategoryById = dishCategoryService.getDishCategoryById(dishCategoryId);
        dish.setDishCategory(dishCategoryById);
        dishService.addOrUpdateDish(dish, file);
        return "redirect:/admin/dish/getAllDishOfCategory/" + dishCategoryId;
    }

    @GetMapping("/addCategory")
    public String addCategory(Model model) {
        List<DishCategory> allDishCategory = dishCategoryService.getAllDishCategory();
        model.addAttribute("allDishCategory", allDishCategory);
        return "admin/addCategory";
    }

    @PostMapping("/addCategory")
    public String saveCategoryDish(@ModelAttribute("dishCategory") DishCategory dishCategory) {
        dishCategoryService.addCategory(dishCategory);
        return "redirect:/admin/dish/getAllDishCategory";
    }

    @GetMapping("/updateCategory/{id}")
    public String updateDishCategory(@PathVariable("id") Long id, Model model) {
        DishCategory dishCategory = dishCategoryService.getDishCategoryById(id);
        model.addAttribute("dishCategory", dishCategory);
        return "admin/updateCategory";
    }

    @PostMapping("/updateCategory/{id}")
    public String saveUpdatedDishCategory(@ModelAttribute("dishCategory") DishCategory dishCategory) {
        dishCategoryService.updateCategory(dishCategory);
        return "redirect:/admin/dish/getAllDishCategory";
    }

    @GetMapping("/getAllDishOfCategory/{id}")
    public String showAllDishesIntoDishCategory(@PathVariable("id") Long id, Model model) {
        List<GetAllDishOfCategoryDTO> dishDTO = dishCategoryService.getAllDishesOfDishCategoryDTO(id);
        model.addAttribute("allDishesIntoDishCategory", dishDTO);
        DishCategory dishCategory = dishCategoryService.getDishCategoryById(id);
        model.addAttribute("dishCategory", dishCategory);
        return "admin/getAllDishOfCategory";
    }

    @GetMapping("/getAllDishCategory")
    public String getAllDishCategory(Model model) {
        List<DishCategory> allDishCategory = dishCategoryService.getAllDishCategory();
        Collections.sort(allDishCategory, Comparator.comparingInt(DishCategory::getNumberPriority));
        model.addAttribute("allDishCategory", allDishCategory);
        return "/admin/getAllDishCategory";
    }

    @PostMapping("/changeStatusDishCategory/{id}")
    public String changeStatusDishCategory(@PathVariable("id") Long id) {
        dishCategoryService.changeStatusDishCategory(id);
        return "redirect:/admin/dish/getAllDishCategory";
    }
}
