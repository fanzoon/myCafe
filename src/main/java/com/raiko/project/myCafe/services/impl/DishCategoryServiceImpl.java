package com.raiko.project.myCafe.services.impl;

import com.raiko.project.myCafe.dtos.GetAllDishOfCategoryDTO;
import com.raiko.project.myCafe.models.Dish;
import com.raiko.project.myCafe.models.DishCategory;
import com.raiko.project.myCafe.repositories.DishCategoryRepository;
import com.raiko.project.myCafe.repositories.DishRepository;
import com.raiko.project.myCafe.services.DishCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DishCategoryServiceImpl implements DishCategoryService {

    @Autowired
    private DishCategoryRepository dishCategoryRepository;

    @Autowired
    private DishRepository dishRepository;


    @Override
    public DishCategory addCategory(DishCategory dishCategory) {
        DishCategory saveDishCategory = dishCategoryRepository.save(dishCategory);
        return saveDishCategory;
    }

    @Override
    public DishCategory updateCategory(DishCategory dishCategory) {
        DishCategory updateDishCategory = dishCategoryRepository.save(dishCategory);
        return updateDishCategory;
    }

    @Override
    public DishCategory getDishCategoryById(Long id) {
        return dishCategoryRepository.getById(id);
    }

    @Override
    public List<DishCategory> getAllDishCategory() {
        List<DishCategory> dishCategoryList = dishCategoryRepository.findAll();
        return dishCategoryList;
    }

    @Override
    public List<Dish> getAllDishesOfDishCategory(Long id) {
        DishCategory dishCategory = dishCategoryRepository.findById(id).get();
        return dishRepository.findAllByDishCategory(dishCategory);
    }

    @Override
    public List<GetAllDishOfCategoryDTO> getAllDishesOfDishCategoryDTO(Long id) {
        List<Dish> allDishesOfDishCategory = getAllDishesOfDishCategory(id);
        List<GetAllDishOfCategoryDTO> getAllDishOfCategoryDTOList = new ArrayList<>();
        for (Dish dish : allDishesOfDishCategory) {
            GetAllDishOfCategoryDTO dto = new GetAllDishOfCategoryDTO();
            dto.setId(dish.getId());
            dto.setName(dish.getName());
            dto.setWeight(dish.getWeight());
            dto.setDescription(dish.getDescription());
            dto.setPrice(dish.getPrice());
            dto.setActivity(dish.getDishCategory().isActivity());
//            Optional<Image> byDish = imageRepository.findByDish(dish);
//            if (byDish.isPresent()){
//                dto.setImageId(byDish.get().getId());
//            }
            if (!dish.getImages().isEmpty()) {
                dto.setImageId(dish.getImages().get(0).getId());
            }
            getAllDishOfCategoryDTOList.add(dto);
        }
        return getAllDishOfCategoryDTOList;
    }

    @Override
    public void changeStatusDishCategory(Long id) {
        DishCategory dishCategory = dishCategoryRepository.findById(id).get();
        boolean activity = dishCategory.isActivity();
        if (activity) {
            activity = false;
        } else {
            activity = true;
        }
        dishCategory.setActivity(activity);
        dishCategoryRepository.save(dishCategory);
    }
}
