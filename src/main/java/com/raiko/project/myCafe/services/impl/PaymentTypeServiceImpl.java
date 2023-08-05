package com.raiko.project.myCafe.services.impl;

import com.raiko.project.myCafe.models.DeliveryType;
import com.raiko.project.myCafe.models.PaymentType;
import com.raiko.project.myCafe.repositories.DeliveryTypeRepository;
import com.raiko.project.myCafe.repositories.PaymentTypeRepository;
import com.raiko.project.myCafe.services.DeliveryTypeService;
import com.raiko.project.myCafe.services.PaymentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentTypeServiceImpl implements PaymentTypeService {

    @Autowired
    private PaymentTypeRepository paymentTypeRepository;

    @Override
    public List<PaymentType> getAllPaymentType() {
        return paymentTypeRepository.findAll();
    }
}
