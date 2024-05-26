package com.rounak.hw1.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FeeDetailsDto {
    private CourseDto course;
//    private int courseId;
    private double amount;
}
