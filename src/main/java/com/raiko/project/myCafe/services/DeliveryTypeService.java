package com.raiko.project.myCafe.services;

import com.raiko.project.myCafe.models.DeliveryType;
import org.springframework.stereotype.Service;

import javax.lang.model.type.DeclaredType;
import java.util.List;


public interface DeliveryTypeService {
    List<DeliveryType> getAllDeliveryType();
}
