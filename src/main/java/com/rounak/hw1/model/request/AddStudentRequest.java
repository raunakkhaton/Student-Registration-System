package com.rounak.hw1.model.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddStudentRequest {
    private Integer admissionNo;
    private Integer rollNo;
    private String standard;
    private Integer courseId;
}
