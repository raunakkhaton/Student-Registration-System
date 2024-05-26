package com.rounak.hw1.service.impl;

import com.rounak.hw1.model.dto.StudentDto;
import com.rounak.hw1.model.entity.Course;
import com.rounak.hw1.model.entity.Student;
import com.rounak.hw1.mapper.StudentMapper;
import com.rounak.hw1.model.request.ModifyStudentRequest;
import com.rounak.hw1.repository.CourseRepository;
import com.rounak.hw1.repository.StudentRepository;
import com.rounak.hw1.model.request.AddStudentRequest;
import com.rounak.hw1.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    private CourseRepository courseRepository;

    public StudentServiceImpl(StudentRepository studentRepository,
                              CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        if (students.size() == 0) {
            return Collections.emptyList();
        }
        List<StudentDto> studentDtos = new ArrayList<StudentDto>();
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            StudentDto studentDto = StudentMapper.mapToStudentDto(student);
            studentDtos.add(studentDto);
        }

        return studentDtos;
    }

    @Override
    public StudentDto addStudent(AddStudentRequest addStudentRequest) {
       Course course = courseRepository.findById(addStudentRequest.getCourseId())
               .orElseThrow(()->new RuntimeException("Course not found"));

        Student student = StudentMapper.mapToStudent(addStudentRequest,course);
        Student addStudent = studentRepository.save(student);
        StudentDto saveStudentDto = StudentMapper.mapToStudentDto(addStudent);
        return saveStudentDto;
    }

    @Override
    public StudentDto updateStudent(Integer id, ModifyStudentRequest modifyStudentRequest) {
        Student student = studentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Student not found")
        );

//        student.setId(updatedStudent.getId());
        student.setAdmissionNo(modifyStudentRequest.getAdmissionNo());
        student.setRollNo(modifyStudentRequest.getRollNo());
        student.setStandard(modifyStudentRequest.getStandard());
        Student updatedStudentObj = studentRepository.save(student);
        return StudentMapper.mapToStudentDto(updatedStudentObj);
    }

    @Override
    public void deleteStudent(Integer id) {
        Student student = studentRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));
        studentRepository.delete(student);
    }
}
