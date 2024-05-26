package com.rounak.hw1.repository;

import com.rounak.hw1.model.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, Integer> {
}
