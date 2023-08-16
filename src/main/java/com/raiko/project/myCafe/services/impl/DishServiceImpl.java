package com.raiko.project.myCafe.services.impl;

import com.raiko.project.myCafe.models.Dish;
import com.raiko.project.myCafe.models.DishCategory;
import com.raiko.project.myCafe.models.Image;
import com.raiko.project.myCafe.repositories.DishRepository;
import com.raiko.project.myCafe.repositories.ImageRepository;
import com.raiko.project.myCafe.services.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    @Override
    public List<Dish> getAllDishes() {
        return dishRepository.findAll();
    }

    @Override
    public Dish getDishById(Long id) {
        return dishRepository.getById(id);
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

    @Override
    public Dish updateDish(Dish dish) {
        Dish changeDish = dishRepository.save(dish);
        return changeDish;
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
