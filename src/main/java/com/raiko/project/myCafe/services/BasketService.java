package com.raiko.project.myCafe.services;

import com.raiko.project.myCafe.dtos.BasketDTO;
import com.raiko.project.myCafe.models.User;

import java.util.List;

public interface BasketService {
    List<BasketDTO> getAllBasketDTO(User user);

    Double getTotalAmount(List<BasketDTO> basketDTOs);

}
