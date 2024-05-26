package com.rounak.hw1.mapper;

import com.rounak.hw1.model.dto.CourseDto;
import com.rounak.hw1.model.entity.Course;
import com.rounak.hw1.model.request.AddCourseRequest;

public class CourseMapper {
    public static Course mapToCourse(AddCourseRequest addCourseRequest) {
        Course course = new Course();
        course.setCourseName(addCourseRequest.getCourseName());
        course.setBranchName(addCourseRequest.getBranchName());
        course.setYear(addCourseRequest.getYear());
        return course;
    }

    public static CourseDto mapToCourseDto(Course course) {
        CourseDto coursedto = new CourseDto();
            coursedto.setCourseName(course.getCourseName());
            coursedto.setBranchName(course.getBranchName());
            coursedto.setYear(course.getYear());
        return coursedto;
    }
}
