package com.raiko.project.myCafe.transformers;

import com.raiko.project.myCafe.dtos.BasketDTO;
import com.raiko.project.myCafe.models.Dish;
import com.raiko.project.myCafe.models.OrderDish;
import org.springframework.stereotype.Component;

@Component
public class TransformerOrderDishToBasketDTO {
    public BasketDTO transform(OrderDish orderDish) {
        BasketDTO basketDTO = new BasketDTO();
        Dish dish = orderDish.getDish();
        basketDTO.setDishId(dish.getId());
        basketDTO.setName(dish.getName());
        basketDTO.setWeight(dish.getWeight());
        basketDTO.setDescription(dish.getDescription());
        basketDTO.setPrice(dish.getPrice());
        basketDTO.setCount(orderDish.getCount());
        basketDTO.setAmount(dish.getPrice() * orderDish.getCount());
        return basketDTO;
    }
}
