package com.raiko.project.myCafe.transformers;

import com.raiko.project.myCafe.dtos.GetAllDishOfCategoryDTO;
import com.raiko.project.myCafe.models.Dish;
import org.springframework.stereotype.Component;

@Component
public class TransformerDishToGetAllDishesOfDishCategoryDTO {
    public GetAllDishOfCategoryDTO transformer(Dish dish) {
        GetAllDishOfCategoryDTO dto = new GetAllDishOfCategoryDTO();
        dto.setId(dish.getId());
        dto.setName(dish.getName());
        dto.setWeight(dish.getWeight());
        dto.setDescription(dish.getDescription());
        dto.setPrice(dish.getPrice());
        dto.setActivity(dish.isActivity());
        if (!dish.getImages().isEmpty()) {
            dto.setImageId(dish.getImages().get(0).getId());
        }
        return dto;
    }
}
