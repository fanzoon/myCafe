package com.raiko.project.myCafe.services;

import com.raiko.project.myCafe.models.Dish;
import com.raiko.project.myCafe.models.Review;

import java.util.List;

public interface ReviewService {


    void saveReview(String message, Integer mark, Long dishId);

    void updateReview(String message, Integer mark, Long reviewId);

    List<Review> getAllReviewByDish(Dish dish);

    Review getReviewById(Long reviewId);
}
