package com.raiko.project.myCafe.repositories;

import com.raiko.project.myCafe.models.DishCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishCategoryRepository extends JpaRepository<DishCategory, Long> {
}
