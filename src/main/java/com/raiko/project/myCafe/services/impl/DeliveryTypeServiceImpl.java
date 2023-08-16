package com.raiko.project.myCafe.services.impl;

import com.raiko.project.myCafe.models.DeliveryType;
import com.raiko.project.myCafe.repositories.DeliveryTypeRepository;
import com.raiko.project.myCafe.services.DeliveryTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryTypeServiceImpl implements DeliveryTypeService {

    @Autowired
    private DeliveryTypeRepository deliveryTypeRepository;

    @Override
    public List<DeliveryType> getAllDeliveryType() {
        return deliveryTypeRepository.findAll();
    }
}
