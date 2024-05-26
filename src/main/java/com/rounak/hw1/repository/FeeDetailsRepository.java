package com.rounak.hw1.repository;

import com.rounak.hw1.model.entity.FeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeeDetailsRepository extends JpaRepository<FeeDetails, Integer> {
}
