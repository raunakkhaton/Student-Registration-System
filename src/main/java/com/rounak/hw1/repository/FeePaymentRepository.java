package com.rounak.hw1.repository;

import com.rounak.hw1.model.entity.FeePayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeePaymentRepository extends JpaRepository<FeePayment, Integer> {
}
