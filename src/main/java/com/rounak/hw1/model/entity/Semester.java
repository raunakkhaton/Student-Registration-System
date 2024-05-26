package com.rounak.hw1.model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "semester", catalog = "college")
public class Semester {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String SemesterName;
    private int courseId;
    private String courseName;
    private String branchName;
}
