package com.raiko.project.myCafe.services.impl;

import com.raiko.project.myCafe.dtos.OrderingDTO;
import com.raiko.project.myCafe.exceptions.NotFindDishException;
import com.raiko.project.myCafe.models.*;
import com.raiko.project.myCafe.repositories.*;
import com.raiko.project.myCafe.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    private DishRepository dishRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDishRepository orderDishRepository;

    @Autowired
    private OrderStatusRepository orderStatusRepository;

    @Autowired
    private PaymentTypeRepository paymentTypeRepository;

    @Autowired
    private  DeliveryTypeRepository deliveryTypeRepository;

    @Override
    public Dish addOrder(Long dishId) {
        Order order = getOrder();


        Dish dish = dishRepository.findById(dishId).orElseThrow(() -> new NotFindDishException("Нет такого блюда"));
        List<OrderDish> orderDishList = order.getOrderDishList();

        boolean isDishOfThisOrder = false;      // это проверка есть ли в таблице orderDish (в базе) такой dish, который мы хотим туда добавить

        for (OrderDish orderDish1 : orderDishList) {
            if (dish.equals(orderDish1.getDish())) {
                isDishOfThisOrder = true;
                orderDish1.setCount(orderDish1.getCount() + 1);
                break;
            }
        }                                       // проверили

        if (isDishOfThisOrder == false) {
            OrderDish orderDish = new OrderDish();
            orderDish.setCount(1);
            orderDish.setOrder(order);
            orderDish.setDish(dish);
            orderDishList.add(orderDish);
        }

        order.setOrderDishList(orderDishList);
        orderRepository.save(order);
        return dish;
    }

    public Order getOrder() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        Order order = null;

        List<Order> orderList = orderRepository.findByUserId(user.getId());
        for (Order order1: orderList) {
            if (order1.getOrderStatus().getName().equals("ACTIVE")) {
                order = order1;
                break;
            }
        }
        if (order == null) {
            order = new Order();
            order.setUser(user);
            OrderStatus active = orderStatusRepository.findByName("ACTIVE").get();
            order.setOrderStatus(active);
        }
        return order;
    }

    @Override
    public void changeStatusOrder(OrderingDTO orderingDTO) {
        Order order = orderRepository.findById(orderingDTO.getOrderId()).get();
        PaymentType paymentType = paymentTypeRepository.findById(orderingDTO.getPaymentTypeId()).get();
        order.setPaymentType(paymentType);
        DeliveryType deliveryType = deliveryTypeRepository.findById(orderingDTO.getDeliveryTypeId()).get();
        order.setDeliveriesType(deliveryType);
        order.setOrderStatus(orderStatusRepository.findByName("DONE").get());
        orderRepository.save(order);
    }

    @Override
    public List<Order> getOrderByUser(User user) {
        return orderRepository.findAll().stream().filter(order -> order.getUser().equals(user)).collect(Collectors.toList());
    }

    @Override
    public Dish removeDishFromOrder(Long dishId) {
        Order order = getOrder();
        Dish dish = dishRepository.findById(dishId).orElseThrow(() -> new NotFindDishException("Нет такого блюда"));
        List<OrderDish> orderDishList = order.getOrderDishList();

        for (OrderDish orderDish : orderDishList) {
            if (dish.equals(orderDish.getDish())) {
                if (orderDish.getCount() > 1) {
                    orderDish.setCount(orderDish.getCount() - 1);
                } else {
                    orderDishList.remove(orderDish);

                    break;
                }
            }
        }
        Order save = orderRepository.save(order);
        return dish;
    }

    @Override
    public Dish addDishFromOrder(Long dishId) {
        Order order = getOrder();
        Dish dish = dishRepository.findById(dishId).orElseThrow(() -> new NotFindDishException("Нет такого блюда"));
        List<OrderDish> orderDishList = order.getOrderDishList();

        for (OrderDish orderDish : orderDishList) {
            if (dish.equals(orderDish.getDish())) {
                orderDish.setCount(orderDish.getCount() + 1);
                break;
            }
        }
        Order save = orderRepository.save(order);
        return dish;
    }
}
