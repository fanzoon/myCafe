package com.raiko.project.myCafe.services;

import com.raiko.project.myCafe.models.Dish;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface DishService {

    List<Dish> getAllDishes();

    Dish getDishById(Long id);

    Dish addDish(Dish newDish, MultipartFile file) throws IOException;

    void deleteDish(Long id);

    Dish updateDish(Dish dish);
}
