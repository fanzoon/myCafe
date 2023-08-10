package com.raiko.project.myCafe.services.impl;

import com.raiko.project.myCafe.models.Dish;
import com.raiko.project.myCafe.models.Image;
import com.raiko.project.myCafe.repositories.DishRepository;
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

    @Override
    public List<Dish> getAllDishes() {
        return dishRepository.findAll();
    }

    @Override
    public Dish getDishById(Long id) {
        return dishRepository.getById(id);
    }

    @Override
    public Dish addDish(Dish newDish, MultipartFile file) throws IOException {
        List<Image> images = new ArrayList<>();
        Image image = convert(file);
        image.setDish(newDish);
        images.add(image);
        newDish.setImages(images);
        Dish save = dishRepository.save(newDish);
        return save;
    }

    @Override
    public void deleteDish(Long id) {
        dishRepository.deleteById(id);
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
