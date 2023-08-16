package com.raiko.project.myCafe.repositories;

import com.raiko.project.myCafe.models.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentTypeRepository extends JpaRepository<PaymentType, Long> {
}
