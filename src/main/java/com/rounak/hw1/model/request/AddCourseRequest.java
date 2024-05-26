package com.rounak.hw1.model.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddCourseRequest {
    private String courseName;
    private String branchName;
    private int year;
}
