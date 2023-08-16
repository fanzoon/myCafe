package com.raiko.project.myCafe.repositories;

import com.raiko.project.myCafe.models.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderStatusRepository extends JpaRepository<OrderStatus, Long> {
    Optional<OrderStatus> findByName(String name);
}
