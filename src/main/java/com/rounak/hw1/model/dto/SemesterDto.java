package com.rounak.hw1.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SemesterDto {
    private String SemesterName;
    private int courseId;
    private String courseName;
    private String branchName;
}
