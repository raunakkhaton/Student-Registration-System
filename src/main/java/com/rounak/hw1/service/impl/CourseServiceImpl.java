package com.rounak.hw1.service.impl;

import com.rounak.hw1.mapper.CourseMapper;
import com.rounak.hw1.model.dto.CourseDto;
import com.rounak.hw1.model.entity.Course;
import com.rounak.hw1.model.entity.Student;
import com.rounak.hw1.model.request.AddCourseRequest;
import com.rounak.hw1.model.request.ModifyCourseRequest;
import com.rounak.hw1.model.request.ModifyStudentRequest;
import com.rounak.hw1.repository.CourseRepository;
import com.rounak.hw1.service.CourseService;
import org.springframework.data.jpa.domain.AbstractPersistable_;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {

        this.courseRepository = courseRepository;
    }

    @Override
    public List<CourseDto> getCourses() {
        List<Course> courses = courseRepository.findAll();
        if (courses.size() == 0) {
            return Collections.emptyList();
        }

        List<CourseDto> courseDtos = new ArrayList<>();
        for (int i = 0; i < courses.size(); i++) {
            Course course = courses.get(i);
            CourseDto courseDto = CourseMapper.mapToCourseDto(course);
            courseDtos.add(courseDto);
        }
        return courseDtos;
    }

    @Override
    public CourseDto addCourse(AddCourseRequest addCourseRequest) {
        Course course = CourseMapper.mapToCourse(addCourseRequest);
        Course addCourse = courseRepository.save(course);
        return CourseMapper.mapToCourseDto(addCourse);
    }

    @Override
    public CourseDto updateCourse(Integer id, ModifyCourseRequest modifyCourseRequest) {
        Course course = courseRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Course not found")
        );
        course.setCourseName(modifyCourseRequest.getCourseName());
        course.setBranchName(modifyCourseRequest.getBranchName());
        Course updateCourse = courseRepository.save(course);
        return CourseMapper.mapToCourseDto(updateCourse);
    }

    @Override
    public void deleteStudent(Integer id) {
        Course course = courseRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));
        courseRepository.delete(course);
    }

}
