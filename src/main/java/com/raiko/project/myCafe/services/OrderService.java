package com.raiko.project.myCafe.services;

import com.raiko.project.myCafe.dtos.BasketDTO;
import com.raiko.project.myCafe.dtos.OrderHistoryDTO;
import com.raiko.project.myCafe.dtos.OrderingDTO;
import com.raiko.project.myCafe.models.Dish;
import com.raiko.project.myCafe.models.Order;
import com.raiko.project.myCafe.models.User;

import java.util.List;

public interface OrderService {
    Dish addOrder(Long dishId);

    List<Order> getOrderByUser(User user);

    Dish removeDishFromOrder(Long dishId);

    Dish addDishFromOrder(Long dishId);

    Order getOrder();

    void changeStatusOrder(OrderingDTO orderingDTO);

    List<OrderHistoryDTO> getHistoryOfOrdersIsPaid();

    List<BasketDTO> getOrderById(Long orderId);

}
