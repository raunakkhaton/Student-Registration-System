package com.rounak.hw1.service;

import com.rounak.hw1.model.dto.StudentDto;
import com.rounak.hw1.model.request.AddStudentRequest;
import com.rounak.hw1.model.request.ModifyStudentRequest;

import java.util.List;

public interface StudentService {
    List<StudentDto> getAllStudents();

    StudentDto addStudent(AddStudentRequest addStudentRequest);

    StudentDto updateStudent(Integer id, ModifyStudentRequest modifyStudentRequest);

    void deleteStudent(Integer id);

}
