package com.raiko.project.myCafe.repositories;

import com.raiko.project.myCafe.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Optional<Order> findByUserId(Long id);

}
