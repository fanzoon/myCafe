package com.raiko.project.myCafe.services.impl;

import com.raiko.project.myCafe.models.Order;
import com.raiko.project.myCafe.models.OrderDish;
import com.raiko.project.myCafe.models.User;
import com.raiko.project.myCafe.repositories.DishRepository;
import com.raiko.project.myCafe.repositories.OrderRepository;
import com.raiko.project.myCafe.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    private DishRepository dishRepository;
    @Autowired
    private OrderRepository orderRepository;




    @Override
    public Order addOrder(Long dishId, User user) {

        Order order = orderRepository.findByUserId(user.getId()).orElse(new Order());
        order.setUser(user);
        List<OrderDish> orderDishList = order.getOrderDishList();
        OrderDish orderDish = new OrderDish();
        orderDish.setOrder(order);
        orderDish.setDish(dishRepository.findById(dishId).orElseThrow(RuntimeException::new));
        orderDish.setCount(1);
        orderDishList.add(orderDish);
        order.setOrderDishList(orderDishList);
        Order saveOrder = orderRepository.save(order);
        return saveOrder;
    }

    @Override
    public List<Order> getOrderByUser(User user) {
        return orderRepository.findAll().stream().filter(order -> order.getUser().equals(user)).collect(Collectors.toList());

    }
}
