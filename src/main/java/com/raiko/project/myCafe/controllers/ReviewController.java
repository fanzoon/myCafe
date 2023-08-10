package com.raiko.project.myCafe.controllers;

import com.raiko.project.myCafe.services.impl.ReviewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReviewController {
    @Autowired
    private ReviewServiceImpl reviewService;

    @GetMapping("/addReview/{dishId}")
    public String addReview(@PathVariable("dishId") Long dishId, Model model) {
        model.addAttribute("dishId", dishId);
        return "/user/dish/addReview";
    }

    @PostMapping("/addReview")
    public String saveReview(@RequestParam("message") String message, @RequestParam("mark") Integer mark, @RequestParam("dishId") Long dishId) {
        reviewService.saveReview(message, mark, dishId);
        return "redirect:/infoDish/" + dishId;
    }
}
