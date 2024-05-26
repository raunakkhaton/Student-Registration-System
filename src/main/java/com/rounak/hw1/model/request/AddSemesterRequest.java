package com.rounak.hw1.model.request;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddSemesterRequest {
    private String SemesterName;
    private int courseId;
    private String courseName;
    private String branchName;
}
