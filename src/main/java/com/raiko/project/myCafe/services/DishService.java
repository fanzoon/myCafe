package com.raiko.project.myCafe.services;

import com.raiko.project.myCafe.models.Dish;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface DishService {
    List<Dish> getAllDishes();

    Dish getDishById(Long id);

    Dish addOrUpdateDish(Dish newDish, MultipartFile file) throws IOException;

    Dish updateDish(Dish dish);

    String deleteDish(Long dishId);

    void changeStatusDish(Long dishId);


}
