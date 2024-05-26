package com.rounak.hw1.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class StudentDto {
    private Integer admissionNo;
    private Integer rollNo;
    private String standard;
    private String courseName;
}
