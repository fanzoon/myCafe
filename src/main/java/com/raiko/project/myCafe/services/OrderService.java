package com.raiko.project.myCafe.services;

import com.raiko.project.myCafe.models.Order;
import com.raiko.project.myCafe.models.User;

import java.util.List;

public interface OrderService {
    Order addOrder(Long dishId, User user);
    List<Order> getOrderByUser(User user);
}
