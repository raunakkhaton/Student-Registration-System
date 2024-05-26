package com.rounak.hw1.controller;

import com.rounak.hw1.model.dto.StudentDto;
import com.rounak.hw1.model.request.AddStudentRequest;
import com.rounak.hw1.model.request.ModifyStudentRequest;
import com.rounak.hw1.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudentDto> addStudent(@RequestBody AddStudentRequest addStudentRequest) {
        StudentDto studentDto = studentService.addStudent(addStudentRequest);
        return new ResponseEntity<>(studentDto, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable("id") Integer id,
                                                    @RequestBody ModifyStudentRequest modifyStudentRequest) {
        StudentDto studentDto = studentService.updateStudent(id, modifyStudentRequest);
        return ResponseEntity.ok(studentDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StudentDto> deleteStudent(@PathVariable("id") Integer id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }


}
