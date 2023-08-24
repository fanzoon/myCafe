package com.raiko.project.myCafe.services.impl;

import com.raiko.project.myCafe.models.*;
import com.raiko.project.myCafe.repositories.DishRepository;
import com.raiko.project.myCafe.repositories.ImageRepository;
import com.raiko.project.myCafe.repositories.OrderDishRepository;
import com.raiko.project.myCafe.repositories.ReviewRepository;
import com.raiko.project.myCafe.services.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DishServiceImpl implements DishService {

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private ImageServiceImpl imageService;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private OrderDishRepository orderDishRepository;

    @Override
    public List<Dish> getAllDishes() {
        return dishRepository.findAll();
    }

    @Override
    public Dish getDishById(Long id) {
        return dishRepository.findById(id).get();
    }

    @Override
    public Dish addOrUpdateDish(Dish newDish, MultipartFile file) throws IOException {
        Dish dish = new Dish();
        Long imageId = null;
        if (newDish.getId() != null) {
            dish = dishRepository.findById(newDish.getId()).orElse(new Dish());
            imageId = imageService.getImageIdFromDish(dish);
        }
        dish.setName(newDish.getName());
        dish.setDescription(newDish.getDescription());
        dish.setWeight(newDish.getWeight());
        dish.setPrice(newDish.getPrice());
        dish.setDishCategory(newDish.getDishCategory());
        Image image = convert(file);
        image.setId(imageId);
        image.setDish(dish);
        List<Image> images = new ArrayList<>();
        images.add(image);
        dish.setImages(images);
        Dish save = dishRepository.save(dish);
        return save;
    }


    public String deleteDish(Long dishId) {
        List<Review> reviewList = reviewRepository.findAll();
        for (Review review : reviewList) {
            if (review.getDish().getId() == dishId) {
                reviewRepository.deleteById(review.getId());
            }
        }
        List<OrderDish> orderDishList = orderDishRepository.findAll();
        for (OrderDish orderDish : orderDishList) {
            if (orderDish.getDish().getId() == dishId) {
                orderDishRepository.deleteById(orderDish.getId());
            }
        }
        dishRepository.deleteById(dishId);
        return null;
    }

    @Override
    public Dish updateDish(Dish dish) {
        Dish changeDish = dishRepository.save(dish);
        return changeDish;
    }

    @Override
    public void changeStatusDish(Long dishId) {
        Dish dish = dishRepository.findById(dishId).get();
        boolean activity = dish.isActivity();
        if (activity) {
            activity = false;
        } else {
            activity = true;
        }
        dish.setActivity(activity);
        dishRepository.save(dish);
    }

    private Image convert(MultipartFile multipartFile) throws IOException {
        Image image = new Image();
        image.setName(multipartFile.getName());
        image.setOriginalFileName(multipartFile.getOriginalFilename());
        image.setContentType(multipartFile.getContentType());
        image.setSize(multipartFile.getSize());
        image.setBytes(multipartFile.getBytes());
        return image;
    }
}
