package com.raiko.project.myCafe.controllers;


import com.raiko.project.myCafe.dtos.BasketDTO;
import com.raiko.project.myCafe.dtos.ContactDTO;
import com.raiko.project.myCafe.dtos.GetAllDishOfCategoryDTO;
import com.raiko.project.myCafe.models.*;
import com.raiko.project.myCafe.repositories.UserRoleRepository;
import com.raiko.project.myCafe.services.impl.*;
import com.raiko.project.myCafe.validators.ContactValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/admin/dish")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminDishController {

    @Autowired
    private DishServiceImpl dishService;

    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private BasketServiceImpl basketService;

    @Autowired
    private DishCategoryServiceImpl dishCategoryService;

    @Autowired
    private ContactServiceImpl contactService;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private ContactValidator contactValidator;

    @Autowired
    private ContactTypeServiceImpl contactTypeService;

    @GetMapping("/mainAdmin")
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
        return "admin/mainAdmin";
    }

    @GetMapping("/menuDishForAdmin")
    public String menuDish(Model model) {
        List<DishCategory> dishCategories = dishCategoryService.getAllDishCategoryIsActive();
        model.addAttribute("dishCategories", dishCategories);
        return "admin/menuDishForAdmin";
    }

    @GetMapping("/getAllDishOfCategoryIsActiveForAdmin/{categoryId}")
    public String showAllDishesIntoDishCategoryForAdmin(@PathVariable("categoryId") Long categoryId, Model model) {
        List<GetAllDishOfCategoryDTO> getAllDishOfCategoryDTOList = dishCategoryService.getAllDishesOfDishCategoryDTOIsActive(categoryId);
        model.addAttribute("getAllDishOfCategoryDTOList", getAllDishOfCategoryDTOList);
        DishCategory dishCategory = dishCategoryService.getDishCategoryById(categoryId);
        model.addAttribute("dishCategory", dishCategory);
        return "admin/getAllDishOfCategoryForAdmin";
    }

    @GetMapping("/basketForAdmin")
    public String showBasketForAdmin(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        List<BasketDTO> basketDTOs = basketService.getAllBasketDTO(user);
        model.addAttribute("listBasketDTO", basketDTOs);
        Double totalAmount = basketService.getTotalAmount(basketDTOs);
        model.addAttribute("totalAmount", totalAmount);
        Order order = orderService.getOrder();
        model.addAttribute("order", order);
        return "admin/basketForAdmin";
    }

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

    @GetMapping("/getAllDishOfCategory/{id}")
    public String showAllDishesIntoDishCategory(@PathVariable("id") Long id, Model model) {
        List<GetAllDishOfCategoryDTO> dishDTO = dishCategoryService.getAllDishesOfDishCategoryDTO(id);
        model.addAttribute("allDishesIntoDishCategory", dishDTO);
        DishCategory dishCategory = dishCategoryService.getDishCategoryById(id);
        model.addAttribute("dishCategory", dishCategory);
        return "admin/getAllDishOfCategory";
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

    @PostMapping("/changeStatusDish/{id}")
    public String changeStatusDish(@PathVariable("id") Long id) {
        Dish dish = dishService.getDishById(id);
        Long dishCategoryId = dish.getDishCategory().getId();
        dishService.changeStatusDish(id);
        return "redirect:/admin/dish/getAllDishOfCategory/" + dishCategoryId;
    }

    @PostMapping("/deleteDish/{dishId}")
    public String deleteDishById (@PathVariable Long dishId) {
        Dish dish = dishService.getDishById(dishId);
        Long dishCategoryId = dish.getDishCategory().getId();
        dishService.deleteDish(dishId);
        return "redirect:/admin/dish/getAllDishOfCategory/" + dishCategoryId;
    }

    @GetMapping("/addCategory")
    public String addCategory(Model model) {
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

    @GetMapping("/adminSetting")
    public String showAdminInformation(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        user.setPassword("1");
        List<Contact> contacts;
        contacts = contactService.getAllContactOfUser(user);
        model.addAttribute("contacts", contacts);
        List<UserRole> userRoleList = userRoleRepository.findAll();
        model.addAttribute("userRoleList", userRoleList);
        return "admin/adminInfo";
    }

    @GetMapping("/addContactForAdmin")
    public String addContact(Model model) {
        List<ContactType> contactTypes = contactTypeService.getAllContactTypes();
        model.addAttribute("contactTypes", contactTypes);
        model.addAttribute("contactDTO", new ContactDTO());
        return "admin/addContactForAdmin";
    }

    @PostMapping("/addContactForAdmin")
    public String saveContact(@Valid ContactDTO contactDTO, BindingResult bindingResult, Model model) {
        contactValidator.validate(contactDTO, bindingResult);
        if (!bindingResult.hasErrors())
        {
            model.addAttribute("noErrors", true);
            contactService.addContact(contactDTO);
            return "redirect:/admin/dish/adminSetting";
        }
        List<ContactType> contactTypes = contactTypeService.getAllContactTypes();
        model.addAttribute("contactTypes", contactTypes);
        model.addAttribute("contactDTO",  contactDTO);
        return "admin/addContactForAdmin";
    }

    @ModelAttribute("user")
    public User detUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        return user;
    }
}
