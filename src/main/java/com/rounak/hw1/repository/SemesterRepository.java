package com.rounak.hw1.repository;

import com.rounak.hw1.model.entity.Semester;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemesterRepository extends JpaRepository<Semester, Integer> {
}
