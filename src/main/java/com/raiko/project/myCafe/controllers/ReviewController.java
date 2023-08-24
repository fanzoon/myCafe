package com.raiko.project.myCafe.controllers;

import com.raiko.project.myCafe.models.Dish;
import com.raiko.project.myCafe.models.Review;
import com.raiko.project.myCafe.models.User;
import com.raiko.project.myCafe.services.impl.DishServiceImpl;
import com.raiko.project.myCafe.services.impl.ReviewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ReviewController {
    @Autowired
    private ReviewServiceImpl reviewService;

    @Autowired
    private DishServiceImpl dishService;

    @GetMapping("/addReview/{dishId}")
    public String addReview(@PathVariable("dishId") Long dishId, Model model) {
        model.addAttribute("dishId", dishId);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        Dish dish = dishService.getDishById(dishId);
        List<Review> reviewListByDish = reviewService.getAllReviewByDish(dish);
        boolean findUserInReviews = reviewListByDish.stream().anyMatch(review -> review.getUser().getId().equals(user.getId()));
            if (!findUserInReviews)
                return "/user/dish/addReview";
        return "redirect:/infoDish/" + dishId;
    }

    @PostMapping("/addReview")
    public String saveReview(@RequestParam("message") String message, @RequestParam("mark") Integer mark, @RequestParam("dishId") Long dishId) {
        reviewService.saveReview(message, mark, dishId);
        return "redirect:/infoDish/" + dishId;
    }

    @GetMapping("/updateReview/{reviewId}")
    public String updateReview(@PathVariable("reviewId") Long reviewId, Model model) {
        Review review = reviewService.getReviewById(reviewId);
        model.addAttribute("review", review);
        return "/user/dish/updateReview";
    }

    @PostMapping("/updateReview")
    public String updateReview(@RequestParam("message") String message,
                                   @RequestParam("mark") Integer mark,
                                   @RequestParam("dishId") Long dishId,
                                   @RequestParam("reviewId") Long reviewId) {
        reviewService.updateReview(message, mark, reviewId);
        return "redirect:/infoDish/" + dishId;
    }

    @ModelAttribute("user")
    public User detUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        return user;
    }
}
