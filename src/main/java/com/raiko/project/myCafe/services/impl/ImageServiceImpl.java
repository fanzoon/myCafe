package com.raiko.project.myCafe.services.impl;

import com.raiko.project.myCafe.models.Dish;
import com.raiko.project.myCafe.models.Image;
import com.raiko.project.myCafe.repositories.ImageRepository;
import com.raiko.project.myCafe.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public Long getImageIdFromDish(Dish dish) {
        Long imageId = null;
        Optional<Image> image = imageRepository.findByDish(dish);
            if (image.isPresent()){
                imageId = image.get().getId();
            }
        return imageId;
    }
}
