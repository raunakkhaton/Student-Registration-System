package com.rounak.hw1.model.entity;


import com.rounak.hw1.model.dto.FeeDetailsDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "FEE_DETAILS")
public class FeeDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(name = "COURSE_ID", referencedColumnName = "ID", nullable = false)
    @OneToOne(fetch = FetchType.LAZY)
    private Course course;

    private double amount;
}
