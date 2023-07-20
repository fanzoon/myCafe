package com.raiko.project.myCafe.services.impl;

import com.raiko.project.myCafe.dtos.BasketDTO;
import com.raiko.project.myCafe.models.Dish;
import com.raiko.project.myCafe.models.Order;
import com.raiko.project.myCafe.models.OrderDish;
import com.raiko.project.myCafe.models.User;
import com.raiko.project.myCafe.repositories.OrderRepository;
import com.raiko.project.myCafe.services.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BasketServiceImpl implements BasketService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<BasketDTO> getAllBasketDTO(User user) {
        List <OrderDish> orderDishList;
        List<BasketDTO> basketDTOList = new ArrayList<>();
        Optional<Order> orderByUserId = orderRepository.findByUserId(user.getId());
        Order order = orderByUserId.orElse(null);
        orderDishList = order.getOrderDishList();
        for (OrderDish orderDish: orderDishList) {
            BasketDTO basketDTO = new BasketDTO();
            Dish dish = orderDish.getDish();
            basketDTO.setDishId(dish.getId());
            basketDTO.setName(dish.getName());
            basketDTO.setDescription(dish.getDescription());
            basketDTO.setPrice(dish.getPrice());
            basketDTO.setCount(orderDish.getCount());
            basketDTO.setAmount(dish.getPrice() * orderDish.getCount());
            basketDTOList.add(basketDTO);
        }
        return basketDTOList;
    }

    @Override
    public Double getTotalAmount(List<BasketDTO> basketDTOs) {
        return basketDTOs.stream().mapToDouble(BasketDTO::getAmount).sum();
    }
}
