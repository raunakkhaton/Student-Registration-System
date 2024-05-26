package com.rounak.hw1.controller;

import com.rounak.hw1.model.dto.CourseDto;
import com.rounak.hw1.model.dto.StudentDto;
import com.rounak.hw1.model.request.AddCourseRequest;
import com.rounak.hw1.model.request.ModifyCourseRequest;
import com.rounak.hw1.model.request.ModifyStudentRequest;
import com.rounak.hw1.service.CourseService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<CourseDto>> getCourses() {
        return new ResponseEntity<>(courseService.getCourses(), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<CourseDto> addCourse(@RequestBody AddCourseRequest addCourseRequest) {
        return new ResponseEntity<>(courseService.addCourse(addCourseRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDto> updateCourse(@PathVariable("id") Integer id,
                                                  @RequestBody ModifyCourseRequest modifyCourseRequest) {

        CourseDto courseDto = courseService.updateCourse(id, modifyCourseRequest);
        return ResponseEntity.ok(courseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StudentDto> deleteStudent(@PathVariable("id") Integer id) {
        courseService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

}
