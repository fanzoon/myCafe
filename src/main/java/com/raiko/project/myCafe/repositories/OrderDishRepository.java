package com.raiko.project.myCafe.repositories;

import com.raiko.project.myCafe.models.OrderDish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface OrderDishRepository extends JpaRepository<OrderDish, Long> {

}
