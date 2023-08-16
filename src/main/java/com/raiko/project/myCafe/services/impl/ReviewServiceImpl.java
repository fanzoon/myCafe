package com.raiko.project.myCafe.services.impl;

import com.raiko.project.myCafe.models.Dish;
import com.raiko.project.myCafe.models.Review;
import com.raiko.project.myCafe.models.User;
import com.raiko.project.myCafe.repositories.DishRepository;
import com.raiko.project.myCafe.repositories.ReviewRepository;
import com.raiko.project.myCafe.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public void saveReview(String message, Integer mark, Long dishId) {
        Review review = new Review();
        review.setMessage(message);
        review.setMark(mark);
        Optional<Dish> dishOptional = dishRepository.findById(dishId);
        Dish dish = dishOptional.get();
        review.setDish(dish);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        review.setUser(user);
        reviewRepository.save(review);
    }

    @Override
    public List<Review> getAllReviewByDish(Dish dish) {
        return reviewRepository.findAllByDish(dish);
    }
}
