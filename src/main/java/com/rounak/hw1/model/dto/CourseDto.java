package com.rounak.hw1.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {
    private String courseName;
    private String branchName;
    private int year;
}
