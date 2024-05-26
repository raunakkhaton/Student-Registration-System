package com.rounak.hw1.service;

import com.rounak.hw1.model.dto.CourseDto;
import com.rounak.hw1.model.request.AddCourseRequest;
import com.rounak.hw1.model.request.ModifyCourseRequest;
import com.rounak.hw1.model.request.ModifyStudentRequest;

import java.util.List;

public interface CourseService {
    List<CourseDto> getCourses();
    CourseDto addCourse(AddCourseRequest addCourseRequest);

    CourseDto updateCourse(Integer id, ModifyCourseRequest modifyCourseRequest);

    void deleteStudent(Integer id);
}
